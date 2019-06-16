package org.rodziem.web.api;

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import org.h2.tools.RunScript;
import org.rodziem.web.api.transfer.TransferRepo;
import org.rodziem.web.api.transfer.TransferService;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class MoneyTransferConfig {

    private static final String DUMP_DATABASE = "/database.sql";

    public TransferService getTransferService() throws ClassNotFoundException, SQLException {
        final DriverAdapterCPDS driver = new DriverAdapterCPDS();
        driver.setDriver("org.h2.Driver");
        driver.setUrl("jdbc:h2:mem:test");
        driver.setUser("sa");
        driver.setPassword("");

        final SharedPoolDataSource pool = new SharedPoolDataSource();
        pool.setConnectionPoolDataSource(driver);
        pool.setMaxTotal(10);
        pool.setValidationQuery("SELECT 1");
        pool.setDefaultTestOnBorrow(true);
        pool.setDefaultTestWhileIdle(true);

        initDatabase(pool.getConnection());

        final TransferRepo repo = new TransferRepo(pool);
        return new TransferService(repo);
    }

    public void initDatabase(final Connection con) throws SQLException {
        final Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(DUMP_DATABASE));
        RunScript.execute(con, reader);
    }
}
