package com.example.adminmodel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_category_mysql";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME, DATABASE_PASSWORD);
            }
            System.out.println("Connect Success");

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
