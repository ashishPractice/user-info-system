package com.vastika.uis.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection con = null;

    public static Connection getConnection() {
        try {
            // loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db", "root", "@Shrestha");

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null) {
            System.out.println("Successful in created the Connection");
        }
        return con;
    }
}
