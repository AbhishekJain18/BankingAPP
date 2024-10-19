package net.javaspringproject.banking.service;

import net.javaspringproject.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto Acc);

    AccountDto getAccountByID(Long id);

    AccountDto accountDeposit(Long id,double amount);

    AccountDto withDraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAcc(Long id);
}
