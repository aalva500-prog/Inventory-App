package model;

public class Cliente {
	private int id_cliente;
	private String nombre;
	
	public Cliente(int id_cliente, String nombre) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
	
	

}
