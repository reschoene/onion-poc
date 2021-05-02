package onion.poc.external.services.spring.jpa.repository;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.ContractRepository;
import onion.poc.external.services.spring.jpa.entity.AddressEntity;
import onion.poc.external.services.spring.jpa.entity.BankAccountEntity;
import onion.poc.external.services.spring.jpa.entity.ContractEntity;
import onion.poc.external.services.spring.jpa.entity.CustomerEntity;
import onion.poc.external.services.spring.jpa.repository.springdata.ContractSpringJPA;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ContractJPARepository implements ContractRepository {
    private final ContractSpringJPA jpaRepo;

    @Override
    public long create(Contract contract) {
        var addressEntity = new AddressEntity();
        var customerEntity = new CustomerEntity();
        var bankAccountEntity = new BankAccountEntity();
        var contractEntity = new ContractEntity();

        addressEntity.loadFromModel(contract.getCustomer().getAddress());
        customerEntity.loadFromModel(contract.getCustomer());
        bankAccountEntity.loadFromModel(contract.getAccount());
        contractEntity.loadFromModel(contract);

        customerEntity.setAddress(addressEntity);
        bankAccountEntity.setOwner(customerEntity);
        contractEntity.setAccount(bankAccountEntity);
        contractEntity.setCustomer(customerEntity);

        contractEntity.setId(0);
        return jpaRepo.save(contractEntity).getId();
    }

    @Override
    public List<Contract> getByCustomer(Customer customer) {
        var addressEntity = new AddressEntity();
        var customerEntity = new CustomerEntity();

        addressEntity.loadFromModel(customer.getAddress());
        customerEntity.loadFromModel(customer);

        customerEntity.setAddress(addressEntity);

        return jpaRepo.findByCustomer(customerEntity)
                .stream()
                .map(ContractEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Contract contract) {
        var optEntity = jpaRepo.findById(contract.getId());
        if(optEntity.isPresent()){
            var entity = optEntity.get();
            entity.setStartDate(contract.getStartDate());
            entity.setEndDate(contract.getEndDate());
            entity.setMaintenanceFee(contract.getMaintenanceFee());
            jpaRepo.save(entity);
        }
    }

    @Override
    public void delete(Contract contract) {
        var optEntity = jpaRepo.findById(contract.getId());
        optEntity.ifPresent(jpaRepo::delete);
    }
}
