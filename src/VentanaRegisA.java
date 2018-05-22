import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaRegisA extends JFrame {
	
	private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTextField cNombre;
	private JTextField cApellido;
	private JTextField cUsuario;
	private JTextField cEdad;
	private JTextField cTel;
	private JTextField cDoc;
	private JPasswordField cPass;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRegisA() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegistroDeAdministrador = new JLabel("Registro de administrador");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		JLabel lblDocumento = new JLabel("Documento");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if((cNombre.getText().trim().equals("")) || (cApellido.getText().trim().equals("")) || (cUsuario.getText().trim().equals("")) || (cPass.getText().trim().equals("")) || (cEdad.getText().trim().equals("")) || (cTel.getText().trim().equals("")) || (cDoc.getText().trim().equals(""))) {
						JOptionPane.showMessageDialog(null, "Gestione todos los campos");
					}
					else {
		            String query = "INSERT INTO `administradores` (`usuario`, `pass`, `nombreA`, `apelA`, `doc`, `edad`, `tel`) VALUES (?,?,?,?,?,?,?);";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, cUsuario.getText());
		            sentenciaP.setString(2, cPass.getText());
		            sentenciaP.setString(3, cNombre.getText());
		            sentenciaP.setString(4, cApellido.getText());
		            sentenciaP.setString(5, cDoc.getText());
		            sentenciaP.setString(6, cEdad.getText());
		            sentenciaP.setString(7, cTel.getText());
		            
		            sentenciaP.executeUpdate();
		            sentenciaP.close();
		            database.close();
		            JOptionPane.showMessageDialog(null, "Usuario agregado", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
					}
		        } catch (SQLException ae) {
		        	JOptionPane.showMessageDialog(null, "No se ha podido agregar", "Registro incompleto", JOptionPane.ERROR_MESSAGE);
		            //ae.printStackTrace();
		        }
			}
		});
		
		cNombre = new JTextField();
		cNombre.setColumns(10);
		
		cApellido = new JTextField();
		cApellido.setColumns(10);
		
		cUsuario = new JTextField();
		cUsuario.setColumns(10);
		
		cEdad = new JTextField();
		cEdad.setColumns(10);
		
		cTel = new JTextField();
		cTel.setColumns(10);
		
		cDoc = new JTextField();
		cDoc.setColumns(10);
		
		cPass = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAgregar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegistroDeAdministrador)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblUsuario)
								.addComponent(lblContrasea)
								.addComponent(lblEdad)
								.addComponent(lblTelefono)
								.addComponent(lblDocumento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(cApellido, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cUsuario, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cEdad, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cTel, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cDoc, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cNombre, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
								.addComponent(cPass, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))))
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistroDeAdministrador)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdad))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDocumento))
					.addGap(18)
					.addComponent(btnAgregar)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
