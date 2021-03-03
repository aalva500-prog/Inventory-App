package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InformePizarra;
import model.InventarioBidon;
import Utils.ConnectionBD;

public class ServicioInventarioBIdon {
	
	public static LinkedList<InventarioBidon> getInventariosBIdones() throws SQLException, ClassNotFoundException{
		LinkedList<InventarioBidon> listUsuarios = new LinkedList<InventarioBidon>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InventarioBidon\".\"id_inventariobidon\",\"public\".\"InventarioBidon\".\"fechainventarioBidon\"" +
				"FROM  \"public\".\"InventarioBidon\"" +
				"ORDER BY \"public\".\"InventarioBidon\".\"fechainventarioBidon\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InventarioBidon user = new InventarioBidon();
			user.setId_inventarioBIdon(resultado.getInt(1));
			user.setFechainventario(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	public static LinkedList<InventarioBidon> getFiltro(float mes,float ano){
		LinkedList<InventarioBidon> listUsuarios = new LinkedList<InventarioBidon>();
		String sentence = "SELECT \"public\".\"InventarioBidon\".\"id_inventariobidon\",\"public\".\"InventarioBidon\".\"fechainventarioBidon\"" +
				"FROM  \"public\".\"InventarioBidon\""
				+ "WHERE \"date_part\"('month',\"InventarioBidon\".\"fechainventarioBidon\")=? and \"date_part\"('year',\"InventarioBidon\".\"fechainventarioBidon\")=?"
				+ "ORDER BY \"public\".\"InventarioBidon\".\"fechainventarioBidon\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InventarioBidon user = new InventarioBidon();
				user.setId_inventarioBIdon(resultado.getInt(1));
				user.setFechainventario(resultado.getDate(2));
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
	
	
	public static void  ModificarInventarioBIdones(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInventarioBidones\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInventarioBidones(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInventarioBidon\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void InsertarInventarioBidon(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInventarioBidon\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	

}
