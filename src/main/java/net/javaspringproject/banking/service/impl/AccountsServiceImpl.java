package net.javaspringproject.banking.service.impl;

import net.javaspringproject.banking.dto.AccountDto;
import net.javaspringproject.banking.entity.Account;
import net.javaspringproject.banking.mapper.AccountMapper;
import net.javaspringproject.banking.repository.AccountRepo;
import net.javaspringproject.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountsServiceImpl implements AccountService {
    private AccountRepo AccRepo;

    public AccountsServiceImpl(AccountRepo accRepo) {
        this.AccRepo = accRepo;
    }

     @Override
    public AccountDto createAccount(AccountDto AccDto) {
        Account acc = AccountMapper.maptoAccount(AccDto);
        Account savedAcc = AccRepo.save(acc);
        return AccountMapper.maptoAccountDto(savedAcc);
    }

    @Override
    public AccountDto getAccountByID(Long id) {

        Account account = AccRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto accountDeposit(Long id, double amount) {
        Account account = AccRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        Account SavedAcc = AccRepo.save(account);
        return AccountMapper.maptoAccountDto(SavedAcc);
    }

    public AccountDto withDraw(Long id,double amount )
    {
        Account acc = AccRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));

        if(acc.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient balance");
        }

        double newBalance = acc.getBalance() - amount;

        acc.setBalance(newBalance);
        Account SavedAcc = AccRepo.save(acc);
        return AccountMapper.maptoAccountDto(acc);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> AccList= AccRepo.findAll();
        return AccList.stream().map((account)-> AccountMapper.maptoAccountDto(account)).collect(Collectors.toList());
    }

    public void deleteAcc(Long id){

        Account account = AccRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        AccRepo.deleteById(id);
    }
}
