package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Producto;
import Utils.ConnectionBD;

public class ServicioProducto {
	
	public static LinkedList<Producto> getProductos() throws SQLException, ClassNotFoundException{
		LinkedList<Producto> listUsuarios = new LinkedList<Producto>();
		Statement consulta = ConnectionBD.connect.getConnection().createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sqlSentenc = "SELECT \"public\".\"Producto\".\"id_producto\",\"public\".\"Producto\".\"nombreP\"" +
				"FROM  \"public\".\"Producto\"" +
				"ORDER BY \"public\".\"Producto\".\"nombreP\" ASC";
		ResultSet resultado = consulta.executeQuery(sqlSentenc);
		while (resultado.next()) {
			Producto user = new Producto();
			user.setId_producto(resultado.getInt(1));
			user.setNombreP(resultado.getString(2));
			listUsuarios.add(user);
		}
		return listUsuarios;
	}

	public static void  ModificarProducto(int id_producto,String nomb) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarProducto\"(?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.setString(2,nomb);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarProducto(int id_producto) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarProducto\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_producto ); 
		prepararCons.execute();		
	}
	
	public static void insertarProducto(String nombre) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarProducto\" (?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, nombre); /* estamos dándole valor al primer parametro que se pasa, es decir al primer ? que aparezca. */
		prepararCons.execute();
	}
}
