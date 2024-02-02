package ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertarRegistroProductos {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Registrar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexi�n con la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String usuario = "SYSTEM";
            String contrasena = "pablo";
            conn = DriverManager.getConnection(url, usuario, contrasena);

            // Iniciar la transacci�n
            conn.setAutoCommit(false);

            // Crear el objeto Empresa con los datos a insertar
            int id = 2;
            String categoria = "Alimentaci�n";
            String subcategoria = "Monitor";

            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO productos (id, categoria, subcategoria) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, categoria);
            stmt.setString(3, subcategoria);
            stmt.executeUpdate();

            // Mostrar todos los datos de la tabla productos
            sql = "SELECT * FROM productos";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_productos = rs.getInt("id");
                String categoria_productos = rs.getString("categoria");
                String subcategoria_productos = rs.getString("subcategoria");
                System.out.println("ID: " + id_productos + " | Categor�a: " + categoria_productos + " | Subcategor�a: " + subcategoria_productos);
            }

            // Hacer commit de la transacci�n
            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // Si ocurre alg�n error, hacer rollback de la transacci�n
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Cerrar la conexi�n y los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}