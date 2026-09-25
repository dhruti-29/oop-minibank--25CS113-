public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;

        twoWheelers = 0;
        fourWheelers = 0;
    }

    public boolean park(String type) {

        if (type.equals("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue = revenue + 20;
                return true;
            }

        } else if (type.equals("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue = revenue + 40;
                return true;
            }
        }

        System.out.println("Full");
        return false;
    }

    public void leave(String type) {

        if (type.equals("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
            }

        } else if (type.equals("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
            }
        }
    }

    public static void main(String[] args) {

        ParkingLot parking = new ParkingLot(2, 2);

        System.out.println("Two wheeler: " + parking.park("two"));
        System.out.println("Two wheeler: " + parking.park("two"));
        System.out.println("Two wheeler: " + parking.park("two"));

        System.out.println("Four wheeler: " + parking.park("four"));
        System.out.println("Four wheeler: " + parking.park("four"));
        System.out.println("Four wheeler: " + parking.park("four"));

        parking.leave("two");

        System.out.println("Two wheeler after leaving: " + parking.park("two"));

        System.out.println("Two wheelers: " + parking.twoWheelers);
        System.out.println("Four wheelers: " + parking.fourWheelers);
        System.out.println("Revenue: " + revenue);
    }
}