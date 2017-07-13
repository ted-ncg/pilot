package com.visa.ncg.canteen.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountDepositTest {

  @Test
  public void depositZeroOrNegativeDollarsToAccountResultsInExceptionThrown() {
    Account account = new Account(0);
    assertThatThrownBy(() -> account.deposit(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Deposits of negative or 0 dollars is not allowed.");
    assertThatThrownBy(() -> account.deposit(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void aNewAccountWithDepositOf10DollarsResultsInAccountHaving10DollarBalance() {
    Account account = new Account(0);
    account.deposit(10);
    assertThat(account.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void aNewAccountHasZeroBalance() {
    Account account = new Account(0);
    assertThat(account.getBalance())
        .isZero();
  }
}
