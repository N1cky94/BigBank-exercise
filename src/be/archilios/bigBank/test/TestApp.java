package be.archilios.bigBank.test;

import be.archilios.bigBank.domain.BankAccount;
import be.archilios.bigBank.domain.Euro;
import be.archilios.bigBank.domain.InMemoryAccountRepository;
import be.archilios.bigBank.domain.TransferHandler;

import static be.archilios.bigBank.test.CustomAssertion.*;

public class TestApp {
    public static void main(String[] args) {
        givenTwoBankAccounts_whenMoneyIsTransfered_TheBalancesShouldBeAdjusted();
        givenTwoIdenticalBankAccounts_whenMoneyIsTransfered_anErrorShouldBeThrown();
    }
    
    public static void givenTwoBankAccounts_whenMoneyIsTransfered_TheBalancesShouldBeAdjusted() {
        InMemoryAccountRepository.resetDataStore();
        InMemoryAccountRepository accountRepository = InMemoryAccountRepository.getInstance();
        
        BankAccount owner = accountRepository.getAccountByIban("BE1234567891234");
        BankAccount receiver = accountRepository.getAccountByIban("BE1234567895678");
        
        TransferHandler handler = new TransferHandler();
        handler.transfer(new TransferHandler.TransferCommand(owner, receiver, new Euro(23.5)));
        
        assertEquals(owner.getBalance(), new Euro(250-23.5));
        assertEquals(receiver.getBalance(), new Euro(150+23.5));
    }
    
    public static void givenTwoIdenticalBankAccounts_whenMoneyIsTransfered_anErrorShouldBeThrown() {
        InMemoryAccountRepository.resetDataStore();
        InMemoryAccountRepository accountRepository = InMemoryAccountRepository.getInstance();
        BankAccount owner = accountRepository.getAccountByIban("BE1234567891234");
        TransferHandler handler = new TransferHandler();
        
        assertThrows(RuntimeException.class, () -> handler.transfer(new TransferHandler.TransferCommand(owner, owner, new Euro(23.5))));
    }
}
