package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Cliente;
import Utils.ConnectionBD;

public class ServicioCliente {
	public static LinkedList<Cliente> getClientes() throws SQLException, ClassNotFoundException{
		LinkedList<Cliente> listUsuarios = new LinkedList<Cliente>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"Cliente\".\"id_cliente\",\"public\".\"Cliente\".\"nombreC\"" +
				"FROM  \"public\".\"Cliente\"" +
				"ORDER BY \"public\".\"Cliente\".\"nombreC\" ASC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Cliente user = new Cliente();
			user.setId_cliente(resultado.getInt(1));
			user.setNombre(resultado.getString(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	public static void  ModificarCliente(int id_producto,String nomb) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarCliente\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.setString(2,nomb);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarCliente(int id_producto) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarCliente\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.execute();		
	}
	
	public static void insertarCliente(String nombre) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarCliente\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, nombre); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
	

}
