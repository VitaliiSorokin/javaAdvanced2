import java.util.Random;

public class Horse extends Thread {
    private Random rand = new Random();
    private Boolean isFinished = false;

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    @Override
    public void run() {
        int totalRun = 0;
        System.out.println(Thread.currentThread().getName() + " has started");
        while(totalRun <= 1000) {
            try {
                Thread.sleep(rand.nextInt(100) + 400);
                totalRun+=rand.nextInt(100) + 100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(Thread.currentThread().getName() + " thread has finished.");
    }
}
