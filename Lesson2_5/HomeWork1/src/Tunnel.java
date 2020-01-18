import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore maxCarsInTunnel;

    public Tunnel( int maxCars) {
        this.maxCarsInTunnel = new Semaphore(maxCars);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(ConsoleColors.getIndex(c.getIndex())+c.getName() + " готовится к этапу(ждет): " + description);

                maxCarsInTunnel.acquire();

                System.out.println(ConsoleColors.getIndex(c.getIndex())+c.getName() + " начал этап: " + description);

                Thread.sleep(length / c.getSpeed() * 1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(ConsoleColors.getIndex(c.getIndex())+c.getName() + " закончил этап: " + description);
                maxCarsInTunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}