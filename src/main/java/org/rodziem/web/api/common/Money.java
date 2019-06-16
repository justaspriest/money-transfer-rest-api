package org.rodziem.web.api.common;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {

    private static final int[] centDivisors = new int[]{1, 10, 100, 1000};

    private BigDecimal amount;

    private Currency currency;

    public Money(final String amountEntry, final String currencyCode) {
        amount = new BigDecimal(amountEntry);
        currency = Currency.getInstance(currencyCode);
    }

    public String getAmount() {
        return amount.toPlainString();
    }

    public String getCurrency() {
        return currency.getCurrencyCode();
    }

    public boolean isEmpty() {
        return amount.compareTo(new BigDecimal(0)) == 0;
    }

    public boolean isPositive() {
        return amount.compareTo(new BigDecimal(0)) > 0;
    }

    public void add(final Money money) {
        if (!money.currency.equals(currency)) {
            return;
        }

        amount = amount.add(money.amount);
    }

    public void sub(final Money money) {
        if (!money.currency.equals(currency)) {
            return;
        }

        amount = amount.subtract(money.amount);
    }

    public int getCentFactor() {
        return centDivisors[currency.getDefaultFractionDigits()];
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        } else if (object == null || object.getClass() != getClass()) {
            return false;
        }

        final Money money2 = (Money) object;
        return amount.compareTo(money2.amount) == 0 &&
                currency.equals(money2.currency);
    }
}
