package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.Deposit;

public class DepositRequest {
  private int amount;
  private int accountId;

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  Deposit getAsDeposit() {
    return new Deposit(accountId, amount);
  }

}
