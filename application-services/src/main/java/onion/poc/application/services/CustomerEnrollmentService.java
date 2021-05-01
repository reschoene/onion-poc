package onion.poc.application.services;

import onion.poc.domain.model.Customer;
import onion.poc.domain.services.usecases.CustomerEnrollment;

public class CustomerEnrollmentService implements CustomerEnrollment {
    @Override
    public boolean enrollNewCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean unEnrollCustomer(Customer customer) {
        return false;
    }
}
