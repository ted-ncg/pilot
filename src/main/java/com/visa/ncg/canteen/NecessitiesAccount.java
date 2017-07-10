package com.visa.ncg.canteen;

public class NecessitiesAccount {
  private int balance;

  public void deposit(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposits of negative or 0 dollars is not allowed.");
    }
    balance = balance + amount;
  }

  public int getBalance() {
    return balance;
  }
}
