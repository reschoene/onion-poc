package onion.poc.domain.model;

import lombok.*;
import onion.poc.domain.exception.DepositException;
import onion.poc.domain.exception.WithdrawException;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BankAccount {
    private long number;
    private Customer owner;
    private double balance;

    public double withdraw(double value) throws WithdrawException {
        if(balance < value )
            throw new WithdrawException("Current balance is less than given amount");

        balance -= value;

        return balance;
    }

    public double deposit(double value) throws DepositException{
        if (value <= 0)
            throw new DepositException("Deposit value must be positive");

        balance += value;

        return balance;
    }
}
