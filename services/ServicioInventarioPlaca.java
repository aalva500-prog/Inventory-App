package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InventarioBidon;
import model.InventarioPlacas;
import Utils.ConnectionBD;

public class ServicioInventarioPlaca {
	public static LinkedList<InventarioPlacas> getInventarioPlacas() throws SQLException, ClassNotFoundException{
		LinkedList<InventarioPlacas> listUsuarios = new LinkedList<InventarioPlacas>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InventarioPlacas\".\"id_inventarioplacas\",\"public\".\"InventarioPlacas\".\"fechainventarioplacas\"" +
				"FROM  \"public\".\"InventarioPlacas\"" +
				"ORDER BY \"public\".\"InventarioPlacas\".\"fechainventarioplacas\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InventarioPlacas user = new InventarioPlacas();
			user.setId_inventarioplacas(resultado.getInt(1));
			user.setFechainventarioplacas(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	
	public static LinkedList<InventarioPlacas> getFiltro(float mes,float ano){
		LinkedList<InventarioPlacas> listUsuarios = new LinkedList<InventarioPlacas>();
		String sentence = "SELECT \"public\".\"InventarioPlacas\".\"id_inventarioplacas\",\"public\".\"InventarioPlacas\".\"fechainventarioplacas\"" +
				"FROM  \"public\".\"InventarioPlacas\""
				+ "WHERE \"date_part\"('month',\"InventarioPlacas\".\"fechainventarioplacas\")=? and \"date_part\"('year',\"InventarioPlacas\".\"fechainventarioplacas\")=?"
				+ "ORDER BY \"public\".\"InventarioPlacas\".\"fechainventarioplacas\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InventarioPlacas user = new InventarioPlacas();
				user.setId_inventarioplacas(resultado.getInt(1));
				user.setFechainventarioplacas(resultado.getDate(2));
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
	
	public static void  ModificarInventarioPlacas(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInventarioPlacas\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInventarioPlacas(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInventarioPlacas\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void insertarInventarioPlacas(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInventarioPlacas\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}

}
