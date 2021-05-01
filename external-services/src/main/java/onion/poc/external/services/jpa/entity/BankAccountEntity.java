package onion.poc.external.services.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.BankAccount;
import onion.poc.domain.model.Customer;

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
    private long number;
    private CustomerEntity owner;
    private double balance;

    public static BankAccountEntity fromModel(BankAccount bankAccount){
        return BankAccountEntity.builder()
                .number(bankAccount.getNumber())
                .owner(CustomerEntity.fromModel(bankAccount.getOwner()))
                .balance(bankAccount.getBalance())
                .build();
    }

    public BankAccount toModel(){
        return BankAccount.builder()
                .owner(getOwner().toModel())
                .balance(getBalance())
                .number(getNumber())
                .build();
    }
}
