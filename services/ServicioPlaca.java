package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Placas;
import Utils.ConnectionBD;

public class ServicioPlaca {
	
	public static LinkedList<Placas> getPlacas(int id_informe){
		LinkedList<Placas> listUsuarios = new LinkedList<Placas>();
		String sentence = "SELECT DISTINCT \"public\".\"Placas\".\"id_placas\",\"public\".\"Placas\".\"placa\",\"public\".\"Placas\".\"cantidadplacas\"," +
				"\"public\".\"Placas\".\"cantporcajas\",\"public\".\"Placas\".\"utilizacion\"" +
				"FROM  \"public\".\"Placas\"" +
				"WHERE \"public\".\"Placas\".\"inventarioplacas\"=?"+
				"ORDER BY \"public\".\"Placas\".\"placa\" ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Placas user = new Placas();
				user.setId_placas(resultado.getInt(1));
				user.setPlaca(resultado.getString(2));
				user.setCantplacas(resultado.getInt(3));
				user.setCantporcajas(resultado.getInt(4));
				user.setUtilizacion(resultado.getString(5));
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

		
		
		
		
		public static void  ModificarPlaca(int id_placas,String placa,int cantidadplacas,int cantporcajas,String utilizacion) throws SQLException, ClassNotFoundException { 
				String sqlSentenc = "SELECT \"public\".\"ModificarPlaca\"(?,?,?,?,?)"; 
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1,id_placas ); 
				prepararCons.setString(2, placa);
				prepararCons.setInt(3, cantidadplacas);
				prepararCons.setInt(4, cantporcajas);
				prepararCons.setString(5, utilizacion);
				prepararCons.execute();		
			}
			
			
			
		public static void  EliminarPlaca(int id_detalle) throws SQLException, ClassNotFoundException { 		
				String sqlSentenc = "SELECT \"public\".\"EliminarPlaca\"(?)" ; 
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1,id_detalle); 
				prepararCons.execute();		
			}
			
		public static void  EliminarPlacasCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
			String sqlSentenc = "SELECT \"public\".\"EliminarPlacasCascada\"(?)" ; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_informe); 
			prepararCons.execute();		
		}


			public static void insertarPlaca(String placa,int cantidadplacas,int cantporcajas,String utilizacion,int inventarioplacas) throws SQLException, ClassNotFoundException{
				String sqlSentenc = "SELECT\"public\".\"InsertarPlaca\" (?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setString(1, placa);
				prepararCons.setInt(2, cantidadplacas);
				prepararCons.setInt(3, cantporcajas);
				prepararCons.setString(4, utilizacion);
				prepararCons.setInt(5, inventarioplacas);
				prepararCons.execute();
			}
			
	

}
