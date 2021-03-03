package model;

import java.util.Date;

public class TanquePlastico {
	private int id_tanqueplastico;
	private String numero;
	private int cantLTS;
	private String producto;
	private float grado;
	private int LTS;
	private Date fechafabricacion;
	private String cliente;
	private int of;
	private int invnetarioPlasticos;
	
	
	public TanquePlastico() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TanquePlastico(int id_tanqueplastico, String numero, int cantLTS,
			String producto, float grado, int lTS, Date fechafabricacion,
			String cliente, int of, int invnetarioPlasticos) {
		super();
		this.id_tanqueplastico = id_tanqueplastico;
		this.numero = numero;
		this.cantLTS = cantLTS;
		this.producto = producto;
		this.grado = grado;
		LTS = lTS;
		this.fechafabricacion = fechafabricacion;
		this.cliente = cliente;
		this.of = of;
		this.invnetarioPlasticos = invnetarioPlasticos;
	}


	public int getId_tanqueplastico() {
		return id_tanqueplastico;
	}


	public void setId_tanqueplastico(int id_tanqueplastico) {
		this.id_tanqueplastico = id_tanqueplastico;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCantLTS() {
		return cantLTS;
	}


	public void setCantLTS(int cantLTS) {
		this.cantLTS = cantLTS;
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


	public int getLTS() {
		return LTS;
	}


	public void setLTS(int lTS) {
		LTS = lTS;
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


	public int getOf() {
		return of;
	}


	public void setOf(int of) {
		this.of = of;
	}


	public int getInvnetarioPlasticos() {
		return invnetarioPlasticos;
	}


	public void setInvnetarioPlasticos(int invnetarioPlasticos) {
		this.invnetarioPlasticos = invnetarioPlasticos;
	}
	
	

}
