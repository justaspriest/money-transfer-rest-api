package org.rodziem.web.api.account;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.rodziem.web.api.generated.tables.records.AccountRecord;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.rodziem.web.api.generated.Tables.ACCOUNT;

public class AccountRepo {

    private final DataSource dataSource;

    public AccountRepo(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AccountRecord getAccount(final int accountId) throws SQLException {
        return DSL.using(dataSource.getConnection(), SQLDialect.H2)
                .fetchOne(ACCOUNT, ACCOUNT.ID.eq(accountId));
    }
}
