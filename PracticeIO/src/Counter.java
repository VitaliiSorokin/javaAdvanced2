import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Counter {
    private int filesCount = 0;
    private int foldersCount = 0;
    private Path path = Paths.get("output.txt");

    private int getFilesCount() {
        return filesCount;
    }

    private int getFoldersCount() {
        return foldersCount;
    }

    private void countFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    filesCount++;
                } else {
                    foldersCount++;
                    countFiles(file);
                }
            }
        }
    }

    private void printDirTree(File folder, StringBuilder indent) throws IOException {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    Files.write(path, (indent + file.getName() + "\n").getBytes(), StandardOpenOption.APPEND);
                    printDirTree(file, getNewIndent(indent));
                } else {
                    Files.write(path, (indent + file.getName() + "\n").getBytes(), StandardOpenOption.APPEND);
                }
            }
        } else {
            Files.write(path, "You have entered wrong path.".getBytes(), StandardOpenOption.APPEND);
        }
    }

    private StringBuilder getNewIndent(StringBuilder indent) {
        StringBuilder newIndent = new StringBuilder(indent);
        newIndent.insert(0, "    ");
        return newIndent;
    }

    public void generateResult(File folder) throws IOException {
        Files.write(path, "".getBytes());
        countFiles(folder);
        Files.write(path, ("You've got " + getFoldersCount() + " folders").getBytes(), StandardOpenOption.APPEND);
        Files.write(path, (" and " + getFilesCount() + " files \n").getBytes(), StandardOpenOption.APPEND);

        StringBuilder indent = new StringBuilder("+---");
        printDirTree(folder, indent);
        System.out.println("Check output.txt for results.");
    }

}
