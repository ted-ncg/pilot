package com.visa.ncg.canteen;

public class NecessitiesAccount {
  private int balance;

  public void deposit(int amount) {
    balance = balance + amount;
  }

  public int getBalance() {
    return balance;
  }
}
