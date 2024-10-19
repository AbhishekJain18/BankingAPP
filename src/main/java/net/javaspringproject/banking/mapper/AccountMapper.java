package net.javaspringproject.banking.mapper;

import net.javaspringproject.banking.dto.AccountDto;
import net.javaspringproject.banking.entity.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDto AccDto)
    {
        Account Acc = new Account(
                AccDto.getId(),
                AccDto.getAccHolderName(),
                AccDto.getBalance()
        );

        return Acc;
    }

    public static AccountDto maptoAccountDto(Account Acc)
    {
        AccountDto AccDto = new AccountDto(
                Acc.getId(),
                Acc.getAccountHolderName(),
                Acc.getBalance()
        );

        return AccDto;
    }
}
