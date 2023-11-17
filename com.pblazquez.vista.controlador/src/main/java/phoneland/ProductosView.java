package phoneland;

import java.util.List;
import java.sql.Connection;

public class ProductosView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<Productos> productos) {
        for (Productos producto : productos) {
            System.out.println("ID producto: " + producto.getId_PRODUCTO()); 
            System.out.println("ID proveedor: " + producto.getId_proveedor()); 
            System.out.println("Nombre: " + producto.getNOMBRE()); 
            System.out.println("Fabricante: " + producto.getFABRICANTE());
            System.out.println("Precio: " + producto.getPRECIO()); 
            System.out.println("PVP: " + producto.getPVP()); 
            System.out.println("Descripción: " + producto.getDescripcion()); 
            System.out.println(); 
        }
    }
}
