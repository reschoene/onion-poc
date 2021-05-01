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
    @JoinColumn(name = "id", referencedColumnName = "id")
    private CustomerEntity owner;

    private double balance;

    public static BankAccountEntity fromModel(BankAccount bankAccount){
        return BankAccountEntity.builder()
                .id(bankAccount.getNumber())
                .owner(CustomerEntity.fromModel(bankAccount.getOwner()))
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
