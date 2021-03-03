package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.MateriaPrima;
import Utils.ConnectionBD;

public class ServicioMateriaPrima {
	
	
		public static LinkedList<MateriaPrima> getMaterias() throws SQLException, ClassNotFoundException{
			LinkedList<MateriaPrima> listUsuarios = new LinkedList<MateriaPrima>();
			Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sqlSentenc = "SELECT \"public\".\"MateriaPrima\".\"id_materia\",\"public\".\"MateriaPrima\".\"materia\"" +
					"FROM  \"public\".\"MateriaPrima\"" +
					"ORDER BY \"public\".\"MateriaPrima\".\"materia\" ASC";
			ResultSet resultado = consulta.executeQuery(sqlSentenc);
			while (resultado.next()) {
				MateriaPrima user = new MateriaPrima();
				user.setId_materia(resultado.getInt(1));
				user.setMateria(resultado.getString(2));
				listUsuarios.add(user);
			}
			return listUsuarios;
		}

		public static void  ModificarMateria(int id_producto,String nomb) throws SQLException, ClassNotFoundException { 
			String sqlSentenc = "SELECT \"public\".\"ModificarMateriaPrima\"(?,?)"; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_producto ); 
			prepararCons.setString(2,nomb);
			prepararCons.execute();		
		}
		
		
		
	public static void  EliminarMateria(int id_producto) throws SQLException, ClassNotFoundException { 		
			String sqlSentenc = "SELECT \"public\".\"EliminarmateriaPrima\"(?)" ; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_producto ); 
			prepararCons.execute();		
		}
		
		public static void insertarMateria(String nombre) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarMateriaPrima\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setString(1, nombre); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
			prepararCons.execute();
		}
	

}
