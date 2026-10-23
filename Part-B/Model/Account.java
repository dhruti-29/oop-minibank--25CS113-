package model;

import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import model.annotation.Id;
import model.annotation.Positive;
import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements Transactable, InterestBearing, Comparable<Account>, Serializable {
    private static final long serialVersionUID = 1L;
    private static long counter = 1;
    @Id
    private final String accountNumber;
    private String ownerName;
    @Positive(message = "Balance must be >= 0")
    private long balance;
    private boolean active = true;

    protected Account(String ownerName, long openingBalance) {
        this.accountNumber = String.format("AC%04d", counter++);
        this.ownerName = ownerName;
        this.balance = Math.max(0, openingBalance);
    }
    @Override public synchronized void deposit(long amount) throws BankException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive");
        balance += amount;
    }
    @Override public synchronized boolean withdraw(long amount) throws BankException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be positive");
        if (!canWithdraw(amount)) throw new InsufficientFundsException("Insufficient funds", Math.max(0, amount - balance));
        balance -= amount;
        return true;
    }
    public abstract boolean canWithdraw(long amount);
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public long getBalance() { return balance; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    @Override public int compareTo(Account other) { return accountNumber.compareTo(other.accountNumber); }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | Balance: ₹" + balance; }
    @Override public boolean equals(Object o) { return this == o || (o instanceof Account a && accountNumber.equals(a.accountNumber)); }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
}