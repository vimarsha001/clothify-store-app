package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    Connection connection;
    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clothify_store","root","2007");
    }
    public Connection getConnection(){
        return connection;
    }
    public static DBConnection getInstance() throws SQLException {
        return instance == null ? new DBConnection() : instance;
    }


}
