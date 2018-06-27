import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySelectFromTable implements SelectFromTable {
    public static ResultSet select (Connection con, String tableName) throws Exception
    {
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM "+tableName;

        ResultSet res = stmt.executeQuery(query);
        return res;
    }

    public static void print (ResultSet res) throws Exception
    {
        while (res.next()) {
            System.out.println("ID: " + res.getInt("id") + ", "
                    + "Author: " + res.getString("author") + ", "
                    + "Title: " + res.getString("title") + ", "
                    + "Price: " + res.getDouble("price") + ", "
                    + "QTY: " + res.getInt("qty"));
        }
    }
}
