package src;
import client.ClientClass;

public class MainClass {

    public static void main(String[] args) {
        final int CLIENT_PORT = 8085;
        final String CLIENT_ADDR = "localhost";

        ClientClass clientClass;
        clientClass = new ClientClass(CLIENT_PORT, CLIENT_ADDR);
        clientClass.clientStart();


    }
}
