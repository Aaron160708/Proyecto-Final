
package Conexion;

import java.sql.*;

public class Conexion 
{
    public static Connection conectar() 
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/programacion", "root", "n0m3l0"); 
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
        return con;
    }

} 