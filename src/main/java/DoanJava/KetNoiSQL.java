package DoanJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiSQL {

    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QLSinhVien_PhamDucTrong;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối cơ sở dữ liệu thành công!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}