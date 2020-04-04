package com.my_rest.Test_another;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JAVA_DB_INSERT {

    // JDBC driver name and database URL //
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://servi.mx:3306";

    // DataBase Credentials //
    static final String USER = "ServiTest/Examen#Serti";
    static final String PASS = "password";

    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            // Connecting to a database
            System.out.println("Connecting to a Selected Database");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Database succefully ...");
            //
            System.out.println("Creating a table in a Data Base");
            statement = connection.createStatement();

            String sql = "CREATE TABLE productos_de_la_tienda(" +
                    "product_id INT NOT_NULL AUTO_INCREMENT, " +
                    "product_name VAR_CHAR(300) NOT_NULL, " +
                    "product_price REAL AUTO_INCREMENT, " +
                    "product_expires_date DATE, " +
                    "PRIMARY KEY (product_id))";
            statement.executeUpdate(sql);
            System.out.println("Created table in given DataBase");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){ // This is an exception for the class.forName();
            e.printStackTrace();
        }finally {
            try {
                if (statement != null){
                    connection.close();
                }
            }catch (SQLException ignored){
            }//do nothing
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("Final the Query");
    }
}
