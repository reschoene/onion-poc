package onion.poc.application.services;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.BankAccountRepository;
import onion.poc.domain.services.usecases.AccountManagement;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountManagementService implements AccountManagement {
    private final BankAccountRepository repository;

    @Override
    public void create(BankAccount account) {
        repository.create(account);
    }

    @Override
    public Optional<BankAccount> getByNumber(long accountNumber) {
        return repository.getByNumber(accountNumber);
    }

    @Override
    public List<BankAccount> getByCustomer(Customer customer) {
        return repository.getByCustomer(customer);
    }

    @Override
    public void update(BankAccount bankAccount) {
        repository.update(bankAccount);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        repository.delete(bankAccount);
    }
}
