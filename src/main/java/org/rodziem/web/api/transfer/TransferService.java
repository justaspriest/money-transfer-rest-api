package org.rodziem.web.api.transfer;


import org.rodziem.web.api.generated.tables.records.TransferRecord;

import java.sql.SQLException;

public class TransferService {

    private final TransferRepo repo;

    public TransferService(final TransferRepo repo) {
        this.repo = repo;
    }

    public TransferDTO getTransfer(final int id) throws SQLException {
        final TransferRecord record = repo.getTransfer(id);
        final TransferDTO dataObject = new TransferDTO();

        dataObject.id = record.getId();
        dataObject.senderId = record.getSender();
        dataObject.receiverId = record.getReceiver();
        dataObject.amount = record.getAmount();
        dataObject.currencyCode = record.getCurrency();

        return dataObject;
    }

    public TransferDTO createTransfer(final TransferDTO dataObject) throws SQLException {
        final int transferId = repo.createTransfer(dataObject);
        dataObject.id = transferId;
        return dataObject;
    }
}
