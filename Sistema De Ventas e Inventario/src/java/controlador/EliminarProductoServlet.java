package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Conexion;

@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = Conexion.conectar()) {
            
            PreparedStatement ps = con.prepareStatement(
                "UPDATE producto SET activo = 0 WHERE id = ?"
            );
            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                response.sendRedirect("productos.jsp?error=noeliminado");
            } else {
                response.sendRedirect("productos.jsp?exito=desactivado"); 
            }

        } catch (SQLException e) {
            
            response.sendRedirect("productos.jsp?error=sql");
        }
    }
}
