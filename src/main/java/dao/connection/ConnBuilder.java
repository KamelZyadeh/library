package dao.connection;

import org.postgresql.Driver;

import java.sql.*;

public class ConnBuilder {

    public static Connection connection;
    public static final String url = "jdbc:postgresql://localhost:5432/library";
    public static final String username = "postgres";
    public static final String password = "12345";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
