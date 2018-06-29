import java.sql.Connection;
import java.sql.ResultSet;

public class Zadatak_02 {
    public static void main(String[] args) throws Exception {
        class PrintTotal {
            public void Print(double Total)
            {
                System.out.println("Ukupna vrijednos biblioteke je " + Total);
            }
        }

        Connection con = Veza.Otvori("oracle");
        ResultSet res = MySelectFromTable.select(con, "books");

        double TotalPrice = MyTotalPrice.Calculate(res, "price", "qty");
        new PrintTotal().Print(TotalPrice);

        Veza.Zatvori(con);
    }
}
