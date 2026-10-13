import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Dhruti", 90);
        scores.put("Riya", 85);
        scores.put("Jay", 95);
        scores.put("Neha", 80);

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(scores.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Leaderboard:");

        for (Map.Entry<String, Integer> player : list) {
            System.out.println(
                player.getKey() + " : " + player.getValue()
            );
        }
    }
}
