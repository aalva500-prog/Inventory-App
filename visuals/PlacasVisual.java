package visuals;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import net.sf.jasperreports.engine.JRException;

import model.InventarioPlacas;
import model.Placas;
import services.ServicioPlaca;
import Utils.FormatoTabla;
import Utils.Reportes;
import Utils.TableModel;
import Utils.UserInterfaceSuport;

public class PlacasVisual extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private InventarioPlacas p=null;
	private JLabel jLabel = null;
	private JTextField PlacajTextField = null;
	private JPanel jPanel = null;
	private JLabel jLabel1 = null;
	private JTextField CAntidadPlacasjTextField = null;
	private JLabel jLabel2 = null;
	private JTextField CantPorjTextField = null;
	private JLabel jLabel3 = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextArea = null;
	private JLabel jLabel4 = null;
	private SpinnerDateModel DatespinnerDateModel=null;
	private JSpinner DatejSpinner=null;
	private JButton InsertarjButton = null;
	private JButton ModificarjButton = null;
	private JButton EliminarjButton = null;
	private JButton ImprimirjButton = null;
	private JButton regresarjButton = null;
	private JButton MenujButton = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable = null;
	

	public PlacasVisual(InventarioPlacas p) {
		super();
		this.p=p;
		initialize();	
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		    this.setSize(new Dimension(1013, 613));
			this.setTitle("INVENTARIO DE PLACAS DE FILTRO");
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
			this.setContentPane(getJContentPane());
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			EliminarjButton.setEnabled(false);
			InsertarjButton.setEnabled(true);
			ModificarjButton.setEnabled(false);		
			TableModel defaultTableModel = new TableModel();
			LinkedList<Placas> listD = new LinkedList<Placas>();
			listD = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
			ArrayList<Object> columdDataPlaca = new ArrayList<Object>();		
			ArrayList<Object> columnDataCantidadPlacas = new ArrayList<Object>();
			ArrayList<Object> columnDataCAntCajas = new ArrayList<Object>();
			ArrayList<Object> columnDataUtilizacion = new ArrayList<Object>();
			for (int i = 0; i < listD.size(); i++) {
				columdDataPlaca.add(listD.get(i).getPlaca());
				columnDataCantidadPlacas.add(listD.get(i).getCantplacas());
				columnDataCAntCajas.add(listD.get(i).getCantporcajas());
				columnDataUtilizacion.add(listD.get(i).getUtilizacion());
				}
			defaultTableModel.setRowCount(listD.size());	
			defaultTableModel.addColumn("PLACA", columdDataPlaca.toArray());
			defaultTableModel.addColumn("CANTIDAD DE PLACAS",columnDataCantidadPlacas.toArray());
			defaultTableModel.addColumn("CANT. POR CAJAS", columnDataCAntCajas.toArray());
			defaultTableModel.addColumn("UTILIZACIÓN",columnDataUtilizacion.toArray());
			getJTable().setModel(defaultTableModel);
			getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
			getJTable().setRowHeight(20);
			
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int pos = jTable.getSelectedRow();
					LinkedList<Placas> users = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
					Placas u = users.get(pos);
					PlacajTextField.setText(u.getPlaca());
					CAntidadPlacasjTextField.setText(String.valueOf(u.getCantplacas()));
					CantPorjTextField.setText(String.valueOf(u.getCantporcajas()));
					jTextArea.setText(u.getUtilizacion());
					EliminarjButton.setEnabled(true);
					InsertarjButton.setEnabled(false);
					ModificarjButton.setEnabled(true);		
					}
			});	
			

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
			gridBagConstraints1.ipadx = 534;
			gridBagConstraints1.ipady = -23;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(3, 3, 3, 5);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(3, 3, 2, 5);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 986;
			gridBagConstraints.ipady = 158;
			gridBagConstraints.gridx = 0;
			jLabel = new JLabel();
			jLabel.setText("PLACA:");
			jLabel.setBounds(new Rectangle(8, 52, 80, 29));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJPanel(), gridBagConstraints);
			jContentPane.add(getJScrollPane1(), gridBagConstraints1);
		}
		return jContentPane;
	}

	/**
	 * This method initializes PlacajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPlacajTextField() {
		if (PlacajTextField == null) {
			PlacajTextField = new JTextField();
			PlacajTextField.setBounds(new Rectangle(8, 80, 80, 29));
		}
		return PlacajTextField;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(8, 8, 45, 29));
			jLabel4.setText("FECHA:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(378, 52, 188, 30));
			jLabel3.setText("UTILIZACIÓN:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(253, 52, 112, 30));
			jLabel2.setText("CANT. POR CAJAS:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(102, 52, 138, 29));
			jLabel1.setText("CANTIDAD DE PLACAS:");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getPlacajTextField(), null);
			jPanel.add(jLabel, null);
			jPanel.add(jLabel1, null);
			jPanel.add(getCAntidadPlacasjTextField(), null);
			jPanel.add(jLabel2, null);
			jPanel.add(getCantPorjTextField(), null);
			jPanel.add(jLabel3, null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(jLabel4, null);
			jPanel.add(getDatejSpinner(), null);
			jPanel.add(getInsertarjButton(), null);
			jPanel.add(getModificarjButton(), null);
			jPanel.add(getEliminarjButton(), null);
			jPanel.add(getImprimirjButton(), null);
			jPanel.add(getRegresarjButton(), null);
			jPanel.add(getMenujButton(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes CAntidadPlacasjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCAntidadPlacasjTextField() {
		if (CAntidadPlacasjTextField == null) {
			CAntidadPlacasjTextField = new JTextField();
			CAntidadPlacasjTextField.setBounds(new Rectangle(102, 80, 139, 29));
		}
		return CAntidadPlacasjTextField;
	}

	/**
	 * This method initializes CantPorjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantPorjTextField() {
		if (CantPorjTextField == null) {
			CantPorjTextField = new JTextField();
			CantPorjTextField.setBounds(new Rectangle(253, 80, 112, 29));
		}
		return CantPorjTextField;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(378, 81, 188, 68));
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
			DatejSpinner.setBounds(new Rectangle(53, 8, 90, 29));
			DatejSpinner.setValue(p.getFechainventarioplacas());
			DatejSpinner.setEnabled(false);
			}
		return DatejSpinner;
	}

	/**
	 * This method initializes InsertarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInsertarjButton() {
		if (InsertarjButton == null) {
			InsertarjButton = new JButton();
			InsertarjButton.setBounds(new Rectangle(576, 8, 115, 34));
			InsertarjButton.setText("Insertar");
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(PlacajTextField.getText().length()!=0 && CAntidadPlacasjTextField.getText().length()!=0 && CantPorjTextField.getText().length()!=0 && jTextArea.getText().length()!=0){
						try {
							ServicioPlaca.insertarPlaca(PlacajTextField.getText(), Integer.valueOf(CAntidadPlacasjTextField.getText()), Integer.valueOf(CantPorjTextField.getText()), jTextArea.getText(), p.getId_inventarioplacas());
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
						TableModel defaultTableModel = new TableModel();
						LinkedList<Placas> listD = new LinkedList<Placas>();
						listD = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
						ArrayList<Object> columdDataPlaca = new ArrayList<Object>();		
						ArrayList<Object> columnDataCantidadPlacas = new ArrayList<Object>();
						ArrayList<Object> columnDataCAntCajas = new ArrayList<Object>();
						ArrayList<Object> columnDataUtilizacion = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataPlaca.add(listD.get(i).getPlaca());
							columnDataCantidadPlacas.add(listD.get(i).getCantplacas());
							columnDataCAntCajas.add(listD.get(i).getCantporcajas());
							columnDataUtilizacion.add(listD.get(i).getUtilizacion());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("PLACA", columdDataPlaca.toArray());
						defaultTableModel.addColumn("CANTIDAD DE PLACAS",columnDataCantidadPlacas.toArray());
						defaultTableModel.addColumn("CANT. POR CAJAS", columnDataCAntCajas.toArray());
						defaultTableModel.addColumn("UTILIZACIÓN",columnDataUtilizacion.toArray());
						getJTable().setModel(defaultTableModel);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(jPanel);
						jTextArea.setText("");
					}else{
						JOptionPane.showMessageDialog(PlacasVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
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
			ModificarjButton.setBounds(new Rectangle(576, 52, 115, 34));
			ModificarjButton.setText("Modificar");
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(PlacasVisual.this, "¿Está seguro que desea Modificar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						if(PlacajTextField.getText().length()!=0 && CAntidadPlacasjTextField.getText().length()!=0 && CantPorjTextField.getText().length()!=0 && jTextArea.getText().length()!=0){
						int pos = jTable.getSelectedRow();
					try {
						LinkedList<Placas> users = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
						Placas u = users.get(pos);	
						ServicioPlaca.ModificarPlaca(u.getId_placas(), PlacajTextField.getText(), Integer.valueOf(CAntidadPlacasjTextField.getText()), Integer.valueOf(CantPorjTextField.getText()), jTextArea.getText());
						JOptionPane.showMessageDialog(PlacasVisual.this, "Registro Modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Placas> listD = new LinkedList<Placas>();
						listD = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
						ArrayList<Object> columdDataPlaca = new ArrayList<Object>();		
						ArrayList<Object> columnDataCantidadPlacas = new ArrayList<Object>();
						ArrayList<Object> columnDataCAntCajas = new ArrayList<Object>();
						ArrayList<Object> columnDataUtilizacion = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataPlaca.add(listD.get(i).getPlaca());
							columnDataCantidadPlacas.add(listD.get(i).getCantplacas());
							columnDataCAntCajas.add(listD.get(i).getCantporcajas());
							columnDataUtilizacion.add(listD.get(i).getUtilizacion());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("PLACA", columdDataPlaca.toArray());
						defaultTableModel.addColumn("CANTIDAD DE PLACAS",columnDataCantidadPlacas.toArray());
						defaultTableModel.addColumn("CANT. POR CAJAS", columnDataCAntCajas.toArray());
						defaultTableModel.addColumn("UTILIZACIÓN",columnDataUtilizacion.toArray());
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
						}else{
							JOptionPane.showMessageDialog(PlacasVisual.this, "Debe Llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);	
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
			EliminarjButton.setBounds(new Rectangle(576, 95, 115, 34));
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(PlacasVisual.this, "¿Está seguro que desea Eliminar el Registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<Placas> users = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
						Placas u = users.get(pos);
						ServicioPlaca.EliminarPlaca(u.getId_placas());
						JOptionPane.showMessageDialog(PlacasVisual.this, "Registro Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<Placas> listD = new LinkedList<Placas>();
						listD = ServicioPlaca.getPlacas(p.getId_inventarioplacas());
						ArrayList<Object> columdDataPlaca = new ArrayList<Object>();		
						ArrayList<Object> columnDataCantidadPlacas = new ArrayList<Object>();
						ArrayList<Object> columnDataCAntCajas = new ArrayList<Object>();
						ArrayList<Object> columnDataUtilizacion = new ArrayList<Object>();
						for (int i = 0; i < listD.size(); i++) {
							columdDataPlaca.add(listD.get(i).getPlaca());
							columnDataCantidadPlacas.add(listD.get(i).getCantplacas());
							columnDataCAntCajas.add(listD.get(i).getCantporcajas());
							columnDataUtilizacion.add(listD.get(i).getUtilizacion());
							}
						defaultTableModel.setRowCount(listD.size());	
						defaultTableModel.addColumn("PLACA", columdDataPlaca.toArray());
						defaultTableModel.addColumn("CANTIDAD DE PLACAS",columnDataCantidadPlacas.toArray());
						defaultTableModel.addColumn("CANT. POR CAJAS", columnDataCAntCajas.toArray());
						defaultTableModel.addColumn("UTILIZACIÓN",columnDataUtilizacion.toArray());
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
	 * This method initializes ImprimirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getImprimirjButton() {
		if (ImprimirjButton == null) {
			ImprimirjButton = new JButton();
			ImprimirjButton.setBounds(new Rectangle(703, 8, 115, 34));
			ImprimirjButton.setText("Imprimir");
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Reportes.getR().InventarioPlacasdeFiltro(p.getId_inventarioplacas());
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
	 * This method initializes regresarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegresarjButton() {
		if (regresarjButton == null) {
			regresarjButton = new JButton();
			regresarjButton.setBounds(new Rectangle(703, 52, 279, 34));
			regresarjButton.setText("Listado Inventarios de Placas de Filtro");
			regresarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			regresarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioPlacasVisual().setVisible(true);
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
			MenujButton.setBounds(new Rectangle(703, 95, 138, 34));
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
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
