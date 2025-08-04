package dev.alfrendosilalahi.leafbank.ms__account.repository;

import dev.alfrendosilalahi.leafbank.ms__account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByMobileNumber(String mobileNumber);

    Optional<Customer> findByMobileNumber(String mobileNumber);

}
