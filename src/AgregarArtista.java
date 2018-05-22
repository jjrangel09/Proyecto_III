import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class AgregarArtista extends JFrame {
	private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public AgregarArtista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAgregarArtista = new JLabel("Agregar artista");

		JLabel lblNewLabel = new JLabel("Nombre del artista");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if ((textField.getText().trim().equals(""))) {
						JOptionPane.showMessageDialog(null, "Gestione todos los campos");
					} else {
						String query = "INSERT INTO `artistas` (`artista`, `vendido`) VALUES (?,?);";
						PreparedStatement sentenciaP = database.open().prepareStatement(query);
						sentenciaP.setString(1, textField.getText());
						sentenciaP.setInt(2, 0);
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(41))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(120, Short.MAX_VALUE)
								.addComponent(lblAgregarArtista).addGap(115))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(107).addComponent(btnAgregar)
						.addContainerGap(130, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(26).addComponent(lblAgregarArtista).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnAgregar).addContainerGap(58, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
