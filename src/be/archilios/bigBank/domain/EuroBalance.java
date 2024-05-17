package be.archilios.bigBank.domain;

public class EuroBalance {
    private Euro balance;
    
    public EuroBalance(Euro balance) {
        this.balance = balance;
    }
    
    public Euro getBalance() {
        return balance;
    }
    
    public void addMoney(Euro amount) {
        this.balance = balance.add(amount);
    }
    
    public void subtractMoney(Euro amount) {
        if (!enoughBalanceAvailable(amount)) throw new RuntimeException("Insufficient balance on account");
        this.balance = balance.subtract(amount);
    }
    
    private boolean enoughBalanceAvailable(Euro amount) {
        try {
            balance.subtract(amount);
        } catch (RuntimeException re) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "EuroBalance{" +
                "balance=" + balance +
                '}';
    }
}
