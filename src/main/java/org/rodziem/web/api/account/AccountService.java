package org.rodziem.web.api.account;

import org.rodziem.web.api.MoneyTransferConfig;
import org.rodziem.web.api.common.Money;
import org.rodziem.web.api.generated.tables.records.AccountRecord;
import org.rodziem.web.api.generated.tables.records.TransferRecord;

import java.sql.SQLException;

public class AccountService {

    private final MoneyTransferConfig config;

    public AccountService(final MoneyTransferConfig config) {
        this.config = config;
    }

    public AccountDTO getAccount(final int id) throws SQLException {
        final var accountRepo = config.getAccountRepo();
        final var account = accountRepo.getAccount(id);
        return new AccountMapper().toDto(account);
    }

    public void applyTransfer(final TransferRecord transfer) throws SQLException {
        final var accountRepo = config.getAccountRepo();
        final AccountRecord sender = accountRepo.getAccount(transfer.getSender());
        final AccountRecord receiver = accountRepo.getAccount(transfer.getReceiver());

        final Money senderWallet = new Money(sender.getAmount(), sender.getCurrency());
        final Money receiverWallet = new Money(receiver.getAmount(), receiver.getCurrency());

        final Money transferMoney = new Money(transfer.getAmount(), transfer.getCurrency());
        if (transferMoney.isEmpty()) {
            return;
        } else if (transferMoney.isPositive()) {
            calculate(senderWallet, receiverWallet, transferMoney);
        } else {
            calculate(receiverWallet, senderWallet, transferMoney);
        }

        sender.setAmount(senderWallet.getAmount());
        receiver.setAmount(receiverWallet.getAmount());
        sender.store();
        receiver.store();
    }

    private void calculate(final Money senderWallet, final Money receiverWallet, final Money transferMoney) {
        receiverWallet.sub(transferMoney);
        senderWallet.add(transferMoney);
    }
}
