package dev.alfrendosilalahi.leafbank.ms__account.service;

import dev.alfrendosilalahi.leafbank.ms__account.dto.request.CustomerRequestDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.request.UpdateAccountRequestDto;
import dev.alfrendosilalahi.leafbank.ms__account.dto.response.AccountResponseDto;

public interface AccountService {

    void createAccount(CustomerRequestDto customerRequestDto);

    AccountResponseDto getAccount(String mobileNumber);

    void updateAccount(UpdateAccountRequestDto updateAccountRequestDto);

    void deleteAccount(Long accountNumber);

}
