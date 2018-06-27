import java.sql.Connection;
import java.sql.ResultSet;

public interface SelectFromTable {
    static ResultSet select (Connection con, String tableName) {return null;};
    static void print (ResultSet res) {};
}
