package onion.poc.domain.services.repository;

import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ContractRepository {
    long create(Contract contract);
    Optional<Contract> getById(long id);
    List<Contract> getByCustomer(Customer customer);
    List<Contract> getByAccount(BankAccount bankAccount);
    void update(Contract contract);
    void delete(Contract contract);
}
