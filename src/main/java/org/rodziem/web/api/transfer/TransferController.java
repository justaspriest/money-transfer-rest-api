package org.rodziem.web.api.transfer;

import com.google.gson.Gson;
import org.rodziem.web.api.MoneyTransferConfig;
import spark.Route;

public class TransferController {

    private final MoneyTransferConfig config;

    public TransferController(final MoneyTransferConfig config) {
        this.config = config;
    }

    public Route prepareGetController() {
        return (request, response) -> {
            try {
                final var idEntry = request.params(":id");
                final var id = Integer.parseInt(idEntry);
                final var transferService = config.getTransferService();
                final var dataObject = transferService.getTransfer(id);
                return new Gson().toJson(dataObject);
            } catch (final Exception e) {
                e.printStackTrace();
                response.status(502);
                return e.getLocalizedMessage();
            }
        };
    }

    public Route prepareCreateController() {
        return (request, response) -> {
            try {
                response.type("application/json");
                final var objectToCreate = new Gson().fromJson(request.body(), TransferDTO.class);
                final var transferService = config.getTransferService();
                final var transferData = transferService.createTransfer(objectToCreate);
                return new Gson().toJson(transferData);
            } catch (final Exception e) {
                e.printStackTrace();
                response.status(502);
                return e.getLocalizedMessage();
            }
        };
    }
}
