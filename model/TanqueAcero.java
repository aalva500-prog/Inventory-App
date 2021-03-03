package model;

import java.util.Date;

public class TanqueAcero {
	private int id_tanque;
	private String numero;
	private int capacidad;
	private String producto;
	private float grado;
	private int lts;
	private Date fechafabricacion;
	private String cliente;
	private int OF;
	private int inventarioTA;
	
	
	public TanqueAcero(int id_tanque, String numero, int capacidad,
			String producto, float grado, int lts, Date fechafabricacion,
			String cliente, int oF, int inventarioTA) {
		super();
		this.id_tanque = id_tanque;
		this.numero = numero;
		this.capacidad = capacidad;
		this.producto = producto;
		this.grado = grado;
		this.lts = lts;
		this.fechafabricacion = fechafabricacion;
		this.cliente = cliente;
		OF = oF;
		this.inventarioTA = inventarioTA;
	}


	public TanqueAcero() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_tanque() {
		return id_tanque;
	}


	public void setId_tanque(int id_tanque) {
		this.id_tanque = id_tanque;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public float getGrado() {
		return grado;
	}


	public void setGrado(float grado) {
		this.grado = grado;
	}


	public int getLts() {
		return lts;
	}


	public void setLts(int lts) {
		this.lts = lts;
	}


	public Date getFechafabricacion() {
		return fechafabricacion;
	}


	public void setFechafabricacion(Date fechafabricacion) {
		this.fechafabricacion = fechafabricacion;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public int getOF() {
		return OF;
	}


	public void setOF(int oF) {
		OF = oF;
	}


	public int getInventarioTA() {
		return inventarioTA;
	}


	public void setInventarioTA(int inventarioTA) {
		this.inventarioTA = inventarioTA;
	}
	
	
	

}
