/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhamDucTrongGiaoDien;
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class dal {

    private static final String URL = "jdbc:sqlserver://localhost:1433;"
           + "databaseName=QLSinhVien;"
           + "encrypt=true;"
           + "trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456";
    public static Connection DBConnection;
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static Connection DBConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

