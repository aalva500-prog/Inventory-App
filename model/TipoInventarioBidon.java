package model;

public class TipoInventarioBidon {
	private int id_tipoinventario;
	private String tipoInventario;
	
	public TipoInventarioBidon(int id_tipoinventario, String tipoInventario) {
		super();
		this.id_tipoinventario = id_tipoinventario;
		this.tipoInventario = tipoInventario;
	}

	public TipoInventarioBidon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_tipoinventario() {
		return id_tipoinventario;
	}

	public void setId_tipoinventario(int id_tipoinventario) {
		this.id_tipoinventario = id_tipoinventario;
	}

	public String getTipoInventario() {
		return tipoInventario;
	}

	public void setTipoInventario(String tipoInventario) {
		this.tipoInventario = tipoInventario;
	}

	@Override
	public String toString() {
		return this.tipoInventario;
	}
	
	
	
	

}
