package com.visa.ncg.canteen.data;

import com.visa.ncg.canteen.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
  public AccountRepository() {
    System.out.println("AccountRepository created");
  }

  private Map<Integer, Account> accountMap = new HashMap<>();

  public Account findById(int id) {
    return accountMap.get(id);
  }

  public void save(Account account) {
    accountMap.put(account.getId(), account);
  }

  // TODO: add an ID generator

}
