import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyCreateTable extends CreateTable {
    @Override
    public void create(Connection con, String tableName, Column[] columns, String pk) throws Exception {
        Statement stmt = con.createStatement();
        String query = "DROP TABLE "+tableName;

        try {
            stmt.executeQuery(query);
        }
        catch (SQLException sqlEx){
            System.out.println("QUERY:\n"+query);
            System.out.println(sqlEx.getMessage());
        }

        try {
            query = "CREATE TABLE " + tableName + "(\n";

            for (Column column : columns) {
                query += column.name + " " + column.type;
                if (column.size > 0) {
                    query += "(" + column.size + ")";
                }
                query += ",\n";
            }

            if (!pk.isEmpty()) {
                query += "PRIMARY KEY (" + pk + ")";
            }
            query += ")";
            stmt.executeQuery(query);

            System.out.println("Table " + tableName + " je kreirana.");
        }
        catch (SQLException sqlEx){
            System.out.println("QUERY:\n"+query);
            System.out.println(sqlEx.getMessage());
        }
    }
}
