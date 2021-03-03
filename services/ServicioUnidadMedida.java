package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.UnidadMedida;
import Utils.ConnectionBD;

public class ServicioUnidadMedida {
	
	public static LinkedList<UnidadMedida> getUnidades() throws SQLException, ClassNotFoundException{
		LinkedList<UnidadMedida> listUsuarios = new LinkedList<UnidadMedida>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"UnidadMedida\".\"id_unidad\",\"public\".\"UnidadMedida\".\"descripcion\"" +
				"FROM  \"public\".\"UnidadMedida\"" +
				"ORDER BY \"public\".\"UnidadMedida\".\"descripcion\" ASC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			UnidadMedida user = new UnidadMedida();
			user.setId_unidad(resultado.getInt(1));
			user.setDescripcion(resultado.getString(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}
	

}
