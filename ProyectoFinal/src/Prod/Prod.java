
package Prod;

import Conexion.Conexion;
import Util.Leer;
import java.sql.*;
import java.util.Scanner;

public class Prod {
    Scanner sc = Leer.getScanner();
    
    public void AltaProd() {
        String nombre;
        int id_proveedor;
        
        System.out.println("Dame el nombre del producto");
        nombre = sc.next();
        System.out.println("Dame el id del proveedor");
        id_proveedor = sc.nextInt();
        
        String sql = "INSERT INTO producto (nombre, id_proveedor) VALUES (?, ?)";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
                ps.setString(1, nombre);
                ps.setInt(2, id_proveedor);
                
                int rows = ps.executeUpdate();
                System.out.println(rows > 0 ? "Se agregó el producto." : "No se pudo agregar el producto.");
        
            } catch (SQLException e) {
                System.out.println("No se pudo agregar producto: " + e.getMessage());
            }
        }
    
    public void BajaProd() {
        int id;
        
        System.out.println("Dame el id del producto");
        id = sc.nextInt();        
        
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, id);
            
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Se eliminó el producto." : "No se encontró el producto.");
            
        } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    
    public void LeerProd(){
        String sql = "SELECT * FROM producto";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("ID\tnombre\tid_proveedor");
            while (rs.next()) 
            {
               System.out.printf("%d\t%s\t%d%n",
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getInt("id_proveedor"));
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("No se pudieron consultar los productos: " + e.getMessage());
        }
    }
    
    public void ModProd() {
        int id;
        String nombre;
        int id_proveedor;
        
        System.out.println("Dame el id del producto");
        id = sc.nextInt();
        System.out.println("Dame el nuevo nombre del producto");
        nombre = sc.next();
        System.out.println("Dame el nuevo id del proveedor");
        id_proveedor = sc.nextInt();
        
        String sql = "UPDATE producto SET nombre = ?, id_proveedor = ? WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {
            
            ps.setString(1, nombre);
            ps.setInt(2, id_proveedor);
            ps.setInt(3, id);
            
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Se actualizo el producto." : "No se encontro el producto.");
            
        } 
        catch (SQLException e) 
        {
            System.out.println("No se pudo actualizar el producto: " + e.getMessage());
        }
    }
}

