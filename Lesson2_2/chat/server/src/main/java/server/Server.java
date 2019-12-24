package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService;

    // JDBC
    private static Connection connection;
    private static Statement stmt;
   // private static PreparedStatement psInsert;

    public AuthService getAuthService() {
        return authService;
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:clients.db");
        stmt = connection.createStatement();
    }


    private static void updateNickName(String login, String newNickName) throws SQLException, ClassNotFoundException {
        connect();
        stmt.executeUpdate("UPDATE details SET nick='"+newNickName+"' WHERE login ='"+login+"'");
        disconnect();
    }

    private ArrayList<UserData> loadAll() throws SQLException, ClassNotFoundException {
        connect();

        ResultSet rs = stmt.executeQuery("SELECT * FROM details ");
        ArrayList<UserData> udList = new ArrayList<>();

        while (rs.next()) {
            UserData ud = new UserData(
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("nick")
            );
            udList.add(ud);
        }

        rs.close();
        disconnect();
        return udList;
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
/*
    public static void fillTable() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i <= 100; i++) {
            psInsert.setString(1, "nick" + i);
            psInsert.setString(2, "passw" + i);
            psInsert.setString(3, "login" + i);
            psInsert.executeUpdate();
        }
        connection.setAutoCommit(true);
    }

    public static void prepareAllStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO details (nick, password, login) VALUES (?, ?, ?);");
    }
*/

    public Server() throws SQLException, ClassNotFoundException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        // No JDBC auth
        //authService = new SimpleAuthService();

        // JDBC auth
        authService = new SimpleAuthService(loadAll());

/*
        try {
            try {
                connect();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            prepareAllStatements();
            fillTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");



            while (true){
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String nick, String msg){
        for (ClientHandler c:clients ) {
            c.sendMsg( nick +" : "+  msg);
        }
    }

    public void newNickName(ClientHandler sender, String newNickName) {
        try {
            updateNickName(sender.getLogin(),newNickName);
            authService.setNicknameByLogin(sender.getLogin(),newNickName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void privateMsg(ClientHandler sender, String receiver, String msg){
        String message = String.format("[ %s ] private [ %s ] : %s",
                sender.getNick(), receiver, msg);

        for (ClientHandler c:clients ) {
            if(c.getNick().equals(receiver)){
                c.sendMsg(message);
                sender.sendMsg(message);
                return;
            }
        }
        sender.sendMsg("Пользователь с ником: "+ receiver +" не найден");
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
        broadcastClientlist();
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
        broadcastClientlist();
    }

    public boolean isLoginAuthorized(String login){
        for (ClientHandler c:clients ) {
            if (c.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void broadcastClientlist(){
        StringBuilder sb = new StringBuilder("/clientlist ");
        for (ClientHandler c:clients ) {
            sb.append(c.getNick()+" ");
        }

        String msg = sb.toString();
        for (ClientHandler c:clients ) {
            c.sendMsg(msg);
        }
    }
}
