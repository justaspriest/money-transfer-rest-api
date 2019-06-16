package org.rodziem.web.api;

import org.rodziem.web.api.common.Path;
import org.rodziem.web.api.info.InfoController;
import org.rodziem.web.api.transfer.TransferController;
import org.rodziem.web.api.transfer.TransferService;

import java.util.logging.Logger;

import static java.lang.System.exit;
import static spark.Spark.*;

public class MoneyTransferApp {

    private static final Logger log = Logger.getLogger(MoneyTransferApp.class.getName());

    private static final String versionPath = "/v1";

    public static void main(String[] args) {
        try {
            final MoneyTransferApp app = new MoneyTransferApp();
            app.configure();
            app.initRoutes();
        } catch (final Exception e) {
            e.printStackTrace();
            log.severe(e.getLocalizedMessage());
            exit(1);
        }
    }

    private void configure() throws Exception {
        port(8080);
        final TransferService transferService = new MoneyTransferConfig().getTransferService();
    }

    private void initRoutes() {
        log.info("Initiating routes");

        get(Path.INFO, InfoController.getInfo);
        path(Path.INFO, () -> path(versionPath, () -> {
            get(Path.TRANSFER, TransferController.getTransfer);
            post(Path.TRANSFER, TransferController.createTransfer);
        }));
    }
}
