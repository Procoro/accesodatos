package productos;

import java.util.List;
import java.sql.Connection;

public class ProductosView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<Productos> productos) {
        for (Productos producto : productos) {
            System.out.println("ID: " + producto.getId()); 
            System.out.println("Nombre: " + producto.getNombre()); 
            System.out.println("Descripción: " + producto.getDescripcion()); 
            System.out.println("Fabricante: " + producto.getFabricante());
            System.out.println("Precio: " + producto.getPrecio()); 
            System.out.println("Nº Serie: " + producto.getnSerie()); 
            System.out.println(); 
        }
    }
}
