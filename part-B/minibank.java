
import java.util.*;
import java.util.regex.*;

public class minibank {

    record BankInfo(String name, String branch) {}

    enum MenuOption { OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT }
    enum TransactionType { DEPOSIT, WITHDRAW, TRANSFER }

    record Command(TransactionType type, String accountNumber, long amount) {}

    static class Validator {
        static boolean check(String s, String regex) {
            return Pattern.matches(regex, s);
        }

        public static boolean isValidMobile(String s) {
            return check(s, "[6-9][0-9]{9}");
        }

        public static boolean isValidEmail(String s) {
            return check(s, "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        }

        public static boolean isValidPan(String s) {
            return check(s, "[A-Z]{5}[0-9]{4}[A-Z]");
        }

        public static boolean isValidIfsc(String s) {
            return check(s, "[A-Z]{4}0[A-Z0-9]{6}");
        }

        public static boolean isValidAmount(String s) {
            return check(s, "[1-9][0-9]*");
        }
    }

    static class CommandParser {
        public static Command parse(String line) {
            String[] p = line.trim().split(" ");

            if (p.length != 3)
                throw new IllegalArgumentException("Invalid command");

            TransactionType type = TransactionType.valueOf(p[0]);
            long amount = Long.parseLong(p[2]);

            return new Command(type, p[1], amount);
        }
    }

    static class StatementFormatter {
        public static String buildStatement(Account a) {
            StringBuilder s = new StringBuilder();
            s.append("----- Account Statement -----\n");
            s.append("Account: ").append(a.getAccountNumber()).append("\n");
            s.append("Owner: ").append(a.getOwnerName()).append("\n");
            s.append("Balance: ").append(a.getBalance());
            return s.toString();
        }
    }

    static class Customer {
        private String name, email, mobile;
        private final String customerId;
        private static int counter = 100;

        Customer(String n, String e, String m) {
            name=n; email=e; mobile=m;
            customerId="CUST"+(++counter);
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getMobile() { return mobile; }
    }

    static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;
        private static int counter;

        Account(String owner, long balance) {
            ownerName=owner; this.balance=balance;
            accountNumber=String.format("AC%04d", ++counter);
        }

        Account(String owner) { this(owner, 0); }

        public void deposit(long n) {
            if(n > 0) balance += n;
        }

        public boolean withdraw(long n) {
            if(n > 0 && n <= balance) {
                balance -= n;
                return true;
            }
            return false;
        }

        public String getAccountNumber() { return accountNumber; }
        public String getOwnerName() { return ownerName; }
        public long getBalance() { return balance; }

        public String toString() {
            return accountNumber+" | "+ownerName+" | Balance: "+balance;
        }

        public boolean equals(Object o) {
            if(!(o instanceof Account)) return false;
            return accountNumber.equals(((Account)o).accountNumber);
        }

        public int hashCode() {
            return accountNumber.hashCode();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankInfo bank = new BankInfo("Mini Bank", "Charusat Branch");

        System.out.println(bank.name()+" - "+bank.branch());

        System.out.println("Mobile: "+Validator.isValidMobile("9876543210"));
        System.out.println("Mobile: "+Validator.isValidMobile("1234567890"));
        System.out.println("Email: "+Validator.isValidEmail("abc@gmail.com"));
        System.out.println("Email: "+Validator.isValidEmail("abc@"));
        System.out.println("PAN: "+Validator.isValidPan("ABCDE1234F"));
        System.out.println("PAN: "+Validator.isValidPan("ABC123"));
        System.out.println("IFSC: "+Validator.isValidIfsc("SBIN0001234"));
        System.out.println("IFSC: "+Validator.isValidIfsc("ABC123"));

        Command c = CommandParser.parse("DEPOSIT AC0001 500");
        System.out.println(c.type()+" "+c.accountNumber()+" "+c.amount());

        Account a = new Account("Riya", 5000);
        a.deposit(1000);

        System.out.println(a);
        System.out.println(StatementFormatter.buildStatement(a));

        boolean running = true;
        while(running) {
            System.out.println("\n1.Open Account\n2.Deposit\n3.Withdraw");
            System.out.println("4.Transfer\n5.Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            String msg = switch(choice) {
                case 1 -> "Open Account";
                case 2 -> "Deposit";
                case 3 -> "Withdraw";
                case 4 -> "Transfer";
                case 5 -> { running=false; yield "Goodbye!"; }
                default -> "Invalid choice!";
            };
            System.out.println(msg);
        }
        sc.close();
    }
}

