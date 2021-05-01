package onion.poc.domain.services.repository;

import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;

import java.util.List;

public interface ContractRepository {
    long create(Contract contract);
    List<Contract> getByCustomer(Customer customer);
    void update(Contract contract);
    void delete(Contract contract);
}
