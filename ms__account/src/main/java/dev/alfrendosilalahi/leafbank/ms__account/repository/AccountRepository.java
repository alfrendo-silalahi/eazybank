package dev.alfrendosilalahi.leafbank.ms__account.repository;

import dev.alfrendosilalahi.leafbank.ms__account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
