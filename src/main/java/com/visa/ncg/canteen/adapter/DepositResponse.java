package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.Deposit;

public class DepositResponse {
  private int id;
  private int accountId;
  private int amount;

  public DepositResponse(Deposit deposit) {
    id = deposit.getId();
    accountId = deposit.getAccountId();
    amount = deposit.getAmount();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
