package dev.alfrendosilalahi.eazybank.account.repository;

import dev.alfrendosilalahi.eazybank.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
