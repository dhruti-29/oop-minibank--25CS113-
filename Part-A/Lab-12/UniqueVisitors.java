import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        String[] users = {
            "riya", "dhruti", "jay", "riya",
            "neha", "jay", "dhruti"
        };

        HashSet<String> unique = new HashSet<>();
        LinkedHashSet<String> order = new LinkedHashSet<>();

        for (String user : users) {
            unique.add(user);
            order.add(user);
        }

        System.out.println("Unique users: " + unique.size());

        System.out.println("First three users:");

        int count = 0;
        for (String user : order) {
            System.out.println(user);
            count++;

            if (count == 3)
                break;
        }
    }
}