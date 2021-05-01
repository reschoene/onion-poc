package onion.poc.external.services.spring.controller.dto;

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
    private CustomerDto customer;

    public static ContractDto fromModel(Contract contract){
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
                .customer(getCustomer().toModel())
                .account(getAccount().toModel())
                .startDate(getStartDate())
                .endDate(getEndDate())
                .maintenanceFee(getMaintenanceFee())
                .build();
    }
}
