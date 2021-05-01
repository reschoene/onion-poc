package onion.poc.external.services.spring.jpa.repository.springdata;

import onion.poc.external.services.spring.jpa.entity.BankAccountEntity;
import onion.poc.external.services.spring.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountSpringJPA extends JpaRepository<BankAccountEntity, Long> {
    List<BankAccountEntity> findByOwner(CustomerEntity owner);
}
