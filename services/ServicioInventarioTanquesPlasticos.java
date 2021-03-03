package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InventarioTanquesAcero;
import model.InventarioTanquesPlasticos;
import Utils.ConnectionBD;

public class ServicioInventarioTanquesPlasticos {
	
	public static LinkedList<InventarioTanquesPlasticos> getInventarioTanquesPlasticos() throws SQLException, ClassNotFoundException{
		LinkedList<InventarioTanquesPlasticos> listUsuarios = new LinkedList<InventarioTanquesPlasticos>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InventarioTanquesPlasticos\".\"id_tanquesplasticos\",\"public\".\"InventarioTanquesPlasticos\".\"fechaplastica\"" +
				"FROM  \"public\".\"InventarioTanquesPlasticos\"" +
				"ORDER BY \"public\".\"InventarioTanquesPlasticos\".\"fechaplastica\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InventarioTanquesPlasticos user = new InventarioTanquesPlasticos();
			user.setId_tanquesplasticos(resultado.getInt(1));
			user.setFechaplasticos(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}


	public static LinkedList<InventarioTanquesPlasticos> getFiltro(float mes,float ano){
		LinkedList<InventarioTanquesPlasticos> listUsuarios = new LinkedList<InventarioTanquesPlasticos>();
		String sentence = "SELECT \"public\".\"InventarioTanquesPlasticos\".\"id_tanquesplasticos\",\"public\".\"InventarioTanquesPlasticos\".\"fechaplastica\"" +
				"FROM  \"public\".\"InventarioTanquesPlasticos\""
				+ "WHERE \"date_part\"('month',\"InventarioTanquesPlasticos\".\"fechaplastica\")=? and \"date_part\"('year',\"InventarioTanquesPlasticos\".\"fechaplastica\")=?"
				+ "ORDER BY \"public\".\"InventarioTanquesPlasticos\".\"fechaplastica\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InventarioTanquesPlasticos user = new InventarioTanquesPlasticos();
				user.setId_tanquesplasticos(resultado.getInt(1));
				user.setFechaplasticos(resultado.getDate(2));
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
	
	
	
	
	public static void  ModificarInventarioTanquesPlasticos(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInventarioTanquesPlasticos\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInventarioTanquesPlasticos(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInventarioTanquesPlasticos\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void insertarInventarioTanquesPlasticos(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInventarioTAnquesPlasticos\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}

}
