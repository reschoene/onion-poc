package onion.poc.external.services.spring.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Contract;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double maintenanceFee;
    private BankAccountDto account;

    @JsonIgnore
    private CustomerDto customer;

    public static ContractDto fromModel(Contract contract){
        if (contract == null)
            return null;

        return ContractDto.builder()
                .id(contract.getId())
                .customer(CustomerDto.fromModel(contract.getCustomer()))
                .account(BankAccountDto.fromModel(contract.getAccount()))
                .startDate(contract.getStartDate())
                .endDate(contract.getEndDate())
                .maintenanceFee(contract.getMaintenanceFee())
                .build();
    }

    public Contract toModel(){
        return Contract.builder()
                .id(getId())
                .customer((getCustomer() != null ? getCustomer().toModel() : null))
                .account((getAccount() != null ? getAccount().toModel() : null))
                .startDate(getStartDate())
                .endDate(getEndDate())
                .maintenanceFee(getMaintenanceFee())
                .build();
    }
}
