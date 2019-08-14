package ru.ncd;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DataDAO {


    public void addToDataBase(Data data, Matrix matrix, Graph graph) throws FileNotFoundException {
        data.matrix = matrix.toString();
        data.n = matrix.n;
        data.m = matrix.m;
        data.result = data.countResult(matrix, graph);
        int id = 1111;
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:~/test";
        final String USER = "sa";
        final String PASS = "";

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "INSERT INTO datadata VALUES ("+ id + "," + data.n + "," + data.m + "," + "\'" + data.matrix + "\'" + ")";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
