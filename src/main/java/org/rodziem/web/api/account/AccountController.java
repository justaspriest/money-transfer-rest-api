package org.rodziem.web.api.account;

import com.google.gson.Gson;
import org.rodziem.web.api.MoneyTransferConfig;
import spark.Route;

public class AccountController {

    private final MoneyTransferConfig config;

    public AccountController(final MoneyTransferConfig config) {
        this.config = config;
    }

    public Route prepareGetController() {
        return (request, response) -> {
            try {
                final var idEntry = request.params(":id");
                final var id = Integer.parseInt(idEntry);
                final var accountService = config.getAccountService();
                final var dataObject = accountService.getAccount(id);
                return new Gson().toJson(dataObject);
            } catch (final Exception e) {
                e.printStackTrace();
                response.status(502);
                return e.getLocalizedMessage();
            }
        };
    }
}
