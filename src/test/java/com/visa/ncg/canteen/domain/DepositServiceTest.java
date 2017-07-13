package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.data.AccountRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DepositServiceTest {

  @Test
  public void processDepositGivenNonExistentAccountIdThrowsException() {
    Deposit deposit = new Deposit(12, 33, 10);
    AccountRepository accountRepository = new AccountRepository();
    DepositService depositService = new DepositService(accountRepository);

    assertThatThrownBy(() -> depositService.process(deposit))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void processDepositGivenExistingAccountResultsIn30DollarsDepositedIntoAccount() {
    AccountRepository accountRepository = new AccountRepository();
    DepositService depositService = new DepositService(accountRepository);
    Account account = new Account(123);
    int initialBalance = account.getBalance();
    accountRepository.save(account);

    Deposit deposit = new Deposit(14, 123, 30);
    depositService.process(deposit);

    int newBalance = accountRepository.findById(123).getBalance();
    assertThat(newBalance)
        .isEqualTo(initialBalance + 30);
  }
}
