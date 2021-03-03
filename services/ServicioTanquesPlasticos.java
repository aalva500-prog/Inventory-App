package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.TanquePlastico;
import Utils.ConnectionBD;

public class ServicioTanquesPlasticos {
	
	public static LinkedList<TanquePlastico> getTanques(int id_informe){
		LinkedList<TanquePlastico> listUsuarios = new LinkedList<TanquePlastico>();
		String sentence = "SELECT DISTINCT \"public\".\"TanquesPlasticos\".\"id_tanquesplasticos\",\"public\".\"TanquesPlasticos\".\"numero\",\"public\".\"TanquesPlasticos\".\"CAntLTS\"," +
				"\"public\".\"Producto\".\"nombreP\",\"public\".\"TanquesPlasticos\".\"grado\",\"public\".\"TanquesPlasticos\".\"LTS\",\"public\".\"TanquesPlasticos\".\"fechafabricacion\"," +
				"\"public\".\"Cliente\".\"nombreC\",\"public\".\"TanquesPlasticos\".\"of\"" +
				"FROM  \"public\".\"Producto\",\"public\".\"TanquesPlasticos\",\"public\".\"Cliente\"" +
				"WHERE \"public\".\"Producto\".\"id_producto\"=\"public\".\"TanquesPlasticos\".\"producto\" and \"public\".\"TanquesPlasticos\".\"inventarioPlastico\"=?" +
				"and \"public\".\"Cliente\".\"id_cliente\"= \"public\".\"TanquesPlasticos\".\"cliente\"" +
				"ORDER BY \"public\".\"TanquesPlasticos\".\"id_tanquesplasticos\"  ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				TanquePlastico user = new TanquePlastico();
				user.setId_tanqueplastico(resultado.getInt(1));
				user.setNumero(resultado.getString(2));
				user.setCantLTS(resultado.getInt(3));
				user.setProducto(resultado.getString(4));
				user.setGrado(resultado.getFloat(5));
				user.setLTS(resultado.getInt(6));
				user.setFechafabricacion(resultado.getDate(7));
				user.setCliente(resultado.getString(8));
				user.setOf(resultado.getInt(9));
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

	
	
	
	public static void  ModificarTanquesPlastico(int id_tanque,String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int ofab) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanquePlastico\"(?,?,?,?,?,?,?,?,?)"; 
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
	
	public static void  ModificarTanquesPlasticossinOFniGradoniLTS(int id_tanque,String numero,int capacidad,int producto,Date fechafabricacion,int cliente) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanquePlasticosinOFniGradoniLTS\"(?,?,?,?,?,?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_tanque ); 
		prepararCons.setString(2, numero);
		prepararCons.setInt(3, capacidad);
		prepararCons.setInt(4, producto);
		prepararCons.setDate(5, fechafabricacion);
		prepararCons.setInt(6, cliente);
		prepararCons.execute();		
	}
	
	public static void  ModificarTanquesPlasticosinOF(int id_tanque,String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente) throws SQLException, ClassNotFoundException { 
		String sqlSentenc = "SELECT \"public\".\"ModificarTanquePlasticosinOF\"(?,?,?,?,?,?,?,?)"; 
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
	
public static void  EliminarTanquesPlastico(int id_detalle) throws SQLException, ClassNotFoundException { 		
		String sqlSentenc = "SELECT \"public\".\"EliminarTanquePlastico\"(?)"; 
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setInt(1,id_detalle); 
		prepararCons.execute();		
	}
	
public static void  EliminarTanquesPlasticoCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
	String sqlSentenc = "SELECT \"public\".\"EliminarTanquePlasticoCascada\"(?)" ; 
	PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
	prepararCons.setInt(1,id_informe); 
	prepararCons.execute();		
}


	public static void insertarTanquePlastico(String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int OF,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanquePlastico\" (?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
	
	public static void insertarTanquePlasticosinOFniGradoniLTS(String numero,int capacidad,int producto,Date fechafabricacion,int cliente,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanquesPlasticossinOFniGradonilLTS\" (?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
		PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
		prepararCons.setString(1, numero);
		prepararCons.setInt(2, capacidad);
		prepararCons.setInt(3, producto);
		prepararCons.setDate(4, fechafabricacion);
		prepararCons.setInt(5, cliente); 
		prepararCons.setInt(6, inventarioTA);
		prepararCons.execute();
	}
	
	public static void insertarTanquePlasticossinOF(String numero,int capacidad,int producto,float grado,int LTSreales,Date fechafabricacion,int cliente,int inventarioTA) throws SQLException, ClassNotFoundException{
		String sqlSentenc = "SELECT\"public\".\"InsertarTanquePlasticosinOF\" (?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
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
