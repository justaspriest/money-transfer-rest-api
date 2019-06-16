package org.rodziem.web.api.info;

import java.io.InputStream;
import java.util.logging.Logger;

public class InfoService {

    private static final Logger log = Logger.getLogger(InfoService.class.getName());

    private static final String PATH_INFO_PAGE = "/index.html";

    public String getInfo() throws Exception {
        try (final InputStream schemaStream = getClass().getResourceAsStream(PATH_INFO_PAGE)) {
            return new String(schemaStream.readAllBytes());
        } catch (final Exception e) {
            log.warning(e.getMessage());
            throw new Exception(e);
        }
    }
}
