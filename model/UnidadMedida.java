package model;

public class UnidadMedida {
	private int id_unidad;
	private String descripcion;
	
	public UnidadMedida(int id_unidad, String descripcion) {
		super();
		this.id_unidad = id_unidad;
		this.descripcion = descripcion;
	}

	public UnidadMedida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(int id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return this.descripcion;
	}

}
