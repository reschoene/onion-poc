package onion.poc.external.services.spring.jpa.repository;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Customer;
import onion.poc.domain.services.repository.BankAccountRepository;
import onion.poc.external.services.spring.jpa.entity.BankAccountEntity;
import onion.poc.external.services.spring.jpa.entity.CustomerEntity;
import onion.poc.external.services.spring.jpa.repository.springdata.BankAccountSpringJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BankAccountJPARepository implements BankAccountRepository {
    private final BankAccountSpringJPA jpaRepo;

    @Override
    public long create(BankAccount account) {
        BankAccountEntity entity = BankAccountEntity.fromModel(account);
        entity.setNumber(0);
        return jpaRepo.save(entity).getNumber();
    }

    @Override
    public Optional<BankAccount> getByNumber(long accountNumber) {
        Optional<BankAccountEntity> entity = jpaRepo.findById(accountNumber);
        return entity.map(BankAccountEntity::toModel);
    }

    @Override
    public List<BankAccount> getByCustomer(Customer customer) {
        return jpaRepo.findByOwner(CustomerEntity.fromModel(customer))
                .stream()
                .map(BankAccountEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void update(BankAccount bankAccount) {
        var optEntity = jpaRepo.findById(bankAccount.getNumber());
        if(optEntity.isPresent()){
            var entity = optEntity.get();
            entity.setNumber(bankAccount.getNumber());
            entity.setBalance(bankAccount.getBalance());
            jpaRepo.save(entity);
        }
    }

    @Override
    public void delete(BankAccount bankAccount) {
        var optEntity = jpaRepo.findById(bankAccount.getNumber());
        optEntity.ifPresent(jpaRepo::delete);
    }
}
