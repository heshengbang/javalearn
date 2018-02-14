package com.hsb.java.jdbc;
        /*
         * Copyright ©2011-2017 hsb
         */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBTest {
    @Test
    public void test1() {
        try {
            runTest();
        } catch (SQLException ex) {
            for (Throwable t:ex) {
                t.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
//            runTest();
//        } catch (SQLException ex) {
//            for (Throwable t:ex) {
//                t.printStackTrace();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    private static void runTest() throws SQLException, IOException {
        try (Connection connection = getConnection()) {
            Statement stat = connection.createStatement();

            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");

            ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
            if (result.next()) {
                System.out.println(result.getString(1));
            }
            result.close();
            stat.executeUpdate("DROP TABLE Greetings");
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(".\\src\\test\\resources\\database.properties");
//
//        File file = new File(".\\src\\test\\resources\\database.properties");
//        System.out.println(file.getAbsolutePath());
//        FileInputStream in = new FileInputStream(file);

//        ClassLoader classLoader = DBTest.class.getClassLoader();
//        URL resource = classLoader.getResource("database.properties");
//        String path = resource != null ? resource.getPath() : "";
//        System.out.println(path);
//        FileInputStream in = new FileInputStream(path);

        properties.load(in);
        in.close();
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
//        String url = "jdbc:mysql://localhost:3306/mysql";
//        String username = "root";
//        String password = "";
//        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}