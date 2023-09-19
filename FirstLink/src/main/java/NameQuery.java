import java.sql.*;
import java.util.ArrayList;

public class NameQuery {
    private String firstName;
    private String secondName;


    public static void filterNames(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select first_name, last_name\n" +
                "from employee \n" +
                "where last_name like '%escu'\n" +
                "order by first_name, last_name\n" +
                "limit 3 offset 2");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<NameQuery> results= new ArrayList<NameQuery>();
        while(resultSet.next()){
            NameQuery temp = new NameQuery();
            temp.firstName = resultSet.getString(1);
            temp.secondName = resultSet.getString(2);
            results.add(temp);
        }
        for(NameQuery i : results){
            System.out.println(i);
        }
    }



    public String toString(){
        return this.firstName + " " + this.secondName;
    }
}
