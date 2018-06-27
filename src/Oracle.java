import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle {
    public static String SQLURL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String SQLUSER = "mmijic";
    public static String SQLPASS = "db12345";

    public static Connection Otvori() {
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection(SQLURL, SQLUSER, SQLPASS);
            if (con != null)
            {
                con.setAutoCommit(false);
            }
            return con;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void Zatvori (Connection con)
    {
        try {
            con.commit();
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
