package model;

public class Proveedor {
	private int id_proveedor;
	private String proveedor;
	
	public Proveedor(int id_proveedor, String proveedor) {
		super();
		this.id_proveedor = id_proveedor;
		this.proveedor = proveedor;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return this.proveedor;
	}
	
	

}
