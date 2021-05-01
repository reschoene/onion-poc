package onion.poc.external.services.spring.controller;

import lombok.RequiredArgsConstructor;
import onion.poc.domain.services.usecases.CustomerEnrollment;
import onion.poc.external.services.spring.controller.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer-enrollment")
public class CustomerEnrollmentController {
    private final CustomerEnrollment customerEnrollment;

    @PostMapping("/enroll")
    public ResponseEntity<CustomerDto>  enrollNewCustomer(@RequestBody CustomerDto customerDto){
        if (customerEnrollment.enrollNewCustomer(customerDto.toModel()))
            return ResponseEntity.ok(customerDto);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/un-enroll")
    public ResponseEntity<CustomerDto> unEnrollCustomer(@RequestBody CustomerDto customerDto){
        if (customerEnrollment.unEnrollCustomer(customerDto.toModel()))
            return ResponseEntity.ok(customerDto);
        else
            return ResponseEntity.badRequest().build();
    }
}
