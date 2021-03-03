package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.InventarioTanquesPlasticos;
import model.Proveedor;
import Utils.ConnectionBD;

public class ServicioProveedor {

	public static LinkedList<Proveedor> getProveedores() throws SQLException, ClassNotFoundException{
		LinkedList<Proveedor> listUsuarios = new LinkedList<Proveedor>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"Proveedores\".\"id_proveedor\",\"public\".\"Proveedores\".\"proveedor\"" +
				"FROM  \"public\".\"Proveedores\"" +
				"ORDER BY \"public\".\"Proveedores\".\"proveedor\" ASC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Proveedor user = new Proveedor();
			user.setId_proveedor(resultado.getInt(1));
			user.setProveedor(resultado.getString(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	public static LinkedList<Proveedor> getFiltroletraA(){
		LinkedList<Proveedor> listUsuarios = new LinkedList<Proveedor>();
		String sentence = "SELECT \"public\".\"Proveedores\".\"id_proveedor\",\"public\".\"Proveedores\".\"proveedor\"" +
				"FROM  \"public\".\"Proveedores\""
				+ "WHERE \"public\".\"Proveedores\".\"proveedor\" LIKE 'A%'";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Proveedor user = new Proveedor();
				user.setId_proveedor(resultado.getInt(1));
				user.setProveedor(resultado.getString(2));
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
	
	public static LinkedList<Proveedor> getFiltroletraB(){
		LinkedList<Proveedor> listUsuarios = new LinkedList<Proveedor>();
		String sentence = "SELECT \"public\".\"Proveedores\".\"id_proveedor\",\"public\".\"Proveedores\".\"proveedor\"" +
				"FROM  \"public\".\"Proveedores\""
				+ "WHERE \"public\".\"Proveedores\".\"proveedor\" LIKE 'B%'";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Proveedor user = new Proveedor();
				user.setId_proveedor(resultado.getInt(1));
				user.setProveedor(resultado.getString(2));
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
	
	public static LinkedList<Proveedor> getFiltroletraC(){
		LinkedList<Proveedor> listUsuarios = new LinkedList<Proveedor>();
		String sentence = "SELECT \"public\".\"Proveedores\".\"id_proveedor\",\"public\".\"Proveedores\".\"proveedor\"" +
				"FROM  \"public\".\"Proveedores\""
				+ "WHERE \"public\".\"Proveedores\".\"proveedor\" LIKE 'C%'";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Proveedor user = new Proveedor();
				user.setId_proveedor(resultado.getInt(1));
				user.setProveedor(resultado.getString(2));
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
	
	
	public static void  Modificarproveedor(int id_producto,String nomb) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarProveedor\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.setString(2,nomb);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarProveedor(int id_producto) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarProveedor\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.execute();		
	}
	
	public static void insertarProveedor(String nombre) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarProveedor\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, nombre); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	
	
}
