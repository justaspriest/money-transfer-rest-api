package org.rodziem.web.api.transfer;

import org.jooq.impl.EnumConverter;
import org.rodziem.web.api.generated.tables.records.TransferRecord;

import static org.rodziem.web.api.generated.Tables.TRANSFER;

public class TransferMapper {

    public TransferDTO toDto(final TransferRecord entity) {
        final var dataObject = new TransferDTO();

        dataObject.id = entity.getId();
        dataObject.senderId = entity.getSender();
        dataObject.receiverId = entity.getReceiver();
        dataObject.amount = entity.getAmount();
        dataObject.currencyCode = entity.getCurrency();
        dataObject.status = entity.getValue(TRANSFER.STATUS, new StatusConverter());

        return dataObject;
    }

    public TransferRecord toEntity(final TransferDTO dataObject) {
        final var entity = new TransferRecord();

        entity.setId(dataObject.id);
        entity.setSender(dataObject.senderId);
        entity.setReceiver(dataObject.receiverId);
        entity.setAmount(dataObject.amount);
        entity.setCurrency(dataObject.currencyCode);

        final var status = dataObject.status == null ? TransferDTO.Status.PENDING : dataObject.status;
        entity.setStatus(status.name());

        return entity;
    }

    public class StatusConverter extends EnumConverter<String, TransferDTO.Status> {
        public StatusConverter() {
            super(String.class, TransferDTO.Status.class);
        }
    }
}
