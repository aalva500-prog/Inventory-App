package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.TipoInventarioBidon;
import Utils.ConnectionBD;

public class ServicioTIpoInventarioBidon {
	
	public static LinkedList<TipoInventarioBidon> getTipos() throws SQLException, ClassNotFoundException{

		LinkedList<TipoInventarioBidon> listRol = new LinkedList<TipoInventarioBidon>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\" " +
		"FROM  \"public\".\"TipoInventarioBIdon\"";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoInventarioBidon rol = new TipoInventarioBidon();
			rol.setId_tipoinventario(resultado.getInt(1));
			rol.setTipoInventario(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}

	public static LinkedList<TipoInventarioBidon> getTiposMaterias() throws SQLException, ClassNotFoundException{

		LinkedList<TipoInventarioBidon> listRol = new LinkedList<TipoInventarioBidon>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\" " +
		"FROM  \"public\".\"TipoInventarioBIdon\""
		+ "WHERE \"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\"=2 OR \"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\"=3";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			TipoInventarioBidon rol = new TipoInventarioBidon();
			rol.setId_tipoinventario(resultado.getInt(1));
			rol.setTipoInventario(resultado.getString(2));
			listRol.add(rol);
		}
		return listRol;
	}
	
	
}
