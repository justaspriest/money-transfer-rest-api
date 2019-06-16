package org.rodziem.web.api.transfer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.rodziem.web.api.MoneyTransferConfig;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TestTransferService {

    private static TransferService transferService;

    @BeforeAll
    private static void prepareTransferService() throws Exception {
        transferService = new MoneyTransferConfig().getTransferService();
    }

    private TransferDTO createTestDTO() {
        final int fromId = 1;
        final int toId = 2;
        final String amount = "10.0";
        final String currencyCode = "RUB";

        final TransferDTO testDto = new TransferDTO();
        testDto.senderId = fromId;
        testDto.receiverId = toId;
        testDto.amount = amount;
        testDto.currencyCode = currencyCode;
        return testDto;
    }

    @Test
    void testService() {
        try {
            final TransferDTO testDTO = createTestDTO();
            final TransferDTO createdDTO = transferService.createTransfer(testDTO);
            final TransferDTO receivedDTO = transferService.getTransfer(createdDTO.id);

            assertEquals(createdDTO, receivedDTO);
        } catch (final SQLException e) {
            fail(e);
        }
    }

    @Test
    void testEntity() {
        try {
            final TransferDTO testDTO = createTestDTO();
            final TransferDTO createdDTO = transferService.createTransfer(testDTO);

            assertNotNull(createdDTO.id);
            assertEquals(createdDTO.senderId, testDTO.senderId);
            assertEquals(createdDTO.receiverId, testDTO.receiverId);
            assertEquals(createdDTO.amount, testDTO.amount);
            assertEquals(createdDTO.currencyCode, testDTO.currencyCode);
        } catch (final SQLException e) {
            fail(e);
        }
    }
}
