import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zadatak_03 {
    public static void main(String[] args) throws Exception {
        class CopyToTable {
            public void PrintAndCopy(Connection con, ResultSet res) throws Exception
            {
                Column[] kolone = new Column[5];
                kolone[0] = new Column("id", "int", 0);
                kolone[1] = new Column("title", "varchar2", 50);
                kolone[2] = new Column("author", "varchar2", 50);
                kolone[3] = new Column("price", "float", 0);
                kolone[4] = new Column("qty", "int", 0);
                //kolone[5] = new Column("owned_by", "varchar2", 50);

                //Create table
                MyCreateTable ct = new MyCreateTable();
                ct.create(con, "library", kolone, "id");

                //Alter table
                MyAlterTable at = new MyAlterTable();
                at.addColumn(con, "library", "owned_by", "varchar2", 50);

                String query = "";
                Statement insert = con.createStatement();
                while (res.next()) {
                    System.out.println("ID: " + res.getInt("id") + ", "
                            + "Author: " + res.getString("author") + ", "
                            + "Title: " + res.getString("title") + ", "
                            + "Price:" + res.getDouble("price") + ", "
                            + "QTY:" + res.getInt("qty"));

                    query = "INSERT INTO library (id, title, author, price, qty, owned_by) VALUES (" +
                            "'"+res.getInt("id")+"', " +
                            "'"+res.getString("title")+"', " +
                            "'"+res.getString("author")+"', " +
                            res.getDouble("price")+", " +
                            res.getInt("qty")+", " +
                            "'Mario')";

                    insert.executeQuery(query);
                }
            }
        }

        Connection con = Veza.Otvori("oracle");
        ResultSet res = MySelectFromTable.select(con, "books");
        new CopyToTable().PrintAndCopy(con, res);

        Veza.Zatvori(con);
    }
}
