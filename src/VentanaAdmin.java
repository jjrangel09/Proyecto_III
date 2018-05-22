import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class VentanaAdmin extends JFrame {
	private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField LeerUsuE;
	private JTextField cNombre;
	private JTextField cApe;
	private JTextField cDoc;
	private JTextField cEdad;
	private JTextField cTel;
	private JTextField cUsu;
	private JTable table_2;
	private JTextField cajaCompras;
	private JTextField textField_7;
	private JPasswordField cPass;
	private JTable table_3;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Usuarios Registrados", null, panel, null);

		JButton btnAgregarNuevoUsuario = new JButton("Agregar Nuevo USUARIO");
		btnAgregarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAgregarNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegisU iRegistro = new VentanaRegisU();
				iRegistro.setVisible(true);
				iRegistro.setLocationRelativeTo(null);
			}
		});

		JButton btnAgregarNuevoAdministrador = new JButton("Agregar Nuevo ADMINISTRADOR");
		btnAgregarNuevoAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegisA frame = new VentanaRegisA ();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnAgregarNuevoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane_1))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(btnAgregarNuevoUsuario, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnAgregarNuevoAdministrador)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAgregarNuevoAdministrador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAgregarNuevoUsuario, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Administradores", null, panel_5, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JButton btnMostrar_1 = new JButton("Mostrar");
		btnMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTabla(2);
				llenartablaA();
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(279)
							.addComponent(btnMostrar_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMostrar_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellido", "Nombre de administrador", "Documento", "Edad", "Telefono" }));
		
		scrollPane_3.setViewportView(table_3);
		
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Usuarios", null, panel_4, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
				
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
			new String[] { "Nombre", "Apellido", "Nombre de Usuario", "Documento", "Edad", "Telefono" }));
		
		scrollPane_1.setViewportView(table_1);
						
						JButton btnMostrar = new JButton("Mostrar");
						btnMostrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								limpiarTabla(1);
								llenarTablaU();
							}
						});
						GroupLayout gl_panel_4 = new GroupLayout(panel_4);
						gl_panel_4.setHorizontalGroup(
							gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_4.createSequentialGroup()
											.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
											.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
											.addComponent(btnMostrar, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
											.addGap(258))))
						);
						gl_panel_4.setVerticalGroup(
							gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addContainerGap()
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnMostrar, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
									.addGap(18))
						);
						panel_4.setLayout(gl_panel_4);
		
		panel.setLayout(gl_panel);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Buscar Usuarios", null, panel_1, null);

		LeerUsuE = new JTextField();
		LeerUsuE.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = LeerUsuE.getText();
				try {
					String query = "SELECT * FROM usuarios WHERE usuario = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, usuario);

		            ResultSet resultado = sentenciaP.executeQuery();
		            if((LeerUsuE.getText().trim().equals(""))) {
	            		JOptionPane.showMessageDialog(null, "Ingrese datos", "Error!", JOptionPane.ERROR_MESSAGE, null);
	            	}
		            else {
		            	while (resultado.next()) {  	
			            	if(resultado.getString("usuario").equals(usuario)) {
			            		cNombre.setText(resultado.getString("nombreU"));
			            		cApe.setText(resultado.getString("apelU"));
			            		cUsu.setText(resultado.getString("usuario"));
			            		cPass.setText(resultado.getString("pass"));
			            		cDoc.setText(resultado.getString("doc"));
			            		cEdad.setText(resultado.getString("edad"));
			            		cTel.setText(resultado.getString("tel"));
			            		
			            	}else if(!resultado.getString("usuario").equals(usuario)){
			            		JOptionPane.showMessageDialog(null, "Usuario inexistente!", "Error!", JOptionPane.ERROR_MESSAGE, null);
			            	}
			            }
		            } 
		            sentenciaP.close();
		            database.close();		            
		        } catch (SQLException ae) {
		        	JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error!", JOptionPane.ERROR_MESSAGE, null);
		            //System.out.println(e.getMessage());
		        }
			}
		});

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");

		JLabel lblNombre = new JLabel("Nombre:");

		cNombre = new JTextField();
		cNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		cNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");

		cApe = new JTextField();
		cApe.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		cApe.setColumns(10);

		JLabel lblUsuario = new JLabel("Nombre usuario:");

		JLabel lblDocumento = new JLabel("Documento:");

		JLabel lblEdad = new JLabel("Edad:");

		JLabel lblTelefono = new JLabel("Telefono:");

		cDoc = new JTextField();
		cDoc.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cDoc.setColumns(10);

		cEdad = new JTextField();
		cEdad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cEdad.setColumns(10);

		cTel = new JTextField();
		cTel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cTel.setColumns(10);

		cUsu = new JTextField();
		cUsu.setColumns(10);

		JButton btnActualizarUsuario = new JButton("Actualizar Usuario");
		btnActualizarUsuario.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String usuario = LeerUsuE.getText();
				try {
					String query = "UPDATE usuarios SET usuario = ?, nombreU = ?, apelU = ?, doc = ?, edad = ?, tel = ?, pass = ? WHERE usuario = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, usuario);

		            //ResultSet resultado = sentenciaP.executeQuery();
		            
		            if((LeerUsuE.getText().trim().equals(""))) {
	            		JOptionPane.showMessageDialog(null, "Ingrese datos", "Error!", JOptionPane.ERROR_MESSAGE, null);
	            	}
		            else {
		            	sentenciaP.setString(1, cUsu.getText());
		            	sentenciaP.setString(2, cNombre.getText());
		            	sentenciaP.setString(3, cApe.getText());
		            	sentenciaP.setString(4, cDoc.getText());
		            	sentenciaP.setString(5, cEdad.getText());
		            	sentenciaP.setString(6, cTel.getText());
		            	sentenciaP.setString(7, cPass.getText());
		            	sentenciaP.setString(8, cUsu.getText());
		            	sentenciaP.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
		            } 
		            
		            sentenciaP.close();
		            database.close();		            
		        } catch (SQLException ae) {
		        	JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error!", JOptionPane.ERROR_MESSAGE, null);
		            System.out.println(ae.getMessage());
		        }
			}
		});

		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrarUsuario.setForeground(Color.RED);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		cPass = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addGap(95)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNombreDeUsuario).addGap(18)
										.addComponent(LeerUsuE, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addGap(18).addComponent(btnBuscar))
								.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
										.addComponent(lblApellido).addComponent(lblTelefono).addComponent(lblEdad)
										.addComponent(lblContrasea).addComponent(lblUsuario).addComponent(lblDocumento))
										.addGap(28)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(cPass, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(cNombre, 218, 218, Short.MAX_VALUE)
												.addComponent(cApe, 218, 218, Short.MAX_VALUE)
												.addComponent(cUsu, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(cTel, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(cEdad, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(cDoc, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE))))
						.addGap(52))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(btnActualizarUsuario).addGap(95)))
				.addComponent(btnBorrarUsuario).addGap(209)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(65)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNombreDeUsuario)
								.addComponent(LeerUsuE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addGap(52)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(cNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cApe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(cPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDocumento))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdad))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(cTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefono))
						.addGap(53).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorrarUsuario).addComponent(btnActualizarUsuario))
						.addContainerGap(91, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reportes", null, panel_3, null);

		JScrollPane scrollPane_2 = new JScrollPane();

		cajaCompras = new JTextField();
		cajaCompras.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cajaCompras.setColumns(10);

		JButton btnConsultarCom = new JButton("Consultar compras");

		JButton botonAlbum = new JButton("Album");

		JButton botonArtista = new JButton("Artista");

		JButton botonCanciones = new JButton("Canciones");

		JLabel lblIngresarFecha = new JLabel("Ingresar fecha inicial (DD-MM-YYYY)");

		JLabel lblNewLabel_1 = new JLabel("Ingresar fecha final (DD-MM-YYYY)");

		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		textField_7.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(scrollPane_2,
								GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup().addGap(24).addComponent(lblIngresarFecha))
								.addGroup(gl_panel_3.createSequentialGroup().addGap(47).addComponent(cajaCompras,
										GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
								.addGap(45)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup().addGap(10)
												.addComponent(textField_7).addGap(154)
												.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
														.addComponent(botonAlbum, GroupLayout.DEFAULT_SIZE, 127,
																Short.MAX_VALUE)
														.addComponent(botonArtista, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(botonCanciones, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnConsultarCom, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
										.addComponent(lblNewLabel_1))))
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_3
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE).addGap(18)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(lblIngresarFecha))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(btnConsultarCom)
						.addComponent(cajaCompras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(botonAlbum).addGap(18).addComponent(botonArtista).addGap(18)
				.addComponent(botonCanciones).addContainerGap()));

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha inicial", "Fecha final", "Nombre", "Canciones compradas" }));

		scrollPane_2.setViewportView(table_2);
		panel_3.setLayout(gl_panel_3);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestionar Musica", null, panel_2, null);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblArtista = new JLabel("Artistas");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarArtista frame = new AgregarArtista();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarArtista frame = new editarArtista();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarArtista frame = new eliminarArtista();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JLabel lblDiscos = new JLabel("Discos");
		lblDiscos.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarAlbum frame = new editarAlbum();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarAlbum frame = new eliminarAlbum();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JLabel lblNewLabel = new JLabel("Canciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnAgregar_2 = new JButton("Agregar");
		btnAgregar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarMusica frame = new agregarMusica();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JButton btnEditar_2 = new JButton("Editar");
		btnEditar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarMusica frame = new editarMusica();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

		JButton btnEliminar_2 = new JButton("Eliminar");
		btnEliminar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarMusica frame = new EliminarMusica();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		JButton btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAlbum frame = new AgregarAlbum();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAgregar)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnEditar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnEliminar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(162)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnEditar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAgregar_1)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(176)
							.addComponent(lblDiscos)))
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnEditar_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAgregar_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnEliminar_2))
							.addContainerGap(133, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(119))))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblArtista)
						.addComponent(lblDiscos))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnAgregar_2)
						.addComponent(btnAgregar_1))
					.addGap(49)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnEditar_1)
						.addComponent(btnEditar_2))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnEliminar_1)
						.addComponent(btnEliminar_2))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Imagen", "Nombre Artista", "Album",
				"Cancion", "Genero", "Duracion", "Precio", "Calidad", "Tamaño (MB)" }));
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);

	}
	
	public void limpiarTabla(int a) {
		DefaultTableModel tb = (DefaultTableModel) table_1.getModel();
		DefaultTableModel tb3 = (DefaultTableModel) table_3.getModel();
		int f = table_1.getRowCount()-1;
		int g = table_3.getRowCount()-1;
		switch(a) {
			case 1:
				for(int i = f; i >=0; i--) {
					tb.removeRow(tb.getRowCount()-1);
				}
			case 2:
				for(int j = g; j>=0; j-- ) {
					tb3.removeRow(tb3.getRowCount()-1);
				}
		}
	}
	
	public void llenarTablaU() {
		DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
		try {
			String query = "SELECT * FROM usuarios;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();
			while(resultado.next()) {
				model_1.addRow(new Object[] {resultado.getString("nombreU"), resultado.getString("apelU"), resultado.getString("usuario"),resultado.getString("doc"),resultado.getString("edad"),resultado.getString("tel")});
			}
			
			sentenciaP.close();
			database.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
		}
	}
	
	public void llenartablaA() {
		DefaultTableModel model_2 = (DefaultTableModel) table_3.getModel();
		try {
			String query = "SELECT * FROM administradores;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();

			while (resultado.next()) {
				model_2.addRow(new Object[] { resultado.getString("nombreA"), resultado.getString("apelA"),
						resultado.getString("usuario"), resultado.getString("doc"), resultado.getString("edad"), resultado.getString("tel") });
			}

			sentenciaP.close();
			database.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
