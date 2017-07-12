package com.visa.ncg.canteen;

import com.visa.ncg.canteen.domain.AccountRepository;
import com.visa.ncg.canteen.domain.NecessitiesAccount;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest {

  @Test
  public void findNonExistentAccountReturnsNull() {
    AccountRepository repository = new AccountRepository();
    NecessitiesAccount account123 = repository.findById(123);
    assertThat(account123)
        .isNull();
  }

  @Test
  public void savingAccountWithId123CanBeFoundByItsId() throws Exception {
    AccountRepository repository = new AccountRepository();

    NecessitiesAccount account = new NecessitiesAccount(123);
    repository.save(account);

    assertThat(repository.findById(123))
        .isNotNull()
        .isEqualTo(account);
  }

  // candidate for removal
  @Test
  public void nonEmptyRepositoryReturnsNullForIdNotFound() throws Exception {
    AccountRepository repository = new AccountRepository();
    NecessitiesAccount account123 = new NecessitiesAccount(123);
    repository.save(account123);

    NecessitiesAccount account456 = new NecessitiesAccount(456);
    repository.save(account456);

    assertThat(repository.findById(123))
        .isEqualTo(account123);
  }

}
