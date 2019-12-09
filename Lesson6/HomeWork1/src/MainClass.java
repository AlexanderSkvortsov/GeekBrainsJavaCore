
import server.ServerClass;
public class MainClass {

    public static void main(String[] args) {
        final int CLIENT_PORT = 8085;
        new ServerClass(CLIENT_PORT).serverStart();
    }
}
