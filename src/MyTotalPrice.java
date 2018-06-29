import java.sql.ResultSet;

public class MyTotalPrice implements TotalPrice {
    public static double Calculate (ResultSet res, String priceColumn, String quantityColumn) throws Exception {
        double totalPrice = 0;
        while (res.next()) {
            totalPrice += res.getDouble(priceColumn) * res.getDouble(quantityColumn);
        }
        return totalPrice;
    }
};
