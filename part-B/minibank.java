
import java.util.Scanner;

public class minibank {
    record BankInfo(String name, String branch) {}

    enum MenuOption {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
    }

   
    static class Customer {
        private String name, email, mobile;
        private final String customerId;
        private static long customerCounter = 100;

        Customer(String name, String email, String mobile) {
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            customerId = "CUST" + (++customerCounter);
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getMobile() { return mobile; }
        public String getCustomerId() { return customerId; }
    }

 
    static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;
        private boolean active;
        private static int accountCounter = 0;

        Account(String ownerName, long balance) {
            this.ownerName = ownerName;
            this.balance = balance;
            this.active = true;
            accountNumber = String.format("AC%04d", ++accountCounter);
        }

        Account(String ownerName) {
            this(ownerName, 0);
        }

        public void deposit(long amount) {
            if (amount > 0) balance += amount;
        }

        public boolean withdraw(long amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public String getAccountNumber() { return accountNumber; }
        public String getOwnerName() { return ownerName; }
        public long getBalance() { return balance; }
        public boolean isActive() { return active; }
    }

    
    static boolean transfer(Account from, Account to, long amount) {
        if (from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("Mini Bank", "Charusat Branch");

        System.out.println("=================================");
        System.out.println("      " + bank.name());
        System.out.println("      " + bank.branch());
        System.out.println("=================================");

    
        Customer c1 = new Customer("Riya", "riya@gmail.com", "9999999999");
        Customer c2 = new Customer("Aarav", "aarav@gmail.com", "8888888888");

        Account[] accounts = {
            new Account(c1.getName(), 5000),
            new Account(c2.getName(), 3000),
            new Account("Dhru", 1000)
        };

        accounts[0].deposit(1000);
        accounts[1].withdraw(500);
        transfer(accounts[0], accounts[2], 1000);

        for (Account a : accounts)
            System.out.println(a.getAccountNumber() + " " +
                    a.getOwnerName() + " Balance: " + a.getBalance());

        boolean running = true;

        while (running) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            String message = switch (choice) {
                case 1 -> "Open Account - Feature added.";
                case 2 -> "Deposit - Feature added.";
                case 3 -> "Withdraw - Feature added.";
                case 4 -> "Transfer - Feature added.";
                case 5 -> {
                    running = false;
                    yield "Thank you for using MiniBank.";
                }
                default -> "Invalid choice!";
            };

            System.out.println(message);
        }
         sc.close();
    }}