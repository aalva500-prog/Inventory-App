package model;

import java.util.Date;

public class InformePizarra {
private int id_informe;
private Date fecha;


public InformePizarra(int id_informe, Date fecha) {
	super();
	this.id_informe = id_informe;
	this.fecha = fecha;
}


public InformePizarra() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId_informe() {
	return id_informe;
}


public void setId_informe(int id_informe) {
	this.id_informe = id_informe;
}


public Date getFecha() {
	return fecha;
}


public void setFecha(Date fecha) {
	this.fecha = fecha;
}



}
