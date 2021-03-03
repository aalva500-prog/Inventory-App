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
import model.InventarioAditivos;
import model.MateriaPrima;
import model.Proveedor;
import model.UnidadMedida;
import services.ServicioAditivo;
import services.ServicioMateriaPrima;
import services.ServicioProveedor;
import services.ServicioUnidadMedida;
import Utils.FormatoTabla;
import Utils.Reportes;
import Utils.TableModel;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AditivosVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private InventarioAditivos adit=null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private SpinnerDateModel DatespinnerDateModel=null;
	private JSpinner DatejSpinner=null;
	private JLabel jLabel1 = null;
	private JComboBox ClientejComboBox = null;
	private JLabel jLabel2 = null;
	private JTextField LTSjTextField = null;
	private JLabel jLabel3 = null;
	private JTextField GradosjTextField = null;
	private JPanel ReposojPanel1 = null;
	private JRadioButton SIjRadioButton = null;
	private JRadioButton NojRadioButton = null;
	private JLabel jLabel7 = null;
	private JComboBox ProductojComboBox = null;
	private JButton InsertarjButton = null;
	private JButton ModificarjButton = null;
	private JButton EliminarjButton = null;
	private JButton regresarjButton = null;
	private JButton MenujButton = null;
	private JButton ImprimirjButton = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable = null;
	private SpinnerDateModel DatespinnerDateModelInicio=null;
	private JSpinner DatejSpinnerInicio=null;
	private JLabel jLabel4 = null;
	private JComboBox UMjComboBox = null;
	
	public AditivosVisual(InventarioAditivos adit)  {
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
		this.setSize(new Dimension(862, 805));
	    this.setTitle("Inventario de Aditivos");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		SIjRadioButton.setSelected(false);
		DatejSpinnerInicio.setVisible(false);
		EliminarjButton.setEnabled(false);
		InsertarjButton.setEnabled(true);
		ModificarjButton.setEnabled(false);		
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	    simbolo.setDecimalSeparator(',');
	    simbolo.setGroupingSeparator('.');
		DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
		TableModel defaultTableModel = new TableModel();
		LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
		listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
		ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
		ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
		ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
		ArrayList<Object> columnDataUM = new ArrayList<Object>();
		ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
		for (int i = 0; i < listD.size(); i++) {
			columdDataCodigo.add(listD.get(i).getCodigo());
			columnDataMateriaPrima.add(listD.get(i).getMateria());
			columnDataProveedor.add(listD.get(i).getProveedor());
			columnDataVencimiento.add(listD.get(i).getVencimiento());
			columnDataUM.add(listD.get(i).getUM());
			columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
			}
		defaultTableModel.setRowCount(listD.size());	
		defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
		defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
		defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
		defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
		defaultTableModel.addColumn("UM", columnDataUM.toArray());
		defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
		getJTable().setModel(defaultTableModel);
		getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
		getJTable().setRowHeight(20);
		
		jTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
			    simbolo.setGroupingSeparator('.');
				DecimalFormat dosDigitos = new DecimalFormat( "###.#####",simbolo);
				int pos = jTable.getSelectedRow();
				LinkedList<Aditivo> users = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
				Aditivo u = users.get(pos);
				if(u.getVencimiento()!=null){
					SIjRadioButton.setSelected(true);
					NojRadioButton.setSelected(false);
					DatejSpinnerInicio.setVisible(true);
					LTSjTextField.setText(u.getCodigo());
				GradosjTextField.setText(String.valueOf(dosDigitos.format(u.getExistencia())));
				DatejSpinnerInicio.setValue(u.getVencimiento());
			    EliminarjButton.setEnabled(true);
				ModificarjButton.setEnabled(true);
				InsertarjButton.setEnabled(false);
				}else{
					NojRadioButton.setSelected(true);
					SIjRadioButton.setSelected(false);
					DatejSpinnerInicio.setVisible(false);
					LTSjTextField.setText(u.getCodigo());
					GradosjTextField.setText(String.valueOf(dosDigitos.format(u.getExistencia())));
				EliminarjButton.setEnabled(true);
				ModificarjButton.setEnabled(true);
				InsertarjButton.setEnabled(false);
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
		
		getClientejComboBox().setModel(boxModel1);
		
		 //Combobox Proveedores
		LinkedList<Proveedor> list = new LinkedList<Proveedor>();
		try {
			list= ServicioProveedor.getProveedores();
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
		
		//ComboBox UM
		LinkedList<UnidadMedida> listUM = new LinkedList<UnidadMedida>();
		try {
			listUM= ServicioUnidadMedida.getUnidades();
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
		
		getUMjComboBox().setModel(boxModelUM);
		
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
			gridBagConstraints1.ipadx = 379;
			gridBagConstraints1.ipady = 48;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(5, 5, 8, 7);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(6, 5, 5, 7);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 831;
			gridBagConstraints.ipady = 266;
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
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(700, 48, 124, 31));
			jLabel4.setText("UM:");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(9, 137, 297, 29));
			jLabel7.setText("PROVEEDOR:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(407, 48, 76, 29));
			jLabel3.setText("EXISTENCIA:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(319, 48, 76, 29));
			jLabel2.setText("CÓDIGO:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(9, 48, 297, 29));
			jLabel1.setText("MATERIA PRIMA:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(376, 8, 47, 29));
			jLabel.setText("FECHA:");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(jLabel, null);
			jPanel.add(getDatejSpinner(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getClientejComboBox(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getLTSjTextField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getGradosjTextField(), null);
			jPanel.add(getReposojPanel1(), null);
			jPanel.add(jLabel7, null);
			jPanel.add(getProductojComboBox(), null);
			jPanel.add(getInsertarjButton(), null);
			jPanel.add(getModificarjButton(), null);
			jPanel.add(getEliminarjButton(), null);
			jPanel.add(getRegresarjButton(), null);
			jPanel.add(getMenujButton(), null);
			jPanel.add(getImprimirjButton(), null);
			jPanel.add(jLabel4, null);
			jPanel.add(getUMjComboBox(), null);
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
			DatejSpinner.setBounds(new Rectangle(422, 8, 90, 29));
			DatejSpinner.setValue(adit.getFechainventarioaditivo());
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
	 * This method initializes ClientejComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getClientejComboBox() {
		if (ClientejComboBox == null) {
			ClientejComboBox = new JComboBox();
			ClientejComboBox.setBounds(new Rectangle(9, 77, 297, 29));
		}
		return ClientejComboBox;
	}

	/**
	 * This method initializes LTSjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLTSjTextField() {
		if (LTSjTextField == null) {
			LTSjTextField = new JTextField();
			LTSjTextField.setBounds(new Rectangle(319, 77, 76, 29));
			}
		return LTSjTextField;
	}

	/**
	 * This method initializes GradosjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGradosjTextField() {
		if (GradosjTextField == null) {
			GradosjTextField = new JTextField();
			GradosjTextField.setBounds(new Rectangle(407, 77, 76, 29));
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
			ReposojPanel1.setBorder(BorderFactory.createTitledBorder(null, "FECHA DE VENCIMIENTO", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			ReposojPanel1.setLayout(null);
			ReposojPanel1.setBounds(new Rectangle(503, 48, 183, 91));
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
			ProductojComboBox.setBounds(new Rectangle(9, 166, 297, 29));
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
			InsertarjButton.setBounds(new Rectangle(330, 166, 99, 36));
			InsertarjButton.setText("Insertar");
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(ClientejComboBox.getSelectedIndex()!=0 && ProductojComboBox.getSelectedIndex()!=0 &&  GradosjTextField.getText().length()!=0 && UMjComboBox.getSelectedIndex()!=0){
						java.sql.Date sqlDateInicio = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						if(SIjRadioButton.isSelected()){
							try {
							try {
								ServicioAditivo.insertarAditivo(LTSjTextField.getText(), ((MateriaPrima)ClientejComboBox.getSelectedItem()).getId_materia(), ((Proveedor)ProductojComboBox.getSelectedItem()).getId_proveedor(), sqlDateInicio, ((UnidadMedida)UMjComboBox.getSelectedItem()).getId_unidad(), Float.valueOf(GradosjTextField.getText()), adit.getId_inventarioaditivo());
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
							TableModel defaultTableModel = new TableModel();
							LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
							listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
							ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
							ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
							ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
							ArrayList<Object> columnDataUM = new ArrayList<Object>();
							ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
							for (int i = 0; i < listD.size(); i++) {
								columdDataCodigo.add(listD.get(i).getCodigo());
								columnDataMateriaPrima.add(listD.get(i).getMateria());
								columnDataProveedor.add(listD.get(i).getProveedor());
								columnDataVencimiento.add(listD.get(i).getVencimiento());
								columnDataUM.add(listD.get(i).getUM());
								columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
								}
							defaultTableModel.setRowCount(listD.size());	
							defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
							defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
							defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
							defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
							defaultTableModel.addColumn("UM", columnDataUM.toArray());
							defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							JOptionPane.showMessageDialog(AditivosVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel);
							}
						
						if(NojRadioButton.isSelected()){
							try {
								try {
									ServicioAditivo.insertarAditivo(LTSjTextField.getText(), ((MateriaPrima)ClientejComboBox.getSelectedItem()).getId_materia(), ((Proveedor)ProductojComboBox.getSelectedItem()).getId_proveedor(), null, ((UnidadMedida)UMjComboBox.getSelectedItem()).getId_unidad(), Float.valueOf(GradosjTextField.getText()), adit.getId_inventarioaditivo());
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
							TableModel defaultTableModel = new TableModel();
							LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
							listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
							ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
							ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
							ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
							ArrayList<Object> columnDataUM = new ArrayList<Object>();
							ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
							for (int i = 0; i < listD.size(); i++) {
								columdDataCodigo.add(listD.get(i).getCodigo());
								columnDataMateriaPrima.add(listD.get(i).getMateria());
								columnDataProveedor.add(listD.get(i).getProveedor());
								columnDataVencimiento.add(listD.get(i).getVencimiento());
								columnDataUM.add(listD.get(i).getUM());
								columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
								}
							defaultTableModel.setRowCount(listD.size());	
							defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
							defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
							defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
							defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
							defaultTableModel.addColumn("UM", columnDataUM.toArray());
							defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							JOptionPane.showMessageDialog(AditivosVisual.this, "Registro Insertado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel);
							}
					}else{
						JOptionPane.showMessageDialog(AditivosVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return InsertarjButton;
	}

	/**
	 * This method initializes ModificarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getModificarjButton() {
		if (ModificarjButton == null) {
			ModificarjButton = new JButton();
			ModificarjButton.setBounds(new Rectangle(438, 166, 117, 36));
			ModificarjButton.setText("Modificar");
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(AditivosVisual.this, "¿Está seguro que desea modificar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						if(ClientejComboBox.getSelectedIndex()!=0 && ProductojComboBox.getSelectedIndex()!=0  && GradosjTextField.getText().length()!=0 && UMjComboBox.getSelectedIndex()!=0){
						if(SIjRadioButton.isSelected()){
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					int pos = jTable.getSelectedRow();
					java.sql.Date sqlDateInicio = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
					LinkedList<Aditivo> users = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
					Aditivo u = users.get(pos);	
					try {
						ServicioAditivo.ModificarAditivo(u.getId_aditivo(), LTSjTextField.getText(), ((MateriaPrima)ClientejComboBox.getSelectedItem()).getId_materia(), ((Proveedor)ProductojComboBox.getSelectedItem()).getId_proveedor(), sqlDateInicio, ((UnidadMedida)UMjComboBox.getSelectedItem()).getId_unidad(), Float.valueOf(GradosjTextField.getText()));
						JOptionPane.showMessageDialog(AditivosVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					InsertarjButton.setEnabled(true);
					TableModel defaultTableModel = new TableModel();
					LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
					listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
					ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
					ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
					ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
					ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
					ArrayList<Object> columnDataUM = new ArrayList<Object>();
					ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
					for (int i = 0; i < listD.size(); i++) {
						columdDataCodigo.add(listD.get(i).getCodigo());
						columnDataMateriaPrima.add(listD.get(i).getMateria());
						columnDataProveedor.add(listD.get(i).getProveedor());
						columnDataVencimiento.add(listD.get(i).getVencimiento());
						columnDataUM.add(listD.get(i).getUM());
						columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
						}
					defaultTableModel.setRowCount(listD.size());	
					defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
					defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
					defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
					defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
					defaultTableModel.addColumn("UM", columnDataUM.toArray());
					defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
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
						LinkedList<Aditivo> users = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
						Aditivo u = users.get(pos);	
						try {
							ServicioAditivo.ModificarAditivo(u.getId_aditivo(), LTSjTextField.getText(), ((MateriaPrima)ClientejComboBox.getSelectedItem()).getId_materia(), ((Proveedor)ProductojComboBox.getSelectedItem()).getId_proveedor(), null, ((UnidadMedida)UMjComboBox.getSelectedItem()).getId_unidad(), Float.valueOf(GradosjTextField.getText()));
							JOptionPane.showMessageDialog(AditivosVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
						listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
						ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
						ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
						ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
						ArrayList<Object> columnDataUM = new ArrayList<Object>();
						ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataCodigo.add(listD.get(i).getCodigo());
							columnDataMateriaPrima.add(listD.get(i).getMateria());
							columnDataProveedor.add(listD.get(i).getProveedor());
							columnDataVencimiento.add(listD.get(i).getVencimiento());
							columnDataUM.add(listD.get(i).getUM());
							columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
						defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
						defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
						defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
						defaultTableModel.addColumn("UM", columnDataUM.toArray());
						defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						}
						}else{
							JOptionPane.showMessageDialog(AditivosVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
						}
					InsertarjButton.setEnabled(true);
					EliminarjButton.setEnabled(false);
					ModificarjButton.setEnabled(false);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}
				}
			});
		}
		return ModificarjButton;
	}

	/**
	 * This method initializes EliminarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEliminarjButton() {
		if (EliminarjButton == null) {
			EliminarjButton = new JButton();
			EliminarjButton.setBounds(new Rectangle(562, 166, 103, 36));
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(AditivosVisual.this, "¿Está seguro que desea Eliminar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<Aditivo> users = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
						Aditivo u = users.get(pos);
						ServicioAditivo.EliminarAditivo(u.getId_aditivo());
						JOptionPane.showMessageDialog(AditivosVisual.this, "Registro Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Aditivo> listD = new LinkedList<Aditivo>();
						listD = ServicioAditivo.getAditivos(adit.getId_inventarioaditivo());
						ArrayList<Object> columdDataCodigo = new ArrayList<Object>();		
						ArrayList<Object> columnDataMateriaPrima = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();
						ArrayList<Object> columnDataVencimiento = new ArrayList<Object>();
						ArrayList<Object> columnDataUM = new ArrayList<Object>();
						ArrayList<Object> columnDataExistencia = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataCodigo.add(listD.get(i).getCodigo());
							columnDataMateriaPrima.add(listD.get(i).getMateria());
							columnDataProveedor.add(listD.get(i).getProveedor());
							columnDataVencimiento.add(listD.get(i).getVencimiento());
							columnDataUM.add(listD.get(i).getUM());
							columnDataExistencia.add(dosDigitos.format(listD.get(i).getExistencia()));
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("CÓDIGO", columdDataCodigo.toArray());
						defaultTableModel.addColumn("MATERIA PRIMA",columnDataMateriaPrima.toArray());
						defaultTableModel.addColumn("PROVEEDOR", columnDataProveedor.toArray());
						defaultTableModel.addColumn("FECHA VENCIMIENTO",columnDataVencimiento.toArray());
						defaultTableModel.addColumn("UM", columnDataUM.toArray());
						defaultTableModel.addColumn("EXISTENCIA", columnDataExistencia.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					EliminarjButton.setEnabled(false);
					ModificarjButton.setEnabled(false);
					
				}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return EliminarjButton;
	}

	/**
	 * This method initializes regresarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegresarjButton() {
		if (regresarjButton == null) {
			regresarjButton = new JButton();
			regresarjButton.setBounds(new Rectangle(330, 220, 223, 36));
			regresarjButton.setText("Listado Inventarios Aditivos");
			regresarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			regresarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioAditivosVisual().setVisible(true);
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
			MenujButton.setBounds(new Rectangle(562, 220, 146, 36));
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
			ImprimirjButton.setBounds(new Rectangle(673, 166, 105, 36));
			ImprimirjButton.setText("Imprimir");
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Reportes.getR().InventarioAditivos(adit.getId_inventarioaditivo());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
	 * This method initializes UMjComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getUMjComboBox() {
		if (UMjComboBox == null) {
			UMjComboBox = new JComboBox();
			UMjComboBox.setBounds(new Rectangle(700, 77, 124, 29));
		}
		return UMjComboBox;
	}

	

}  //  @jve:decl-index=0:visual-constraint="12,8"
