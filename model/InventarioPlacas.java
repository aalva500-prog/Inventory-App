package model;

import java.util.Date;

public class InventarioPlacas {
	private int id_inventarioplacas;
	private Date fechainventarioplacas;
	
	public InventarioPlacas(int id_inventarioplacas, Date fechainventarioplacas) {
		super();
		this.id_inventarioplacas = id_inventarioplacas;
		this.fechainventarioplacas = fechainventarioplacas;
	}

	public InventarioPlacas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_inventarioplacas() {
		return id_inventarioplacas;
	}

	public void setId_inventarioplacas(int id_inventarioplacas) {
		this.id_inventarioplacas = id_inventarioplacas;
	}

	public Date getFechainventarioplacas() {
		return fechainventarioplacas;
	}

	public void setFechainventarioplacas(Date fechainventarioplacas) {
		this.fechainventarioplacas = fechainventarioplacas;
	}
	

}
