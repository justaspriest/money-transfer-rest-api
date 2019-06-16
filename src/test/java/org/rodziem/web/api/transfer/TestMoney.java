package org.rodziem.web.api.transfer;

import org.junit.jupiter.api.Test;
import org.rodziem.web.api.common.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoney {

    @Test
    public void testEquals() {
        final String amount = "10.0";
        final String currencyCode = "RUB";

        final Money money1 = new Money(amount, currencyCode);
        final Money money2 = new Money(amount, currencyCode);

        assertEquals(money1.getAmount(), amount);
        assertEquals(money1.getCurrency(), currencyCode);
        assertEquals(money1.getAmount(), money2.getAmount());
        assertEquals(money1.getCurrency(), money2.getCurrency());
        assertEquals(money1, money2);
    }
}
