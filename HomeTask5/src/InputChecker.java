import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputChecker implements Runnable {
    private String previousInput = "";
    private String currentInput = "";
    private boolean running = true;

    private void terminate() {
        running = false;
    }

    public void setCurrentInput(String input) {
        previousInput = this.currentInput;
        this.currentInput = input;
    }

    @Override
    public void run() {
        while (running) {
            try {
                if (!currentInput.equals(previousInput)) {
                    write2file();
                }
                if (currentInput.equals("quit")) {
                    terminate();
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void write2file() {
        try {
            Files.write(Paths.get("output.txt"), currentInput.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
