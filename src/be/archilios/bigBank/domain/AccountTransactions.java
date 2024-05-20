package be.archilios.bigBank.domain;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactions {
    private final List<Transaction> depositTransactions;
    private final List<Transaction> withdrawTransactions;
    
    public AccountTransactions() {
        depositTransactions = new ArrayList<>();
        withdrawTransactions = new ArrayList<>();
    }
    
    public AccountTransactions(List<Transaction> depositTransactions, List<Transaction> withdrawTransactions) {
        this.depositTransactions = depositTransactions;
        this.withdrawTransactions = withdrawTransactions;
    }
    
    public List<Transaction> getDepositTransactions() {
        return depositTransactions;
    }
    
    public List<Transaction> getWithdrawTransactions() {
        return withdrawTransactions;
    }
    
    public void registerDepositTransaction(Transaction trans) {
        depositTransactions.add(trans);
    }
    
    public void registerWithdrawTransaction(Transaction trans) {
        withdrawTransactions.add(trans);
    }
    
    @Override
    public String toString() {
        return "AccountTransactions{" +
                "depositTransactions=" + depositTransactions +
                ", withdrawTransactions=" + withdrawTransactions +
                '}';
    }
}
