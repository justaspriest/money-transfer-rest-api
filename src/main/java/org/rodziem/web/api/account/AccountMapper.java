package org.rodziem.web.api.account;

import org.rodziem.web.api.generated.tables.records.AccountRecord;

public class AccountMapper {

    public AccountDTO toDto(final AccountRecord account) {
        final var dataObject = new AccountDTO();

        dataObject.id = account.getId();
        dataObject.amount = account.getAmount();
        dataObject.currencyCode = account.getCurrency();

        return dataObject;
    }
}
