package org.rodziem.web.api.transfer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.rodziem.web.api.MoneyTransferConfig;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TestTransferService {

    private static MoneyTransferConfig config;

    @BeforeAll
    private static void prepareTransferService() throws Exception {
        config = new MoneyTransferConfig();
    }

    private TransferDTO createTestDTO() {
        final var fromId = 1;
        final var toId = 2;
        final var amount = "10.0";
        final var currencyCode = "RUB";

        final var testDto = new TransferDTO();
        testDto.senderId = fromId;
        testDto.receiverId = toId;
        testDto.amount = amount;
        testDto.currencyCode = currencyCode;
        testDto.status = TransferDTO.Status.PENDING;
        return testDto;
    }

    @Test
    void testService() {
        try {
            final var transferService = config.getTransferService();
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
            final var testDTO = createTestDTO();
            final var transferService = config.getTransferService();
            final TransferDTO createdDTO = transferService.createTransfer(testDTO);

            assertTrue(createdDTO.id > 0);
            assertEquals(createdDTO.senderId, testDTO.senderId);
            assertEquals(createdDTO.receiverId, testDTO.receiverId);
            assertEquals(createdDTO.amount, testDTO.amount);
            assertEquals(createdDTO.currencyCode, testDTO.currencyCode);
            assertEquals(createdDTO.status, testDTO.status);
        } catch (final SQLException e) {
            fail(e);
        }
    }
}
