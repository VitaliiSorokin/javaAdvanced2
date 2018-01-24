import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
//        String location = "D://2code/alevel/PracticeIO";
        System.out.println("Enter directory path: ");
        Scanner scanner = new Scanner(System.in);
        String location = scanner.nextLine();

        File folder = new File(location);
        Counter counter = new Counter();
        counter.generateResult(folder);
    }
}
