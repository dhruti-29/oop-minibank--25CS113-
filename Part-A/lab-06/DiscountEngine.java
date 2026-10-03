import java.util.Scanner;

interface Discount {
    double apply(double price);
}

public class DiscountEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] prices = {100, 200, 300};

        System.out.println("1. 10% discount");
        System.out.println("2. 20% discount");

        int choice = sc.nextInt();

        Discount discount;

        if (choice == 1) {
            discount = price -> price * 0.90;
        } else {
            discount = price -> price * 0.80;
        }

        for (double price : prices) {
            System.out.println(discount.apply(price));
        }

        sc.close();
    }
}