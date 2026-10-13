import java.nio.file.*;
import java.io.IOException;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        Path[] files = {
            Path.of("log1.txt"),
            Path.of("log2.txt"),
            Path.of("log3.txt")
        };

        Files.writeString(files[0], "Java started\nError found\nJava completed");
        Files.writeString(files[1], "Login successful\nJava program running");
        Files.writeString(files[2], "Error found\nSystem running\nJava task done");

        String keyword = "Java";
        int totalLines = 0;
        int keywordCount = 0;

        for (Path file : files) {
            int lines = 0;

            for (String line : Files.readAllLines(file)) {
                lines++;
                totalLines++;

                if (line.contains(keyword))
                    keywordCount++;
            }

            System.out.println(file.getFileName() +
                    " Size: " + Files.size(file) + " bytes");
            System.out.println("Lines: " + lines);
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing '" + keyword + "': " + keywordCount);
    }
}