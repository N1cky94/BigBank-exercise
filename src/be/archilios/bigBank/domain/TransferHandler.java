package be.archilios.bigBank.domain;

public class TransferHandler {
    public void transfer(TransferCommand command) {
        Transaction transaction = new Transaction(
                command.sender.getIban(),
                command.receiver.getIban(),
                command.amount()
        );
        
        command.sender.withdraw(transaction);
        command.receiver.deposit(transaction);
    }
    
    public record TransferCommand(BankAccount sender, BankAccount receiver, Euro amount) {
    
    }
}
