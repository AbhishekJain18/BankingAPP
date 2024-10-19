package net.javaspringproject.banking.controller;

import net.javaspringproject.banking.dto.AccountDto;
import net.javaspringproject.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {

    private AccountService accService;

    public AccountController(AccountService accService) {
        this.accService = accService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAcc(@RequestBody AccountDto accDto)
    {
        return new ResponseEntity<>(accService.createAccount(accDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id)
    {
        AccountDto accountDto = accService.getAccountByID(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> Deposit(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        AccountDto accountDto = accService.accountDeposit(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withDraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        AccountDto accountDto = accService.withDraw(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccountbyList(@PathVariable Long id)
    {
         List<AccountDto> accountDtoList= accService.getAllAccounts();
        return ResponseEntity.ok(accountDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accService.deleteAcc(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
