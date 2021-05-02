package onion.poc.external.services.spring.jpa.repository;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.CustomerRepository;
import onion.poc.external.services.spring.jpa.entity.AddressEntity;
import onion.poc.external.services.spring.jpa.entity.CustomerEntity;
import onion.poc.external.services.spring.jpa.repository.springdata.CustomerSpringJPA;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerJPARepository implements CustomerRepository {
    private final CustomerSpringJPA jpaRepo;

    @Override
    public long create(Customer customer) {
        var addressEntity = AddressEntity.fromModel(customer.getAddress());
        CustomerEntity entity = CustomerEntity.fromModel(customer, addressEntity);
        entity.setId(0);
        return jpaRepo.save(entity).getId();
    }

    @Override
    public Optional<Customer> getByCpf(String cpf) {
        return jpaRepo.findByCpf(cpf)
                .stream()
                .map(CustomerEntity::toModel)
                .findFirst();
    }

    @Override
    public Optional<Customer> getByCnpj(String cnpj) {
        return jpaRepo.findByCnpj(cnpj)
                .stream()
                .map(CustomerEntity::toModel)
                .findFirst();
    }

    @Override
    public void update(Customer customer) {
        var optEntity = jpaRepo.findById(customer.getId());
        if(optEntity.isPresent()){
            var entity = optEntity.get();
            entity.setCnpj(customer.getCnpj());
            entity.setCpf(customer.getCpf());
            entity.setFirstName(customer.getFirstName());
            entity.setFamilyName(customer.getFamilyName());
            jpaRepo.save(entity);
        }
    }

    @Override
    public void delete(Customer customer) {
        var optEntity = jpaRepo.findById(customer.getId());
        optEntity.ifPresent(jpaRepo::delete);
    }
}
