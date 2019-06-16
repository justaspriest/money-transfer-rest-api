package org.rodziem.web.api.transfer;

import spark.Route;

public class TransferController {

    public static Route getTransfer = (request, response) -> "get";

    public static Route createTransfer = (request, response) -> "post";
}
