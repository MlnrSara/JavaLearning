import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAgeQuery {
    private String job;
    private int noEmployees;
    public static void over40 (Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select employee.job_title as Job, count(employee.employee_id) as NoEmployees\n" +
                "from employee \n" +
                "where employee.age >= 40\n" +
                "group by employee.job_title\n" +
                "order by employee.job_title");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<EmployeeAgeQuery> results= new ArrayList<EmployeeAgeQuery>();
        while(resultSet.next()){
            EmployeeAgeQuery temp = new EmployeeAgeQuery();
            temp.job = resultSet.getString(1);
            temp.noEmployees = resultSet.getInt(2);
            results.add(temp);
        }
        for(EmployeeAgeQuery i : results){
            System.out.println(i);
        }

    }

    public String toString(){
        return this.job + " " + this.noEmployees;
    }
}
