
import java.util.*;

public class minibank {

    record BankInfo(String name, String branch) {}

    enum MenuOption {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
    }

    static class Customer implements Cloneable {
        private String name, email, mobile;
        private final String customerId;
        private Address address;
        private static long customerCounter = 100;

        Customer(String n, String e, String m, Address a) {
            name=n; email=e; mobile=m; address=a;
            customerId="CUST"+(++customerCounter);
        }

        public String getName(){ return name; }
        public String getEmail(){ return email; }
        public String getMobile(){ return mobile; }
        public String getCustomerId(){ return customerId; }
        public Address getAddress(){ return address; }

        public Customer clone() {
            try { return (Customer)super.clone(); }
            catch(CloneNotSupportedException e){ return null; }
        }

        public static class Address {
            private String line, city, pincode;

            Address(String l, String c, String p) {
                line=l; city=c; pincode=p;
            }

            public String getLine(){ return line; }
            public String getCity(){ return city; }
            public String getPincode(){ return pincode; }
        }
    }

    static class Account {
        private final String accountNumber;
        private String ownerName;
        private long balance;
        private boolean active;
        private static int counter=0;

        Account(String owner, long balance) {
            ownerName=owner; this.balance=balance; active=true;
            accountNumber=String.format("AC%04d",++counter);
        }

        Account(String owner){ this(owner,0); }

        public void deposit(long n){ if(n>0) balance+=n; }

        public boolean withdraw(long n) {
            if(n>0 && n<=balance){ balance-=n; return true; }
            return false;
        }

        public String getAccountNumber(){ return accountNumber; }
        public String getOwnerName(){ return ownerName; }
        public long getBalance(){ return balance; }

        public String toString() {
            return accountNumber+" | "+ownerName+
                   " | Balance: "+balance+" | Active: "+active;
        }

        public boolean equals(Object o) {
            if(this==o) return true;
            if(!(o instanceof Account)) return false;
            Account a=(Account)o;
            return accountNumber.equals(a.accountNumber);
        }

        public int hashCode(){ return accountNumber.hashCode(); }
    }

    static boolean transfer(Account a, Account b, long n) {
        if(a.withdraw(n)){ b.deposit(n); return true; }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankInfo bank=new BankInfo("Mini Bank","Charusat Branch");

        System.out.println("=================================");
        System.out.println("      "+bank.name());
        System.out.println("      "+bank.branch());
        System.out.println("=================================");

        Customer.Address ad=new Customer.Address(
                "Main Road","Anand","388001");
        Customer c1=new Customer(
                "Riya","riya@gmail.com","9999999999",ad);

        Customer c2=c1.clone();
        System.out.println("Customer: "+c1.getName());
        System.out.println("Address: "+c1.getAddress().getCity());
        System.out.println("Clone: "+c2.getName());

        Account[] accounts={
            new Account("Riya",5000),
            new Account("Aarav",3000),
            new Account("Dhru",1000)
        };

        accounts[0].deposit(1000);
        accounts[1].withdraw(500);
        transfer(accounts[0],accounts[2],1000);

        for(Account a:accounts) System.out.println(a);

        System.out.println("Same account? "+accounts[0].equals(accounts[1]));
        System.out.println("Is Account? "+(accounts[0] instanceof Account));

        boolean running=true;
        while(running) {
            System.out.println("\n1.Open Account\n2.Deposit\n3.Withdraw");
            System.out.println("4.Transfer\n5.Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();

            String msg=switch(choice) {
                case 1 -> "Open Account - Feature added.";
                case 2 -> "Deposit - Feature added.";
                case 3 -> "Withdraw - Feature added.";
                case 4 -> "Transfer - Feature added.";
                case 5 -> { running=false; yield "Goodbye!"; }
                default -> "Invalid choice!";
            };
            System.out.println(msg);
        }
        sc.close();
    }
}

