/*
 * This file is generated by jOOQ.
 */
package org.rodziem.web.api.generated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;
import org.rodziem.web.api.generated.tables.Account;
import org.rodziem.web.api.generated.tables.Transfer;
import org.rodziem.web.api.generated.tables.records.AccountRecord;
import org.rodziem.web.api.generated.tables.records.TransferRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>TRANSFER_API</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Identities0.IDENTITY_ACCOUNT;
    public static final Identity<TransferRecord, Integer> IDENTITY_TRANSFER = Identities0.IDENTITY_TRANSFER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> CONSTRAINT_E = UniqueKeys0.CONSTRAINT_E;
    public static final UniqueKey<TransferRecord> CONSTRAINT_7 = UniqueKeys0.CONSTRAINT_7;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TransferRecord, AccountRecord> CONSTRAINT_7A = ForeignKeys0.CONSTRAINT_7A;
    public static final ForeignKey<TransferRecord, AccountRecord> CONSTRAINT_7AF = ForeignKeys0.CONSTRAINT_7AF;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Internal.createIdentity(Account.ACCOUNT, Account.ACCOUNT.ID);
        public static Identity<TransferRecord, Integer> IDENTITY_TRANSFER = Internal.createIdentity(Transfer.TRANSFER, Transfer.TRANSFER.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountRecord> CONSTRAINT_E = Internal.createUniqueKey(Account.ACCOUNT, "CONSTRAINT_E", Account.ACCOUNT.ID);
        public static final UniqueKey<TransferRecord> CONSTRAINT_7 = Internal.createUniqueKey(Transfer.TRANSFER, "CONSTRAINT_7", Transfer.TRANSFER.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<TransferRecord, AccountRecord> CONSTRAINT_7A = Internal.createForeignKey(org.rodziem.web.api.generated.Keys.CONSTRAINT_E, Transfer.TRANSFER, "CONSTRAINT_7A", Transfer.TRANSFER.SENDER);
        public static final ForeignKey<TransferRecord, AccountRecord> CONSTRAINT_7AF = Internal.createForeignKey(org.rodziem.web.api.generated.Keys.CONSTRAINT_E, Transfer.TRANSFER, "CONSTRAINT_7AF", Transfer.TRANSFER.RECEIVER);
    }
}