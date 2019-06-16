package org.rodziem.web.api.transfer;


public interface ITransferService {

    /**
     * Returns transfer object related to passed identifier
     * @param id - identifier for transfer object
     * @return transfer object or null if there is no transfer object with passed identifier
     */
    TransferEntity getTransfer(final int id);

    /**
     * Creates transfer object
     * @param fromId - transfer addresser
     * @param toId - transfer addressee
     * @return newly created transfer object
     */
    TransferEntity createTransfer(final int fromId, final int toId);
}
