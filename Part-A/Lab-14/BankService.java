import java.util.ArrayList;

public class BankService {

    ArrayList<Account> accounts = new ArrayList<>();

    void addAccount(String name, double balance) {
        accounts.add(new Account(name, balance));
    }

    int getCount() {
        return accounts.size();
    }

    void withdraw(int index, double amount) {
        if (index < 0 || index >= accounts.size())
            throw new IllegalArgumentException("Invalid account");

        accounts.get(index).balance -= amount;
    }
}