import java.sql.Connection;
import java.sql.Statement;

public class MyAlterTable extends AlterTable {
    public void addColumn(Connection con, String table, String column, String type, int size) throws Exception {
        String query = "ALTER TABLE "+table+" ADD "+column+" "+type.toUpperCase();
        if (size > 0)
        {
            query += "("+size+")";
        }

        Statement stmt = con.createStatement();
        if(!stmt.execute(query))
        {
            System.out.println("Uspješno izmjenjena tabela "+table);
        }
        else
        {
            System.out.println("Nije uspjela izmjena tabele "+table);
        }
    }
}
