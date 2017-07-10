package com.visa.ncg.canteen;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Bean (POJO) with typical boilerplate
 */
public class Money {

  private final BigDecimal amount;
  private final Currency currency;

  public Money(BigDecimal amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Money money = (Money) o;

    if (!amount.equals(money.amount)) return false;
    return currency.equals(money.currency);
  }

  @Override
  public int hashCode() {
    int result = amount.hashCode();
    result = 31 * result + currency.hashCode();
    return result;
  }
}