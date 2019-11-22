package dateException;

public class MyDayException extends MyMonthException {
    int day;

    public MyDayException(String message, int day, int month) {
        super(message,month);
        this.day = day;

    }

    public int getDay() {
        return day;
    }

}
