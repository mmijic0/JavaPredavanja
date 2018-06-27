import java.sql.Connection;

public abstract class CreateTable {
    public abstract void create(Connection con, String tableName, Column[] columns, String pk) throws Exception;
}
