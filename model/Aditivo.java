package model;

import java.util.Date;

public class Aditivo {
private int id_aditivo;
private String codigo;
private String proveedor;
private Date vencimiento;
private String UM;
private float existencia;
private String materia;





public String getMateria() {
	return materia;
}


public void setMateria(String materia) {
	this.materia = materia;
}


public Aditivo(int id_aditivo, String codigo, String proveedor,
		Date vencimiento, String uM, float existencia, String materia) {
	super();
	this.id_aditivo = id_aditivo;
	this.codigo = codigo;
	this.proveedor = proveedor;
	this.vencimiento = vencimiento;
	UM = uM;
	this.existencia = existencia;
	this.materia = materia;
}


public Aditivo() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId_aditivo() {
	return id_aditivo;
}


public void setId_aditivo(int id_aditivo) {
	this.id_aditivo = id_aditivo;
}


public String getCodigo() {
	return codigo;
}


public void setCodigo(String codigo) {
	this.codigo = codigo;
}


public String getProveedor() {
	return proveedor;
}


public void setProveedor(String proveedor) {
	this.proveedor = proveedor;
}


public Date getVencimiento() {
	return vencimiento;
}


public void setVencimiento(Date vencimiento) {
	this.vencimiento = vencimiento;
}


public String getUM() {
	return UM;
}


public void setUM(String uM) {
	UM = uM;
}


public float getExistencia() {
	return existencia;
}


public void setExistencia(float existencia) {
	this.existencia = existencia;
}





}
