package onion.poc.external.services.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.BankAccount;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BankAccount")
public class BankAccountEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private CustomerEntity owner;

    private double balance;

    public static BankAccountEntity fromModel(BankAccount bankAccount, CustomerEntity customerEntity){
        if (bankAccount == null)
            return null;

        return BankAccountEntity.builder()
                .id(bankAccount.getNumber())
                .owner(customerEntity)
                .balance(bankAccount.getBalance())
                .build();
    }

    public BankAccount toModel(){
        return BankAccount.builder()
                .owner(getOwner().toModel())
                .balance(getBalance())
                .number(getId())
                .build();
    }
}
