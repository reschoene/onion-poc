package onion.poc.external.services.jpa.repository;

import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.CustomerRepository;

public class CustomerJPARepository implements CustomerRepository {
    @Override
    public void create(Customer customer) {

    }

    @Override
    public Customer getByCpf(String cpf) {
        return null;
    }

    @Override
    public Customer getByCnpj(String cnpj) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
