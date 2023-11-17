package productos;

public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private String fabricante;
    private int precio;
    private int nSerie;

    public Productos(int id,String nombre, String descripcion,  String fabricante,
    		int precio,int nSerie) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.fabricante=fabricante;
        this.precio=precio;
        this.nSerie=nSerie;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getnSerie() {
		return nSerie;
	}

	public void setnSerie(int nSerie) {
		this.nSerie = nSerie;
	}
    

}
