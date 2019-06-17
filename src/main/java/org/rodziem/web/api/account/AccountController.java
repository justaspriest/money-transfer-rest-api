package org.rodziem.web.api.account;

import com.google.gson.Gson;
import org.rodziem.web.api.MoneyTransferConfig;
import spark.Route;

import java.util.logging.Logger;

public class AccountController {

    private static final Logger log = Logger.getLogger(AccountController.class.getName());

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

                if (dataObject == null) {
                    response.status(404);
                    return "Data not found!";
                }

                return new Gson().toJson(dataObject);
            } catch (final Exception e) {
                log.warning(e.getLocalizedMessage());
                response.status(502);
                return e.getLocalizedMessage();
            }
        };
    }
}
