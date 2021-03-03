package visuals;

import java.awt.Dimension;
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
import javax.swing.SpinnerDateModel;

import model.InventarioTanquesPlasticos;
import services.ServicioInventarioTanquesPlasticos;
import services.ServicioTanquesPlasticos;
import Utils.FormatoTabla;
import Utils.TableModel;
import Utils.UserInterfaceSuport;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaInventarioTanquesPlasticosVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel = null;
	private JButton InsertarjButton = null;
	private JButton ModificarjButton = null;
	private JButton EliminarjButton = null;
	private JButton SalirjButton = null;
	
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private SpinnerDateModel DatespinnerDateModel=null;
	private JSpinner DatejSpinner=null;
	private JButton DatosjButton = null;
	private JPanel panel;
	private JCheckBox checkBox;
	private JLabel lblMes;
	private JLabel lblAo;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	
	public ListaInventarioTanquesPlasticosVisual() {
		super();
		initialize();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		    this.setSize(new Dimension(679, 610));
		    this.setContentPane(getJPanel());
			this.setTitle("Listado de Inventarios de Tanques Plásticos de 1000 LTS");
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			EliminarjButton.setEnabled(false);
			InsertarjButton.setEnabled(true);
			ModificarjButton.setEnabled(false);
			SalirjButton.setEnabled(true);
					
			TableModel defaultTableModel = new TableModel();
			LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
			try {
				list = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			    e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArrayList<Object> columnDataProducto = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				columnDataProducto.add(list.get(i).getFechaplasticos());
				}
			defaultTableModel.setRowCount(list.size());							
			defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
			getJTable().setModel(defaultTableModel);	
			getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
			getJTable().setRowHeight(20);
			
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<InventarioTanquesPlasticos> users = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						InventarioTanquesPlasticos u = users.get(pos);
						DatejSpinner.setValue(u.getFechaplasticos());						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					EliminarjButton.setEnabled(true);
					ModificarjButton.setEnabled(true);
					InsertarjButton.setEnabled(false);
					DatosjButton.setEnabled(true);
					}
			});	
			
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));		
		}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setText("Fecha del Inventario de Tanques Plásticos:");
			jLabel.setBounds(new Rectangle(5, 4, 248, 26));
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(getJPanel1(), null);
			jPanel.add(getJPanel2(), null);
			jPanel.add(getPanel());
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(6, 62, 494, 495));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
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
	 * This method initializes InsertarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInsertarjButton() {
		if (InsertarjButton == null) {
			InsertarjButton = new JButton();
			InsertarjButton.setText("Insertar");
			InsertarjButton.setBounds(new Rectangle(3, 6, 140, 38));
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					try {
						ServicioInventarioTanquesPlasticos.insertarInventarioTanquesPlasticos(sqlDate);
						TableModel defaultTableModel = new TableModel();
						LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
						try {
							list = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						    e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getFechaplasticos());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
						
						JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Fecha Insertada", "Información", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel);
					
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
			ModificarjButton.setText("Modificar");
			ModificarjButton.setBounds(new Rectangle(3, 62, 140, 38));
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {					
					int result = JOptionPane.showConfirmDialog(ListaInventarioTanquesPlasticosVisual.this, "¿Está seguro que desea modificar la Fecha?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					if(textField.getText().length()==0 && textField_1.getText().length()==0){
					try {
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						LinkedList<InventarioTanquesPlasticos> users = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						InventarioTanquesPlasticos u = users.get(pos);	
						ServicioInventarioTanquesPlasticos.ModificarInventarioTanquesPlasticos(u.getId_tanquesplasticos(), sqlDate);
						JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Fecha Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
						try {
							list = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						    e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getFechaplasticos());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(getJPanel());
											
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						try {
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
							LinkedList<InventarioTanquesPlasticos> users = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
							InventarioTanquesPlasticos u = users.get(pos);	
							ServicioInventarioTanquesPlasticos.ModificarInventarioTanquesPlasticos(u.getId_tanquesplasticos(), sqlDate);
							JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Fecha Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
							InsertarjButton.setEnabled(true);
							TableModel defaultTableModel = new TableModel();
							LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
							list = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
							ArrayList<Object> columnDataProducto = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataProducto.add(list.get(i).getFechaplasticos());
								}
							defaultTableModel.setRowCount(list.size());							
							defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
							getJTable().setModel(defaultTableModel);	
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							UserInterfaceSuport.clearComponents(getJPanel());
												
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					InsertarjButton.setEnabled(true);
					EliminarjButton.setEnabled(false);
					ModificarjButton.setEnabled(false);
					DatosjButton.setEnabled(false);
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
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setBounds(new Rectangle(3, 167, 140, 38));
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(ListaInventarioTanquesPlasticosVisual.this, "¿Está seguro que desea Eliminar el Inventario de Tanques Plasticos de 1000 LTS?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					if(textField.getText().length()==0 && textField_1.getText().length()==0){
					try {
						LinkedList<InventarioTanquesPlasticos> users = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						InventarioTanquesPlasticos u = users.get(pos);
						ServicioTanquesPlasticos.EliminarTanquesPlasticoCascada(u.getId_tanquesplasticos());
						ServicioInventarioTanquesPlasticos.EliminarInventarioTanquesPlasticos(u.getId_tanquesplasticos());						
						JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Inventario de Tanques Plasticos de 1000 LTS Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
						try {
							list = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						    e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getFechaplasticos());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(getJPanel());
											
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                  }else{
                	  try {
  						LinkedList<InventarioTanquesPlasticos> users = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
  						InventarioTanquesPlasticos u = users.get(pos);
  						ServicioTanquesPlasticos.EliminarTanquesPlasticoCascada(u.getId_tanquesplasticos());
  						ServicioInventarioTanquesPlasticos.EliminarInventarioTanquesPlasticos(u.getId_tanquesplasticos());						
  						JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Inventario de Tanques Plasticos de 1000 LTS Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
  						InsertarjButton.setEnabled(true);
  						TableModel defaultTableModel = new TableModel();
  						LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
  						list = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
  						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
  						for (int i = 0; i < list.size(); i++) {
  							columnDataProducto.add(list.get(i).getFechaplasticos());
  							}
  						defaultTableModel.setRowCount(list.size());							
  						defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
  						getJTable().setModel(defaultTableModel);	
  						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
  						getJTable().setRowHeight(20);
  						UserInterfaceSuport.clearComponents(getJPanel());
  											
  					} catch (SQLException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					} catch (ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
					}
					EliminarjButton.setEnabled(false);
					ModificarjButton.setEnabled(false);
					DatosjButton.setEnabled(false);
				}
					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					
				}
			});
		}
		return EliminarjButton;
	}

	/**
	 * This method initializes SalirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalirjButton() {
		if (SalirjButton == null) {
			SalirjButton = new JButton();
			SalirjButton.setText("Menú Principal");
			SalirjButton.setBounds(new Rectangle(3, 220, 140, 38));
			SalirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			SalirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Principio i = new Principio();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return SalirjButton;
	}
	
	
	

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new Rectangle(507, 9, 145, 269));
			jPanel1.add(getSalirjButton(), null);
			jPanel1.add(getEliminarjButton(), null);
			jPanel1.add(getModificarjButton(), null);
			jPanel1.add(getInsertarjButton(), null);
			jPanel1.add(getDatosjButton(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(new Rectangle(8, 9, 453, 45));
			jPanel2.add(jLabel, null);
			jPanel2.add(getDatejSpinner(), null);
			
		}
		return jPanel2;
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
			DatejSpinner.setBounds(new Rectangle(252, 4, 136, 26));
		}
		return DatejSpinner;
	}

	/**
	 * This method initializes DatosjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDatosjButton() {
		if (DatosjButton == null) {
			DatosjButton = new JButton();
			DatosjButton.setBounds(new Rectangle(3, 114, 140, 38));
			DatosjButton.setText("Ver Datos");
			DatosjButton.setEnabled(false);
			DatosjButton.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			DatosjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {					
					int pos = jTable.getSelectedRow();
					if(textField.getText().length()==0 && textField_1.getText().length()==0){
					LinkedList<InventarioTanquesPlasticos> users;
					try {
						users = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						InventarioTanquesPlasticos u = users.get(pos);
						dispose();
						new TanquesPlasticosVisual(u).setVisible(true);			
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						LinkedList<InventarioTanquesPlasticos> users;
						users = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
						InventarioTanquesPlasticos u = users.get(pos);
						dispose();
						new TanquesPlasticosVisual(u).setVisible(true);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return DatosjButton;
	}

	
	

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(507, 291, 145, 266);
			panel.setLayout(null);
			panel.add(getCheckBox());
			panel.add(getLblMes());
			panel.add(getLblAo());
			panel.add(getTextField());
			panel.add(getTextField_1());
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("Filtrar");
			checkBox.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if(checkBox.isSelected()){
						lblAo.setVisible(true);
						lblMes.setVisible(true);
						textField.setVisible(true);
						textField_1.setVisible(true);
						btnNewButton.setVisible(true);
					}else{
						lblAo.setVisible(false);
						lblMes.setVisible(false);
						textField.setVisible(false);
						textField_1.setVisible(false);
						btnNewButton.setVisible(false);
						textField_1.setText("");
						textField.setText("");
						TableModel defaultTableModel = new TableModel();
						LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
						try {
							list = ServicioInventarioTanquesPlasticos.getInventarioTanquesPlasticos();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						    e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getFechaplasticos());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
					}
				}
			});
			checkBox.setBounds(8, 9, 113, 25);
		}
		return checkBox;
	}
	private JLabel getLblMes() {
		if (lblMes == null) {
			lblMes = new JLabel("Mes:");
			lblMes.setBounds(8, 43, 28, 25);
			lblMes.setVisible(false);
		}
		return lblMes;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o:");
			lblAo.setBounds(8, 81, 28, 25);
			lblAo.setVisible(false);
		}
		return lblAo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(37, 44, 80, 22);
			textField.setColumns(10);
			textField.setVisible(false);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(37, 82, 80, 22);
			textField_1.setColumns(10);
			textField_1.setVisible(false);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setVisible(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textField.getText().length()!=0 && textField_1.getText().length()!=0){
						if(Float.valueOf(textField.getText())>=1 && Float.valueOf(textField.getText())<=12){
					TableModel defaultTableModel = new TableModel();
					LinkedList<InventarioTanquesPlasticos> list = new LinkedList<InventarioTanquesPlasticos>();
					list = ServicioInventarioTanquesPlasticos.getFiltro(Float.valueOf(textField.getText()), Float.valueOf(textField_1.getText()));
					ArrayList<Object> columnDataProducto = new ArrayList<Object>();
					for (int i = 0; i < list.size(); i++) {
						columnDataProducto.add(list.get(i).getFechaplasticos());
						}
					defaultTableModel.setRowCount(list.size());							
					defaultTableModel.addColumn("Fechas de los Inventarios de Tanques Plásticos de 1000 LTS",columnDataProducto.toArray());
					getJTable().setModel(defaultTableModel);	
					getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
					getJTable().setRowHeight(20);
						}else{
							JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "El mes debe ser entre 1 y 12", "Información", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(ListaInventarioTanquesPlasticosVisual.this, "Los Campos Mes y Año no deben estar vacíos", "Información", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnNewButton.setIcon(new ImageIcon(ListaInventarioTanquesPlasticosVisual.class.getResource("/img/system-search.png")));
			btnNewButton.setToolTipText("Filtrar");
			btnNewButton.setBounds(0, 132, 145, 31);
		}
		return btnNewButton;
	}
}  //  @jve:decl-index=0:visual-constraint="209,6"
