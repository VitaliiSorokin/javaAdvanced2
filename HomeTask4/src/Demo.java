import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String input = scanner.nextLine();
        System.out.println("Enter output file name: ");
        String output = scanner.nextLine();
        System.out.println("Enter number of lines to copy: ");
        int lines = scanner.nextInt();
        System.out.println("1 - using IO; 2 - using NIO;");
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                TeleportationIO teleportationIO = new TeleportationIO(input, output, lines);
                teleportationIO.doJob();
                break;
            case 2:
                TeleportationNIO teleportationNIO = new TeleportationNIO(input, output, lines);
                teleportationNIO.doJob();
                break;
            default:
                System.out.println("wrong choice");
        }
    }
}
