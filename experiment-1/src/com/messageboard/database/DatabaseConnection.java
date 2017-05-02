package com.messageboard.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nicholas on 17-4-20.
 */
public class DatabaseConnection {
    private String     DBDRIVER   = "com.mysql.jdbc.Driver";
    private String     DBURL      = "jdbc:mysql://localhost:3306/message?characterEncoding=utf8&useUnicode=true&useSSL=false";
    private String     DBUSER     = "root";
    private String     DBPASSWORD = "123456";

    private Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(DBDRIVER);
        return DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return new DatabaseConnection().connection();
    }
}
