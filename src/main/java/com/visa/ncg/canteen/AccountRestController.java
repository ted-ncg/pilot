package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

  private static AccountRepository accountRepository = new AccountRepository();

  @GetMapping("/{id}")
  public NecessitiesAccount getAccountById(@PathVariable int id) {
    return accountRepository.findById(id);
  }

  @PostMapping
  public NecessitiesAccount createAccount() {
    NecessitiesAccount account = new NecessitiesAccount(123);
    accountRepository.save(account);
    return account;
  }

}
