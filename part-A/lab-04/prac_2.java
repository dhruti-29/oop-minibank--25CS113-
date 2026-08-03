import java.util.Scanner;

class ChatFilter {

    static String filter(String[] logs, String keyword) {

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (String line : logs) {

            String[] parts = line.split(" ", 3);

            if (parts.length < 3) {
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (message.toLowerCase().contains(keyword.toLowerCase())) {

                count++;

                result.append(time)
                      .append(" ")
                      .append(user)
                      .append(": ")
                      .append(message)
                      .append("\n");
            }
        }

        System.out.println("Matches: " + count);
        System.out.println(result);
        
        return result.toString();
    }
}


public class prac_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob How are you",
            "10:07 charlie Good morning",
            "10:08"
        };

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        ChatFilter.filter(logs, keyword);

        sc.close();
    }
}