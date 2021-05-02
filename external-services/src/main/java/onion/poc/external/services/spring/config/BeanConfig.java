package onion.poc.external.services.spring.config;

import lombok.RequiredArgsConstructor;
import onion.poc.application.services.AccountManagementService;
import onion.poc.application.services.CustomerEnrollmentService;
import onion.poc.domain.model.AccountTransferService;
import onion.poc.domain.services.FundsTransferService;
import onion.poc.domain.services.repository.BankAccountRepository;
import onion.poc.domain.services.repository.ContractRepository;
import onion.poc.domain.services.repository.CustomerRepository;
import onion.poc.domain.services.usecases.AccountManagement;
import onion.poc.domain.services.usecases.CustomerEnrollment;
import onion.poc.external.services.spring.jpa.repository.BankAccountJPARepository;
import onion.poc.external.services.spring.jpa.repository.ContractJPARepository;
import onion.poc.external.services.spring.jpa.repository.CustomerJPARepository;
import onion.poc.external.services.spring.jpa.repository.springdata.BankAccountSpringJPA;
import onion.poc.external.services.spring.jpa.repository.springdata.ContractSpringJPA;
import onion.poc.external.services.spring.jpa.repository.springdata.CustomerSpringJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {
    private final BankAccountSpringJPA bankAccountSpringJPA;
    private final CustomerSpringJPA customerSpringJPA;
    private final ContractSpringJPA contractSpringJPA;

    @Bean
    public AccountTransferService getAccountTransferService(){
        return new FundsTransferService();
    }

    @Bean
    public BankAccountRepository getBankAccountRepository(){
        return new BankAccountJPARepository(bankAccountSpringJPA);
    }

    @Bean
    public CustomerRepository getCustomerRepository(){
        return new CustomerJPARepository(customerSpringJPA);
    }

    @Bean
    public ContractRepository getContractRepository(){
        return new ContractJPARepository(contractSpringJPA);
    }

    @Bean
    public AccountManagement getAccountManagement(){
        return new AccountManagementService(getBankAccountRepository());
    }

    @Bean
    public CustomerEnrollment getCustomerEnrollment(){
        return new CustomerEnrollmentService(getContractRepository());
    }
}
