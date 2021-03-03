package model;

import java.util.Date;

public class InventarioTanquesPlasticos {
	private int id_tanquesplasticos;
	private Date fechaplasticos;
	
	public InventarioTanquesPlasticos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventarioTanquesPlasticos(int id_tanquesplasticos,
			Date fechaplasticos) {
		super();
		this.id_tanquesplasticos = id_tanquesplasticos;
		this.fechaplasticos = fechaplasticos;
	}

	public int getId_tanquesplasticos() {
		return id_tanquesplasticos;
	}

	public void setId_tanquesplasticos(int id_tanquesplasticos) {
		this.id_tanquesplasticos = id_tanquesplasticos;
	}

	public Date getFechaplasticos() {
		return fechaplasticos;
	}

	public void setFechaplasticos(Date fechaplasticos) {
		this.fechaplasticos = fechaplasticos;
	}
	
	

}
