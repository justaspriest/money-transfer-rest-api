package org.rodziem.web.api.transfer;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.rodziem.web.api.generated.tables.records.TransferRecord;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.rodziem.web.api.generated.tables.Transfer.TRANSFER;

public class TransferRepo {

    private final DataSource dataSource;

    public TransferRepo(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TransferRecord createTransfer(final TransferDTO transferData) throws SQLException {
        final var transfer = new TransferMapper().toEntity(transferData);

        DSL.using(dataSource.getConnection(), SQLDialect.H2)
                .attach(transfer);

        transfer.changed(TRANSFER.ID, false);
        transfer.insert();
        return transfer;
    }

    public TransferRecord getTransfer(final int transferId) throws SQLException {
        return DSL.using(dataSource.getConnection(), SQLDialect.H2)
                .fetchOne(TRANSFER, TRANSFER.ID.eq(transferId));
    }


}
