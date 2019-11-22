package dateException;

public class MyMonthException extends Exception{
    int  month;

    public MyMonthException(String message, int month) {
        super(message);
        this.month = month;

    }

    public int getMonth() {
        return month;
    }

}
