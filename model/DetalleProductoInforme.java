package model;

import java.util.Date;

public class DetalleProductoInforme {
	private String cliente;
	private float litros;
	private float grados;
	private Date FInicio;
	private Date FFinal;
	private int OF;
	private String producto;
	private String observaciones;
	private Date informe;
	private int id_detalle;
	
	public DetalleProductoInforme(String cliente, float litros, float grados,
			Date fInicio, Date fFinal, int oF, String producto,
			String observaciones, Date informe, int id_detalle) {
		super();
		this.cliente = cliente;
		this.litros = litros;
		this.grados = grados;
		this.FInicio = fInicio;
		this.FFinal = fFinal;
		this.OF = oF;
		this.producto = producto;
		this.observaciones = observaciones;
		this.informe = informe;
		this.id_detalle = id_detalle;
	}

	public DetalleProductoInforme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public float getGrados() {
		return grados;
	}

	public void setGrados(float grados) {
		this.grados = grados;
	}

	public Date getFInicio() {
		return FInicio;
	}

	public void setFInicio(Date fInicio) {
		FInicio = fInicio;
	}

	public Date getFFinal() {
		return FFinal;
	}

	public void setFFinal(Date fFinal) {
		FFinal = fFinal;
	}

	public int getOF() {
		return OF;
	}

	public void setOF(int oF) {
		OF = oF;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getInforme() {
		return informe;
	}

	public void setInforme(Date informe) {
		this.informe = informe;
	}

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}
	
	
	

}
