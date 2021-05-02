package onion.poc.domain.services.usecases;

import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;

import java.util.List;

public interface CustomerEnrollment {
    Contract enrollNewCustomer(Customer customer);
    List<Contract> unEnrollCustomer(Customer customer);
}
