package dev.alfrendosilalahi.eazybank.account.service.impl;

import dev.alfrendosilalahi.eazybank.account.dto.client.card.CardsDto;
import dev.alfrendosilalahi.eazybank.account.dto.client.loan.LoansDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.CustomerDetailResponseDto;
import dev.alfrendosilalahi.eazybank.account.entity.Customer;
import dev.alfrendosilalahi.eazybank.account.exception.ResourceNotFoundException;
import dev.alfrendosilalahi.eazybank.account.repository.CustomerRepository;
import dev.alfrendosilalahi.eazybank.account.service.CustomerService;
import dev.alfrendosilalahi.eazybank.account.service.client.CardFeignClient;
import dev.alfrendosilalahi.eazybank.account.service.client.LoanFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CardFeignClient cardFeignClient;

    private final LoanFeignClient loanFeignClient;

    @Override
    public CustomerDetailResponseDto getCustomerDetail(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        CustomerDetailResponseDto.AccountResponse accountResponse = CustomerDetailResponseDto.AccountResponse.builder()
                .name(customer.getName())
                .mobileNumber(customer.getMobileNumber())
                .email(customer.getEmail())
                .branchAddress(customer.getAccount().getBranchAddress())
                .number(customer.getAccount().getId())
                .type(customer.getAccount().getType())
                .build();

        CardsDto cardsDto = null;
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if (Objects.nonNull(cardsDtoResponseEntity)) cardsDto = cardsDtoResponseEntity.getBody();

        LoansDto loansDto = null;
        ResponseEntity<LoansDto> loansDtoResponseEntity = loanFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if (Objects.nonNull(loansDtoResponseEntity)) loansDto = loansDtoResponseEntity.getBody();

        return CustomerDetailResponseDto.builder()
                .account(accountResponse)
                .cardsDto(cardsDto)
                .loansDto(loansDto)
                .build();
    }

}
