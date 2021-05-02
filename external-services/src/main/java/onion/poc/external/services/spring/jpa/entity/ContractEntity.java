package onion.poc.external.services.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Contract;

import javax.persistence.*;
import javax.security.auth.login.AccountException;
import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Contract")
public class ContractEntity implements ConvertableEntity<ContractEntity, Contract>{
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

    @Override
    public void loadFromModel(Contract contract){
        if (contract != null){
            id = contract.getId();
            startDate = contract.getStartDate();
            endDate = contract.getEndDate();
            maintenanceFee = contract.getMaintenanceFee();
        }
    }

    @Override
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
