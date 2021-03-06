package onion.poc.domain.services.repository;

import onion.poc.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
    long create(Customer customer);
    Optional<Customer> getByCpf(String cpf);
    Optional<Customer> getByCnpj(String cnpj);
    void update(Customer customer);
    void delete(Customer customer);
}