package onion.poc.external.services.spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.BankAccount;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {
    private long number;
    private CustomerDto owner;
    private double balance;

    public static BankAccountDto fromModel(BankAccount bankAccount){
        if (bankAccount == null)
            return null;

        return BankAccountDto.builder()
                .number(bankAccount.getNumber())
                .owner(CustomerDto.fromModel(bankAccount.getOwner()))
                .balance(bankAccount.getBalance())
                .build();
    }

    public BankAccount toModel(){
        return BankAccount.builder()
                .owner((getOwner() != null ? getOwner().toModel() : null))
                .balance(getBalance())
                .number(getNumber())
                .build();
    }
}
