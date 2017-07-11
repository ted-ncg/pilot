package com.visa.ncg.canteen;

public class NecessitiesAccount {
  private int balance;

  public void deposit(int amount) {
    if (invalidDepositOf(amount)) {
      throw new IllegalArgumentException("Deposits of negative or 0 dollars is not allowed.");
    }

    if (limitExceededAfterDepositing(amount)) {
      throw new IllegalStateException();
    }

    balance = balance + amount;
  }

  private boolean invalidDepositOf(int amount) {
    return amount <= 0;
  }

  private boolean limitExceededAfterDepositing(int amount) {
    return balance + amount > 50;
  }

  public int getBalance() {
    return balance;
  }
}
