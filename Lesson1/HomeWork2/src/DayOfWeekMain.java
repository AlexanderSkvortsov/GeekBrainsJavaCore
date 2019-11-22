

public class DayOfWeekMain {

    private static String getWorkingHours(DayOfWeek dayOfWeek){

        switch (dayOfWeek) {
            case SUNDAY:
            case SATURDAY:
                            return "Сегодня выходной!";
            default:
                            return "Сегодня  " +dayOfWeek+". До выходных осталось "+ DayOfWeek.SATURDAY.compareTo(dayOfWeek) * 8 + " часов.";
        }

    }

    public static void main(String[] args) {

        for (DayOfWeek d: DayOfWeek.values()) {
            System.out.println(getWorkingHours(d));
        }


    }
}
