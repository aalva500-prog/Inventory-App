package model;

public class Producto {
	private int id_producto;
	private String nombreP;
	
	public Producto(int id_producto, String nombreP) {
		super();
		this.id_producto = id_producto;
		this.nombreP = nombreP;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_producto() {
		return id_producto;
	}

	@Override
	public String toString() {
		return this.nombreP;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	
	

}
