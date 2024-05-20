package be.archilios.bigBank;

import be.archilios.bigBank.domain.*;

public class BigBankApp {
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("BE1234567891234", "NICK BAUTERS", new Euro(250), new AccountTransactions());
        BankAccount acc2 = new BankAccount("BE1234567895678", "KELLY DE LANGE", new Euro(150), new AccountTransactions());
        
        TransferHandler handler = new TransferHandler();
        handler.transfer(new TransferHandler.TransferCommand(acc1, acc2, new Euro(23.5)));
        
        System.out.println(acc1);
        System.out.println(acc2);
        
        
    }
    
}
