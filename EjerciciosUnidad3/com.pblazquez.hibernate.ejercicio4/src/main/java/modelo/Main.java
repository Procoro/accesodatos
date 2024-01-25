package modelo;


import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
Juegos juegos = new Juegos(4,"World of Wordcraft", 2010, "Blizzard",80.00,"Pedazo de juego","todas");


// Obtener la sesión actual
Session session = context.currentSession();

// Iniciar transacción
session.beginTransaction();

// Guardar objeto en la base de datos
session.save(juegos);

// Hacer commit de la transacción
session.getTransaction().commit();

// Imprimir juego guardado en la base de datos
System.out.println("Juego añadido: " + juegos);

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