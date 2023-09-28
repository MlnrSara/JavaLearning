package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manipulator {
    public static void create (Connection connection, String name, String fields ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("create table " + name + "( " + fields + " )" );
        preparedStatement.execute();
    }

    public static void insert (Connection connection, String table, String columns, String values) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into " + table + " ( " + columns + " ) " + " values ( " + values + " )");
        preparedStatement.execute();
        Manipulator.checkInsert(connection, table, columns, values);

    }

    private static void checkInsert(Connection connection, String table, String columns, String values) throws SQLException {
        if (table.equals( "sale" ) && columns.contains( "purchase_quantity" )){
            String[] parsedColumns = columns.split(", +");
            String[] parsedValues = values.split(", +");
            int purchaseIndex = 0;
            int productIndex = -1;
            for(int i=0; i<parsedColumns.length; i++) {
                if (parsedColumns[i].equals("purchase_quantity"))
                    purchaseIndex = i;
                if (parsedColumns[i].equals("product_id"))
                    productIndex = i;
            }
            ResultSet resultSet = Manipulator.select(connection, "product", "*", "product_id = " + parsedValues[productIndex]);
            while ( resultSet.next() ) {
                if (Integer.parseInt(parsedValues[purchaseIndex]) > resultSet.getInt(3)) {
                    Manipulator.update(connection, "sale", "purchase_quantity", String.valueOf(resultSet.getInt(3)), "product_id = " + parsedValues[productIndex]);
                }
            }
        }
    }
    public static ResultSet select (Connection connection, String table, String columns, String condition) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select " + columns + " from " + table + " where " + condition );
        return preparedStatement.executeQuery();
    }

    public static void update (Connection connection, String table, String column, String newValue, String condition) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update " + table + " set " + column + " = " + newValue + " where " + condition );
        checkUpdate(connection, table,column,newValue,condition);
        preparedStatement.execute();
    }

    private static void checkUpdate(Connection connection, String table, String column, String newValue, String condition) throws SQLException {
        if (table.equals( "product" ) && column.equals( "quantity" )){
            int temp = Integer.parseInt(newValue);
            ResultSet resultSet = Manipulator.select(connection, "product", "*", condition);
            while(resultSet.next()) {
                if (temp < resultSet.getInt(3)) {
                    int difference = resultSet.getInt(3) - temp;
                    Manipulator.insert(connection, "sale", "employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id", "1, '1999-09-09 00:00:00', 1, " + resultSet.getInt(1) + " , " + difference + " , 1" );
                }
            }
        }
    }

    public static void delete (Connection connection, String table, String condition) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from " + table + " where " + condition );
        preparedStatement.execute();
    }


}
