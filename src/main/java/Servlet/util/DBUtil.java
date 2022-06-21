package Servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    static String driverClassName = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/sts";
    static String username = "root";
    static String password = "root";

    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("连接失败");
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("访问失败", e);
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement stmt) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
