public class Car implements Runnable {
    private static int CARS_COUNT;
    private static StartStopEvent startStopEvent;
    private static final Object sync = new Object();


    static {
        CARS_COUNT = 0;
    }

    public static void setStartStopEvent(StartStopEvent startStopEvent) {
        Car.startStopEvent = startStopEvent;
    }

    private Race race;
    private int speed;
    private String name;
    private int Index;

    public int getIndex() {return Index;}
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        Index = CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(ConsoleColors.getIndex(Index )+this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(ConsoleColors.getIndex(Index )+this.name + " готов");

            startStopEvent.getStartEvent().countDown();
            startStopEvent.getStartEvent().await();
            Thread.sleep(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (sync) {
            if (startStopEvent.getStopEvent().getCount() == CARS_COUNT)
                System.out.println(ConsoleColors.getIndex(Index )+this.name + " WIN");
            else
                System.out.println(ConsoleColors.getIndex(Index )+this.name + " место "+(1+CARS_COUNT-startStopEvent.getStopEvent().getCount()));
            startStopEvent.getStopEvent().countDown();
        }

    }
}