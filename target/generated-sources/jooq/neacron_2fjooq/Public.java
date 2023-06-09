/*
 * This file is generated by jOOQ.
 */
package neacron_2fjooq;


import java.util.Arrays;
import java.util.List;

import neacron_2fjooq.tables.Logs;
import neacron_2fjooq.tables.News;
import neacron_2fjooq.tables.Tags;
import neacron_2fjooq.tables.Todo;
import neacron_2fjooq.tables.Users;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.logs</code>.
     */
    public final Logs LOGS = Logs.LOGS;

    /**
     * The table <code>public.news</code>.
     */
    public final News NEWS = News.NEWS;

    /**
     * The table <code>public.tags</code>.
     */
    public final Tags TAGS = Tags.TAGS;

    /**
     * The table <code>public.todo</code>.
     */
    public final Todo TODO = Todo.TODO;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Logs.LOGS,
            News.NEWS,
            Tags.TAGS,
            Todo.TODO,
            Users.USERS
        );
    }
}
