import dateException.MyDayException;
import dateException.MyMonthException;

import java.util.Calendar;

public class MainClass {

    static void checkDate(int day, int month, int year) throws MyDayException, MyMonthException {

        if ((month < Calendar.JANUARY+1) || (month > Calendar.DECEMBER+1)){
            throw new MyMonthException("Месяц вне диапазона",month);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        int daysQty = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        if ((day > daysQty ) || (day <=0)){
            throw new MyDayException("День вне диапазона",day,month);

        }

    }

    static void printDate(int day, int month, int year){
        try {
            checkDate(day,month,year);
            System.out.println("День "+day+" месяц "+month+".");
        } catch (MyDayException e) {
//            e.printStackTrace();
            System.out.println("Исключение:Неверная дата "+e.getDay()+"."+e.getMonth());

        } catch (MyMonthException e) {
//            e.printStackTrace();
            System.out.println("Исключение:Неверный месяц "+e.getMonth());
        }
    }

    public static void main(String[] args) {

        printDate(10,10,2012);
        printDate(31,11,2012);
        printDate(30,11,2012);
        printDate(-1,11,2012);
        printDate(1,15,2012);


    }
}
