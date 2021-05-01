package onion.poc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter @Setter
public class Contract {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double maintenanceFee;
    private BankAccount account;
    private Customer customer;
}
