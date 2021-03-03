package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;

import model.Aditivo;
import Utils.ConnectionBD;

public class ServicioAditivo {
	
	public static LinkedList<Aditivo> getAditivos(int id_informe){
		LinkedList<Aditivo> listUsuarios = new LinkedList<Aditivo>();
		String sentence = "SELECT DISTINCT \"public\".\"Aditivos\".\"id_aditivos\",\"public\".\"Aditivos\".\"codigo\",\"public\".\"MateriaPrima\".\"materia\"," +
				"\"public\".\"Proveedores\".\"proveedor\",\"public\".\"Aditivos\".\"vencimiento\",\"public\".\"UnidadMedida\".\"descripcion\",\"public\".\"Aditivos\".\"existencia\"" +
				"FROM  \"public\".\"Aditivos\",\"public\".\"UnidadMedida\",\"public\".\"MateriaPrima\",\"public\".\"Proveedores\"" +
				"WHERE \"public\".\"Aditivos\".\"inventarioaditivo\"=? and \"public\".\"Aditivos\".\"materiaprima\"=\"public\".\"MateriaPrima\".\"id_materia\" and " +
				"\"public\".\"Aditivos\".\"proveedor\"=\"public\".\"Proveedores\".\"id_proveedor\" and \"public\".\"Aditivos\".\"um\"=\"public\".\"UnidadMedida\".\"id_unidad\" "+
				"ORDER BY \"public\".\"Proveedores\".\"proveedor\", \"public\".\"MateriaPrima\".\"materia\" ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Aditivo user = new Aditivo();
				user.setId_aditivo(resultado.getInt(1));
				user.setCodigo(resultado.getString(2));
				user.setMateria(resultado.getString(3));
				user.setProveedor(resultado.getString(4));
				user.setVencimiento(resultado.getDate(5));
				user.setUM(resultado.getString(6));
				user.setExistencia(resultado.getFloat(7));
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

		
		
		
		
		public static void  ModificarAditivo(int id_aditivos,String codigo,int materiaprima,int proveedor,Date vencimiento,int um,float existencia) throws SQLException, ClassNotFoundException { 
				String sqlSentenc = "SELECT \"public\".\"ModificarAditivo\"(?,?,?,?,?,?,?)"; 
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1,id_aditivos ); 
				prepararCons.setString(2, codigo);
				prepararCons.setInt(3, materiaprima);
				prepararCons.setInt(4, proveedor);
				prepararCons.setDate(5, vencimiento);
				prepararCons.setInt(6, um);
				prepararCons.setFloat(7, existencia);
				prepararCons.execute();		
			}
			
			
			
		public static void  EliminarAditivo(int id_detalle) throws SQLException, ClassNotFoundException { 		
				String sqlSentenc = "SELECT \"public\".\"EliminarAditivos\"(?)" ; 
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1,id_detalle); 
				prepararCons.execute();		
			}
			
		public static void  EliminarAditivosCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
			String sqlSentenc = "SELECT \"public\".\"EliminarAditivosCascada\"(?)" ; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_informe); 
			prepararCons.execute();		
		}


			public static void insertarAditivo(String codigo,int materiaprima,int proveedor,Date vencimiento,int um,float existencia,int inventarioaditivo) throws SQLException, ClassNotFoundException{
				String sqlSentenc = "SELECT\"public\".\"InsertarAditivos\" (?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setString(1, codigo);
				prepararCons.setInt(2, materiaprima);
				prepararCons.setInt(3, proveedor);
				prepararCons.setDate(4, vencimiento);
				prepararCons.setInt(5, um);
				prepararCons.setFloat(6, existencia);
				prepararCons.setInt(7, inventarioaditivo);
				prepararCons.execute();
			}
	

}
