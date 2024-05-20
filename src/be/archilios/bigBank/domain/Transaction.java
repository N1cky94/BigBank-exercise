package be.archilios.bigBank.domain;

public record Transaction(String senderIban, String receiverIban, Euro transferAmount) {

}
