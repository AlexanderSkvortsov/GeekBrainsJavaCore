import java.util.concurrent.CountDownLatch;

public class StartStopEvent {
    CountDownLatch startEvent ;
    CountDownLatch stopEvent ;

    public StartStopEvent(int CARS_COUNT) {
        startEvent = new CountDownLatch(CARS_COUNT);
        stopEvent = new CountDownLatch(CARS_COUNT);
    }

    public CountDownLatch getStartEvent() {
        return startEvent;
    }

    public CountDownLatch getStopEvent() {
        return stopEvent;
    }

}
