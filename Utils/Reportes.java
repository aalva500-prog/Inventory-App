package Utils;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;


public class Reportes {

	
	
	private java.sql.Connection myConnection = null;
       static  Reportes report;
	
	public Reportes() {
		super();
		try {
			this.myConnection = ConnectionBD.connect.getConnection();
			Class.forName("org.postgresql.Driver");
			 myConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/InventarioLaboratorio", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static Reportes getR()
	{
		if(report == null)
		{
			report = new Reportes();
		}
		return report;
			
	}
	//Reporte Informe de Pizarra
	public void InformePizarra(int informe) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("informe", informe);
		JasperFillManager.fillReportToFile("reportes/InformedePizarra.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/InformedePizarra.jrprint", false,false);	
}
	
	//Reporte Inventario de Placas de Filtro
public void InventarioPlacasdeFiltro(int informe) throws JRException{		
		HashMap<String, Object> mypara = new HashMap <String, Object> ();
		mypara.put("inventario", informe);
		JasperFillManager.fillReportToFile("reportes/InventarioPlacasdeFiltro.jasper", mypara, myConnection);
		JasperViewer.viewReport("reportes/InventarioPlacasdeFiltro.jrprint", false,false);	
}
	
//Reporte Inventario Aditivos
public void InventarioAditivos(int informe) throws JRException{		
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("inventario", informe);
	JasperFillManager.fillReportToFile("reportes/InventarioAditivos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/InventarioAditivos.jrprint", false,false);	
}

//Reporte Inventario Tanques de Acero
public void InventarioTanquesAcero(int informe) throws JRException{		
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("inventario", informe);
	JasperFillManager.fillReportToFile("reportes/InventarioTanquesAcero.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/InventarioTanquesAcero.jrprint", false,false);	
}

//Reporte Inventario Tanques Plásticos
public void InventarioTanquesPlasticos(int informe) throws JRException{		
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("inventario", informe);
	JasperFillManager.fillReportToFile("reportes/InventarioTanquesPlasticos.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/InventarioTanquesPlasticos.jrprint", false,false);	
}
//Reportes Inventario Bidón
public void InventarioBidónMateriasPrimas(int invbidon,int tipoinv) throws JRException{		
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("invbidon", invbidon);
	mypara.put("tipoinventario", tipoinv);
	JasperFillManager.fillReportToFile("reportes/reporteBidnesMateriasPrimas.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/reporteBidnesMateriasPrimas.jrprint", false,false);	
}

public void InventarioBidónRones(int invbidon,int tipoinv) throws JRException{		
	HashMap<String, Object> mypara = new HashMap <String, Object> ();
	mypara.put("invBidon", invbidon);
	mypara.put("tipoinv", tipoinv);
	JasperFillManager.fillReportToFile("reportes/ReporteBidonesRones.jasper", mypara, myConnection);
	JasperViewer.viewReport("reportes/ReporteBidonesRones.jrprint", false,false);	
}



}