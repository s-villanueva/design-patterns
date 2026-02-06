package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final ConexionDB conexionDB = new ConexionDB();

    private ConexionDB() {
    }

    public Connection connect() {
        try {
            var conn = DriverManager.getConnection("jdbc:sqlite:/root/projects/ChatUPBv2/upbchat.db");
            return conn;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ConexionDB getInstance(){
        return conexionDB;
    }

}

