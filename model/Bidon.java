package model;

import java.util.Date;

public class Bidon {
private int id_bidon;
private String producto;
private float grados;
private Date fechafabricacion;
private int OFabricacion;
private int bidon;
private int litros;
private String estado;
private String tipoinventario;
private String materiaprima;
private String tiporon;


public Bidon(int id_bidon, String producto, float grados, Date fechafabricacion,
		int oFabricacion, int bidon, int litros, String estado,
		String tipoinventario, String materiaprima, String tiporon) {
	super();
	this.id_bidon = id_bidon;
	this.producto = producto;
	this.grados = grados;
	this.fechafabricacion = fechafabricacion;
	OFabricacion = oFabricacion;
	this.bidon = bidon;
	this.litros = litros;
	this.estado = estado;
	this.tipoinventario = tipoinventario;
	this.materiaprima = materiaprima;
	this.tiporon = tiporon;
}


public Bidon() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId_bidon() {
	return id_bidon;
}


public void setId_bidon(int id_bidon) {
	this.id_bidon = id_bidon;
}


public String getProducto() {
	return producto;
}


public void setProducto(String producto) {
	this.producto = producto;
}


public float getGrados() {
	return grados;
}


public void setGrados(float grados) {
	this.grados = grados;
}


public Date getFechafabricacion() {
	return fechafabricacion;
}


public void setFechafabricacion(Date fechafabricacion) {
	this.fechafabricacion = fechafabricacion;
}


public int getOFabricacion() {
	return OFabricacion;
}


public void setOFabricacion(int oFabricacion) {
	OFabricacion = oFabricacion;
}


public int getBidon() {
	return bidon;
}


public void setBidon(int bidon) {
	this.bidon = bidon;
}


public int getLitros() {
	return litros;
}


public void setLitros(int litros) {
	this.litros = litros;
}


public String getEstado() {
	return estado;
}


public void setEstado(String estado) {
	this.estado = estado;
}


public String getTipoinventario() {
	return tipoinventario;
}


public void setTipoinventario(String tipoinventario) {
	this.tipoinventario = tipoinventario;
}


public String getMateriaprima() {
	return materiaprima;
}


public void setMateriaprima(String materiaprima) {
	this.materiaprima = materiaprima;
}


public String getTiporon() {
	return tiporon;
}


public void setTiporon(String tiporon) {
	this.tiporon = tiporon;
}



}
