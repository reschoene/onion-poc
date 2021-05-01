package onion.poc.domain.services.repository;

import onion.poc.domain.model.Customer;

public interface CustomerRepository {
    void create(Customer customer);
    Customer getByCpf(String cpf);
    Customer getByCnpj(String cnpj);
    void update(Customer customer);
    void delete(Customer customer);
}