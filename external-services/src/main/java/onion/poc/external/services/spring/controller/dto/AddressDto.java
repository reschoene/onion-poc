package onion.poc.external.services.spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Address;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private long id;
    private String zipCode;
    private String street;
    private int number;

    public static AddressDto fromModel(Address address){
        return AddressDto.builder()
                .zipCode(address.getZipCode())
                .street(address.getStreet())
                .number(address.getNumber())
                .build();
    }

    public Address toModel(){
        return Address.builder()
                .zipCode(getZipCode())
                .number(getNumber())
                .street(getStreet())
                .build();
    }
}
