package model;

public class MateriaPrima {
	private int id_materia;
	private String materia;
	
	
	public MateriaPrima(int id_materia, String materia) {
		super();
		this.id_materia = id_materia;
		this.materia = materia;
	}


	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_materia() {
		return id_materia;
	}


	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}


	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}


	@Override
	public String toString() {
		return this.materia;
	}
	
	

}
