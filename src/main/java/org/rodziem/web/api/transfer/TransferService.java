package org.rodziem.web.api.transfer;

import org.rodziem.web.api.MoneyTransferConfig;
import org.rodziem.web.api.generated.tables.records.TransferRecord;

import java.sql.SQLException;

public class TransferService {

    private final MoneyTransferConfig config;

    public TransferService(final MoneyTransferConfig config) {
        this.config = config;
    }

    public TransferDTO createTransfer(final TransferDTO dataObject) throws SQLException {
        final var transferRepo = config.getTransferRepo();
        final var transfer = transferRepo.createTransfer(dataObject);
        final var accountService = config.getAccountService();
        accountService.applyTransfer(transfer);
        return new TransferMapper().toDto(transfer);
    }

    public TransferDTO getTransfer(final int id) throws SQLException {
        final var transferRepo = config.getTransferRepo();
        final TransferRecord transfer = transferRepo.getTransfer(id);
        return new TransferMapper().toDto(transfer);
    }
}
