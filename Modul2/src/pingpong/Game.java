package pingpong;

import java.util.concurrent.*;

public class Game {

    static volatile boolean isFinished = false;
    static volatile boolean isEntered = false;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(new Ai(), 2, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Checker(), 0, 2, TimeUnit.SECONDS);

        while (!isFinished) {
            Thread.yield();
        }
        System.out.println("Too late! Game is over!");
        scheduledExecutorService.shutdownNow();
        System.exit(0);
    }
}
