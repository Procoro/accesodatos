package phoneland;

public class Productos {
	private int id_PRODUCTO;
	private int id_proveedor;
	private String NOMBRE;
	private String FABRICANTE;
	private String PRECIO;
	private float PVP;
	private String Descripcion;
	public Productos(int id_PRODUCTO, int id_proveedor, String nOMBRE, String fABRICANTE, String precio, float pVP,
			String descripcion) {
		super();
		this.id_PRODUCTO = id_PRODUCTO;
		this.id_proveedor = id_proveedor;
		NOMBRE = nOMBRE;
		FABRICANTE = fABRICANTE;
		PRECIO = precio;
		PVP = pVP;
		Descripcion = descripcion;
	}
	public int getId_PRODUCTO() {
		return id_PRODUCTO;
	}
	public void setId_PRODUCTO(int id_PRODUCTO) {
		this.id_PRODUCTO = id_PRODUCTO;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getFABRICANTE() {
		return FABRICANTE;
	}
	public void setFABRICANTE(String fABRICANTE) {
		FABRICANTE = fABRICANTE;
	}
	public String getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(String pRECIO) {
		PRECIO = pRECIO;
	}
	public float getPVP() {
		return PVP;
	}
	public void setPVP(float pVP) {
		PVP = pVP;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
