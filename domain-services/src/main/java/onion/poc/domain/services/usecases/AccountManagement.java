package onion.poc.domain.services.usecases;

import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Customer;

import java.util.List;

public interface AccountManagement {
    void create(BankAccount account);
    BankAccount getByNumber(long accountNumber);
    List<BankAccount> getByCustomer(Customer customer);
    void update(BankAccount bankAccount);
    void delete(BankAccount bankAccount);
}
