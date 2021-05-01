package onion.poc.external.services.jpa.repository;

import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.BankAccountRepository;

import java.util.List;

public class BankAccountJPARepository implements BankAccountRepository {
    @Override
    public void create(BankAccount account) {

    }

    @Override
    public BankAccount getByNumber(long accountNumber) {
        return null;
    }

    @Override
    public List<BankAccount> getByCustomer(Customer customer) {
        return null;
    }

    @Override
    public void update(BankAccount bankAccount) {

    }

    @Override
    public void delete(BankAccount bankAccount) {

    }
}
