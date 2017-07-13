package com.visa.ncg.canteen.data;

import com.visa.ncg.canteen.domain.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest {

  @Test
  public void findNonExistentAccountReturnsNull() {
    AccountRepository repository = new AccountRepository();
    Account account123 = repository.findById(123);
    assertThat(account123)
        .isNull();
  }

  @Test
  public void savingAccountWithId123CanBeFoundByItsId() throws Exception {
    AccountRepository repository = new AccountRepository();

    Account account = new Account(123);
    repository.save(account);

    assertThat(repository.findById(123))
        .isNotNull()
        .isEqualTo(account);
  }

  // candidate for removal
  @Test
  public void nonEmptyRepositoryReturnsNullForIdNotFound() throws Exception {
    AccountRepository repository = new AccountRepository();
    Account account123 = new Account(123);
    repository.save(account123);

    Account account456 = new Account(456);
    repository.save(account456);

    assertThat(repository.findById(123))
        .isEqualTo(account123);
  }

}
