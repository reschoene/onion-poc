package onion.poc.external.services.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import onion.poc.domain.model.Customer;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String familyName;
    private String cpf;
    private String cnpj;
    private AddressEntity address;

    public static CustomerEntity fromModel(Customer customer){
        return CustomerEntity.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .familyName(customer.getFamilyName())
                .cpf(customer.getCpf())
                .cnpj(customer.getCnpj())
                .address(AddressEntity.fromModel(customer.getAddress()))
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
