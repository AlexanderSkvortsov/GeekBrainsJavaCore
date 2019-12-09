package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
        private int tcpPort;
        private String tcpAddress;


    public ClientClass(int tcpPort, String tcpAddress) {
        this.tcpPort = tcpPort;
        this.tcpAddress = tcpAddress;
    }

    private void clientIn(DataInputStream in){
        String s = null;
        while (true) {
            try {
                s = in.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }
            System.out.println("Получено от сервера -> " + s);
        }
    }

    private void clientOut(DataOutputStream out){
        Scanner sc = new Scanner(System.in);
        String s ="";

        while (true) {
            System.out.println("Клиент ожидает ввод...");

            s=sc.nextLine();

            System.out.println("Отправлено серверу  -> " + s);
            try {
                out.writeUTF(s);
            } catch (IOException e) {
                //e.printStackTrace();
                return;
            }


        }

    }

    public void clientStart() {
        System.out.println("Ожидание готовности сервера...");
        {
            while (true) {

                try (Socket clientSocket = new Socket(tcpAddress, tcpPort)) {

                    System.out.println("Клиент запущен на порту " + tcpPort + ", ожидаем подключения...");

                    System.out.println("Клиент подключился к серверу");

                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                    Thread cIn = new Thread(() -> clientIn(in));
                    cIn.start();
                    new Thread(() -> clientOut(out)).start();

                    try {
                        cIn.join();
                        System.out.println("Соединение потеряно, ожидание соединения...");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    //e.printStackTrace();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
