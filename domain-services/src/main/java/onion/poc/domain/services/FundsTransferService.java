package onion.poc.domain.services;

import onion.poc.domain.exception.DepositException;
import onion.poc.domain.exception.WithdrawException;
import onion.poc.domain.model.AccountTransferService;
import onion.poc.domain.model.BankAccount;

public class FundsTransferService implements AccountTransferService {
    @Override
    public boolean transfer(double amount, BankAccount from, BankAccount to) {
        boolean result = true;

        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (WithdrawException | DepositException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
