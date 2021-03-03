package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.TanqueAcero;
import Utils.ConnectionBD;

public class ServicioTanquesAcero {
	
	public static LinkedList<TanqueAcero> getTanques(int id_informe){
		LinkedList<TanqueAcero> listUsuarios = new LinkedList<TanqueAcero>();
		String sentence = "SELECT DISTINCT \"public\".\"TanquesAcero\".\"id_tanque\",\"public\".\"TanquesAcero\".\"numero\",\"public\".\"TanquesAcero\".\"capacidad\"," +
				"\"public\".\"Producto\".\"nombreP\",\"public\".\"TanquesAcero\".\"grado\",\"public\".\"TanquesAcero\".\"LTSreales\",\"public\".\"TanquesAcero\".\"fechafabricacion\"," +
				"\"public\".\"Cliente\".\"nombreC\",\"public\".\"TanquesAcero\".\"OF\"" +
				"FROM  \"public\".\"Producto\",\"public\".\"TanquesAcero\",\"public\".\"Cliente\"" +
				"WHERE \"public\".\"Producto\".\"id_producto\"=\"public\".\"TanquesAcero\".\"producto\" and \"public\".\"TanquesAcero\".\"inventarioTA\"=?" +
				"and \"public\".\"Cliente\".\"id_cliente\"= \"public\".\"TanquesAcero\".\"cliente\"" +
				"ORDER BY \"public\".\"TanquesAcero\".\"id_tanque\"  ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				TanqueAcero user = new TanqueAcero();
				user.setId_tanque(resultado.getInt(1));
				user.setNumero(resultado.getString(2));
				user.setCapacidad(resultado.getInt(3));
				user.setProducto(resultado.getString(4));
				user.setGrado(resultado.getFloat(5));
				user.setLts(resultado.getInt(6));
				user.setFechafabricacion(resultado.getDate(7));
				user.setCliente(resultado.getString(8));
				user.setOF(resultado.getInt(9));
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

	
	
	
	public static void  ModificarTanquesAcero(int id_tanque,String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int ofab) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanqueAcero\"(?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_tanque ); 
		prepararCons.setString(2, numero);
		prepararCons.setInt(3, capacidad);
		prepararCons.setInt(4, producto);
		prepararCons.setFloat(5, grado);
		prepararCons.setInt(6, LTSreales);
		prepararCons.setDate(7, fechafabricacion);
		prepararCons.setInt(8, cliente);
		prepararCons.setInt(9, ofab);
		prepararCons.execute();		
	}
	
	public static void  ModificarTanquesAcerosinOFniGradoniLTS(int id_tanque,String numero,int capacidad,int producto,Date fechafabricacion,int cliente) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanqueAcerosinLTSniOFniGrado\"(?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_tanque ); 
		prepararCons.setString(2, numero);
		prepararCons.setInt(3, capacidad);
		prepararCons.setInt(4, producto);
		prepararCons.setDate(5, fechafabricacion);
		prepararCons.setInt(6, cliente);
		prepararCons.execute();		
	}
	
	public static void  ModificarTanquesAcerosinOF(int id_tanque,String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanqueAcerosinOF\"(?,?,?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_tanque ); 
		prepararCons.setString(2, numero);
		prepararCons.setInt(3, capacidad);
		prepararCons.setInt(4, producto);
		prepararCons.setFloat(5, grado);
		prepararCons.setInt(6, LTSreales);
		prepararCons.setDate(7, fechafabricacion);
		prepararCons.setInt(8, cliente);
		prepararCons.execute();		
	}
	
public static void  EliminarTanquesAcero(int id_detalle) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarTanqueAcero\"(?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_detalle); 
		prepararCons.execute();		
	}
	
public static void  EliminarTanquesAceroCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
	String sqlSentenc = "SELECT \"public\".\"EliminarTanquesAceroCascada\"(?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setInt(1,id_informe); 
	prepararCons.execute();		
}


	public static void insertarTanqueAcero(String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int OF,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanqueAcero\" (?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, numero);
		prepararCons.setInt(2, capacidad);
		prepararCons.setInt(3, producto);
		prepararCons.setFloat(4, grado);
		prepararCons.setInt(5, LTSreales);
		prepararCons.setDate(6, fechafabricacion);
		prepararCons.setInt(7, cliente); 
		prepararCons.setInt(8, OF);
		prepararCons.setInt(9, inventarioTA);
		prepararCons.execute();
	}
	
	public static void insertarTanqueAcerosinOFniGradoniLTS(String numero,int capacidad,int producto,Date fechafabricacion,int cliente,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanqueAcerosinGradoLitroniOF\" (?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, numero);
		prepararCons.setInt(2, capacidad);
		prepararCons.setInt(3, producto);
		prepararCons.setDate(4, fechafabricacion);
		prepararCons.setInt(5, cliente); 
		prepararCons.setInt(6, inventarioTA);
		prepararCons.execute();
	}
	
	public static void insertarTanqueAcerosinOF(String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanqueAcerosinOF\" (?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, numero);
		prepararCons.setInt(2, capacidad);
		prepararCons.setInt(3, producto);
		prepararCons.setFloat(4, grado);
		prepararCons.setInt(5, LTSreales);
		prepararCons.setDate(6, fechafabricacion);
		prepararCons.setInt(7, cliente); 
		prepararCons.setInt(8, inventarioTA);
		prepararCons.execute();
	}
	
	
}
