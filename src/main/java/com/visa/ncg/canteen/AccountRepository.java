package com.visa.ncg.canteen;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
  private Map<Integer, NecessitiesAccount> accountMap = new HashMap<>();

  public NecessitiesAccount findById(int id) {
    return accountMap.get(id);
  }

  public void save(NecessitiesAccount account) {
    accountMap.put(account.getId(), account);
  }
}
