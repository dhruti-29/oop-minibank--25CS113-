package util;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
public class ReportGenerator {
    public static void generate(Path folder, Path report) throws IOException {
        long deposits=0, withdrawals=0;
        Files.createDirectories(folder);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path file : stream) {
                if (!Files.isRegularFile(file)) continue;
                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line=reader.readLine()) != null) {
                        String[] p=line.split(",");
                        if (p.length >= 2) try {
                            long amount=Long.parseLong(p[1]);
                            if (p[0].equals("DEPOSIT")) deposits += amount;
                            if (p[0].equals("WITHDRAW")) withdrawals += amount;
                        } catch(NumberFormatException ignored) { }
                    }
                }
                BasicFileAttributes a=Files.readAttributes(file, BasicFileAttributes.class);
                System.out.println(file.getFileName()+" size="+a.size()+" modified="+a.lastModifiedTime());
            }
        }
        Files.writeString(report, "MiniBank End-of-Day Report\nTotal deposits: ₹"+deposits+
            "\nTotal withdrawals: ₹"+withdrawals+"\n");
    }
}