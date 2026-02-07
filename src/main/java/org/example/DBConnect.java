package org.example;
import java.sql.*;

public class DBConnect {
    static ConexionDB connection = ConexionDB.getInstance();

//    public static void crearTabla() {
//        String url = "jdbc:sqlite:/root/projects/ChatUPBv2/upbchat.db";
//        String sql = "CREATE TABLE IF NOT EXISTS usuarios ( id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, email TEXT);";
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement()) {
//            stmt.execute(sql);
//            System.out.println("Tabla creada o ya existente.");
//
//        } catch (SQLException e) {
//            System.out.println("Error al crear tabla: " + e.getMessage());
//        }
//    }

    public static void insertarUsuario(String nombre, String email) {
        String sql = "INSERT INTO usuarios(nombre, email) VALUES(?, ?)";

        try (Connection logic = connection.connect()){
             PreparedStatement pstmt = logic.prepareStatement(sql);{

            pstmt.setString(1, nombre);
            pstmt.setString(2, email);

            pstmt.executeUpdate();
            System.out.println("Usuario insertado correctamente: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static void consultarUsuarios() {
        String sql = "SELECT id, nombre, email FROM usuarios";

        try (Connection logic = connection.connect()){
             Statement stmt = logic.createStatement();
             ResultSet rs = stmt.executeQuery(sql) ;{

                System.out.println("\n--- LISTA DE USUARIOS ---");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String email = rs.getString("email");

                    System.out.println(String.format("ID: %d | Nombre: %-15s | Email: %s", id, nombre, email));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
    }
}
