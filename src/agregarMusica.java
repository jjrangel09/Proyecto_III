import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class agregarMusica extends JFrame {
	private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTextField nombreC;
	private JTextField duracion;
	private JTextField genero;
	private JTextField calidad;
	private JTextField size;
	private JTextField precio;


	@SuppressWarnings("unchecked")
	public agregarMusica() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 315, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAgregarMusica = new JLabel("Agregar canciones");

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblDuracion = new JLabel("Duracion");

		JLabel lblPrecio = new JLabel("Precio");

		JLabel lblCalidad = new JLabel("Calidad");

		JLabel lblTamao = new JLabel("Tama\u00F1o");

		JLabel lblNewLabel = new JLabel("Album");

		JLabel lblArtista = new JLabel("Artista");

		JLabel lblGenero = new JLabel("Genero");

		nombreC = new JTextField();
		nombreC.setColumns(10);

		duracion = new JTextField();
		duracion.setColumns(10);

		genero = new JTextField();
		genero.setColumns(10);

		calidad = new JTextField();
		calidad.setColumns(10);

		size = new JTextField();
		size.setColumns(10);

		precio = new JTextField();
		precio.setColumns(10);
		@SuppressWarnings("rawtypes")
		JComboBox comboAlbum = new JComboBox();
		@SuppressWarnings("rawtypes")
		JComboBox comboArt = new JComboBox();
		comboArt.addItem("Seleccione");
		try {
			String query = "SELECT * FROM artistas;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();

			while (resultado.next()) {
				comboArt.addItem(resultado.getString("artista"));
			}

			sentenciaP.close();
			database.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		comboArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llenaCombo(comboArt.getSelectedItem().toString());
			}
			
			private void llenaCombo(String setArt) {
				comboAlbum.removeAllItems();
				try {
					String query = "SELECT album FROM albumes WHERE artista = ?;";
					PreparedStatement sentenciaP = database.open().prepareStatement(query);
					sentenciaP.setString(1, setArt);
					ResultSet resultado = sentenciaP.executeQuery();

					while (resultado.next()) {
						comboAlbum.addItem(resultado.getString("album"));
					}

					sentenciaP.close();
					database.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}});

		
	

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if ((nombreC.getText().trim().equals("")) || (duracion.getText().trim().equals(""))
							|| (genero.getText().trim().equals("")) || (calidad.getText().trim().equals(""))
							|| (size.getText().trim().equals("")) || (precio.getText().trim().equals(""))
							|| (comboArt.getSelectedItem().equals("Seleccione"))
							|| (comboAlbum.getSelectedItem().equals("Seleccione"))) {
						JOptionPane.showMessageDialog(null, "Gestione todos los campos");
					} else {
						String query = "INSERT INTO `canciones` (`nombre`, `album`, `duracion`, `precio`, `calidad`, `tamaño`, `artista`, `genero`) VALUES (?,?,?,?,?,?,?,?);";
						PreparedStatement sentenciaP = database.open().prepareStatement(query);
						sentenciaP.setString(1, nombreC.getText());
						sentenciaP.setString(2, comboAlbum.getSelectedItem().toString());
						sentenciaP.setString(3, duracion.getText());
						sentenciaP.setString(4, precio.getText());
						sentenciaP.setString(5, calidad.getText());
						sentenciaP.setString(6, size.getText());
						sentenciaP.setString(7, comboArt.getSelectedItem().toString());
						
						sentenciaP.setString(8, genero.getText());
						sentenciaP.executeUpdate();
						sentenciaP.close();
						database.close();
						JOptionPane.showMessageDialog(null, "Artista agregado", "Registro exitoso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException ae) {
					JOptionPane.showMessageDialog(null, "No se ha podido agregar", "Registro incompleto",
							JOptionPane.ERROR_MESSAGE);
					ae.printStackTrace();
				}
			}
		});
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblPrecio)
								.addComponent(lblDuracion)
								.addComponent(lblCalidad)
								.addComponent(lblTamao)
								.addComponent(lblGenero)
								.addComponent(lblArtista)
								.addComponent(lblNewLabel))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboAlbum, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(duracion)
								.addComponent(precio)
								.addComponent(genero)
								.addComponent(nombreC)
								.addComponent(size)
								.addComponent(calidad)
								.addComponent(comboArt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(109)
							.addComponent(lblAgregarMusica))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(btnNewButton)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAgregarMusica)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombreC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboArt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtista))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(genero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenero))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(duracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDuracion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(calidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCalidad))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addComponent(lblTamao))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
