package com.visa.ncg.canteen.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
  public AccountRepository() {
    System.out.println("AccountRepository created");
  }

  private Map<Integer, NecessitiesAccount> accountMap = new HashMap<>();

  public NecessitiesAccount findById(int id) {
    return accountMap.get(id);
  }

  public void save(NecessitiesAccount account) {
    accountMap.put(account.getId(), account);
  }

  // TODO: add an ID generator

}
