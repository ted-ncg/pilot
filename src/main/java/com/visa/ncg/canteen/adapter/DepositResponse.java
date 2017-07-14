package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.Deposit;

public class DepositResponse {
  private int accountId;
  private int amount;

  public DepositResponse(Deposit deposit) {
    accountId = deposit.getAccountId();
    amount = deposit.getAmount();
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
