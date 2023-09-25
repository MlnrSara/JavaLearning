import java.sql.*;
import java.util.ArrayList;

public class EmployeeNameQuery {
    private String firstName;
    private String secondName;


    public static void filterNames(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select first_name, last_name\n" +
                "from employee \n" +
                "where last_name like '%escu'\n" +
                "order by first_name, last_name\n" +
                "limit 3 offset 2");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<EmployeeNameQuery> results= new ArrayList<EmployeeNameQuery>();
        while(resultSet.next()){
            EmployeeNameQuery temp = new EmployeeNameQuery();
            temp.firstName = resultSet.getString(1);
            temp.secondName = resultSet.getString(2);
            results.add(temp);
        }
        for(EmployeeNameQuery i : results){
            System.out.println(i);
        }
    }



    public String toString(){
        return this.firstName + " " + this.secondName;
    }
}
