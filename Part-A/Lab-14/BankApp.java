import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Account");
        System.out.println("2. Show Count");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter balance: ");
            double balance = sc.nextDouble();

            bank.addAccount(name, balance);
            System.out.println("Account added");
        }
        else if (choice == 2) {
            System.out.println("Accounts: " + bank.getCount());
        }
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}