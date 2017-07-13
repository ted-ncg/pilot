package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.data.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

  private final AccountRepository accountRepository;

  @Autowired
  public DepositService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void process(Deposit deposit) {
    int accountId = deposit.getAccountId();
    validateAccount(accountId);

    Account account = accountRepository.findById(accountId);
    account.deposit(deposit.getAmount());

    accountRepository.save(account);
  }

  /**
   * Throws IllegalArgumentException if the specified accountId is not found
   *
   * @param accountId ID of the account to validate
   */
  private void validateAccount(int accountId) {
    if (accountRepository.findById(accountId) == null) {
      throw new IllegalArgumentException("Could not find an Account with an Account ID of " + accountId);
    }
  }
}
