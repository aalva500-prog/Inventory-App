package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;

import model.Aditivo;
import model.Bidon;
import model.InventarioAditivos;
import model.InventarioBidon;
import model.MateriaPrima;
import model.Producto;
import model.Proveedor;
import model.TipoInventarioBidon;
import model.UnidadMedida;
import services.ServicioAditivo;
import services.ServicioBidon;
import services.ServicioMateriaPrima;
import services.ServicioProducto;
import services.ServicioProveedor;
import services.ServicioTIpoInventarioBidon;
import services.ServicioUnidadMedida;
import Utils.FormatoTabla;
import Utils.Reportes;
import Utils.TableModel;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class BidonesVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private InventarioBidon adit=null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private SpinnerDateModel DatespinnerDateModel=null;
	private JSpinner DatejSpinner=null;
	private JLabel jLabel1 = null;
	private JComboBox MateriaPrimajComboBox = null;
	private JLabel jLabel2 = null;
	private JTextField OFjTextField = null;
	private JLabel jLabel3 = null;
	private JTextField GradosjTextField = null;
	private JPanel ReposojPanel1 = null;
	private JRadioButton SIjRadioButton = null;
	private JRadioButton NojRadioButton = null;
	private JLabel jLabel7 = null;
	private JComboBox ProductojComboBox = null;
	private JButton InsertarjButton = null;
	private JButton regresarjButton = null;
	private JButton MenujButton = null;
	private JButton ImprimirjButton = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable = null;
	private SpinnerDateModel DatespinnerDateModelInicio=null;
	private JSpinner DatejSpinnerInicio=null;
	private JLabel jLabel4 = null;
	private JComboBox GrupojComboBox = null;
	private JLabel jLabel5 = null;
	private JTextField bIDONjTextField = null;
	private JLabel jLabel6 = null;
	private JTextField LTSjTextField = null;
	private JLabel jLabel8 = null;
	private JTextField EstadojTextField = null;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	public BidonesVisual(InventarioBidon adit)  {
		super();
		this.adit=adit;
		initialize();		
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		this.setSize(new Dimension(1040, 805));
	    this.setTitle("Inventario de Bidones de 220 LTS");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		SIjRadioButton.setSelected(false);
		DatejSpinnerInicio.setVisible(false);
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	    simbolo.setDecimalSeparator(',');
	    simbolo.setGroupingSeparator('.');
		DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
		TableModel defaultTableModel = new TableModel();
		LinkedList<Bidon> listD = new LinkedList<Bidon>();
		LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
		LinkedList<Bidon> listSFM = new LinkedList<Bidon>();
		listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
		listD = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
		listSFM= ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
		ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
		ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
		ArrayList<Object> columnDataGrados = new ArrayList<Object>();
		ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
		ArrayList<Object> columnDataOF = new ArrayList<Object>();
		ArrayList<Object> columnDataBidon = new ArrayList<Object>();
		ArrayList<Object> columnDataLitros = new ArrayList<Object>();
		ArrayList<Object> columnDataEstado = new ArrayList<Object>();
		for (int i = 0; i < listD.size(); i++) {
			columdDataGrupo.add(listD.get(i).getTipoinventario());
			columdDataContenido.add(listD.get(i).getProducto());
			columnDataGrados.add(dosDigitos.format(listD.get(i).getGrados()));
			columnDataFechaFabricacion.add(listD.get(i).getFechafabricacion());
			columnDataOF.add(listD.get(i).getOFabricacion());
			columnDataBidon.add(listD.get(i).getBidon());
			columnDataLitros.add(listD.get(i).getLitros());
			columnDataEstado.add(listD.get(i).getEstado());
			}
		for (int i = 0; i < listMaterias.size(); i++) {
			columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
			columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
			columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
			columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
			columnDataOF.add(listMaterias.get(i).getOFabricacion());
			columnDataBidon.add(listMaterias.get(i).getBidon());
			columnDataLitros.add(listMaterias.get(i).getLitros());
			columnDataEstado.add(listMaterias.get(i).getEstado());
			}
		for (int i = 0; i < listSFM.size(); i++) {
			columdDataGrupo.add(listSFM.get(i).getTipoinventario());
			columdDataContenido.add(listSFM.get(i).getMateriaprima());
			columnDataGrados.add(dosDigitos.format(listSFM.get(i).getGrados()));
			columnDataFechaFabricacion.add(listSFM.get(i).getFechafabricacion());
			columnDataOF.add(listSFM.get(i).getOFabricacion());
			columnDataBidon.add(listSFM.get(i).getBidon());
			columnDataLitros.add(listSFM.get(i).getLitros());
			columnDataEstado.add(listSFM.get(i).getEstado());
			}
		defaultTableModel.setRowCount(listD.size());	
		defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
		defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
		defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
		defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
		defaultTableModel.addColumn("OF",columnDataOF.toArray());
		defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
		defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
		defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
		getJTable().setModel(defaultTableModel);
		getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
		getJTable().setRowHeight(20);
		
		jTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
			    simbolo.setGroupingSeparator('.');
				DecimalFormat dosDigitos = new DecimalFormat( "###.#####",simbolo);
				int pos = jTable.getSelectedRow();		
				if(GrupojComboBox.getSelectedIndex()==2){
				LinkedList<Bidon> users1 = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());		
				Bidon u1 = users1.get(pos);	
				if(u1.getFechafabricacion()!=null){
				    OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
					GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
					bIDONjTextField.setText(String.valueOf(u1.getBidon()));
					LTSjTextField.setText(String.valueOf(u1.getLitros()));
					EstadojTextField.setText(u1.getEstado());	
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);	
					DatejSpinnerInicio.setValue(u1.getFechafabricacion());
					SIjRadioButton.setSelected(true);
					NojRadioButton.setSelected(false);
					InsertarjButton.setEnabled(false);
					}else{
						   OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
							GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
							bIDONjTextField.setText(String.valueOf(u1.getBidon()));
							LTSjTextField.setText(String.valueOf(u1.getLitros()));
							EstadojTextField.setText(u1.getEstado());	
							btnNewButton.setEnabled(true);
							btnNewButton_1.setEnabled(true);	
							SIjRadioButton.setSelected(false);
							NojRadioButton.setSelected(true);
							InsertarjButton.setEnabled(false);
					}
				}
				if(GrupojComboBox.getSelectedIndex()==1){					
					LinkedList<Bidon> users1 = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());		
					Bidon u1 = users1.get(pos);	
					if(u1.getFechafabricacion()==null){
					    OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
						GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
						bIDONjTextField.setText(String.valueOf(u1.getBidon()));
						LTSjTextField.setText(String.valueOf(u1.getLitros()));
						EstadojTextField.setText(u1.getEstado());	
						btnNewButton.setEnabled(true);
						btnNewButton_1.setEnabled(true);	
						SIjRadioButton.setSelected(false);
						NojRadioButton.setSelected(true);
						InsertarjButton.setEnabled(false);
					}else{						
						    OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
							GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
							bIDONjTextField.setText(String.valueOf(u1.getBidon()));
							LTSjTextField.setText(String.valueOf(u1.getLitros()));
							EstadojTextField.setText(u1.getEstado());	
							btnNewButton.setEnabled(true);
							btnNewButton_1.setEnabled(true);	
							DatejSpinnerInicio.setValue(u1.getFechafabricacion());
							SIjRadioButton.setSelected(true);
							NojRadioButton.setSelected(false);
							InsertarjButton.setEnabled(false);
					}
				}
				if(GrupojComboBox.getSelectedIndex()==3){
					LinkedList<Bidon> users1 = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());		
					Bidon u1 = users1.get(pos);	
					if(u1.getFechafabricacion()!=null){
					    OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
						GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
						bIDONjTextField.setText(String.valueOf(u1.getBidon()));
						LTSjTextField.setText(String.valueOf(u1.getLitros()));
						EstadojTextField.setText(u1.getEstado());	
						btnNewButton.setEnabled(true);
						btnNewButton_1.setEnabled(true);	
						DatejSpinnerInicio.setValue(u1.getFechafabricacion());
						SIjRadioButton.setSelected(true);
						NojRadioButton.setSelected(false);
						InsertarjButton.setEnabled(false);
					}else{
						  OFjTextField.setText(String.valueOf(u1.getOFabricacion()));
							GradosjTextField.setText(String.valueOf(dosDigitos.format(u1.getGrados())));
							bIDONjTextField.setText(String.valueOf(u1.getBidon()));
							LTSjTextField.setText(String.valueOf(u1.getLitros()));
							EstadojTextField.setText(u1.getEstado());	
							btnNewButton.setEnabled(true);
							btnNewButton_1.setEnabled(true);	
							SIjRadioButton.setSelected(false);
							NojRadioButton.setSelected(true);
							InsertarjButton.setEnabled(false);
						}
					}
				}
		});	
	
	 //Combobox Materia Prima
		LinkedList<MateriaPrima> list1 = new LinkedList<MateriaPrima>();
		try {
			list1= ServicioMateriaPrima.getMaterias();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
		boxModel1.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list1.size(); i++) {
			boxModel1.addElement(list1.get(i));
		}
		
		getMateriaPrimajComboBox().setModel(boxModel1);
		
		 //Combobox Productos
		LinkedList<Producto> list = new LinkedList<Producto>();
		try {
			list= ServicioProducto.getProductos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list.size(); i++) {
			boxModel.addElement(list.get(i));
		}
		
		getProductojComboBox().setModel(boxModel);
		
		//ComboBox TipoInventario
		LinkedList<TipoInventarioBidon> listUM = new LinkedList<TipoInventarioBidon>();
		try {
			listUM= ServicioTIpoInventarioBidon.getTipos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModelUM = new DefaultComboBoxModel();
		boxModelUM.addElement(new String("<Seleccione>"));
		for (int i = 0; i < listUM.size(); i++) {
			boxModelUM.addElement(listUM.get(i));
		}
		
		getGrupojComboBox().setModel(boxModelUM);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));		
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 564;
			gridBagConstraints1.ipady = 65;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(5, 5, 8, 7);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(6, 5, 5, 7);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 1016;
			gridBagConstraints.ipady = 249;
			gridBagConstraints.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJPanel(), gridBagConstraints);
			jContentPane.add(getJScrollPane1(), gridBagConstraints1);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(837, 115, 168, 29));
			jLabel8.setText("ESTADO:");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(929, 46, 76, 30));
			jLabel6.setText("LTS:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(837, 46, 76, 30));
			jLabel5.setText("BIDÓN:");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(3, 45, 172, 31));
			jLabel4.setText("GRUPO:");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(182, 115, 267, 29));
			jLabel7.setText("PRODUCTO:");
			jLabel7.setVisible(false);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(544, 46, 76, 29));
			jLabel3.setText("GRADOS:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(456, 46, 76, 29));
			jLabel2.setText("OF:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(183, 46, 267, 29));
			jLabel1.setText("MATERIA PRIMA:");
			jLabel1.setVisible(false);
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(456, 8, 47, 29));
			jLabel.setText("FECHA:");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(jLabel, null);
			jPanel.add(getDatejSpinner(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getMateriaPrimajComboBox(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getOFjTextField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getGradosjTextField(), null);
			jPanel.add(getReposojPanel1(), null);
			jPanel.add(jLabel7, null);
			jPanel.add(getProductojComboBox(), null);
			jPanel.add(getInsertarjButton(), null);
			jPanel.add(getRegresarjButton(), null);
			jPanel.add(getMenujButton(), null);
			jPanel.add(getImprimirjButton(), null);
			jPanel.add(jLabel4, null);
			jPanel.add(getGrupojComboBox(), null);
			jPanel.add(jLabel5, null);
			jPanel.add(getBIDONjTextField(), null);
			jPanel.add(jLabel6, null);
			jPanel.add(getLTSjTextField(), null);
			jPanel.add(jLabel8, null);
			jPanel.add(getEstadojTextField(), null);
			jPanel.add(getBtnNewButton());
			jPanel.add(getBtnNewButton_1());
		}
		return jPanel;
	}
	
	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel() {
		if (DatespinnerDateModel  == null) {
			DatespinnerDateModel = new SpinnerDateModel();
		}
		return DatespinnerDateModel;
	}

	private JSpinner getDatejSpinner() {
		if (DatejSpinner == null) {
			DatejSpinner = new JSpinner(getDatespinnerDateModel() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner.setEditor(new JSpinner.DateEditor(DatejSpinner,dateFormat.toPattern()));
			DatejSpinner.setBounds(new Rectangle(502, 8, 90, 29));
			DatejSpinner.setValue(adit.getFechainventario());
			DatejSpinner.setEnabled(false);
			}
		return DatejSpinner;
	}

	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModelInicio() {
		if (DatespinnerDateModelInicio  == null) {
			DatespinnerDateModelInicio = new SpinnerDateModel();
		}
		return DatespinnerDateModelInicio;
	}

	private JSpinner getDatejSpinnerInicio() {
		if (DatejSpinnerInicio == null) {
			DatejSpinnerInicio = new JSpinner(getDatespinnerDateModelInicio() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinnerInicio.setEditor(new JSpinner.DateEditor(DatejSpinnerInicio,dateFormat.toPattern()));
			DatejSpinnerInicio.setBounds(new Rectangle(10, 50, 90, 29));
			}
		return DatejSpinnerInicio;
	}
	
	
	
	/**
	 * This method initializes MateriaPrimajComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getMateriaPrimajComboBox() {
		if (MateriaPrimajComboBox == null) {
			MateriaPrimajComboBox = new JComboBox();
			MateriaPrimajComboBox.setBounds(new Rectangle(183, 75, 267, 29));
			MateriaPrimajComboBox.setVisible(false);
		}
		return MateriaPrimajComboBox;
	}

	/**
	 * This method initializes OFjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOFjTextField() {
		if (OFjTextField == null) {
			OFjTextField = new JTextField();
			OFjTextField.setBounds(new Rectangle(456, 75, 76, 29));
			Validate.validateDigit(OFjTextField);
			}
		return OFjTextField;
	}

	/**
	 * This method initializes GradosjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGradosjTextField() {
		if (GradosjTextField == null) {
			GradosjTextField = new JTextField();
			GradosjTextField.setBounds(new Rectangle(544, 75, 76, 29));
			Validate.validateDigitAndComma(GradosjTextField);
		}
		return GradosjTextField;
	}

	/**
	 * This method initializes ReposojPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getReposojPanel1() {
		if (ReposojPanel1 == null) {
			ReposojPanel1 = new JPanel();
			ReposojPanel1.setBorder(BorderFactory.createTitledBorder(null, "FECHA DE FABRICACIÓN", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			ReposojPanel1.setLayout(null);
			ReposojPanel1.setBounds(new Rectangle(640, 46, 183, 91));
			ReposojPanel1.add(getSIjRadioButton(), null);
			ReposojPanel1.add(getNojRadioButton(), null);
			ReposojPanel1.add(getDatejSpinnerInicio(), null);
		}
		return ReposojPanel1;
	}

	/**
	 * This method initializes SIjRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSIjRadioButton() {
		if (SIjRadioButton == null) {
			SIjRadioButton = new JRadioButton();
			SIjRadioButton.setBounds(new Rectangle(10, 17, 61, 21));
			SIjRadioButton.setText("Si");
			SIjRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(SIjRadioButton.isSelected()){
						NojRadioButton.setSelected(false);
						DatejSpinnerInicio.setVisible(true);
						}
				    System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return SIjRadioButton;
	}

	/**
	 * This method initializes NojRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getNojRadioButton() {
		if (NojRadioButton == null) {
			NojRadioButton = new JRadioButton();
			NojRadioButton.setBounds(new Rectangle(88, 18, 61, 21));
			NojRadioButton.setText("No");
			NojRadioButton.setSelected(true);
			NojRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(NojRadioButton.isSelected()){
					SIjRadioButton.setSelected(false);
					DatejSpinnerInicio.setVisible(false);
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					}
					}
			});
		}
		return NojRadioButton;
	}

	/**
	 * This method initializes ProductojComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getProductojComboBox() {
		if (ProductojComboBox == null) {
			ProductojComboBox = new JComboBox();
			ProductojComboBox.setBounds(new Rectangle(182, 144, 267, 29));
			ProductojComboBox.setVisible(false);
		}
		return ProductojComboBox;
	}

	/**
	 * This method initializes InsertarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInsertarjButton() {
		if (InsertarjButton == null) {
			InsertarjButton = new JButton();
			InsertarjButton.setBounds(new Rectangle(6, 203, 99, 36));
			InsertarjButton.setText("Insertar");
			InsertarjButton.setEnabled(false);
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
						java.sql.Date sqlDateInicio = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						if(GrupojComboBox.getSelectedIndex()==1){
						if(SIjRadioButton.isSelected()){
							try {
								try {
									ServicioBidon.insertarBidonesProducto(adit.getId_inventarioBIdon(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
						    simbolo1.setDecimalSeparator(',');
						    simbolo1.setGroupingSeparator('.');
							DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getProducto());			
								columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel);
							}
						
						if(NojRadioButton.isSelected()){
							try {
								try {
									ServicioBidon.insertarBidonesProducto(adit.getId_inventarioBIdon(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
						    simbolo1.setDecimalSeparator(',');
						    simbolo1.setGroupingSeparator('.');
							DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getProducto());			
								columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel);
							}
						}
						if(GrupojComboBox.getSelectedIndex()==2){
							if(SIjRadioButton.isSelected()){
								try {
									try {
										ServicioBidon.insertarBidonesMateriaPrima(adit.getId_inventarioBIdon(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
							    simbolo1.setDecimalSeparator(',');
							    simbolo1.setGroupingSeparator('.');
								DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel);
								}
							
							if(NojRadioButton.isSelected()){
								try {
									try {
										ServicioBidon.insertarBidonesMateriaPrima(adit.getId_inventarioBIdon(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
							    simbolo1.setDecimalSeparator(',');
							    simbolo1.setGroupingSeparator('.');
								DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel);
						}
						}
						
						if(GrupojComboBox.getSelectedIndex()==3){
							if(SIjRadioButton.isSelected()){
								try {
									try {
										ServicioBidon.insertarBidonesMateriaPrima(adit.getId_inventarioBIdon(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
							    simbolo1.setDecimalSeparator(',');
							    simbolo1.setGroupingSeparator('.');
								DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel);
								}
							
							if(NojRadioButton.isSelected()){
								try {
									try {
										ServicioBidon.insertarBidonesMateriaPrima(adit.getId_inventarioBIdon(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia(), Integer.valueOf(OFjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(),((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} catch (NumberFormatException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								DecimalFormatSymbols simbolo1=new DecimalFormatSymbols();
							    simbolo1.setDecimalSeparator(',');
							    simbolo1.setGroupingSeparator('.');
								DecimalFormat dosDigitos1 = new DecimalFormat( "###,###.#####",simbolo1);
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos1.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel);
						}
						}
					}else{
						JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return InsertarjButton;
	}

	/**
	 * This method initializes regresarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegresarjButton() {
		if (regresarjButton == null) {
			regresarjButton = new JButton();
			regresarjButton.setBounds(new Rectangle(476, 203, 223, 36));
			regresarjButton.setText("Listado Inventarios Bidones");
			regresarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			regresarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioBidonesVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return regresarjButton;
	}

	/**
	 * This method initializes MenujButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMenujButton() {
		if (MenujButton == null) {
			MenujButton = new JButton();
			MenujButton.setBounds(new Rectangle(711, 203, 146, 36));
			MenujButton.setText("Menú Principal");
			MenujButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			MenujButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Principio p= new Principio();
					dispose();
					new Principal(p).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MenujButton;
	}

	/**
	 * This method initializes ImprimirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getImprimirjButton() {
		if (ImprimirjButton == null) {
			ImprimirjButton = new JButton();
			ImprimirjButton.setBounds(new Rectangle(359, 203, 105, 36));
			ImprimirjButton.setText("Imprimir");
			ImprimirjButton.setEnabled(false);
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(GrupojComboBox.getSelectedIndex()==2){
						try {
							Reportes.getR().InventarioBidónMateriasPrimas(adit.getId_inventarioBIdon(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(GrupojComboBox.getSelectedIndex()==3){
						try {
							Reportes.getR().InventarioBidónMateriasPrimas(adit.getId_inventarioBIdon(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(GrupojComboBox.getSelectedIndex()==1){
						try {
							Reportes.getR().InventarioBidónRones(adit.getId_inventarioBIdon(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ImprimirjButton;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTable());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}

	/**
	 * This method initializes GrupojComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getGrupojComboBox() {
		if (GrupojComboBox == null) {
			GrupojComboBox = new JComboBox();
			GrupojComboBox.setBounds(new Rectangle(3, 74, 172, 29));
			GrupojComboBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(GrupojComboBox.getSelectedIndex()==0){
						InsertarjButton.setEnabled(true);
						jLabel1.setVisible(false);
						MateriaPrimajComboBox.setVisible(false);
						jLabel7.setVisible(true);
						ProductojComboBox.setVisible(true);
						ImprimirjButton.setEnabled(false);
						TableModel defaultTableModel = new TableModel();
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);						
					}
					
					if(GrupojComboBox.getSelectedIndex()==1){
						InsertarjButton.setEnabled(true);
						jLabel1.setVisible(false);
						MateriaPrimajComboBox.setVisible(false);
						jLabel7.setVisible(true);
						ProductojComboBox.setVisible(true);
						ImprimirjButton.setEnabled(true);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getProducto());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						
					}
					if(GrupojComboBox.getSelectedIndex()==2){
						InsertarjButton.setEnabled(true);
						jLabel1.setVisible(true);
						MateriaPrimajComboBox.setVisible(true);
						jLabel7.setVisible(false);
						ProductojComboBox.setVisible(false);
						ImprimirjButton.setEnabled(true);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						
					}
					if(GrupojComboBox.getSelectedIndex()==3){
						InsertarjButton.setEnabled(true);
						jLabel1.setVisible(true);
						MateriaPrimajComboBox.setVisible(true);
						jLabel7.setVisible(false);
						ProductojComboBox.setVisible(false);
						ImprimirjButton.setEnabled(true);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						
					}
					
					if(GrupojComboBox.getSelectedIndex()==4){
						InsertarjButton.setEnabled(false);
						jLabel1.setVisible(false);
						MateriaPrimajComboBox.setVisible(false);
						jLabel7.setVisible(false);
						ProductojComboBox.setVisible(false);
						ImprimirjButton.setEnabled(false);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listD = new LinkedList<Bidon>();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						LinkedList<Bidon> listSFM = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						listD = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						listSFM= ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataGrupo.add(listD.get(i).getTipoinventario());
							columdDataContenido.add(listD.get(i).getProducto());
							columnDataGrados.add(dosDigitos.format(listD.get(i).getGrados()));
							columnDataFechaFabricacion.add(listD.get(i).getFechafabricacion());
							columnDataOF.add(listD.get(i).getOFabricacion());
							columnDataBidon.add(listD.get(i).getBidon());
							columnDataLitros.add(listD.get(i).getLitros());
							columnDataEstado.add(listD.get(i).getEstado());
							}
						for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						for (int i = 0; i < listSFM.size(); i++) {
							columdDataGrupo.add(listSFM.get(i).getTipoinventario());
							columdDataContenido.add(listSFM.get(i).getProducto());
							columnDataGrados.add(dosDigitos.format(listSFM.get(i).getGrados()));
							columnDataFechaFabricacion.add(listSFM.get(i).getFechafabricacion());
							columnDataOF.add(listSFM.get(i).getOFabricacion());
							columnDataBidon.add(listSFM.get(i).getBidon());
							columnDataLitros.add(listSFM.get(i).getLitros());
							columnDataEstado.add(listSFM.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return GrupojComboBox;
	}

	/**
	 * This method initializes bIDONjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBIDONjTextField() {
		if (bIDONjTextField == null) {
			bIDONjTextField = new JTextField();
			bIDONjTextField.setBounds(new Rectangle(837, 75, 76, 31));
		}
		return bIDONjTextField;
	}

	/**
	 * This method initializes LTSjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLTSjTextField() {
		if (LTSjTextField == null) {
			LTSjTextField = new JTextField();
			LTSjTextField.setBounds(new Rectangle(929, 75, 76, 31));
			Validate.validateDigit(LTSjTextField);
		}
		return LTSjTextField;
	}

	/**
	 * This method initializes EstadojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEstadojTextField() {
		if (EstadojTextField == null) {
			EstadojTextField = new JTextField();
			EstadojTextField.setBounds(new Rectangle(837, 144, 168, 31));
			Validate.validateLetter(EstadojTextField);
		}
		return EstadojTextField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Eliminar");
			btnNewButton.setEnabled(false);
			btnNewButton.setIcon(new ImageIcon(BidonesVisual.class.getResource("/img/ico_alpha_Delete_16x16.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(BidonesVisual.this, "¿Está seguro que desea modificar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						
							if(GrupojComboBox.getSelectedIndex()==2){
								if(MateriaPrimajComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
						if(SIjRadioButton.isSelected()){
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
					int pos = jTable.getSelectedRow();					
					LinkedList<Bidon> users = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
					Bidon u = users.get(pos);	
					try {
						try {
							ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
							JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					TableModel defaultTableModel = new TableModel();
					LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
					listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
					ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
					ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
					ArrayList<Object> columnDataGrados = new ArrayList<Object>();
					ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
					ArrayList<Object> columnDataOF = new ArrayList<Object>();
					ArrayList<Object> columnDataBidon = new ArrayList<Object>();
					ArrayList<Object> columnDataLitros = new ArrayList<Object>();
					ArrayList<Object> columnDataEstado = new ArrayList<Object>();
				for (int i = 0; i < listMaterias.size(); i++) {
						columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
						columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
						columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
						columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
						columnDataOF.add(listMaterias.get(i).getOFabricacion());
						columnDataBidon.add(listMaterias.get(i).getBidon());
						columnDataLitros.add(listMaterias.get(i).getLitros());
						columnDataEstado.add(listMaterias.get(i).getEstado());
						}
					defaultTableModel.setRowCount(listMaterias.size());	
					defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
					defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
					defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
					defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
					defaultTableModel.addColumn("OF",columnDataOF.toArray());
					defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
					defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
					defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
					getJTable().setModel(defaultTableModel);
					getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
					getJTable().setRowHeight(20);
					UserInterfaceSuport.clearComponents(jPanel);
						}
						if(NojRadioButton.isSelected()){
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						int pos = jTable.getSelectedRow();
						LinkedList<Bidon> users = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						Bidon u = users.get(pos);	
						try {
							try {
								ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						}
						}else{
							JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
						}
							}
							
							if(GrupojComboBox.getSelectedIndex()==3){
								if(MateriaPrimajComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
								if(SIjRadioButton.isSelected()){
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
							int pos = jTable.getSelectedRow();					
							LinkedList<Bidon> users = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
							Bidon u = users.get(pos);	
							try {
								try {
									ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
									JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}						
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
								columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
								}
								if(NojRadioButton.isSelected()){
									DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
								    simbolo.setDecimalSeparator(',');
								    simbolo.setGroupingSeparator('.');
									DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								int pos = jTable.getSelectedRow();
								LinkedList<Bidon> users = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								Bidon u = users.get(pos);	
								try {
									try {
										ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
										JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}							
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								UserInterfaceSuport.clearComponents(jPanel);
								}
							}else{
								JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
							}
								}				
						
						
						
						if(GrupojComboBox.getSelectedIndex()==1){
							if(ProductojComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
							if(SIjRadioButton.isSelected()){
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						int pos = jTable.getSelectedRow();					
						LinkedList<Bidon> users = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						Bidon u = users.get(pos);	
						try {
							try {
								ServicioBidon.ModificarBidonProducto(u.getId_bidon(),  Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto());
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getProducto());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
							}
							if(NojRadioButton.isSelected()){
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							int pos = jTable.getSelectedRow();
							LinkedList<Bidon> users = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							Bidon u = users.get(pos);	
							try {
								try {
									ServicioBidon.ModificarBidonProducto(u.getId_bidon(),  Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto());
									JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}							
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getProducto());			
								columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
							}
							}else{
								JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
							}
								}
					InsertarjButton.setEnabled(true);
					btnNewButton.setEnabled(false);
					btnNewButton_1.setEnabled(false);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}				
				}
			});
			btnNewButton.setBounds(236, 203, 105, 36);
		}
		return btnNewButton;
	}
	
	
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Modificar");
			btnNewButton_1.setEnabled(false);
			btnNewButton_1.setIcon(new ImageIcon(BidonesVisual.class.getResource("/img/ico_alpha_Refresh2_16x16.png")));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(BidonesVisual.this, "¿Está seguro que desea modificar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						
							if(GrupojComboBox.getSelectedIndex()==2){
								if(MateriaPrimajComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
						if(SIjRadioButton.isSelected()){
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
					int pos = jTable.getSelectedRow();					
					LinkedList<Bidon> users = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
					Bidon u = users.get(pos);	
					try {
						try {
							ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
							JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					TableModel defaultTableModel = new TableModel();
					LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
					listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
					ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
					ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
					ArrayList<Object> columnDataGrados = new ArrayList<Object>();
					ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
					ArrayList<Object> columnDataOF = new ArrayList<Object>();
					ArrayList<Object> columnDataBidon = new ArrayList<Object>();
					ArrayList<Object> columnDataLitros = new ArrayList<Object>();
					ArrayList<Object> columnDataEstado = new ArrayList<Object>();
				for (int i = 0; i < listMaterias.size(); i++) {
						columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
						columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
						columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
						columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
						columnDataOF.add(listMaterias.get(i).getOFabricacion());
						columnDataBidon.add(listMaterias.get(i).getBidon());
						columnDataLitros.add(listMaterias.get(i).getLitros());
						columnDataEstado.add(listMaterias.get(i).getEstado());
						}
					defaultTableModel.setRowCount(listMaterias.size());	
					defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
					defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
					defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
					defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
					defaultTableModel.addColumn("OF",columnDataOF.toArray());
					defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
					defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
					defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
					getJTable().setModel(defaultTableModel);
					getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
					getJTable().setRowHeight(20);
					UserInterfaceSuport.clearComponents(jPanel);
						}
						if(NojRadioButton.isSelected()){
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						int pos = jTable.getSelectedRow();
						LinkedList<Bidon> users = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						Bidon u = users.get(pos);	
						try {
							try {
								ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesMateriasPrimas(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						}
						}else{
							JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
						}
							}
							
							if(GrupojComboBox.getSelectedIndex()==3){
								if(MateriaPrimajComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
								if(SIjRadioButton.isSelected()){
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
							int pos = jTable.getSelectedRow();					
							LinkedList<Bidon> users = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
							Bidon u = users.get(pos);	
							try {
								try {
									ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
									JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}						
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
								columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
								}
								if(NojRadioButton.isSelected()){
									DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
								    simbolo.setDecimalSeparator(',');
								    simbolo.setGroupingSeparator('.');
									DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								int pos = jTable.getSelectedRow();
								LinkedList<Bidon> users = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								Bidon u = users.get(pos);	
								try {
									try {
										ServicioBidon.ModificarBidonMateriaPrima(u.getId_bidon(), Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((TipoInventarioBidon)GrupojComboBox.getSelectedItem()).getId_tipoinventario(), ((MateriaPrima)MateriaPrimajComboBox.getSelectedItem()).getId_materia());
										JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}							
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								TableModel defaultTableModel = new TableModel();
								LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
								listMaterias = ServicioBidon.getBidonesproduccionesSFM(adit.getId_inventarioBIdon());
								ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
								ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
								ArrayList<Object> columnDataGrados = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
								ArrayList<Object> columnDataOF = new ArrayList<Object>();
								ArrayList<Object> columnDataBidon = new ArrayList<Object>();
								ArrayList<Object> columnDataLitros = new ArrayList<Object>();
								ArrayList<Object> columnDataEstado = new ArrayList<Object>();
							for (int i = 0; i < listMaterias.size(); i++) {
									columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
									columdDataContenido.add(listMaterias.get(i).getMateriaprima());			
									columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
									columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
									columnDataOF.add(listMaterias.get(i).getOFabricacion());
									columnDataBidon.add(listMaterias.get(i).getBidon());
									columnDataLitros.add(listMaterias.get(i).getLitros());
									columnDataEstado.add(listMaterias.get(i).getEstado());
									}
								defaultTableModel.setRowCount(listMaterias.size());	
								defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
								defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
								defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
								defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
								defaultTableModel.addColumn("OF",columnDataOF.toArray());
								defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
								defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
								defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
								getJTable().setModel(defaultTableModel);
								getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
								getJTable().setRowHeight(20);
								UserInterfaceSuport.clearComponents(jPanel);
								}
							}else{
								JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
							}
								}				
						
						
						
						if(GrupojComboBox.getSelectedIndex()==1){
							if(ProductojComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && GrupojComboBox.getSelectedIndex()!=0){
							if(SIjRadioButton.isSelected()){
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						int pos = jTable.getSelectedRow();					
						LinkedList<Bidon> users = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						Bidon u = users.get(pos);	
						try {
							try {
								ServicioBidon.ModificarBidonProducto(u.getId_bidon(),  Float.valueOf(GradosjTextField.getText()), sqlDate, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto());
								JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						TableModel defaultTableModel = new TableModel();
						LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
						listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
						ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
						ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
						ArrayList<Object> columnDataGrados = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataBidon = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataEstado = new ArrayList<Object>();
					for (int i = 0; i < listMaterias.size(); i++) {
							columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
							columdDataContenido.add(listMaterias.get(i).getProducto());			
							columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
							columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
							columnDataOF.add(listMaterias.get(i).getOFabricacion());
							columnDataBidon.add(listMaterias.get(i).getBidon());
							columnDataLitros.add(listMaterias.get(i).getLitros());
							columnDataEstado.add(listMaterias.get(i).getEstado());
							}
						defaultTableModel.setRowCount(listMaterias.size());	
						defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
						defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
						defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
						defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
						defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
						defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
							}
							if(NojRadioButton.isSelected()){
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							int pos = jTable.getSelectedRow();
							LinkedList<Bidon> users = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							Bidon u = users.get(pos);	
							try {
								try {
									ServicioBidon.ModificarBidonProducto(u.getId_bidon(),  Float.valueOf(GradosjTextField.getText()), null, Integer.valueOf(OFjTextField.getText()), Integer.valueOf(bIDONjTextField.getText()), Integer.valueOf(LTSjTextField.getText()), EstadojTextField.getText(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto());
									JOptionPane.showMessageDialog(BidonesVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}							
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							TableModel defaultTableModel = new TableModel();
							LinkedList<Bidon> listMaterias = new LinkedList<Bidon>();
							listMaterias = ServicioBidon.getBidonesProducto(adit.getId_inventarioBIdon());
							ArrayList<Object> columdDataGrupo = new ArrayList<Object>();	
							ArrayList<Object> columdDataContenido = new ArrayList<Object>();		
							ArrayList<Object> columnDataGrados = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFabricacion = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataBidon = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataEstado = new ArrayList<Object>();
						for (int i = 0; i < listMaterias.size(); i++) {
								columdDataGrupo.add(listMaterias.get(i).getTipoinventario());			
								columdDataContenido.add(listMaterias.get(i).getProducto());			
								columnDataGrados.add(dosDigitos.format(listMaterias.get(i).getGrados()));
								columnDataFechaFabricacion.add(listMaterias.get(i).getFechafabricacion());
								columnDataOF.add(listMaterias.get(i).getOFabricacion());
								columnDataBidon.add(listMaterias.get(i).getBidon());
								columnDataLitros.add(listMaterias.get(i).getLitros());
								columnDataEstado.add(listMaterias.get(i).getEstado());
								}
							defaultTableModel.setRowCount(listMaterias.size());	
							defaultTableModel.addColumn("GRUPO",columdDataGrupo.toArray());
							defaultTableModel.addColumn("CONTENIDO", columdDataContenido.toArray());
							defaultTableModel.addColumn("GRADOS",columnDataGrados.toArray());
							defaultTableModel.addColumn("FECHA DE FABRICACIÓN", columnDataFechaFabricacion.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("BIDON", columnDataBidon.toArray());
							defaultTableModel.addColumn("LITROS", columnDataLitros.toArray());
							defaultTableModel.addColumn("ESTADO",columnDataEstado.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
							}
							}else{
								JOptionPane.showMessageDialog(BidonesVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
							}
								}
					InsertarjButton.setEnabled(true);
					btnNewButton.setEnabled(false);
					btnNewButton_1.setEnabled(false);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}
					
				}
			});
			btnNewButton_1.setBounds(117, 203, 107, 36);
		}
		return btnNewButton_1;
	}
}  //  @jve:decl-index=0:visual-constraint="255,0"
