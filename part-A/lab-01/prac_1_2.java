import java.util.Scanner;

public class prac_1_2 {

    
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bike = 0, car = 0, truck = 0;

        while (true) {

            System.out.print("Enter Vehicle Number (or done): ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter Vehicle Type (bike/car/truck): ");
            String type = sc.nextLine().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> {
                    bike++;
                    yield 20;
                }
                case "car" -> {
                    car++;
                    yield 50;
                }
                case "truck" -> {
                    truck++;
                    yield 150;
                }
                default -> {
                    System.out.println("Invalid Vehicle Type");
                    yield 0;
                }
            };

            totalToll += toll;
        }

        String mostFrequent;

        if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        } else if (car >= bike && car >= truck) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("\nTotal Toll: " + totalToll);
        System.out.println("Most Frequent: " + mostFrequent);

        sc.close();
    }
}