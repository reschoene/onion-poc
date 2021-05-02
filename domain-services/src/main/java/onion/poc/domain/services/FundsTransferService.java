package onion.poc.domain.services;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.exception.DepositException;
import onion.poc.domain.exception.WithdrawException;
import onion.poc.domain.model.AccountTransferService;
import onion.poc.domain.model.BankAccount;
import onion.poc.domain.services.repository.BankAccountRepository;

@RequiredArgsConstructor
public class FundsTransferService implements AccountTransferService {
    private final BankAccountRepository bankAccountRepository;

    @Override
    public String transfer(double amount, BankAccount from, BankAccount to) {
        String result = "";

        try {
            from = bankAccountRepository.getByNumber(from.getNumber()).orElseThrow(() -> new WithdrawException("Account from not found"));
            to = bankAccountRepository.getByNumber(to.getNumber()).orElseThrow(() -> new DepositException("Account to not found"));

            from.withdraw(amount);
            to.deposit(amount);

            bankAccountRepository.update(from);
            bankAccountRepository.update(to);

        } catch (WithdrawException | DepositException e) {
            result = e.getMessage();
        }

        return result;
    }
}
