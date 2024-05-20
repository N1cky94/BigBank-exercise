package be.archilios.bigBank;

import be.archilios.bigBank.domain.*;

public class BigBankApp {
    
    public static void main(String[] args) {
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();
        
        BankAccount owner = accountRepository.getAccountByIban("BE1234567891234");
        BankAccount receiver = accountRepository.getAccountByIban("BE1234567895678");
        
        TransferHandler handler = new TransferHandler();
        handler.transfer(new TransferHandler.TransferCommand(owner, receiver, new Euro(23.5)));
        
        System.out.println(owner);
        System.out.println(receiver);
        
        
    }
    
}
