import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    public static String SQLURL = "jdbc:mysql://localhost/javatest?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String SQLUSER = "root";
    public static String SQLPASS = "db12345";

    public static Connection Otvori()
    {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection(SQLURL,SQLUSER,SQLPASS);
            con.close();
            return con;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return null;
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
