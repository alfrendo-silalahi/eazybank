package dev.alfrendosilalahi.eazybank.account.service;

import dev.alfrendosilalahi.eazybank.account.dto.response.CustomerDetailResponseDto;

public interface CustomerService {

    CustomerDetailResponseDto getCustomerDetail(String mobileNumber);

}
