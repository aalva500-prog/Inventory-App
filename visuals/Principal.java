package visuals;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Utils.CurrentUser;
import Utils.Idioma;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;




public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar mainMenuBar = null;

	private JMenu FileMenu = null;

	private JMenuItem jMenuItem1 = null;
	private Principio owner = null;

	private JMenuItem jMenuItemAutenticar = null;

	private JMenuItem UsuariosjMenuItem = null;

	private JMenuItem jMenuItemBackup = null;

	private JMenu jMenu = null;

	private JMenuItem jMenuItem = null;

	private JMenuItem jMenuItem2 = null;

	private JLabel jLabel = null;

	private JMenuItem InformesPizarrajMenuItem3 = null;

	private JMenuItem jMenuItem3 = null;

	private JMenuItem MateriasPrimasjMenuItem4 = null;

	private JMenuItem ProveedoresjMenuItem4 = null;

	private JMenu DatosjMenu1 = null;

	private JMenu InventariosjMenu1 = null;

	private JMenuItem AditivosjMenuItem4 = null;

	private JMenuItem TanquesAcerojMenuItem4 = null;

	private JMenuItem TanquesPlasticosjMenuItem4 = null;

	private JMenuItem BidonesjMenuItem4 = null;

	/**
	 * This is the default constructor
	 */
	public Principal(Principio parent) {
		super();
		this.owner = parent;
		initialize();
		}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(1006, 804));	
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/inventario.png")));
		this.setJMenuBar(getMainMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Principal");
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosed(java.awt.event.WindowEvent e) {    
				getOwner().dispose();
			}
			public void windowOpened(java.awt.event.WindowEvent e) {
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Administrador")){
					getUsuariosjMenuItem().setVisible(true);
				}
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Invitado")){
					getUsuariosjMenuItem().setVisible(false);
				}
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
			jContentPane = new JPanel();
			GridBagLayout gbl_jContentPane = new GridBagLayout();
			gbl_jContentPane.columnWidths = new int[]{1002, 0};
			gbl_jContentPane.rowHeights = new int[]{735, 0};
			gbl_jContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_jContentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			jContentPane.setLayout(gbl_jContentPane);
			jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("/Img/inventarios.png")));
			GridBagConstraints gbc_jLabel = new GridBagConstraints();
			gbc_jLabel.fill = GridBagConstraints.BOTH;
			gbc_jLabel.gridx = 0;
			gbc_jLabel.gridy = 0;
			jContentPane.add(jLabel, gbc_jLabel);
			}
		return jContentPane;
	}

	/**
	 * This method initializes mainMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMainMenuBar() {
		if (mainMenuBar == null) {
			mainMenuBar = new JMenuBar();
			mainMenuBar.add(getFileMenu());
			mainMenuBar.add(getJMenu());
			}
		return mainMenuBar;
	}

	/**
	 * This method initializes FileMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (FileMenu == null) {
			FileMenu = new JMenu();
			FileMenu.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_FilesAndFolders_32x32.png")));
			FileMenu.add(getUsuariosjMenuItem());
			FileMenu.add(getJMenuItemAutenticar());
			FileMenu.add(getJMenuItemBackup());
			FileMenu.add(getJMenuItem1());			
		}
		return FileMenu;
	}

	
	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Salir");
			jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Delete_16x16.png")));
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(DISPOSE_ON_CLOSE);
				}
			});
		}
		return jMenuItem1;
	}

	public void idioma(){
		if(Idioma.getInstance().getIdioma().equalsIgnoreCase("ingles")){
			FileMenu.setText("File");
			jMenuItem1.setText("Exit");
			jMenuItemAutenticar.setText("Change User");
			UsuariosjMenuItem.setText("Users");
			this.setTitle("Main");
			}
		}

	public Principal returnThis(){
		return this;
	}

	public Principio getOwner() {
		return owner;
	}

	/**
	 * This method initializes jMenuItemAutenticar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAutenticar() {
		if (jMenuItemAutenticar == null) {
			jMenuItemAutenticar = new JMenuItem();
			jMenuItemAutenticar.setText("Cambiar Usuario");
			jMenuItemAutenticar.setIcon(new ImageIcon(getClass().getResource("/Img/edit_user.png")));
			jMenuItemAutenticar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
					Principio r = new Principio();
					r.setVisible(true);
				}
			});
		}
		return jMenuItemAutenticar;
	}

	/**
	 * This method initializes UsuariosjMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getUsuariosjMenuItem() {
		if (UsuariosjMenuItem == null) {
			UsuariosjMenuItem = new JMenuItem();
			UsuariosjMenuItem.setText("Usuarios");
			UsuariosjMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/add_user.png")));
			UsuariosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new Usuarios(Principal.this,true).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()	
				}
			});
		}
		return UsuariosjMenuItem;
	}

	/**
	 * This method initializes jMenuItemBackup	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemBackup() {
		if (jMenuItemBackup == null) {
			jMenuItemBackup = new JMenuItem();
			jMenuItemBackup.setText("Backup");
			jMenuItemBackup.setIcon(new ImageIcon(getClass().getResource("/Img/save_edit.png")));
			jMenuItemBackup.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new Backup(Principal.this,true).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()					
				}
			});
		}
		return jMenuItemBackup;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setIcon(new ImageIcon(getClass().getResource("/Img/gestion.png")));
			jMenu.add(getDatosjMenu1());
			jMenu.add(getInventariosjMenu1());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/ICONO-producto.png")));
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ProductoVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/nuestros_clientes.png")));
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ClienteVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes InformesPizarrajMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getInformesPizarrajMenuItem3() {
		if (InformesPizarrajMenuItem3 == null) {
			InformesPizarrajMenuItem3 = new JMenuItem();
			InformesPizarrajMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Img/informes pizarra.png")));
			InformesPizarrajMenuItem3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							dispose();
							new ListaInformesPizarraVisual().setVisible(true);
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return InformesPizarrajMenuItem3;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
		    jMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Img/Placas.png")));
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioPlacasVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItem3;
	}

	/**
	 * This method initializes MateriasPrimasjMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasjMenuItem4() {
		if (MateriasPrimasjMenuItem4 == null) {
			MateriasPrimasjMenuItem4 = new JMenuItem();
			MateriasPrimasjMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/Materias_primas.png")));
			MateriasPrimasjMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new MateriaPrimaVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MateriasPrimasjMenuItem4;
	}

	/**
	 * This method initializes ProveedoresjMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getProveedoresjMenuItem4() {
		if (ProveedoresjMenuItem4 == null) {
			ProveedoresjMenuItem4 = new JMenuItem();
			ProveedoresjMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/proveedores.png")));
			ProveedoresjMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ProveedorVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ProveedoresjMenuItem4;
	}

	/**
	 * This method initializes DatosjMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getDatosjMenu1() {
		if (DatosjMenu1 == null) {
			DatosjMenu1 = new JMenu();
			DatosjMenu1.setIcon(new ImageIcon(getClass().getResource("/Img/pae_12950047242961245.png")));
			DatosjMenu1.add(getProveedoresjMenuItem4());
			DatosjMenu1.add(getMateriasPrimasjMenuItem4());
			DatosjMenu1.add(getJMenuItem());
			DatosjMenu1.add(getJMenuItem2());
		}
		return DatosjMenu1;
	}

	/**
	 * This method initializes InventariosjMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getInventariosjMenu1() {
		if (InventariosjMenu1 == null) {
			InventariosjMenu1 = new JMenu();
			InventariosjMenu1.setIcon(new ImageIcon(getClass().getResource("/Img/MenuInventarios.png")));
			InventariosjMenu1.add(getInformesPizarrajMenuItem3());
			InventariosjMenu1.add(getJMenuItem3());
			InventariosjMenu1.add(getAditivosjMenuItem4());
			InventariosjMenu1.add(getTanquesAcerojMenuItem4());
			InventariosjMenu1.add(getTanquesPlasticosjMenuItem4());
			InventariosjMenu1.add(getBidonesjMenuItem4());
		}
		return InventariosjMenu1;
	}

	/**
	 * This method initializes AditivosjMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAditivosjMenuItem4() {
		if (AditivosjMenuItem4 == null) {
			AditivosjMenuItem4 = new JMenuItem();
			AditivosjMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/aditivos.png")));
			AditivosjMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioAditivosVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return AditivosjMenuItem4;
	}

	/**
	 * This method initializes TanquesAcerojMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTanquesAcerojMenuItem4() {
		if (TanquesAcerojMenuItem4 == null) {
			TanquesAcerojMenuItem4 = new JMenuItem();
			TanquesAcerojMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/tanque3.png")));
			TanquesAcerojMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioTanquesAceroVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return TanquesAcerojMenuItem4;
	}

	/**
	 * This method initializes TanquesPlasticosjMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTanquesPlasticosjMenuItem4() {
		if (TanquesPlasticosjMenuItem4 == null) {
			TanquesPlasticosjMenuItem4 = new JMenuItem();
			TanquesPlasticosjMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/tanquesplasticos.png")));
			TanquesPlasticosjMenuItem4.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							dispose();
							new ListaInventarioTanquesPlasticosVisual().setVisible(true);
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return TanquesPlasticosjMenuItem4;
	}

	/**
	 * This method initializes BidonesjMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getBidonesjMenuItem4() {
		if (BidonesjMenuItem4 == null) {
			BidonesjMenuItem4 = new JMenuItem();
			BidonesjMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Img/bidones.png")));
			BidonesjMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListaInventarioBidonesVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return BidonesjMenuItem4;
	}

	
}  //  @jve:decl-index=0:visual-constraint="243,38"
