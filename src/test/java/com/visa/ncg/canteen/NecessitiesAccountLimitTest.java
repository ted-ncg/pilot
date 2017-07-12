package com.visa.ncg.canteen;

import com.visa.ncg.canteen.domain.NecessitiesAccount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NecessitiesAccountLimitTest {

  @Test
  public void depositCausingBalanceToExceed50DollarsThrowsExceptionAndKeepsBalanceUnchanged() {
    NecessitiesAccount necessitiesAccount = new NecessitiesAccount(0);
    necessitiesAccount.deposit(45);

    assertThatThrownBy(() -> necessitiesAccount.deposit(10))
        .isInstanceOf(IllegalStateException.class);

    assertThat(necessitiesAccount.getBalance())
        .isEqualTo(45);
  }

}
