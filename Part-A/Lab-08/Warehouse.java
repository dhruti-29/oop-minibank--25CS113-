class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(int shortfall) {
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {

    public InvalidQuantityException() {
        super("Invalid quantity");
    }
}

public class Warehouse {

    int stock = 10;

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException();
        }

        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }

        stock = stock - qty;

        System.out.println("Issued " + qty + " " + item);
    }

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        int[] requests = {3, 5, 10, -2, 2};

        for (int qty : requests) {

            try {

                warehouse.issue("Pen", qty);

            } catch (OutOfStockException e) {

                System.out.println("Out of stock. Shortfall: "
                        + e.getShortfall());

            } catch (InvalidQuantityException e) {

                System.out.println(e.getMessage());
            }
        }
    }
}