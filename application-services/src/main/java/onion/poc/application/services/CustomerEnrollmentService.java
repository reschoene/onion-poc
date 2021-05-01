package onion.poc.application.services;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.BankAccountRepository;
import onion.poc.domain.services.repository.ContractRepository;
import onion.poc.domain.services.repository.CustomerRepository;
import onion.poc.domain.services.usecases.CustomerEnrollment;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class CustomerEnrollmentService implements CustomerEnrollment {
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public boolean enrollNewCustomer(Customer customer) {
        try{
            BankAccount account = BankAccount.builder()
                    .balance(0)
                    .owner(customer)
                    .build();

            long accountNumber = bankAccountRepository.create(account);
            account.setNumber(accountNumber);

            customerRepository.create(customer);

            Contract contract = Contract.builder()
                    .startDate(LocalDate.now())
                    .maintenanceFee(10.30)
                    .customer(customer)
                    .account(account)
                    .build();

            contractRepository.create(contract);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean unEnrollCustomer(Customer customer) {
        List<Contract> contracts = contractRepository.getByCustomer(customer);

        try {
            for (Contract c : contracts) {
                c.setEndDate(LocalDate.now());
                contractRepository.update(c);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
