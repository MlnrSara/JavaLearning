import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ControlPanel {
    private final static Logger logger = LogManager.getLogger("shop");
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("C:\\Users\\sara.molnar\\OneDrive - ACCESA\\Documents\\credentials.json");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        String url = (String) jsonObject.get("url");
        String user = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        char[] s = password.toCharArray();
        for(int i=0; i<s.length; i++)
            s[i] -= 7;
        password = new String(s);
        System.out.println(password);
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            logger.info("Connected");
            System.out.println("Connected");
            Statement statement = connection.createStatement();
            NameQuery.filterNames(connection);
            AgeQuery.over40(connection);
            PurchasedProductsQuery.showPurchasedItems(connection);
            Manipulator.insert(connection, "sale", "employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id", "3, '2023-09-12 12:00:00', 3, 1, 2, 1");
            Manipulator.update(connection, "product", "quantity", "6", "product_id = 6" );
            Manipulator.update(connection, "product", "quantity", "1", "product_id = 6" );
            Manipulator.insert(connection, "sale", "employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id", "3, '2023-09-12 12:00:00', 3, 6, 2, 3" );


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
