package com.visa.ncg.canteen.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountLimitTest {

  @Test
  public void depositCausingBalanceToExceed50DollarsThrowsExceptionAndKeepsBalanceUnchanged() {
    Account account = new Account(0);
    account.deposit(45);

    assertThatThrownBy(() -> account.deposit(10))
        .isInstanceOf(IllegalStateException.class);

    assertThat(account.getBalance())
        .isEqualTo(45);
  }

}
