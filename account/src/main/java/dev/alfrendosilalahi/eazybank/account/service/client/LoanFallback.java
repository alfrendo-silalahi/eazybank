package dev.alfrendosilalahi.eazybank.account.service.client;

import dev.alfrendosilalahi.eazybank.account.dto.client.loan.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanFallback implements LoanFeignClient{

    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }

}
