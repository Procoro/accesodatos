package phoneland;

import java.util.List;

import com.pblazquez.vista.controlador.ClienteModel;

import java.sql.*;

public class ProductosController {
    private ProductosModel model; // Instancia del modelo
    private ProductosView view;   // Instancia de la vista

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public ProductosController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new ProductosModel(dbURL, dbUser, dbPassword); // Inicializa el modelo con la conexión a la base de datos
        view = new ProductosView(); // Inicializa la vista
    }

    // Método para mostrar los clientes
    public void mostrarProductos() throws SQLException {
        List<Productos> productos = model.getAllProductos(); // Obtiene la lista de clientes desde el modelo
        view.mostrarProductos(productos); // Muestra los clientes en la vista
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }
}
