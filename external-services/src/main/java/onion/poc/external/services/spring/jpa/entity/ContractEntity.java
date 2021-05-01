package onion.poc.external.services.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Contract;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Contract")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double maintenanceFee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number", referencedColumnName = "id")
    private BankAccountEntity account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private CustomerEntity customer;

    public static ContractEntity fromModel(Contract contract){
        return ContractEntity.builder()
                .id(contract.getId())
                .customer(CustomerEntity.fromModel(contract.getCustomer()))
                .account(BankAccountEntity.fromModel(contract.getAccount()))
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
