package org.rodziem.web.api;

import java.io.InputStream;

import static spark.Spark.*;

public class MoneyTransferStarter {

    public static void main(String[] args) {
        final MoneyTransferStarter app = new MoneyTransferStarter();
        app.start();
    }

    private void start() {
        try (final InputStream schemaStream = getClass().getResourceAsStream("/index.html")) {
            final String content = new String(schemaStream.readAllBytes());
            get("/", (req, res) -> content);
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }
}
