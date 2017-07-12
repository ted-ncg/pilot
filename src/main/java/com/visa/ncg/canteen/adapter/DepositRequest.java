package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.Deposit;
import com.visa.ncg.canteen.domain.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DepositRequest {
  private int amount;
  private int accountId;

  private final DepositRepository depositRepository;

  @Autowired
  public DepositRequest(DepositRepository depositRepository) {
    this.depositRepository = depositRepository;
  }

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
    int id = depositRepository.nextId();
    return new Deposit(id, accountId, amount);
  }

}
