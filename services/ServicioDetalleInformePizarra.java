package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.DetalleProductoInforme;
import Utils.ConnectionBD;

public class ServicioDetalleInformePizarra {
	public static LinkedList<DetalleProductoInforme> getDetallesProductos(int id_informe){
		LinkedList<DetalleProductoInforme> listUsuarios = new LinkedList<DetalleProductoInforme>();
		String sentence = "SELECT DISTINCT \"public\".\"DetalleProductoInforme\".\"id_detalleinforme\",\"public\".\"Producto\".\"nombreP\",\"public\".\"DetalleProductoInforme\".\"LTS\"," +
				"\"public\".\"DetalleProductoInforme\".\"Grado\",\"public\".\"DetalleProductoInforme\".\"Inicio\",\"public\".\"DetalleProductoInforme\".\"Final\",\"public\".\"DetalleProductoInforme\".\"OFabricacion\"," +
				"\"public\".\"DetalleProductoInforme\".\"observaciones\",\"public\".\"Cliente\".\"nombreC\"" +
				"FROM  \"public\".\"Producto\",\"public\".\"DetalleProductoInforme\",\"public\".\"Cliente\"" +
				"WHERE \"public\".\"Producto\".\"id_producto\"=\"public\".\"DetalleProductoInforme\".\"producto\" and \"public\".\"DetalleProductoInforme\".\"informe\"=?" +
				"and \"public\".\"Cliente\".\"id_cliente\"= \"public\".\"DetalleProductoInforme\".\"cliente\"" +
				"ORDER BY \"public\".\"Cliente\".\"nombreC\",\"public\".\"Producto\".\"nombreP\",\"public\".\"DetalleProductoInforme\".\"OFabricacion\"  ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				DetalleProductoInforme user = new DetalleProductoInforme();
				user.setId_detalle(resultado.getInt(1));
				user.setProducto(resultado.getString(2));
				user.setLitros(resultado.getFloat(3));
				user.setGrados(resultado.getFloat(4));
				user.setFInicio(resultado.getDate(5));
				user.setFFinal(resultado.getDate(6));
				user.setOF(resultado.getInt(7));
				user.setObservaciones(resultado.getString(8));
				user.setCliente(resultado.getString(9));
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

	
	
	
	public static void  ModificarDetalleInformePizarra(int id_detalle,int producto,float LTS,float Grado,Date Inicio,Date Final,int OFabricacion,String observaciones,int cliente) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarDetalleInformePizarra\"(?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_detalle ); 
		prepararCons.setInt(2, producto);
		prepararCons.setFloat(3, LTS);
		prepararCons.setFloat(4, Grado);
		prepararCons.setDate(5, Inicio);
		prepararCons.setDate(6, Final);
		prepararCons.setInt(7, OFabricacion);
		prepararCons.setString(8,observaciones);
		prepararCons.setInt(9, cliente);
		prepararCons.execute();		
	}
	
	
	
public static void  EliminarDetalleInforme(int id_detalle) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarDetalleInformePizarra\"(?)" ; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_detalle); 
		prepararCons.execute();		
	}
	
public static void  EliminarDetalleInformeCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
	String sqlSentenc = "SELECT \"public\".\"EliminarDetalleInformeCascada\"(?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setInt(1,id_informe); 
	prepararCons.execute();		
}


	public static void insertarDetalleInforme(int producto,float LTS,float Grado,Date Inicio,Date Final,int OFabricacion,String observaciones,int cliente,int informe) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarDetalleInformePizarra\" (?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1, producto);
		prepararCons.setFloat(2, LTS);
		prepararCons.setFloat(3, Grado);
		prepararCons.setDate(4, Inicio);
		prepararCons.setDate(5, Final);
		prepararCons.setInt(6, OFabricacion);
		prepararCons.setString(7, observaciones); 
		prepararCons.setInt(8, cliente);
		prepararCons.setInt(9, informe);
		prepararCons.execute();
	}
	
	
}
