/*
 * This file is generated by jOOQ.
 */
package org.rodziem.web.api.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.rodziem.web.api.generated.Indexes;
import org.rodziem.web.api.generated.Keys;
import org.rodziem.web.api.generated.TransferApi;
import org.rodziem.web.api.generated.tables.records.TransferRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Transfer extends TableImpl<TransferRecord> {

    private static final long serialVersionUID = -1299715070;

    /**
     * The reference instance of <code>TRANSFER_API.TRANSFER</code>
     */
    public static final Transfer TRANSFER = new Transfer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransferRecord> getRecordType() {
        return TransferRecord.class;
    }

    /**
     * The column <code>TRANSFER_API.TRANSFER.ID</code>.
     */
    public final TableField<TransferRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>TRANSFER_API.TRANSFER.SENDER</code>.
     */
    public final TableField<TransferRecord, Integer> SENDER = createField("SENDER", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSFER_API.TRANSFER.RECEIVER</code>.
     */
    public final TableField<TransferRecord, Integer> RECEIVER = createField("RECEIVER", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>TRANSFER_API.TRANSFER.AMOUNT</code>.
     */
    public final TableField<TransferRecord, String> AMOUNT = createField("AMOUNT", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRANSFER_API.TRANSFER.CURRENCY</code>.
     */
    public final TableField<TransferRecord, String> CURRENCY = createField("CURRENCY", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>TRANSFER_API.TRANSFER.STATUS</code>.
     */
    public final TableField<TransferRecord, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * Create a <code>TRANSFER_API.TRANSFER</code> table reference
     */
    public Transfer() {
        this(DSL.name("TRANSFER"), null);
    }

    /**
     * Create an aliased <code>TRANSFER_API.TRANSFER</code> table reference
     */
    public Transfer(String alias) {
        this(DSL.name(alias), TRANSFER);
    }

    /**
     * Create an aliased <code>TRANSFER_API.TRANSFER</code> table reference
     */
    public Transfer(Name alias) {
        this(alias, TRANSFER);
    }

    private Transfer(Name alias, Table<TransferRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transfer(Name alias, Table<TransferRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Transfer(Table<O> child, ForeignKey<O, TransferRecord> key) {
        super(child, key, TRANSFER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return TransferApi.TRANSFER_API;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CONSTRAINT_INDEX_7, Indexes.CONSTRAINT_INDEX_7A, Indexes.PRIMARY_KEY_7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TransferRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TRANSFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TransferRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_7;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TransferRecord>> getKeys() {
        return Arrays.<UniqueKey<TransferRecord>>asList(Keys.CONSTRAINT_7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TransferRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TransferRecord, ?>>asList(Keys.CONSTRAINT_7A, Keys.CONSTRAINT_7AF);
    }

    public Account constraint_7a() {
        return new Account(this, Keys.CONSTRAINT_7A);
    }

    public Account constraint_7af() {
        return new Account(this, Keys.CONSTRAINT_7AF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transfer as(String alias) {
        return new Transfer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transfer as(Name alias) {
        return new Transfer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transfer rename(String name) {
        return new Transfer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Transfer rename(Name name) {
        return new Transfer(name, null);
    }
}
