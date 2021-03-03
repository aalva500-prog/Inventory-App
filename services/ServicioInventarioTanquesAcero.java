package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InventarioPlacas;
import model.InventarioTanquesAcero;
import Utils.ConnectionBD;

public class ServicioInventarioTanquesAcero {
	public static LinkedList<InventarioTanquesAcero> getInventarioTanquesAcero() throws SQLException, ClassNotFoundException{
		LinkedList<InventarioTanquesAcero> listUsuarios = new LinkedList<InventarioTanquesAcero>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InventarioTanquesAcero\".\"id_tanquesacero\",\"public\".\"InventarioTanquesAcero\".\"fechaacero\"" +
				"FROM  \"public\".\"InventarioTanquesAcero\"" +
				"ORDER BY \"public\".\"InventarioTanquesAcero\".\"fechaacero\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InventarioTanquesAcero user = new InventarioTanquesAcero();
			user.setId_inventarioAcero(resultado.getInt(1));
			user.setFechaAcero(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	
	public static LinkedList<InventarioTanquesAcero> getFiltro(float mes,float ano){
		LinkedList<InventarioTanquesAcero> listUsuarios = new LinkedList<InventarioTanquesAcero>();
		String sentence = "SELECT \"public\".\"InventarioTanquesAcero\".\"id_tanquesacero\",\"public\".\"InventarioTanquesAcero\".\"fechaacero\"" +
				"FROM  \"public\".\"InventarioTanquesAcero\""
				+ "WHERE \"date_part\"('month',\"InventarioTanquesAcero\".\"fechaacero\")=? and \"date_part\"('year',\"InventarioTanquesAcero\".\"fechaacero\")=?"
				+ "ORDER BY \"public\".\"InventarioTanquesAcero\".\"fechaacero\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InventarioTanquesAcero user = new InventarioTanquesAcero();
				user.setId_inventarioAcero(resultado.getInt(1));
				user.setFechaAcero(resultado.getDate(2));
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
	
	public static void  ModificarInventarioTanquesAcero(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInventarioTanquesAcero\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInventarioTanquesAcero(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInventarioTanquesAcero\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void insertarInventarioTanquesAcero(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInventarioTanquesAcero\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	
	

}
