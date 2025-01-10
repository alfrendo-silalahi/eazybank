package dev.alfrendosilalahi.eazybank.account.controller;

import dev.alfrendosilalahi.eazybank.account.dto.response.CustomerDetailResponseDto;
import dev.alfrendosilalahi.eazybank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{mobile-number}")
    public ResponseEntity<CustomerDetailResponseDto> getCustomerDetail(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @PathVariable("mobile-number") String mobileNumber
    ) {
        log.info("eazybank correlation id: {}", correlationId);
        CustomerDetailResponseDto customerDetailResponseDto = customerService.getCustomerDetail(mobileNumber, correlationId);
        return ResponseEntity.ok(customerDetailResponseDto);
    }

}
