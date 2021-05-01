package onion.poc.external.services.jpa.repository;

import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.ContractRepository;

import java.util.List;

public class ContractJPARepository implements ContractRepository {
    @Override
    public void create(Contract contract) {

    }

    @Override
    public List<Contract> getByCustomer(Customer customer) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
