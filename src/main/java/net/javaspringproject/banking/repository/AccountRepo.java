package net.javaspringproject.banking.repository;

import net.javaspringproject.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
