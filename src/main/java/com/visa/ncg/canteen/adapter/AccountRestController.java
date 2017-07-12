package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.AccountRepository;
import com.visa.ncg.canteen.domain.NecessitiesAccount;
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
  public NecessitiesAccount getAccountById(@PathVariable int id) {
    return accountRepository.findById(id);
  }

  @PostMapping
  public NecessitiesAccount createAccount() {
    // TODO: use the account repository's ID generator
    NecessitiesAccount account = new NecessitiesAccount(123);
    accountRepository.save(account);
    return account;
  }

}
