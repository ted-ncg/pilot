package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NecessitiesAccountTest {


  @Test
  public void depositZeroOrNegativeDollarsToAccountResultsInExceptionThrown() {
    NecessitiesAccount necessitiesAccount = new NecessitiesAccount();
    assertThatThrownBy(() -> necessitiesAccount.deposit(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Deposits of negative or 0 dollars is not allowed.");
    assertThatThrownBy(() -> necessitiesAccount.deposit(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

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
