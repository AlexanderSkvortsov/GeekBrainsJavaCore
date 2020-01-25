import java.lang.reflect.InvocationTargetException;

public class MainClass {
    public static void main(String[] args) {
        try {
            RunTest.start();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
