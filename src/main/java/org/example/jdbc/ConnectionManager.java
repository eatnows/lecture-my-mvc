package org.example.jdbc;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
    private static final int MAX_POOL_SIZE = 40;

    private static final DataSource da;

    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_DRIVER);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);

        da = hikariDataSource;
    }

    public static Connection getConnection() {
//        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
//        String id = "sa";
//        String pa = "";
//
//        try {
//            Class.forName("org.h2.Driver");
//            return DriverManager.getConnection(url, id, pa);
//        } catch (Exception e) {
//            return null;
//        }

        try {
            return da.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

//    public static DataSource getDataSource() {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setDriverClassName(DB_DRIVER);
//        hikariDataSource.setJdbcUrl(DB_URL);
//        hikariDataSource.setUsername("sa");
//        hikariDataSource.setPassword("");
//        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
//        hikariDataSource.setMinimumIdle(MAX_POOL_SIZE);
//
//        return hikariDataSource;
//    }

    public static DataSource getDataSource() {
        return da;
    }
}
