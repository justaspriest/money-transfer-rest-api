package org.rodziem.web.api;

import org.rodziem.web.api.common.Path;

import java.util.logging.Logger;

import static java.lang.System.exit;
import static spark.Spark.*;

public class MoneyTransferApp {

    private static final Logger log = Logger.getLogger(MoneyTransferApp.class.getName());

    private static final String versionPath = "/v1";

    public static void main(String[] args) {
        try {
            final var app = new MoneyTransferApp();
            final var config = new MoneyTransferConfig();
            app.configure(config);
        } catch (final Exception e) {
            log.severe(e.getLocalizedMessage());
            exit(1);
        }
    }

    private void configure(final MoneyTransferConfig config) {
        port(8080);
        initRoutes(config);
    }

    private void initRoutes(final MoneyTransferConfig config) {
        log.info("Initiating routes");

        get(Path.INFO, config.getInfoController());
        path(Path.API, () -> path(versionPath, () -> {
            get(Path.READ_ACCOUNT, config.getAccountController());
            get(Path.READ_TRANSFER, config.getTransferController());
            post(Path.CREATE_TRANSFER, config.createTransferController());
        }));

        log.info("Routes have initialised successfully");
    }
}
