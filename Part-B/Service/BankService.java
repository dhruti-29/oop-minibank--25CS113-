package service;
import exception.*;
import model.*;
import util.*;
import java.io.IOException;
import java.nio.file.*;
public class BankService {
    private final Repository<Account> repository = new Repository<>();
    private final Path logFile = Path.of("logs", "transactions.csv");
    public Account openAccount(String name, int type, long opening) {
        Account a = switch(type) {
            case 2 -> new CurrentAccount(name, opening, 1000);
            case 3 -> new FixedDepositAccount(name, opening);
            default -> new SavingsAccount(name, opening, 0);
        };
        repository.save(a); log("OPEN,"+opening+","+a.getAccountNumber()); return a;
    }
    public void deposit(String id, long amount) throws BankException {
        Account a = require(id); a.deposit(amount); log("DEPOSIT,"+amount+","+id);
    }
    public void withdraw(String id, long amount) throws BankException {
        Account a = require(id); a.withdraw(amount); log("WITHDRAW,"+amount+","+id);
    }
    public void transfer(String from, String to, long amount) throws BankException {
        Account a=require(from), b=require(to);
        try { a.withdraw(amount); b.deposit(amount); log("TRANSFER,"+amount+","+from+","+to); }
        catch (BankException e) { throw e; }
        finally { System.out.println("Transfer attempt finished."); }
    }
    public String statement(String id) throws BankException { return StatementFormatter.buildStatement(require(id)); }
    public void listAccounts() { for(Account a: repository.findAll()) System.out.println(a); }
    public Account require(String id) throws AccountNotFoundException {
        Account a=repository.findById(id); if(a==null) throw new AccountNotFoundException("Account not found: "+id); return a;
    }
    public void saveState() {
        try { Files.createDirectories(Path.of("data")); StatePersister.save(repository.findAll().toArray(new Account[0]), Path.of("data/accounts.bin")); }
        catch(IOException e) { System.out.println("Could not save state: "+e.getMessage()); }
    }
    private void log(String line) { try { Files.createDirectories(logFile.getParent()); TransactionLog.append(logFile,line); } catch(IOException e) { System.out.println("Log warning: "+e.getMessage()); } }
    public void report() { try { ReportGenerator.generate(Path.of("logs"), Path.of("report.txt")); System.out.println("Report written to report.txt"); } catch(IOException e) { System.out.println(e.getMessage()); } }
}