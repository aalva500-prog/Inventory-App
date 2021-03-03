package model;

import java.util.Date;

public class InventarioAditivos {
	private int id_inventarioaditivo;
	private Date fechainventarioaditivo;
	
	public InventarioAditivos(int id_inventarioaditivo,
			Date fechainventarioaditivo) {
		super();
		this.id_inventarioaditivo = id_inventarioaditivo;
		this.fechainventarioaditivo = fechainventarioaditivo;
	}

	public InventarioAditivos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_inventarioaditivo() {
		return id_inventarioaditivo;
	}

	public void setId_inventarioaditivo(int id_inventarioaditivo) {
		this.id_inventarioaditivo = id_inventarioaditivo;
	}

	public Date getFechainventarioaditivo() {
		return fechainventarioaditivo;
	}

	public void setFechainventarioaditivo(Date fechainventarioaditivo) {
		this.fechainventarioaditivo = fechainventarioaditivo;
	}
	
	
	

}
