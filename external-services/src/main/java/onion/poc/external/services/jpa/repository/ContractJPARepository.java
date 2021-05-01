package onion.poc.external.services.jpa.repository;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.Contract;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.ContractRepository;
import onion.poc.external.services.jpa.entity.ContractEntity;
import onion.poc.external.services.jpa.entity.CustomerEntity;
import onion.poc.external.services.jpa.repository.springdata.ContractSpringJPA;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ContractJPARepository implements ContractRepository {
    private final ContractSpringJPA jpaRepo;

    @Override
    public long create(Contract contract) {
        ContractEntity entity = ContractEntity.fromModel(contract);
        entity.setId(0);
        return jpaRepo.save(entity).getId();
    }

    @Override
    public List<Contract> getByCustomer(Customer customer) {
        return jpaRepo.findByCustomer(CustomerEntity.fromModel(customer))
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
