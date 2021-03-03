package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Bidon;
import Utils.ConnectionBD;

public class ServicioBidon {
	
	public static LinkedList<Bidon> getBidonesProducto(int id_informe){
		LinkedList<Bidon> listUsuarios = new LinkedList<Bidon>();
		String sentence = "SELECT DISTINCT \"public\".\"Bidones\".\"id_bidones\",\"public\".\"Producto\".\"nombreP\",\"public\".\"Bidones\".\"grados\"," +
				"\"public\".\"Bidones\".\"fechafabricacion\",\"public\".\"Bidones\".\"OFbidones\",\"public\".\"Bidones\".\"bidon\",\"public\".\"Bidones\".\"litros\"," +
				"\"public\".\"Bidones\".\"estado\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\""+
		     	"FROM  \"public\".\"Bidones\",\"public\".\"Producto\",\"public\".\"TipoInventarioBIdon\"" +
				"WHERE \"public\".\"Bidones\".\"inventariobidones\"=? and \"public\".\"Bidones\".\"tipoinventario\"=1 and" +
				"\"public\".\"Bidones\".\"tipoinventario\"=\"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\" and \"public\".\"Bidones\".\"producto\"=\"public\".\"Producto\".\"id_producto\" " +
				"ORDER BY \"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"Producto\".\"nombreP\" ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Bidon user = new Bidon();
				user.setId_bidon(resultado.getInt(1));
				user.setProducto(resultado.getString(2));
				user.setGrados(resultado.getFloat(3));
				user.setFechafabricacion(resultado.getDate(4));
				user.setOFabricacion(resultado.getInt(5));
				user.setBidon(resultado.getInt(6));
				user.setLitros(resultado.getInt(7));
				user.setEstado(resultado.getString(8));
				user.setTipoinventario(resultado.getString(9));
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

	
	public static LinkedList<Bidon> getBidonesALL(int id_informe){
		LinkedList<Bidon> listUsuarios = new LinkedList<Bidon>();
		String sentence = "SELECT DISTINCT \"public\".\"Bidones\".\"id_bidones\",\"public\".\"Bidones\".\"grados\"," +
				"\"public\".\"Bidones\".\"fechafabricacion\",\"public\".\"Bidones\".\"OFbidones\",\"public\".\"Bidones\".\"bidon\",\"public\".\"Bidones\".\"litros\"," +
				"\"public\".\"Bidones\".\"estado\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\""+
		     	"FROM  \"public\".\"Bidones\",\"public\".\"Producto\",\"public\".\"TipoInventarioBIdon\"" +
				"WHERE \"public\".\"Bidones\".\"inventariobidones\"=? and  " +
				"\"public\".\"Bidones\".\"tipoinventario\"=\"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\"" +
				"GROUP BY \"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"Bidones\".\"id_bidones\",\"public\".\"Bidones\".\"grados\"," +
				"\"public\".\"Bidones\".\"fechafabricacion\",\"public\".\"Bidones\".\"OFbidones\",\"public\".\"Bidones\".\"bidon\",\"public\".\"Bidones\".\"litros\"," +
				"\"public\".\"Bidones\".\"estado\"" +
				"ORDER BY \"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\"";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Bidon user = new Bidon();
				user.setId_bidon(resultado.getInt(1));
				user.setGrados(resultado.getFloat(2));
				user.setFechafabricacion(resultado.getDate(3));
				user.setOFabricacion(resultado.getInt(4));
				user.setBidon(resultado.getInt(5));
				user.setLitros(resultado.getInt(6));
				user.setEstado(resultado.getString(7));
				user.setTipoinventario(resultado.getString(8));
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
	
		
	public static LinkedList<Bidon> getBidonesMateriasPrimas(int id_informe){
		LinkedList<Bidon> listUsuarios = new LinkedList<Bidon>();
		String sentence = "SELECT DISTINCT \"public\".\"Bidones\".\"id_bidones\",\"public\".\"Bidones\".\"grados\"," +
				"\"public\".\"Bidones\".\"fechafabricacion\",\"public\".\"Bidones\".\"OFbidones\",\"public\".\"Bidones\".\"bidon\",\"public\".\"Bidones\".\"litros\"," +
				"\"public\".\"Bidones\".\"estado\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"MateriaPrima\".\"materia\"," +
				"\"public\".\"Bidones\".\"tiporon\"" +
				"FROM  \"public\".\"Bidones\",\"public\".\"MateriaPrima\",\"public\".\"TipoInventarioBIdon\"" +
				"WHERE \"public\".\"Bidones\".\"inventariobidones\"=? and \"public\".\"Bidones\".\"tipoinventario\"=2 and" +
				"\"public\".\"Bidones\".\"tipoinventario\"=\"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\" and \"public\".\"Bidones\".\"materiaprima\"=\"public\".\"MateriaPrima\".\"id_materia\" " +
				"ORDER BY \"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"MateriaPrima\".\"materia\" ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Bidon user = new Bidon();
				user.setId_bidon(resultado.getInt(1));
				user.setGrados(resultado.getFloat(2));
				user.setFechafabricacion(resultado.getDate(3));
				user.setOFabricacion(resultado.getInt(4));
				user.setBidon(resultado.getInt(5));
				user.setLitros(resultado.getInt(6));
				user.setEstado(resultado.getString(7));
				user.setTipoinventario(resultado.getString(8));
				user.setMateriaprima(resultado.getString(9));
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
		
	public static LinkedList<Bidon> getBidonesproduccionesSFM(int id_informe){
		LinkedList<Bidon> listUsuarios = new LinkedList<Bidon>();
		String sentence = "SELECT DISTINCT \"public\".\"Bidones\".\"id_bidones\",\"public\".\"Bidones\".\"grados\"," +
				"\"public\".\"Bidones\".\"fechafabricacion\",\"public\".\"Bidones\".\"OFbidones\",\"public\".\"Bidones\".\"bidon\",\"public\".\"Bidones\".\"litros\"," +
				"\"public\".\"Bidones\".\"estado\",\"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"MateriaPrima\".\"materia\"," +
				"\"public\".\"Bidones\".\"tiporon\"" +
				"FROM  \"public\".\"Bidones\",\"public\".\"MateriaPrima\",\"public\".\"TipoInventarioBIdon\"" +
				"WHERE \"public\".\"Bidones\".\"inventariobidones\"=? and \"public\".\"Bidones\".\"tipoinventario\"=3 and" +
				"\"public\".\"Bidones\".\"tipoinventario\"=\"public\".\"TipoInventarioBIdon\".\"id_tipoInventario\" and \"public\".\"Bidones\".\"materiaprima\"=\"public\".\"MateriaPrima\".\"id_materia\" " +
				"ORDER BY \"public\".\"TipoInventarioBIdon\".\"tipoInventarioBidon\",\"public\".\"MateriaPrima\".\"materia\" ASC";
		try {
			PreparedStatement stat = ConnectionBD.connect.getConnection().prepareStatement(sentence);
			stat.setInt(1, id_informe);
			stat.execute();
			ResultSet resultado = stat.getResultSet();
			while (resultado.next()) {				
				Bidon user = new Bidon();
				user.setId_bidon(resultado.getInt(1));
				user.setGrados(resultado.getFloat(2));
				user.setFechafabricacion(resultado.getDate(3));
				user.setOFabricacion(resultado.getInt(4));
				user.setBidon(resultado.getInt(5));
				user.setLitros(resultado.getInt(6));
				user.setEstado(resultado.getString(7));
				user.setTipoinventario(resultado.getString(8));
				user.setMateriaprima(resultado.getString(9));
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
		
		public static void  ModificarBidonProducto(int id_bidones,float grados,Date fechafabricacion,int OFbidones,int bidon,int litros,String estado,int producto) throws SQLException, ClassNotFoundException { 
			String sqlSentenc = "SELECT \"public\".\"ModificarRon\"(?,?,?,?,?,?,?,?)"; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_bidones ); 
			prepararCons.setFloat(2, grados);
			prepararCons.setDate(3, fechafabricacion);
			prepararCons.setInt(4, OFbidones);
			prepararCons.setInt(5, bidon);
			prepararCons.setInt(6, litros);
			prepararCons.setString(7, estado);
			prepararCons.setInt(8, producto);
			prepararCons.execute();		
		}
		
		
		public static void  ModificarBidonMateriaPrima(int id_bidones,float grados,Date fechafabricacion,int OFbidones,int bidon,int litros,String estado,int tipoinventario,int materiaP) throws SQLException, ClassNotFoundException { 
			String sqlSentenc = "SELECT \"public\".\"ModificarProduccionesSFMyMateriasPrimas\"(?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_bidones ); 
			prepararCons.setFloat(2, grados);
			prepararCons.setDate(3, fechafabricacion);
			prepararCons.setInt(4, OFbidones);
			prepararCons.setInt(5, bidon);
			prepararCons.setInt(6, litros);
			prepararCons.setString(7, estado);
			prepararCons.setInt(8, tipoinventario);
			prepararCons.setInt(9, materiaP);
			prepararCons.execute();		
		}
			
			
		public static void  EliminarBidon(int id_detalle) throws SQLException, ClassNotFoundException { 		
				String sqlSentenc = "SELECT \"public\".\"EliminarBidones\"(?)" ; 
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1,id_detalle); 
				prepararCons.execute();		
			}
			
		public static void  EliminarBidonesCascada(int id_informe) throws SQLException, ClassNotFoundException { 		
			String sqlSentenc = "SELECT \"public\".\"EliminarBidonesCascada\"(?)" ; 
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1,id_informe); 
			prepararCons.execute();		
		}


		public static void insertarBidonesMateriaPrima(int inventariobidones,int materiaprima,int OFbidones,float grados,Date fechafabricacion,int bidon,int litros,String estado,int tipo) throws SQLException, ClassNotFoundException{
				String sqlSentenc = "SELECT\"public\".\"InsertarBidonMateriaPrima\" (?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
				PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
				prepararCons.setInt(1, inventariobidones);
				prepararCons.setInt(2, materiaprima);
				prepararCons.setInt(3, OFbidones);
				prepararCons.setFloat(4, grados);
				prepararCons.setDate(5, fechafabricacion);
				prepararCons.setInt(6, bidon);				
				prepararCons.setInt(7, litros);
				prepararCons.setString(8, estado);
				prepararCons.setInt(9, tipo);
				prepararCons.execute();
			}
		
		public static void insertarBidonesProducto(int inventariobidones,int producto,int OFbidones,float grados,Date fechafabricacion,int bidon,int litros,String estado,int tipo) throws SQLException, ClassNotFoundException{
			String sqlSentenc = "SELECT\"public\".\"InsertarBidonProducto\" (?,?,?,?,?,?,?,?,?)"; /*Los símbolos ? indican los parámetros que se van a pasar */
			PreparedStatement prepararCons = ConnectionBD.connect.getConnection().prepareStatement(sqlSentenc);
			prepararCons.setInt(1, inventariobidones);
			prepararCons.setInt(2, producto);
			prepararCons.setInt(3, OFbidones);
			prepararCons.setFloat(4, grados);
			prepararCons.setDate(5, fechafabricacion);
			prepararCons.setInt(6, bidon);				
			prepararCons.setInt(7, litros);
			prepararCons.setString(8, estado);
			prepararCons.setInt(9, tipo);
			prepararCons.execute();
		}
		

}
