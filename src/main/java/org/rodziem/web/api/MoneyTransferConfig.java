package org.rodziem.web.api;

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import org.h2.tools.RunScript;
import org.rodziem.web.api.account.AccountController;
import org.rodziem.web.api.account.AccountRepo;
import org.rodziem.web.api.account.AccountService;
import org.rodziem.web.api.info.InfoController;
import org.rodziem.web.api.transfer.TransferController;
import org.rodziem.web.api.transfer.TransferRepo;
import org.rodziem.web.api.transfer.TransferService;
import spark.Route;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class MoneyTransferConfig {

    private static final String DUMP_DATABASE = "/database.sql";

    private DataSource dataSource;

    public MoneyTransferConfig() throws SQLException, ClassNotFoundException {
        dataSource = prepareDataSource();
    }

    private DataSource prepareDataSource() throws ClassNotFoundException, SQLException {
        final DriverAdapterCPDS driver = new DriverAdapterCPDS();
        driver.setDriver("org.h2.Driver");
        driver.setUrl("jdbc:h2:mem:test;mode=MySQL");
        driver.setUser("sa");
        driver.setPassword("");

        final SharedPoolDataSource pool = new SharedPoolDataSource();
        pool.setConnectionPoolDataSource(driver);
        pool.setMaxTotal(10);
        pool.setValidationQuery("SELECT 1");
        pool.setDefaultTestOnBorrow(true);
        pool.setDefaultTestWhileIdle(true);

        initDatabase(pool.getConnection());

        return pool;
    }

    private void initDatabase(final Connection con) throws SQLException {
        final Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(DUMP_DATABASE));
        RunScript.execute(con, reader);
    }

    public TransferRepo getTransferRepo() {
        return new TransferRepo(dataSource);
    }

    public TransferService getTransferService() {
        return new TransferService(this);
    }

    public AccountRepo getAccountRepo() {
        return new AccountRepo(dataSource);
    }

    public AccountService getAccountService() {
        return new AccountService(this);
    }

    public Route getInfoController() {
        return InfoController.getInfo;
    }

    public Route getAccountController() {
        return new AccountController(this).prepareGetController();
    }

    public Route getTransferController() {
        return new TransferController(this).prepareGetController();
    }

    public Route createTransferController() {
        return new TransferController(this).prepareCreateController();
    }
}
