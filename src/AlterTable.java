import java.sql.Connection;

public abstract class AlterTable {
    public abstract void addColumn(Connection con, String table, String column, String type, int size) throws Exception;
}
