
import server.ServerClass;

import java.io.IOException;
import java.net.ServerSocket;

public class MainClass {

    public static void main(String[] args) {
        final int CLIENT_PORT = 8085;

        ServerClass serverClass;
        serverClass = new ServerClass(CLIENT_PORT);
        serverClass.serverStart();


    }
}
