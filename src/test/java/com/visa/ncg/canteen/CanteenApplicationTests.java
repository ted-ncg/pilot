package com.visa.ncg.canteen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CanteenApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
  public void makeMoney() throws Exception {
	  Money money = new Money(BigDecimal.valueOf(100), Currency.getInstance(Locale.getDefault()));
    assertThat(money.getCurrency())
        .isEqualTo(Currency.getInstance(Locale.US));
    assertThat(money.getAmount())
        .isEqualTo(BigDecimal.valueOf(100));
  }
}
