package onion.poc.domain.services.repository;

import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;

import java.util.List;

public interface ContractRepository {
    void create(Contract contract);
    List<Contract> getByCustomer(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
}
