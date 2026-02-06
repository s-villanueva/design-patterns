package org.example;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ConexionDB conn = ConexionDB.getInstance();

        try (var conexion = conn.connect()) {
            DBConnect.insertarUsuario("Pablito", "pablitoxd@gmail.com", conexion);
            DBConnect.consultarUsuarios(conexion);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
