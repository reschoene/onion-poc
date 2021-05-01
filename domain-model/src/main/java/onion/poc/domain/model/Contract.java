package onion.poc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
public class Contract {
    private LocalDate startDate;
    private LocalDate endDate;
    private double maintenanceFee;
    private BankAccount account;
    private Customer customer;
}
