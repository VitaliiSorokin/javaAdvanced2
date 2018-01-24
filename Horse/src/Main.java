import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int startX;
        int startY;
        int finishX;
        int finishY;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start X: ");
        startX = scanner.nextInt();
        System.out.println("Enter start Y: ");
        startY = scanner.nextInt();
        System.out.println("Enter finish X: ");
        finishX = scanner.nextInt();
        System.out.println("Enter finish Y: ");
        finishY = scanner.nextInt();

        if (startX >= 0 && startY <= 8 && finishX >= 0 && finishY <= 8) {
            if ((Math.abs(startX - finishX) == 2 && Math.abs(startY - finishY) == 1) ||
                    (Math.abs(startX - finishX) == 1 && Math.abs(startY - finishY) == 2)) {
                System.out.println("Move is possible!");
            } else {
                System.out.println("Move is not possible.(");
            }

        } else {
            System.out.println("Out of bounds.");
        }
    }
}
