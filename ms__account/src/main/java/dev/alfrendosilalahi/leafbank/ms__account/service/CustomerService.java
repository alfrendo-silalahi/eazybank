package dev.alfrendosilalahi.leafbank.ms__account.service;

import dev.alfrendosilalahi.leafbank.ms__account.dto.response.CustomerDetailResponseDto;

public interface CustomerService {

    CustomerDetailResponseDto getCustomerDetail(String mobileNumber, String correlationId);

}
