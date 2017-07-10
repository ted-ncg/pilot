package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NecessitiesAccountTest {

  @Test
  public void aNewAccountWithDepositOf10DollarsResultsInAccountHaving10DollarBalance() {
    NecessitiesAccount necessitiesAccount = new NecessitiesAccount();
    necessitiesAccount.deposit(10);
    assertThat(necessitiesAccount.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void aNewAccountHasZeroBalance() {
    NecessitiesAccount necessitiesAccount = new NecessitiesAccount();
    assertThat(necessitiesAccount.getBalance())
        .isZero();
  }
}
