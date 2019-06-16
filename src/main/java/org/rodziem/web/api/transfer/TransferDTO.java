package org.rodziem.web.api.transfer;

public class TransferDTO {

    public int id;

    public int senderId;

    public int receiverId;

    public String amount;

    public String currencyCode;

    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        } else if (object == null || object.getClass() != getClass()) {
            return false;
        }

        final TransferDTO dataObject2 = (TransferDTO) object;
        return id == dataObject2.id &&
                senderId == dataObject2.senderId &&
                receiverId == dataObject2.receiverId &&
                amount.equals(dataObject2.amount) &&
                currencyCode.equals(dataObject2.currencyCode);
    }
}
