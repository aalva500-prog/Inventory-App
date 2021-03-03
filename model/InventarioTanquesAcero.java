package model;

import java.sql.Date;

public class InventarioTanquesAcero {
	private int id_inventarioAcero;
	private Date fechaAcero;
	
	public InventarioTanquesAcero(int id_inventarioAcero, Date fechaAcero) {
		super();
		this.id_inventarioAcero = id_inventarioAcero;
		this.fechaAcero = fechaAcero;
	}

	public InventarioTanquesAcero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_inventarioAcero() {
		return id_inventarioAcero;
	}

	public void setId_inventarioAcero(int id_inventarioAcero) {
		this.id_inventarioAcero = id_inventarioAcero;
	}

	public Date getFechaAcero() {
		return fechaAcero;
	}

	public void setFechaAcero(Date fechaAcero) {
		this.fechaAcero = fechaAcero;
	}
	
	

}
