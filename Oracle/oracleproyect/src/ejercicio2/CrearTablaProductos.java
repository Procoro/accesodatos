package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaProductos {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // URL de la base de datos
    private static final String USUARIO = "SYSTEM";
    private static final String CONTRASENA = "pablo";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Obtener la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
    public static void main(String[] args) {
    	 Connection conexion = CrearTablaProductos.obtenerConexion();
        if (conexion != null) {
            Statement statement = null;

            try {
                statement = conexion.createStatement();

                // Crear la tabla "productos"
                String crearTablaSQL = "CREATE TABLE productos ("
                        + "id INT PRIMARY KEY,"
                        + "categoria VARCHAR(30),"
                        + "subcategoria VARCHAR(30)"
                        + ")";
                statement.executeUpdate(crearTablaSQL);

                System.out.println("Tabla 'productos' creada con éxito.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
