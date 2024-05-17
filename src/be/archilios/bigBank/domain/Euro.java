package be.archilios.bigBank.domain;

import java.math.BigDecimal;

public class Euro {
    private final BigDecimal amount;
    
    public Euro(double amount) {
        this(BigDecimal.valueOf(amount));
    }
    
    public Euro(BigDecimal amount) {
        validate(amount);
        this.amount = amount;
    }
    
    private void validate(BigDecimal amount) {
        if (isNegative(amount)) throw new RuntimeException("You can't have a negative amount of euros");
    }
    
    private boolean isNegative(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }
    
    public BigDecimal value() {
        return amount;
    }
    
    public Euro subtract(Euro euro) {
        return new Euro(value().subtract(euro.value()));
    }
    
    public Euro add(Euro euro) {
        return new Euro(value().add(euro.value()));
    }
    
    @Override
    public String toString() {
        return "Euro{" +
                String.format("amount= € %.2f", amount) +
                '}';
    }
}
