package com.zone.codezone.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static String url = "jdbc:postgresql://localhost:5432/codingZone";
    private static String user = "postgres";
    private static String passwd = "4094";
    private static String driver = "org.postgresql.Driver";
    private static Connection connect;

    public static Connection getInstance(){
        if(connect == null){
            try {
                Class.forName(driver);
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
