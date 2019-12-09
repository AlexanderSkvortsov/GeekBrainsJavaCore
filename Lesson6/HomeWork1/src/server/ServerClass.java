package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClass {

        private int tcpPort;

    public ServerClass(int tcpPort) {
        this.tcpPort = tcpPort;

    }

    private void serverIn(DataInputStream in){
        String s = null;
        while (true) {
            try {
                s = in.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }
            System.out.println("Получено от клиента -> " + s);
        }
    }

    private void serverOut(DataOutputStream out){
        Scanner sc = new Scanner(System.in);
        String s ="";

        while (true) {
           System.out.println("Сервер ожидает ввод....");
           s=sc.nextLine();
           System.out.println("Отправлено клиенту -> " + s);
           try {
               out.writeUTF(s);
           } catch (IOException e) {
               //e.printStackTrace();
               return;
           }
        }
    }

    public void serverStart() {
        try {
            ServerSocket serverSocket = new ServerSocket(tcpPort);

            System.out.println("Сервер запущен на порту " + tcpPort + ", ожидаем подключения...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread sIn = new Thread(() -> serverIn(in));
                sIn.start();
                new Thread(() -> serverOut(out)).start();

                try {
                    sIn.join();
                    System.out.println("Соединение потеряно, ожидание соединения...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
