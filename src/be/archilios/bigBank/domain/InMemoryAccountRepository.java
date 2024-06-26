package be.archilios.bigBank.domain;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository {
    private static final List<BankAccount> ACCOUNTS = new ArrayList<>();
    private static final InMemoryAccountRepository REPOSITORY = new InMemoryAccountRepository();
    
    private InMemoryAccountRepository() {
        initializeDataStore();
    }
    
    private static void initializeDataStore() {
        ACCOUNTS.add(new BankAccount("BE1234567891234", "NICK BAUTERS", new Euro(250), new AccountTransactions()));
        ACCOUNTS.add(new BankAccount("BE1234567895678", "KELLY DE LANGE", new Euro(150), new AccountTransactions()));
    }
    
    public static void resetDataStore() {
        while(!ACCOUNTS.isEmpty()) {
            ACCOUNTS.removeFirst();
        }
        
        initializeDataStore();
    }
    
    public static InMemoryAccountRepository getInstance() {
        return REPOSITORY;
    }
    
    
    
    public BankAccount getAccountByIban(String iban) {
        return ACCOUNTS.stream()
                .filter(
                        a -> a.getIban().equals(iban)
                    )
                .findFirst()
                .orElseThrow();
    }
}
