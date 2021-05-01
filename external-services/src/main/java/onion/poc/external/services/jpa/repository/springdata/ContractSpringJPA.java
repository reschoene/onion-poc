package onion.poc.external.services.jpa.repository.springdata;

import onion.poc.external.services.jpa.entity.BankAccountEntity;
import onion.poc.external.services.jpa.entity.ContractEntity;
import onion.poc.external.services.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractSpringJPA extends JpaRepository<ContractEntity, Long> {
    List<ContractEntity> findByCustomer(CustomerEntity owner);
}
