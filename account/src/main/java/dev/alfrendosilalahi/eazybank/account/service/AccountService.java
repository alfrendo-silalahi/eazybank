package dev.alfrendosilalahi.eazybank.account.service;

import dev.alfrendosilalahi.eazybank.account.dto.request.CustomerRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.request.UpdateAccountRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.AccountResponseDto;

public interface AccountService {

    void createAccount(CustomerRequestDto customerRequestDto);

    AccountResponseDto getAccount(String mobileNumber);

    void updateAccount(UpdateAccountRequestDto updateAccountRequestDto);

    void deleteAccount(Long accountNumber);

}
