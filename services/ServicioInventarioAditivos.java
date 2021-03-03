package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InformePizarra;
import model.InventarioAditivos;
import Utils.ConnectionBD;

public class ServicioInventarioAditivos {
	public static LinkedList<InventarioAditivos> getInventarioAditivos() throws SQLException, ClassNotFoundException{
		LinkedList<InventarioAditivos> listUsuarios = new LinkedList<InventarioAditivos>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InventarioAditivos\".\"id_inventarioaditivos\",\"public\".\"InventarioAditivos\".\"fecha\"" +
				"FROM  \"public\".\"InventarioAditivos\"" +
				"ORDER BY \"public\".\"InventarioAditivos\".\"fecha\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InventarioAditivos user = new InventarioAditivos();
			user.setId_inventarioaditivo(resultado.getInt(1));
			user.setFechainventarioaditivo(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	
	public static LinkedList<InventarioAditivos> getFiltro(float mes,float ano){
		LinkedList<InventarioAditivos> listUsuarios = new LinkedList<InventarioAditivos>();
		String sentence = "SELECT \"public\".\"InventarioAditivos\".\"id_inventarioaditivos\",\"public\".\"InventarioAditivos\".\"fecha\"" +
				"FROM  \"public\".\"InventarioAditivos\""
				+ "WHERE \"date_part\"('month',\"InventarioAditivos\".\"fecha\")=? and \"date_part\"('year',\"InventarioAditivos\".\"fecha\")=?"
				+ "ORDER BY \"public\".\"InventarioAditivos\".\"fecha\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InventarioAditivos user = new InventarioAditivos();
				user.setId_inventarioaditivo(resultado.getInt(1));
				user.setFechainventarioaditivo(resultado.getDate(2));
				listUsuarios.add(user);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsuarios;
	}
	
	public static void  ModificarInventarioAditivos(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInventarioAditivos\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInventarioAditivos(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInventarioAditivo\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void insertarInventarioAditivos(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInventarioAditivos\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	
	

}
