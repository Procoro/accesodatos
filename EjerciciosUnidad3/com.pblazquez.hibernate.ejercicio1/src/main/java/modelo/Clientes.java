package modelo;


import javax.persistence.*;


@Entity
@Table(name = "clientes")
public class Clientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "nombre")
    private String nombre;


    @Column(name = "edad")
    private String edad;


    // Constructor por defecto requerido por Hibernate
    public Clientes() {
    }


    // Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad espec�ficos
    public Clientes(String nombre, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    // Getter y setter para el atributo id
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    // Getter y setter para el atributo nombre
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Getter y setter para el atributo ciudad
    public String getEdad() {
        return edad;
    }


    public void setCiudad(String ciudad) {
        this.edad = ciudad;
    }


    // M�todo para imprimir informaci�n del objeto Clientes
    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
