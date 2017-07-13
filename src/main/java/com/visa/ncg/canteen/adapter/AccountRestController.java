package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.data.AccountRepository;
import com.visa.ncg.canteen.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountRestController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/{id}")
  public Account getAccountById(@PathVariable int id) {
    return accountRepository.findById(id);
  }

  @PostMapping
  public Account createAccount() {
    // TODO: use the account repository's ID generator
    Account account = new Account(123);
    accountRepository.save(account);
    return account;
  }

}
