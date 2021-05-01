package onion.poc.domain.services.usecases;

import onion.poc.domain.model.Customer;

public interface CustomerEnrollment {
    boolean enrollNewCustomer(Customer customer);
    boolean unEnrollCustomer(Customer customer);
}
