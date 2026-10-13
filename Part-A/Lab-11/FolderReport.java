import java.nio.file.*;
import java.io.IOException;

public class FolderReport {
    public static void main(String[] args) throws IOException {

        Path folder = Path.of(".");
        Path report = Path.of("report.txt");

        StringBuilder result = new StringBuilder();

        Files.walk(folder)
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try {
                    result.append("Name: ")
                          .append(file.getFileName())
                          .append("\n");

                    result.append("Size: ")
                          .append(Files.size(file))
                          .append(" bytes\n");

                    result.append("Modified: ")
                          .append(Files.getLastModifiedTime(file))
                          .append("\n\n");

                } catch (IOException e) {
                    System.out.println("Error reading file");
                }
            });

        Files.writeString(report, result.toString());

        System.out.println("Report created: report.txt");
    }
}