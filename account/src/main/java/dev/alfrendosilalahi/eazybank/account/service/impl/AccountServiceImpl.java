package dev.alfrendosilalahi.eazybank.account.service.impl;

import dev.alfrendosilalahi.eazybank.account.dto.request.CustomerRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.request.UpdateAccountRequestDto;
import dev.alfrendosilalahi.eazybank.account.dto.response.AccountResponseDto;
import dev.alfrendosilalahi.eazybank.account.entity.Account;
import dev.alfrendosilalahi.eazybank.account.entity.Customer;
import dev.alfrendosilalahi.eazybank.account.exception.CustomerAlreadyExistsException;
import dev.alfrendosilalahi.eazybank.account.exception.ResourceNotFoundException;
import dev.alfrendosilalahi.eazybank.account.repository.AccountRepository;
import dev.alfrendosilalahi.eazybank.account.repository.CustomerRepository;
import dev.alfrendosilalahi.eazybank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    /**
     * Create a new account.
     *
     * @param customerRequestDto the customer data.
     * @throws CustomerAlreadyExistsException if a customer with the same mobile number already exists.
     */
    @Override
    @Transactional
    public void createAccount(CustomerRequestDto customerRequestDto) {
        if (customerRepository.existsByMobileNumber(customerRequestDto.getMobileNumber())) {
            throw new CustomerAlreadyExistsException("Customer already exists with mobileNumber " + customerRequestDto.getMobileNumber());
        }

        Customer customer = Customer.builder()
                .name(customerRequestDto.getName())
                .email(customerRequestDto.getEmail())
                .mobileNumber(customerRequestDto.getMobileNumber())
                .build();
        Account account = Account.builder()
                .id(getRandomNumber())
                .type("SAVINGS")
                .branchAddress("South Jakarta")
                .build();
        account.setCustomer(customer);
        customer.setAccount(account);
        customerRepository.save(customer);
        log.info("Created account successfully");
    }

    /**
     * Get account information by mobile number.
     *
     * @param mobileNumber the customer mobile number.
     * @return the account information.
     * @throws ResourceNotFoundException if no customer found with the given mobile number.
     */
    @Override
    public AccountResponseDto getAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        AccountResponseDto.AccountResponse accountResponse = AccountResponseDto.AccountResponse.builder()
                .name(customer.getName())
                .mobileNumber(customer.getMobileNumber())
                .email(customer.getEmail())
                .branchAddress(customer.getAccount().getBranchAddress())
                .number(customer.getAccount().getId())
                .type(customer.getAccount().getType())
                .build();
        return new AccountResponseDto(accountResponse);
    }

    /**
     * Update account information.
     *
     * @param updateAccountRequestDto the account information.
     */
    @Override
    @Transactional
    public void updateAccount(UpdateAccountRequestDto updateAccountRequestDto) {
        Account account = findAccountByNumber(updateAccountRequestDto.getAccountNumber());
        account.setType(updateAccountRequestDto.getAccountType());
        account.setBranchAddress(updateAccountRequestDto.getAccountBranchAddress());

        Customer customer = account.getCustomer();
        customer.setName(updateAccountRequestDto.getName());
        customer.setEmail(updateAccountRequestDto.getEmail());
        customer.setMobileNumber(updateAccountRequestDto.getMobileNumber());
        account.setCustomer(customer);

        accountRepository.save(account);
    }

    /**
     * Delete account by given account number.
     *
     * @param accountNumber the account number.
     * @throws ResourceNotFoundException if no account found with the given account number.
     */
    @Override
    @Transactional
    public void deleteAccount(Long accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        accountRepository.delete(account);
    }

    private Account findAccountByNumber(Long number) {
        return accountRepository.findById(number)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "number", number.toString()));
    }

    private Long getRandomNumber() {
        return 1_000_000_000L + new Random().nextLong(900_000_000L);
    }

}
