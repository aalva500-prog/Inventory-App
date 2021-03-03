package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;

import model.Bidon;
import model.InformePizarra;
import Utils.ConnectionBD;

public class ServicioInformePizarra {
	public static LinkedList<InformePizarra> getInformes() throws SQLException, ClassNotFoundException{
		LinkedList<InformePizarra> listUsuarios = new LinkedList<InformePizarra>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"InformePizarra\".\"id_informe\",\"public\".\"InformePizarra\".\"fecha\"" +
				"FROM  \"public\".\"InformePizarra\"" +
				"ORDER BY \"public\".\"InformePizarra\".\"fecha\" DESC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			InformePizarra user = new InformePizarra();
			user.setId_informe(resultado.getInt(1));
			user.setFecha(resultado.getDate(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	
	public static LinkedList<InformePizarra> getFiltro(float mes,float ano){
		LinkedList<InformePizarra> listUsuarios = new LinkedList<InformePizarra>();
		String sentence = "SELECT \"public\".\"InformePizarra\".\"id_informe\",\"public\".\"InformePizarra\".\"fecha\"" +
				"FROM  \"public\".\"InformePizarra\""
				+ "WHERE \"date_part\"('month',\"InformePizarra\".\"fecha\")=? and \"date_part\"('year',\"InformePizarra\".\"fecha\")=?"
				+ "ORDER BY \"public\".\"InformePizarra\".\"fecha\" DESC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setFloat(1, mes);
			stat.setFloat(2, ano);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				InformePizarra user = new InformePizarra();
				user.setId_informe(resultado.getInt(1));
				user.setFecha(resultado.getDate(2));
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
	
	
	
	public static void  ModificarInforme(int id_informe,Date fech) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarInformePizarra\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.setDate(2,fech);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarInforme(int id_informe) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarInformePizarra\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_informe ); 
		prepararCons.execute();		
	}
	
	public static void insertarInforme(Date fecha) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarInformePrizarra\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setDate(1, fecha); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	

}
