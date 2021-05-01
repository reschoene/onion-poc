package onion.poc.external.services.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Address;
import onion.poc.domain.model.Customer;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String zipCode;
    private String street;
    private int number;

    public static AddressEntity fromModel(Address address){
        return AddressEntity.builder()
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
