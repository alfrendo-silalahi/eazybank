package dev.alfrendosilalahi.eazybank.account.service.client;

import dev.alfrendosilalahi.eazybank.account.dto.client.loan.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "loan", fallback = LoanFallback.class)
public interface LoanFeignClient {

    @GetMapping(value = "/api/fetch", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<LoansDto> fetchLoanDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestParam String mobileNumber
    );

}
