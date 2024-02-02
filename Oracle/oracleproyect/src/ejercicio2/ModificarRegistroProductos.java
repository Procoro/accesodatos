package ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracleconnect.CrearTabla;

public class ModificarRegistroProductos {
    public static void modificarRegistro(int id, String nuevaCategoria, String nuevaSubcategoria) {
        Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                // Actualizar el registro en la tabla "productos"
                String actualizarRegistroSQL = "UPDATE productos SET categoria=?, subcategoria=? WHERE id=?";
                preparedStatement = conexion.prepareStatement(actualizarRegistroSQL);
                preparedStatement.setString(1, nuevaCategoria);
                preparedStatement.setString(2, nuevaSubcategoria);
                preparedStatement.setInt(3, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro actualizado con éxito.");
                    System.out.println(id+ " , "+nuevaCategoria+ " , "+nuevaSubcategoria);
                    
                } else {
                    System.out.println("No se encontró el registro con ID: " + id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
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

    public static void main(String[] args) {
        // Ejemplo de uso
    	 modificarRegistro(2, "Alimentación", "Monitor");
    	 
    }
}