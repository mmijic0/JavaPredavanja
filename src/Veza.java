import java.sql.Connection;
import java.sql.SQLException;

public class Veza {
    String db = "oracle";

    public static Connection Otvori(String db)
    {
        Connection con = null;
        switch (db.toLowerCase())
        {
            case "oracle":
                con = Oracle.Otvori();
                break;

            case "mysql":
                con = MySQL.Otvori();
                break;

            default:
                con = Oracle.Otvori();
                break;
        }
        return con;
    }

    public static void Zatvori (Connection con)
    {
        try {
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
