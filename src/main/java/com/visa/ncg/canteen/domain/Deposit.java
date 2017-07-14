package com.visa.ncg.canteen.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deposit {
  private final int accountId;
  private final int amount;

  @JsonCreator
  public Deposit(@JsonProperty("accountId") int accountId,
                 @JsonProperty("amount") int amount) {
    this.accountId = accountId;
    this.amount = amount;
  }

  public int getAccountId() {
    return accountId;
  }

  public int getAmount() {
    return amount;
  }
}
