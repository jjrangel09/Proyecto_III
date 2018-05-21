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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaAdmin extends JFrame {

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
		
		JButton btnAgregarNuevoAdministrador = new JButton("Agregar Nuevo ADMINISTRADOR");
		btnAgregarNuevoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(btnAgregarNuevoUsuario, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnAgregarNuevoAdministrador)))
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
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellido", "Nombre de Usuario", "Documento", "Edad", "Telefono"}));
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
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JLabel lblDocumento = new JLabel("Documento:");
		
		JLabel lblEdad = new JLabel("Edad:");
		
		JLabel lblTelefono = new JLabel("Telefono:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnActualizarUsuario = new JButton("Actualizar Usuario");
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrarUsuario.setForeground(Color.RED);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(95)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNombreDeUsuario)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDocumento)
								.addComponent(lblEdad)
								.addComponent(lblUsuario)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblTelefono))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(textField_1, 218, 230, Short.MAX_VALUE)
								.addComponent(textField_2, 218, 230, Short.MAX_VALUE)
								.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(btnActualizarUsuario))))
					.addGap(50)
					.addComponent(btnBorrarUsuario)
					.addGap(217))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreDeUsuario)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(52)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumento)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblEdad))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(48)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActualizarUsuario)
						.addComponent(btnBorrarUsuario))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reportes", null, panel_3, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestionar Musica", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblArtista = new JLabel("Artistas");
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnAgregar = new JButton("Agregar");
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnEliminar = new JButton("Eliminar");
		
		JLabel lblDiscos = new JLabel("Discos");
		lblDiscos.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnAgregar_1 = new JButton("Agregar");
		
		JButton btnEditar_1 = new JButton("Editar");
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		
		JLabel lblNewLabel = new JLabel("Canciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnAgregar_2 = new JButton("Agregar");
		
		JButton btnEditar_2 = new JButton("Editar");
		
		JButton btnEliminar_2 = new JButton("Eliminar");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
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
								.addComponent(btnAgregar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEditar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminar_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(176)
							.addComponent(lblDiscos)))
					.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnEditar_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAgregar_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnEliminar_2))
							.addContainerGap(124, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(119))))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
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
						.addComponent(btnAgregar_1)
						.addComponent(btnAgregar_2))
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
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Imagen", "Nombre Artista", "Album", "Cancion", "Genero", "Duracion", "Precio", "Calidad", "Tamaño (MB)" }));
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		}
}
