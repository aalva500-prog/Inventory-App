package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;

import model.Cliente;
import model.DetalleProductoInforme;
import model.InformePizarra;
import model.Producto;
import services.ServicioCliente;
import services.ServicioDetalleInformePizarra;
import services.ServicioProducto;
import Utils.FormatoTabla;
import Utils.Reportes;
import Utils.TableModel;
import Utils.UserInterfaceSuport;
import Utils.Validate;

public class DetalleInformePizarraVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private InformePizarra informe=null;
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
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JComboBox ProductojComboBox = null;
	private JLabel jLabel8 = null;
	private JTextField OFjTextField = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextArea = null;
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
	private SpinnerDateModel DatespinnerDateModelFinal=null;
	private JSpinner DatejSpinnerFinal=null;
	public DetalleInformePizarraVisual(InformePizarra informe)  {
		super();
		this.informe=informe;
		initialize();		
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		this.setSize(new Dimension(1006, 805));
	    this.setTitle("Informe de Pizarra");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		SIjRadioButton.setSelected(false);
		jLabel5.setVisible(false);
		jLabel6.setVisible(false);
		DatejSpinnerInicio.setVisible(false);
		DatejSpinnerFinal.setVisible(false);	
		EliminarjButton.setEnabled(false);
		InsertarjButton.setEnabled(true);
		ModificarjButton.setEnabled(false);		
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	    simbolo.setDecimalSeparator(',');
	    simbolo.setGroupingSeparator('.');
		DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
		TableModel defaultTableModel = new TableModel();
		LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
		listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
		ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
		ArrayList<Object> columnDataProducto = new ArrayList<Object>();
		ArrayList<Object> columnDataLitros = new ArrayList<Object>();
		ArrayList<Object> columnDataGrado = new ArrayList<Object>();
		ArrayList<Object> columnDataInicio = new ArrayList<Object>();
		ArrayList<Object> columnDataFinal = new ArrayList<Object>();
		ArrayList<Object> columnDataOF = new ArrayList<Object>();
		ArrayList<Object> columnDataObserv = new ArrayList<Object>();
		for (int i = 0; i < listD.size(); i++) {
			columdDataCliente.add(listD.get(i).getCliente());
			columnDataProducto.add(listD.get(i).getProducto());
			columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
			columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
			columnDataInicio.add(listD.get(i).getFInicio());
			columnDataFinal.add(listD.get(i).getFFinal());
			columnDataOF.add(listD.get(i).getOF());
			columnDataObserv.add(listD.get(i).getObservaciones());
			}
		defaultTableModel.setRowCount(listD.size());	
		defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
		defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
		defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
		defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
		defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
		defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
		defaultTableModel.addColumn("OF",columnDataOF.toArray());
		defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
		getJTable().setModel(defaultTableModel);
		getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
		getJTable().setRowHeight(20);
		
		jTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
			    simbolo.setDecimalSeparator('.');
				DecimalFormat dosDigitos = new DecimalFormat( "###.#####",simbolo);
				int pos = jTable.getSelectedRow();
				LinkedList<DetalleProductoInforme> users = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
				DetalleProductoInforme u = users.get(pos);
				if(u.getFInicio()!=null && u.getFFinal()!=null){
					SIjRadioButton.setSelected(true);
					NojRadioButton.setSelected(false);
					jLabel5.setVisible(true);
					jLabel6.setVisible(true);
					DatejSpinnerInicio.setVisible(true);
					DatejSpinnerFinal.setVisible(true);	
				LTSjTextField.setText(String.valueOf(dosDigitos.format(u.getLitros())));
				GradosjTextField.setText(String.valueOf(dosDigitos.format(u.getGrados())));
				DatejSpinnerInicio.setValue(u.getFInicio());
				DatejSpinnerFinal.setValue(u.getFFinal());
				OFjTextField.setText(String.valueOf(u.getOF()));
				jTextArea.setText(u.getObservaciones());
				EliminarjButton.setEnabled(true);
				ModificarjButton.setEnabled(true);
				InsertarjButton.setEnabled(false);
				}else{
					NojRadioButton.setSelected(true);
					SIjRadioButton.setSelected(false);
					jLabel5.setVisible(false);
					jLabel6.setVisible(false);
					DatejSpinnerInicio.setVisible(false);
					DatejSpinnerFinal.setVisible(false);	
				LTSjTextField.setText(String.valueOf(dosDigitos.format(u.getLitros())));
				GradosjTextField.setText(String.valueOf(dosDigitos.format(u.getGrados())));
				OFjTextField.setText(String.valueOf(u.getOF()));
				jTextArea.setText(u.getObservaciones());
				EliminarjButton.setEnabled(true);
				ModificarjButton.setEnabled(true);
				InsertarjButton.setEnabled(false);
				}
				}
		});	
		
		
		 //Combobox Cliente
		LinkedList<Cliente> list1 = new LinkedList<Cliente>();
		try {
			list1= ServicioCliente.getClientes();
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
		
		 //Combobox Producto
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
			gridBagConstraints1.ipadx = 526;
			gridBagConstraints1.ipady = 48;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(6, 5, 7, 4);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(6, 5, 5, 4);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 978;
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
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(319, 137, 163, 29));
			jLabel8.setText("OBSERVACIONES:");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(9, 137, 297, 29));
			jLabel7.setText("PRODUCTO:");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(840, 48, 76, 29));
			jLabel4.setText("OF:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(407, 48, 76, 29));
			jLabel3.setText("GRADOS:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(319, 48, 76, 29));
			jLabel2.setText("LTS:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(9, 48, 297, 29));
			jLabel1.setText("CLIENTE:");
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
			jPanel.add(jLabel4, null);
			jPanel.add(jLabel7, null);
			jPanel.add(getProductojComboBox(), null);
			jPanel.add(jLabel8, null);
			jPanel.add(getOFjTextField(), null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(getInsertarjButton(), null);
			jPanel.add(getModificarjButton(), null);
			jPanel.add(getEliminarjButton(), null);
			jPanel.add(getRegresarjButton(), null);
			jPanel.add(getMenujButton(), null);
			jPanel.add(getImprimirjButton(), null);
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
			DatejSpinner.setValue(informe.getFecha());
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
			DatejSpinnerInicio.setBounds(new Rectangle(25, 80, 90, 29));
			}
		return DatejSpinnerInicio;
	}
	
	
	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModelFinal() {
		if (DatespinnerDateModelFinal  == null) {
			DatespinnerDateModelFinal = new SpinnerDateModel();
		}
		return DatespinnerDateModelFinal;
	}

	private JSpinner getDatejSpinnerFinal() {
		if (DatejSpinnerFinal == null) {
			DatejSpinnerFinal = new JSpinner(getDatespinnerDateModelFinal());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinnerFinal.setEditor(new JSpinner.DateEditor(DatejSpinnerFinal,dateFormat.toPattern()));
			DatejSpinnerFinal.setBounds(new Rectangle(150, 80, 85, 29));
			}
		return DatejSpinnerFinal;
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
			Validate.validateDigitAndComma(LTSjTextField);
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
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(150, 55, 85, 26));
			jLabel6.setText("FINAL:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(25, 55, 90, 26));
			jLabel5.setText("INICIO:");
			ReposojPanel1 = new JPanel();
			ReposojPanel1.setBorder(BorderFactory.createTitledBorder(null, "REPOSO", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			ReposojPanel1.setLayout(null);
			ReposojPanel1.setBounds(new Rectangle(503, 48, 321, 118));
			ReposojPanel1.add(getSIjRadioButton(), null);
			ReposojPanel1.add(getNojRadioButton(), null);
			ReposojPanel1.add(jLabel5, null);
			ReposojPanel1.add(jLabel6, null);
			ReposojPanel1.add(getDatejSpinnerInicio(), null);
			ReposojPanel1.add(getDatejSpinnerFinal(), null);
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
			SIjRadioButton.setBounds(new Rectangle(31, 17, 61, 21));
			SIjRadioButton.setText("Si");
			SIjRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(SIjRadioButton.isSelected()){
						NojRadioButton.setSelected(false);
						jLabel5.setVisible(true);
						jLabel6.setVisible(true);
						DatejSpinnerInicio.setVisible(true);
						DatejSpinnerFinal.setVisible(true);
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
			NojRadioButton.setBounds(new Rectangle(147, 17, 61, 21));
			NojRadioButton.setText("No");
			NojRadioButton.setSelected(true);
			NojRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(NojRadioButton.isSelected()){
					SIjRadioButton.setSelected(false);
					jLabel5.setVisible(false);
					jLabel6.setVisible(false);
					DatejSpinnerInicio.setVisible(false);
					DatejSpinnerFinal.setVisible(false);
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
	 * This method initializes OFjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOFjTextField() {
		if (OFjTextField == null) {
			OFjTextField = new JTextField();
			OFjTextField.setBounds(new Rectangle(840, 76, 76, 29));
			Validate.validateDigit(OFjTextField);
		}
		return OFjTextField;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(319, 166, 163, 74));
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			}
		return jTextArea;
	}

	/**
	 * This method initializes InsertarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInsertarjButton() {
		if (InsertarjButton == null) {
			InsertarjButton = new JButton();
			InsertarjButton.setBounds(new Rectangle(503, 175, 99, 36));
			InsertarjButton.setText("Insertar");
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(ClientejComboBox.getSelectedIndex()!=0 && ProductojComboBox.getSelectedIndex()!=0 && LTSjTextField.getText().length()!=0 && GradosjTextField.getText().length()!=0
							&& OFjTextField.getText().length()!=0 && jTextArea.getText().length()!=0){
						java.sql.Date sqlDateInicio = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						java.sql.Date sqlDateFinal = new java.sql.Date(getDatespinnerDateModelFinal().getDate().getTime());
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						if(SIjRadioButton.isSelected()){
							try {
								ServicioDetalleInformePizarra.insertarDetalleInforme(((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Float.valueOf(LTSjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, sqlDateFinal, Integer.valueOf(OFjTextField.getText()), jTextArea.getText(), ((Cliente)ClientejComboBox.getSelectedItem()).getId_cliente(), informe.getId_informe());
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (ClassNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							TableModel defaultTableModel = new TableModel();
							LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
							listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
							ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
							ArrayList<Object> columnDataProducto = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataGrado = new ArrayList<Object>();
							ArrayList<Object> columnDataInicio = new ArrayList<Object>();
							ArrayList<Object> columnDataFinal = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataObserv = new ArrayList<Object>();
							for (int i = 0; i < listD.size(); i++) {
								columdDataCliente.add(listD.get(i).getCliente());
								columnDataProducto.add(listD.get(i).getProducto());
								columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
								columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
								columnDataInicio.add(listD.get(i).getFInicio());
								columnDataFinal.add(listD.get(i).getFFinal());
								columnDataOF.add(listD.get(i).getOF());
								columnDataObserv.add(listD.get(i).getObservaciones());
								}
							defaultTableModel.setRowCount(listD.size());	
							defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
							defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
							defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
							defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
							defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
							defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
							jTextArea.setText("");
						}
						
						if(NojRadioButton.isSelected()){
							try {
								ServicioDetalleInformePizarra.insertarDetalleInforme(((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Float.valueOf(LTSjTextField.getText()), Float.valueOf(GradosjTextField.getText()), null, null, Integer.valueOf(OFjTextField.getText()), jTextArea.getText(), ((Cliente)ClientejComboBox.getSelectedItem()).getId_cliente(), informe.getId_informe());
							} catch (NumberFormatException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (ClassNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							TableModel defaultTableModel = new TableModel();
							LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
							listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
							ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
							ArrayList<Object> columnDataProducto = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataGrado = new ArrayList<Object>();
							ArrayList<Object> columnDataInicio = new ArrayList<Object>();
							ArrayList<Object> columnDataFinal = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataObserv = new ArrayList<Object>();
							for (int i = 0; i < listD.size(); i++) {
								columdDataCliente.add(listD.get(i).getCliente());
								columnDataProducto.add(listD.get(i).getProducto());
								columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
								columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
								columnDataInicio.add(listD.get(i).getFInicio());
								columnDataFinal.add(listD.get(i).getFFinal());
								columnDataOF.add(listD.get(i).getOF());
								columnDataObserv.add(listD.get(i).getObservaciones());
								}
							defaultTableModel.setRowCount(listD.size());	
							defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
							defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
							defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
							defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
							defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
							defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
							jTextArea.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(DetalleInformePizarraVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
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
			ModificarjButton.setBounds(new Rectangle(611, 175, 117, 36));
			ModificarjButton.setText("Modificar");
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(DetalleInformePizarraVisual.this, "¿Está seguro que desea modificar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						if(ClientejComboBox.getSelectedIndex()!=0 && ProductojComboBox.getSelectedIndex()!=0 && LTSjTextField.getText().length()!=0 && GradosjTextField.getText().length()!=0
								&& OFjTextField.getText().length()!=0 && jTextArea.getText().length()!=0){
						if(SIjRadioButton.isSelected()){
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					int pos = jTable.getSelectedRow();
					try {
						java.sql.Date sqlDateInicio = new java.sql.Date(getDatespinnerDateModelInicio().getDate().getTime());
						java.sql.Date sqlDateFinal = new java.sql.Date(getDatespinnerDateModelFinal().getDate().getTime());
						LinkedList<DetalleProductoInforme> users = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
						DetalleProductoInforme u = users.get(pos);	
						ServicioDetalleInformePizarra.ModificarDetalleInformePizarra(u.getId_detalle(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Float.valueOf(LTSjTextField.getText()), Float.valueOf(GradosjTextField.getText()), sqlDateInicio, sqlDateFinal, Integer.valueOf(OFjTextField.getText()), jTextArea.getText(), ((Cliente)ClientejComboBox.getSelectedItem()).getId_cliente());
						JOptionPane.showMessageDialog(DetalleInformePizarraVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
						listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
						ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataGrado = new ArrayList<Object>();
						ArrayList<Object> columnDataInicio = new ArrayList<Object>();
						ArrayList<Object> columnDataFinal = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataObserv = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataCliente.add(listD.get(i).getCliente());
							columnDataProducto.add(listD.get(i).getProducto());
							columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
							columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
							columnDataInicio.add(listD.get(i).getFInicio());
							columnDataFinal.add(listD.get(i).getFFinal());
							columnDataOF.add(listD.get(i).getOF());
							columnDataObserv.add(listD.get(i).getObservaciones());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
						defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
						defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
						defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
						defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
						defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						jTextArea.setText("");					
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
						if(NojRadioButton.isSelected()){
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						int pos = jTable.getSelectedRow();
						try {
							LinkedList<DetalleProductoInforme> users = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
							DetalleProductoInforme u = users.get(pos);	
							ServicioDetalleInformePizarra.ModificarDetalleInformePizarra(u.getId_detalle(), ((Producto)ProductojComboBox.getSelectedItem()).getId_producto(), Float.valueOf(LTSjTextField.getText()), Float.valueOf(GradosjTextField.getText()), null, null, Integer.valueOf(OFjTextField.getText()), jTextArea.getText(), ((Cliente)ClientejComboBox.getSelectedItem()).getId_cliente());
							JOptionPane.showMessageDialog(DetalleInformePizarraVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
							InsertarjButton.setEnabled(true);
							TableModel defaultTableModel = new TableModel();
							LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
							listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
							ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
							ArrayList<Object> columnDataProducto = new ArrayList<Object>();
							ArrayList<Object> columnDataLitros = new ArrayList<Object>();
							ArrayList<Object> columnDataGrado = new ArrayList<Object>();
							ArrayList<Object> columnDataInicio = new ArrayList<Object>();
							ArrayList<Object> columnDataFinal = new ArrayList<Object>();
							ArrayList<Object> columnDataOF = new ArrayList<Object>();
							ArrayList<Object> columnDataObserv = new ArrayList<Object>();
							for (int i = 0; i < listD.size(); i++) {
								columdDataCliente.add(listD.get(i).getCliente());
								columnDataProducto.add(listD.get(i).getProducto());
								columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
								columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
								columnDataInicio.add(listD.get(i).getFInicio());
								columnDataFinal.add(listD.get(i).getFFinal());
								columnDataOF.add(listD.get(i).getOF());
								columnDataObserv.add(listD.get(i).getObservaciones());
								}
							defaultTableModel.setRowCount(listD.size());	
							defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
							defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
							defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
							defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
							defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
							defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
							defaultTableModel.addColumn("OF",columnDataOF.toArray());
							defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
							getJTable().setModel(defaultTableModel);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(jPanel);
							jTextArea.setText("");					
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						}else{
							JOptionPane.showMessageDialog(DetalleInformePizarraVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
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
			EliminarjButton.setBounds(new Rectangle(735, 175, 103, 36));
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(DetalleInformePizarraVisual.this, "¿Está seguro que desea Eliminar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<DetalleProductoInforme> users = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
						DetalleProductoInforme u = users.get(pos);
						ServicioDetalleInformePizarra.EliminarDetalleInforme(u.getId_detalle());
						JOptionPane.showMessageDialog(DetalleInformePizarraVisual.this, "Registro Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel defaultTableModel = new TableModel();
						LinkedList<DetalleProductoInforme> listD = new LinkedList<DetalleProductoInforme>();
						listD = ServicioDetalleInformePizarra.getDetallesProductos(informe.getId_informe());
						ArrayList<Object> columdDataCliente = new ArrayList<Object>();		
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						ArrayList<Object> columnDataLitros = new ArrayList<Object>();
						ArrayList<Object> columnDataGrado = new ArrayList<Object>();
						ArrayList<Object> columnDataInicio = new ArrayList<Object>();
						ArrayList<Object> columnDataFinal = new ArrayList<Object>();
						ArrayList<Object> columnDataOF = new ArrayList<Object>();
						ArrayList<Object> columnDataObserv = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataCliente.add(listD.get(i).getCliente());
							columnDataProducto.add(listD.get(i).getProducto());
							columnDataLitros.add(dosDigitos.format(listD.get(i).getLitros()));
							columnDataGrado.add(dosDigitos.format(listD.get(i).getGrados()));
							columnDataInicio.add(listD.get(i).getFInicio());
							columnDataFinal.add(listD.get(i).getFFinal());
							columnDataOF.add(listD.get(i).getOF());
							columnDataObserv.add(listD.get(i).getObservaciones());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("CLIENTE", columdDataCliente.toArray());
						defaultTableModel.addColumn("PRODUCTO",columnDataProducto.toArray());
						defaultTableModel.addColumn("LTS", columnDataLitros.toArray());
						defaultTableModel.addColumn("GRADO",columnDataGrado.toArray());
						defaultTableModel.addColumn("INICIO", columnDataInicio.toArray());
						defaultTableModel.addColumn("FINAL", columnDataFinal.toArray());
						defaultTableModel.addColumn("OF",columnDataOF.toArray());
						defaultTableModel.addColumn("OBSERVACIONES",columnDataObserv.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						jTextArea.setText("");
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
			regresarjButton.setBounds(new Rectangle(503, 221, 223, 36));
			regresarjButton.setText("Listado Informes de Pizarra");
			regresarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			regresarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInformesPizarraVisual().setVisible(true);
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
			MenujButton.setBounds(new Rectangle(735, 221, 146, 36));
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
			ImprimirjButton.setBounds(new Rectangle(846, 175, 105, 36));
			ImprimirjButton.setText("Imprimir");
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Reportes.getR().InformePizarra(informe.getId_informe());
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

	

}  //  @jve:decl-index=0:visual-constraint="12,8"
