package com.visa.ncg.canteen;

import com.visa.ncg.canteen.data.AccountRepository;
import com.visa.ncg.canteen.domain.DepositService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CanteenApplication {

  public static void main(String[] args) {
    SpringApplication.run(CanteenApplication.class, args);
  }

  @Bean
  public AccountRepository accountRepository() {
    return new AccountRepository();
  }

  @Bean
  public DepositService depositService(AccountRepository accountRepository) {
    return new DepositService(accountRepository);
  }
}
