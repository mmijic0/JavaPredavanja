import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zadatak_01 {
    public static void main(String[] args) throws Exception {

        Connection con = Veza.Otvori("oracle");
        Column[] kolone = new Column[5];
        kolone[0] = new Column("id", "int", 0);
        kolone[1] = new Column("title", "varchar2", 50);
        kolone[2] = new Column("author", "varchar2", 50);
        kolone[3] = new Column("price", "float", 0);
        kolone[4] = new Column("qty", "int", 0);

        //Create table
        MyCreateTable ct = new MyCreateTable();
        ct.create(con, "books", kolone, "id");

        //Insert data
        Statement stmt = con.createStatement();
        stmt.executeQuery("INSERT INTO books VALUES (1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11)");
        stmt.executeQuery("INSERT INTO books VALUES (1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22)");
        stmt.executeQuery("INSERT INTO books VALUES (1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33)");
        stmt.executeQuery("INSERT INTO books VALUES (1004, 'A Cup of Java', 'Kumar', 44.44, 44)");
        stmt.executeQuery("INSERT INTO books VALUES (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55)");

        ResultSet res = MySelectFromTable.select(con, "books");
        MySelectFromTable.print(res);

        Veza.Zatvori(con);
    }
}
