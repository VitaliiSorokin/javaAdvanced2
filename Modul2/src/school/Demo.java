package school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/school.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DBUtils.createTable();

        for (String line : lines) {
            DBUtils.addRow(line.split(","));
        }

        System.out.println("Enter class name: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(DBUtils.getClassInfo(scanner.nextLine()));

    }
}
