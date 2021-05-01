package onion.poc.external.services.jpa.repository.springdata;

import onion.poc.external.services.jpa.entity.BankAccountEntity;
import onion.poc.external.services.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountSpringJPA extends JpaRepository<BankAccountEntity, Long> {
    List<BankAccountEntity> findByOwner(CustomerEntity owner);
}
