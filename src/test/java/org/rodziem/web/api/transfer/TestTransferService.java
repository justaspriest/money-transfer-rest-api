package org.rodziem.web.api.transfer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTransferService {

    private final TransferDTO testDto = new TransferDTO();

    private final ITransferService transferService = null;

    @BeforeAll
    private void prepareTestDTO() {
        final int fromId = 1;
        final int toId = 2;

        testDto.addresserId = fromId;
        testDto.addresseeId = toId;
    }

    @Test
    void testService() {
        final TransferEntity transfer1 = transferService.createTransfer(testDto);
        final TransferEntity transfer2 = transferService.getTransfer(transfer1.getId());

        assertEquals(transfer1, transfer2);
    }

    @Test
    void testEntity() {
        final TransferEntity transfer = transferService.createTransfer(testDto);

        assertEquals(transfer.getAddresserId(), testDto.addresserId);
        assertEquals(transfer.getAddresseeId(), testDto.addresseeId);
    }

    @Test
    void testMapper() {
        final TransferMapper mapper = new TransferMapper();

        final TransferEntity entity1 = mapper.toEntity(testDto);
        final TransferDTO dto1 = mapper.toDto(entity1);

        assertEquals(testDto, dto1);

        final TransferEntity entity2 = mapper.toEntity(testDto);

        assertEquals(entity1, entity2);
    }
}
