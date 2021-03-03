package model;

import java.util.Date;

public class InventarioBidon {
private int id_inventarioBIdon;
private Date fechainventario;


public InventarioBidon(int id_inventarioBIdon, Date fechainventario) {
	super();
	this.id_inventarioBIdon = id_inventarioBIdon;
	this.fechainventario = fechainventario;
}


public InventarioBidon() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId_inventarioBIdon() {
	return id_inventarioBIdon;
}


public void setId_inventarioBIdon(int id_inventarioBIdon) {
	this.id_inventarioBIdon = id_inventarioBIdon;
}


public Date getFechainventario() {
	return fechainventario;
}


public void setFechainventario(Date fechainventario) {
	this.fechainventario = fechainventario;
}



}
