package be.archilios.bigBank.domain;

import java.security.InvalidParameterException;

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
}
