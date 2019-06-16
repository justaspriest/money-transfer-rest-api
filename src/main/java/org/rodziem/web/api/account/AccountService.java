package org.rodziem.web.api.account;

import org.rodziem.web.api.common.Money;
import org.rodziem.web.api.generated.tables.records.AccountRecord;

public class AccountService {

    public void applyTransfer(final AccountRecord sender, final AccountRecord receiver, final Money moneyToTransfer) {
        final Money senderWallet = new Money(sender.getAmount(), sender.getCurrency());
        final Money receiverWallet = new Money(receiver.getAmount(), receiver.getCurrency());

        if (moneyToTransfer.isEmpty()) {
            return;
        } else if (moneyToTransfer.isPositive()) {
            calculate(senderWallet, receiverWallet, moneyToTransfer);
        } else {
            calculate(receiverWallet, senderWallet, moneyToTransfer);
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
