import java.util.Scanner;
import model.*;
import service.BankService;
import exception.BankException;

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();
        BankInfo info = new BankInfo("MiniBank", "Anand");
        System.out.println("================================");
        System.out.println("       " + info.name());
        System.out.println("       Branch: " + info.branch());
        System.out.println("================================");
        boolean running=true;
        while(running) {
            System.out.println("\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Statement\n6. List Accounts\n7. Report\n8. Exit");
            System.out.print("Choice: ");
            if(!sc.hasNextInt()) { System.out.println("Please enter a number."); sc.nextLine(); continue; }
            int choice=sc.nextInt(); sc.nextLine();
            try {
                switch(choice) {
                    case 1 -> {
                        System.out.print("Owner name: "); String name=sc.nextLine();
                        System.out.print("Opening balance: "); long opening=Long.parseLong(sc.nextLine());
                        System.out.print("Type (1 Savings, 2 Current, 3 Fixed Deposit): "); int type=Integer.parseInt(sc.nextLine());
                        Account a=bank.openAccount(name,type,opening);
                        System.out.println("Account created: "+a);
                    }
                    case 2 -> { System.out.print("Account number: "); String id=sc.nextLine(); System.out.print("Amount: "); long amount=Long.parseLong(sc.nextLine()); bank.deposit(id,amount); System.out.println("Deposit successful."); }
                    case 3 -> { System.out.print("Account number: "); String id=sc.nextLine(); System.out.print("Amount: "); long amount=Long.parseLong(sc.nextLine()); bank.withdraw(id,amount); System.out.println("Withdrawal successful."); }
                    case 4 -> { System.out.print("From account: "); String from=sc.nextLine(); System.out.print("To account: "); String to=sc.nextLine(); System.out.print("Amount: "); long amount=Long.parseLong(sc.nextLine()); bank.transfer(from,to,amount); System.out.println("Transfer successful."); }
                    case 5 -> { System.out.print("Account number: "); System.out.println(bank.statement(sc.nextLine())); }
                    case 6 -> bank.listAccounts();
                    case 7 -> bank.report();
                    case 8 -> { bank.saveState(); running=false; System.out.println("Goodbye! Thank you for using MiniBank."); }
                    default -> System.out.println("Invalid choice.");
                }
            } catch(BankException | NumberFormatException e) { System.out.println("Operation failed: "+e.getMessage()); }
            finally { /* one operation has finished */ }
        }
        sc.close();
    }
}