package model;

import java.util.Date;

public class Placas {
	private int id_placas;
	private String placa;
	private int cantplacas;
	private int cantporcajas;
	private String utilizacion;
	private Date fechaInventarioPlacas;
	
	
	public Placas(int id_placas, String placa, int cantplacas,
			int cantporcajas, String utilizacion, Date fechaInventarioPlacas) {
		super();
		this.id_placas = id_placas;
		this.placa = placa;
		this.cantplacas = cantplacas;
		this.cantporcajas = cantporcajas;
		this.utilizacion = utilizacion;
		this.fechaInventarioPlacas = fechaInventarioPlacas;
	}


	public Placas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_placas() {
		return id_placas;
	}


	public void setId_placas(int id_placas) {
		this.id_placas = id_placas;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public int getCantplacas() {
		return cantplacas;
	}


	public void setCantplacas(int cantplacas) {
		this.cantplacas = cantplacas;
	}


	public int getCantporcajas() {
		return cantporcajas;
	}


	public void setCantporcajas(int cantporcajas) {
		this.cantporcajas = cantporcajas;
	}


	public String getUtilizacion() {
		return utilizacion;
	}


	public void setUtilizacion(String utilizacion) {
		this.utilizacion = utilizacion;
	}


	public Date getFechaInventarioPlacas() {
		return fechaInventarioPlacas;
	}


	public void setFechaInventarioPlacas(Date fechaInventarioPlacas) {
		this.fechaInventarioPlacas = fechaInventarioPlacas;
	}
	
	
	
	

}
