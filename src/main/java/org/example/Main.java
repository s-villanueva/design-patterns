package org.example;


public class Main {

    public static void main(String[] args) {
        DBConnect.insertarUsuario("Sergio", "sergioxd@gmail.com");
        DBConnect.consultarUsuarios();
    }
}
