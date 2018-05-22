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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_2;
	private JTextField cajaCompras;
	private JTextField textField_7;
	private JPasswordField passwordField;

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

		JScrollPane scrollPane_1 = new JScrollPane();

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
		btnAgregarNuevoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(btnAgregarNuevoUsuario, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnAgregarNuevoAdministrador))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAgregarNuevoAdministrador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAgregarNuevoUsuario, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addGap(47)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellido", "Nombre de Usuario", "Documento", "Edad", "Telefono" }));
		DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
		try {
			String query = "SELECT * FROM usuarios;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();

			while (resultado.next()) {
				model_1.addRow(new Object[] { resultado.getString("nombreU"), resultado.getString("apelU"),
						resultado.getString("usuario"), resultado.getString("doc"), resultado.getString("edad"), resultado.getString("tel") });
			}

			sentenciaP.close();
			database.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		scrollPane_1.setViewportView(table_1);
		panel.setLayout(gl_panel);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Buscar Usuarios", null, panel_1, null);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");

		JLabel lblNombre = new JLabel("Nombre:");

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		textField_1.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		textField_2.setColumns(10);

		JLabel lblUsuario = new JLabel("Nombre usuario:");

		JLabel lblDocumento = new JLabel("Documento:");

		JLabel lblEdad = new JLabel("Edad:");

		JLabel lblTelefono = new JLabel("Telefono:");

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if (Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		JButton btnActualizarUsuario = new JButton("Actualizar Usuario");

		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrarUsuario.setForeground(Color.RED);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		passwordField = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addGap(95)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNombreDeUsuario).addGap(18)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addGap(18).addComponent(btnBuscar))
								.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
										.addComponent(lblApellido).addComponent(lblTelefono).addComponent(lblEdad)
										.addComponent(lblContrasea).addComponent(lblUsuario).addComponent(lblDocumento))
										.addGap(28)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(textField_1, 218, 218, Short.MAX_VALUE)
												.addComponent(textField_2, 218, 218, Short.MAX_VALUE)
												.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE)
												.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 218,
														Short.MAX_VALUE))))
						.addGap(52))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(btnActualizarUsuario).addGap(95)))
				.addComponent(btnBorrarUsuario).addGap(209)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(65)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNombreDeUsuario)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addGap(52)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDocumento))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdad))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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

		JButton btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAlbum frame = new AgregarAlbum();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});

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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(98)
						.addGroup(gl_panel_2
								.createParallelGroup(Alignment.LEADING)
								.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAgregar)
								.addGroup(gl_panel_2
										.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnEditar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEliminar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
								.createSequentialGroup().addGap(162)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnAgregar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnEditar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnEliminar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(176).addComponent(lblDiscos)))
						.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnEditar_2, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnAgregar_2, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(btnEliminar_2))
										.addContainerGap(124, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel).addGap(119))))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(24)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblArtista).addComponent(lblDiscos))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnAgregar)
								.addComponent(btnAgregar_1).addComponent(btnAgregar_2))
						.addGap(49)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnEditar)
								.addComponent(btnEditar_1).addComponent(btnEditar_2))
						.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnEliminar)
								.addComponent(btnEliminar_1).addComponent(btnEliminar_2))
						.addGap(35)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Imagen", "Nombre Artista", "Album",
				"Cancion", "Genero", "Duracion", "Precio", "Calidad", "Tamaño (MB)" }));
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);

	}
}
