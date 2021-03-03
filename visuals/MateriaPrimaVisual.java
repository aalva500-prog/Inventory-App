package visuals;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.MateriaPrima;
import services.ServicioMateriaPrima;
import Utils.FormatoTabla;
import Utils.TableModel;
import Utils.UserInterfaceSuport;

public class MateriaPrimaVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JButton InsertarjButton = null;
	private JButton ModificarjButton = null;
	private JButton EliminarjButton = null;
	private JButton SalirjButton = null;
	private JPanel jPanel1 = null;
	
	public MateriaPrimaVisual() {
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
		    this.setSize(new Dimension(534, 624));
		    this.setContentPane(getJPanel());
			this.setTitle("Gestionar Materias Primas");
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			EliminarjButton.setEnabled(false);
			InsertarjButton.setEnabled(true);
			ModificarjButton.setEnabled(false);
			SalirjButton.setEnabled(true);
					
			TableModel defaultTableModel = new TableModel();
			LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
			try {
				list = ServicioMateriaPrima.getMaterias();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
		        e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArrayList<Object> columnDataProducto = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				columnDataProducto.add(list.get(i).getMateria());
				}
			defaultTableModel.setRowCount(list.size());							
			defaultTableModel.addColumn("Materias Primas",columnDataProducto.toArray());
			getJTable().setModel(defaultTableModel);
			getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
			getJTable().setRowHeight(20);
			
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<MateriaPrima> users = ServicioMateriaPrima.getMaterias();
						MateriaPrima u = users.get(pos);
						jTextField.setText(u.getMateria());
						
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
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(5, 4, 2, 8);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 503;
			gridBagConstraints2.ipady = 135;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 51;
			gridBagConstraints1.ipady = 7;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(3, 6, 5, 6);
			jLabel = new JLabel();
			jLabel.setText("Materia Prima:");
			jLabel.setBounds(new Rectangle(6, 10, 98, 26));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJScrollPane(), gridBagConstraints1);
			jPanel.add(getJPanel1(), gridBagConstraints2);
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
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(6, 35, 452, 38));
		}
		return jTextField;
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
			InsertarjButton.setBounds(new Rectangle(6, 88, 104, 38));
			InsertarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
						try {
							ServicioMateriaPrima.insertarMateria(jTextField.getText());
							TableModel defaultTableModel = new TableModel();
							LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
							try {
								list = ServicioMateriaPrima.getMaterias();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
						        e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object> columnDataProducto = new ArrayList<Object>();
							for (int i = 0; i < list.size(); i++) {
								columnDataProducto.add(list.get(i).getMateria());
								}
							defaultTableModel.setRowCount(list.size());							
							defaultTableModel.addColumn("Materias Primas",columnDataProducto.toArray());
							getJTable().setModel(defaultTableModel);	
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
							getJTable().setRowHeight(20);
							JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "Materia Prima Insertada", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "Ya Existe la Materia Prima", "Información", JOptionPane.ERROR_MESSAGE);	
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
			ModificarjButton.setText("Modificar");
			ModificarjButton.setBounds(new Rectangle(119, 88, 116, 38));
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					int result = JOptionPane.showConfirmDialog(MateriaPrimaVisual.this, "¿Está seguro que desea modificar la Materia Prima?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<MateriaPrima> users = ServicioMateriaPrima.getMaterias();
						MateriaPrima u = users.get(pos);	
						ServicioMateriaPrima.ModificarMateria(u.getId_materia(), jTextField.getText());
						JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "Materia Prima Modificada", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
						try {
							list = ServicioMateriaPrima.getMaterias();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
					        e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getMateria());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Materias Primas",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(getJPanel1());
											
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "Ya Existe la Materia Prima", "Información", JOptionPane.ERROR_MESSAGE);	
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setBounds(new Rectangle(242, 88, 104, 38));
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(MateriaPrimaVisual.this, "¿Está seguro que desea Eliminar la Materia Prima?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					try {
						LinkedList<MateriaPrima> users = ServicioMateriaPrima.getMaterias();
						MateriaPrima u = users.get(pos);
						ServicioMateriaPrima.EliminarMateria(u.getId_materia());
						JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "Materia Prima Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						InsertarjButton.setEnabled(true);
						TableModel defaultTableModel = new TableModel();
						LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
						try {
							list = ServicioMateriaPrima.getMaterias();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
					        e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataProducto = new ArrayList<Object>();
						for (int i = 0; i < list.size(); i++) {
							columnDataProducto.add(list.get(i).getMateria());
							}
						defaultTableModel.setRowCount(list.size());							
						defaultTableModel.addColumn("Materias Primas",columnDataProducto.toArray());
						getJTable().setModel(defaultTableModel);	
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());		
						getJTable().setRowHeight(20);
						UserInterfaceSuport.clearComponents(getJPanel1());
											
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(MateriaPrimaVisual.this, "No se Puede Eliminar la Materia Prima porque existen relaciones que la implican", "Información", JOptionPane.ERROR_MESSAGE);
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
	 * This method initializes SalirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalirjButton() {
		if (SalirjButton == null) {
			SalirjButton = new JButton();
			SalirjButton.setText("Menú Principal");
			SalirjButton.setBounds(new Rectangle(353, 88, 140, 38));
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
			jPanel1.add(getJTextField(), null);
			jPanel1.add(jLabel, null);
			jPanel1.add(getInsertarjButton(), null);
			jPanel1.add(getModificarjButton(), null);
			jPanel1.add(getEliminarjButton(), null);
			jPanel1.add(getSalirjButton(), null);
		}
		return jPanel1;
	}

}  //  @jve:decl-index=0:visual-constraint="175,2"
