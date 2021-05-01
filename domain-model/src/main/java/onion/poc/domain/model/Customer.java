package onion.poc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Customer {
    private String firstName;
    private String familyName;
    private String cpf;
    private String cnpj;
    private Address address;
}
