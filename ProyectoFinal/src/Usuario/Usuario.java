package Usuario;

import Conexion.Conexion;
import MenuPrinc.MenuPrinc;
import Util.Leer;
import java.sql.*;
import java.util.Scanner;

public class Usuario {
    
    public void RUsuario(String nombre, String contra) {
        String sql = "INSERT INTO usuario (contra, nombre) VALUES (?, ?)";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, contra);
            ps.setString(2, nombre);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Se agregó el usuario." : "No se pudo agregar el usuario.");

        } catch (SQLException e) {
            System.out.println("No se pudo agregar usuario: " + e.getMessage());
        }
    }

    public void IniciarSesion() {
        MenuPrinc mp = new MenuPrinc();
        Scanner sc = Leer.getScanner();

        System.out.print("Nombre de usuario: ");
        String nombre = sc.nextLine();

        System.out.print("Contraseña: ");
        String contra = sc.nextLine();

        String sql = "SELECT * FROM usuario WHERE nombre = ? AND contra = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(2, nombre);
            ps.setString(1, contra);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Bienvenido " + nombre);
                mp.MenuPrinc();
            } else {
                System.out.println("Nombre o contraseña incorrectos.");
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }
}
