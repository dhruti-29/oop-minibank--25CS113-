import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter vehicle number: ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type: ");
            String type = sc.nextLine().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            total = total + toll;

            if (type.equals("bike")) {
                bikeCount++;
            } else if (type.equals("car")) {
                carCount++;
            } else if (type.equals("truck")) {
                truckCount++;
            }
        }

        System.out.println("Total toll: " + total);

        if (bikeCount >= carCount && bikeCount >= truckCount) {
            System.out.println("Most frequent: bike");
        } else if (carCount >= bikeCount && carCount >= truckCount) {
            System.out.println("Most frequent: car");
        } else {
            System.out.println("Most frequent: truck");
        }

        sc.close();
    }
}