
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        StartStopEvent startStopEvent = new StartStopEvent(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        Car.setStartStopEvent(startStopEvent);

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            startStopEvent.getStartEvent().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ConsoleColors.WHITE+"ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            startStopEvent.getStopEvent().await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(ConsoleColors.WHITE+"ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }
}

