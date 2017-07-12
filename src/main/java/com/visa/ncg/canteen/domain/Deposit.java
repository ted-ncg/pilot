package com.visa.ncg.canteen.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deposit {
  private final int id;
  private final int accountId;
  private final int amount;

  @JsonCreator
  public Deposit(@JsonProperty("id") int id,
                 @JsonProperty("accountId") int accountId,
                 @JsonProperty("amount") int amount) {
    this.id = id;
    this.accountId = accountId;
    this.amount = amount;
  }

  public int getId() {
    return id;
  }

  public int getAccountId() {
    return accountId;
  }

  public int getAmount() {
    return amount;
  }
}
