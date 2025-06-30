package Prov;

import Conexion.Conexion;
import Util.Leer;
import java.sql.*;
import java.util.Scanner;

public class Prov {
    Scanner sc = Leer.getScanner();
    
    public void AltaProv() {
        
        String nombre;
        
        System.out.println("Dame el nombre del proveedor");
        nombre = sc.next();
        
        String sql = "INSERT INTO proveedor (nombre) VALUES (?)";
        
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Se agregó el proveedor." : "No se pudo agregar el proveedor.");
            
        } catch (SQLException e) {
            System.out.println("No se pudo agregar proveedor: " + e.getMessage());
        }
    }
    
    public void BajaProv() {
        
        int id;
        
        System.out.println("Dame el id del proveedor");
        id = sc.nextInt();
        
        String eProd = "DELETE FROM producto WHERE id_proveedor = ?";
        String eProv = "DELETE FROM proveedor WHERE id = ?";

        try (Connection con = Conexion.conectar();
                PreparedStatement psProductos = con.prepareStatement(eProd);
                PreparedStatement psProveedor = con.prepareStatement(eProv)) 
        {
            // Borrar productos del proveedor
            psProductos.setInt(1, id);
            psProductos.executeUpdate();

            // Borrar el proveedor
            psProveedor.setInt(1, id);
            int rows = psProveedor.executeUpdate();

            System.out.println(rows > 0 ? "Se eliminó el proveedor y sus productos." : "No se encontró el proveedor.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LeerProv() {
        String sql = "SELECT * FROM proveedor ORDER BY id;";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql); 
                ResultSet rs = ps.executeQuery()) {

            System.out.println("ID\tnombre");
            while (rs.next()) {
                System.out.printf("%d\t%s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("No se pudieron consultar los proveedores: " + e.getMessage());
        }
    }

    public void ModProv() {
        int id;
        String nombre;
        
        System.out.println("Dame el id del proveedor a modificar");
        id = sc.nextInt();
        
        System.out.println("Dame el nuevo nombre del proveedor");
        nombre = sc.next();
        
        String sql = "UPDATE proveedor SET nombre = ? WHERE id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Se actualizó el proveedor." : "No se encontró el proveedor.");

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el proveedor: " + e.getMessage());
        }
    }
}
