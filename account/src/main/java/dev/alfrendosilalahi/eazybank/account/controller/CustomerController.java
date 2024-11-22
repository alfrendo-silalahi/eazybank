package dev.alfrendosilalahi.eazybank.account.controller;

import dev.alfrendosilalahi.eazybank.account.dto.response.CustomerDetailResponseDto;
import dev.alfrendosilalahi.eazybank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{mobile-number}")
    public ResponseEntity<CustomerDetailResponseDto> getCustomerDetail(@PathVariable("mobile-number") String mobileNumber) {
        CustomerDetailResponseDto customerDetailResponseDto = customerService.getCustomerDetail(mobileNumber);
        return ResponseEntity.ok(customerDetailResponseDto);
    }

}
