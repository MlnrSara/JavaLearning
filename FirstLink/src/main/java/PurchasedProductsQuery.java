import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PurchasedProductsQuery {
    private int id;
    private String item;
    private String adress;
    private Timestamp purchased;

    public static void showPurchasedItems(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select product.product_id as ID, product.name as Item, store_location.adress as Adress, sale.purchase_date as Purchased\n" +
                "from ((product inner join store_location on product.store_id = store_location.store_id) inner join sale on product.product_id  = sale.product_id ) \n" +
                "where product.store_id = 3\n" +
                "order by sale.purchase_date");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PurchasedProductsQuery> results= new ArrayList<PurchasedProductsQuery>();
        while(resultSet.next()){
            PurchasedProductsQuery temp = new PurchasedProductsQuery();
            temp.id = resultSet.getInt(1);
            temp.item = resultSet.getString(2);
            temp.adress = resultSet.getString(3);
            temp.purchased = resultSet.getTimestamp(4);
            results.add(temp);
        }
        for(PurchasedProductsQuery i : results){
            System.out.println(i);
        }

    }

    public String toString(){
        return this.id + " " + this.item+ " " + this.adress + " " + this.purchased;
    }
}
