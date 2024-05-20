package be.archilios.bigBank.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public class BankAccount {
    private final String iban;
    private String accountHolder;
    private EuroBalance balance;
    private final AccountTransactions transactions;
    
    public BankAccount(String iban, String accountHolder, Euro balance, AccountTransactions transactions) {
        this.iban = iban;
        this.accountHolder = accountHolder;
        this.balance = new EuroBalance(balance);
        this.transactions = transactions;
    }
    
    public String getIban() {
        return iban;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public EuroBalance getBalance() {
        return balance;
    }
    
    public AccountTransactions getTransactions() {
        return transactions;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public void withdraw(Transaction trans) {
        balance.subtractMoney(trans.transferAmount());
        transactions.registerWithdrawTransaction(trans);
    }
    
    public void deposit(Transaction trans) {
        balance.addMoney(trans.transferAmount());
        transactions.registerDepositTransaction(trans);
    }
    
    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        BankAccount that = (BankAccount) o;
        return Objects.equals(getIban(), that.getIban()) && Objects.equals(getAccountHolder(), that.getAccountHolder());
    }
    
    @Override
    public int hashCode() {
        int result = Objects.hashCode(getIban());
        result = 31 * result + Objects.hashCode(getAccountHolder());
        return result;
    }
}
