package modelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

public static void main(String[] args) {

// Configurar la sesin de Hibernate
SessionFactory sessionFactory = new Configuration()
.configure()//llama al fichero hibernate.cfg.xml

// .configure("hibernate.cfg.xml") // Ruta del archivo de configuracin de Hibernate
.buildSessionFactory(); // Construir la sesin de Hibernate

// Configurar la sesin en el contexto actual
ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
context.bind(sessionFactory.openSession());

try {
// Crear objeto alumno
Productos productos = new Productos("Asterix y Obelix en Hispania", "Un emocionante libro para los amantes de la lectura.", 29.99, "Editorial ABC",50);
Productos productos2 = new Productos("Dune", "El mejor libro de Ciencia Ficción", 15.0, "Editorial Marvel", 100);
Productos productos3 = new Productos("Illiada", "Un clásico para regalar", 50.00, "Editorial Homero", 30);
Productos productos4 = new Productos("Juego la batalla del Abismo de Helm", "Juego de estrategia para divertirse en familia.", 39.99, "Juegos Divertidos S.L.", 20);
// Obtener la sesión actual
Session session = context.currentSession();

// Iniciar transacción
session.beginTransaction();

// Guardar objeto en la base de datos
session.save(productos);
session.save(productos2);
session.save(productos3);
session.save(productos4);

// Hacer commit de la transacción
session.getTransaction().commit();

// Imprimir alumno guardado en la base de datos
System.out.println("Producto añadido: " + productos);
System.out.println("Producto añadido: " + productos2);
System.out.println("Producto añadido: " + productos3);
System.out.println("Producto añadido: " + productos4);

} catch (Exception e) {
e.printStackTrace();
} finally {
// Desligar la sesión del contexto
ThreadLocalSessionContext.unbind(sessionFactory);
// Cerrar la sesión de Hibernate
sessionFactory.close();
}
}
}