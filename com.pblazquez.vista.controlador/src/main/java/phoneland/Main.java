package phoneland;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/phoneland"; // URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = ""; // Contraseña del usuario

        try {
            ProductosController controller = new ProductosController(dbURL, dbUser, dbPassword);
            controller.mostrarProductos(); 
            controller.cerrarConexion(); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}

