package modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nombre")
	private String nombre;


// Constructor por defecto requerido por Hibernate
	public Fabricante() {
	}

	public Fabricante(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}