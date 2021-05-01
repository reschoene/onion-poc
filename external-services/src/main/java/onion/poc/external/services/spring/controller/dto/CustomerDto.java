package onion.poc.external.services.spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Customer;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String firstName;
    private String familyName;
    private String cpf;
    private String cnpj;
    private AddressDto address;

    public static CustomerDto fromModel(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .familyName(customer.getFamilyName())
                .cpf(customer.getCpf())
                .cnpj(customer.getCnpj())
                .address(AddressDto.fromModel(customer.getAddress()))
                .build();
    }

    public Customer toModel(){
        return Customer.builder()
                .id(getId())
                .firstName(getFirstName())
                .familyName(getFamilyName())
                .cpf(getCpf())
                .cnpj(getCnpj())
                .address(getAddress().toModel())
                .build();
    }
}
