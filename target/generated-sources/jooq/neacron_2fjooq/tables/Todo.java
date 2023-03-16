/*
 * This file is generated by jOOQ.
 */
package neacron_2fjooq.tables;


import java.time.LocalDateTime;
import java.util.function.Function;

import neacron_2fjooq.Keys;
import neacron_2fjooq.Public;
import neacron_2fjooq.tables.records.TodoRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Todo extends TableImpl<TodoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.todo</code>
     */
    public static final Todo TODO = new Todo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TodoRecord> getRecordType() {
        return TodoRecord.class;
    }

    /**
     * The column <code>public.todo.id</code>.
     */
    public final TableField<TodoRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.todo.created_at</code>.
     */
    public final TableField<TodoRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.todo.status</code>.
     */
    public final TableField<TodoRecord, Boolean> STATUS = createField(DSL.name("status"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.todo.text</code>.
     */
    public final TableField<TodoRecord, String> TEXT = createField(DSL.name("text"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.todo.updated_at</code>.
     */
    public final TableField<TodoRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6), this, "");

    private Todo(Name alias, Table<TodoRecord> aliased) {
        this(alias, aliased, null);
    }

    private Todo(Name alias, Table<TodoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.todo</code> table reference
     */
    public Todo(String alias) {
        this(DSL.name(alias), TODO);
    }

    /**
     * Create an aliased <code>public.todo</code> table reference
     */
    public Todo(Name alias) {
        this(alias, TODO);
    }

    /**
     * Create a <code>public.todo</code> table reference
     */
    public Todo() {
        this(DSL.name("todo"), null);
    }

    public <O extends Record> Todo(Table<O> child, ForeignKey<O, TodoRecord> key) {
        super(child, key, TODO);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<TodoRecord, Long> getIdentity() {
        return (Identity<TodoRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<TodoRecord> getPrimaryKey() {
        return Keys.TODO_PKEY;
    }

    @Override
    public Todo as(String alias) {
        return new Todo(DSL.name(alias), this);
    }

    @Override
    public Todo as(Name alias) {
        return new Todo(alias, this);
    }

    @Override
    public Todo as(Table<?> alias) {
        return new Todo(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Todo rename(String name) {
        return new Todo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Todo rename(Name name) {
        return new Todo(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Todo rename(Table<?> name) {
        return new Todo(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, LocalDateTime, Boolean, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Long, ? super LocalDateTime, ? super Boolean, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Long, ? super LocalDateTime, ? super Boolean, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
