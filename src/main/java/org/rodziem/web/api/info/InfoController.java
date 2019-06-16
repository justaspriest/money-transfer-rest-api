package org.rodziem.web.api.info;

import spark.Route;

import static spark.Spark.halt;

public class InfoController {

    public static Route getInfo = (response, request) -> {
        try {
            final InfoService service = new InfoService();
            return service.getInfo();
        } catch (final Exception e) {
            throw halt(502, e.getMessage());
        }
    };
}
