package onion.poc.external.services.jpa.repository.springdata;

import onion.poc.external.services.jpa.entity.ContractEntity;
import onion.poc.external.services.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerSpringJPA extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByCpf(String cpf);
    List<CustomerEntity> findByCnpj(String cnpj);
}
