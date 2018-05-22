import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class AgregarAlbum extends JFrame {
	private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTextField nombreA;
	private JTextField genero;
	private JTextField precio;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	@SuppressWarnings("unchecked")
	public AgregarAlbum() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Agregar album");

		JLabel lblNewLabel_1 = new JLabel("Nombre");

		JLabel lblNewLabel_2 = new JLabel("Genero");

		JLabel lblNewLabel_3 = new JLabel("Artista");
		JLabel lblPrecio = new JLabel("Precio");

		precio = new JTextField();
		precio.setColumns(10);

		nombreA = new JTextField();
		nombreA.setColumns(10);

		genero = new JTextField();
		genero.setColumns(10);

		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Seleccione");
		try {
			String query = "SELECT * FROM artistas;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();

			while (resultado.next()) {
				comboBox.addItem(resultado.getString("artista"));
			}

			sentenciaP.close();
			database.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if ((nombreA.getText().trim().equals("")) || (genero.getText().trim().equals(""))||(precio.getText().trim().equals(""))||(comboBox.getSelectedItem().equals("Seleccione"))){
						JOptionPane.showMessageDialog(null, "Gestione todos los campos");
					} else {
						String query = "INSERT INTO `albumes` (`album`, `artista`, `genero`, `imagen`, `precio`) VALUES (?,?,?,?,?);";
						PreparedStatement sentenciaP = database.open().prepareStatement(query);
						sentenciaP.setString(1, nombreA.getText());
						sentenciaP.setString(2, comboBox.getSelectedItem().toString());
						sentenciaP.setString(3, genero.getText());
						sentenciaP.setString(4, null);
						sentenciaP.setInt(5, 0);
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(21)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(lblPrecio))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(genero, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175,
										Short.MAX_VALUE)
								.addComponent(nombreA, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 175, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(93).addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(90).addComponent(btnAgregar)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(23)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(nombreA,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(genero,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(comboBox,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPrecio).addComponent(
						precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addComponent(btnAgregar).addGap(22)));
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
	
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(lblNewLabel)
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(btnAgregar)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrecio)
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
