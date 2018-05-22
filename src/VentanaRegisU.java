import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentanaRegisU extends JFrame {
	 private static DBManager database = new DBManager();
	private JPanel contentPane;
	private JTextField cajaNombre;
	private JTextField cajaApel;
	private JTextField cajaUser;
	private JTextField cajaDoc;
	private JTextField cajaEd;
	private JTextField cajaTel;
	private JPasswordField cajaContra;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaRegisU() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 424);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblDocumento = new JLabel("Documento");
		
		JLabel lblEdad = new JLabel("Edad");
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		cajaNombre = new JTextField();
		cajaNombre.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		cajaNombre.setColumns(10);
		
		cajaApel = new JTextField();
		cajaApel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo letras");
				}
			}
		});
		cajaApel.setColumns(10);
		
		cajaUser = new JTextField();
		cajaUser.setColumns(10);
		
		cajaDoc = new JTextField();
		cajaDoc.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cajaDoc.setColumns(10);
		
		cajaEd = new JTextField();
		cajaEd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cajaEd.setColumns(10);
		
		cajaTel = new JTextField();
		cajaTel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "              Solo numeros");
				}
			}
		});
		cajaTel.setColumns(10);
		
		JButton botonIngreU = new JButton("Ingresar");
		botonIngreU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if((cajaUser.getText().trim().equals("")) || (cajaNombre.getText().trim().equals("")) || (cajaApel.getText().trim().equals("")) || (cajaDoc.getText().trim().equals("")) || (cajaEd.getText().trim().equals("")) || (cajaTel.getText().trim().equals("")) || (cajaContra.getText().trim().equals(""))) {
						JOptionPane.showMessageDialog(null, "Gestione todos los campos");
					}
					else {
		            String query = "INSERT INTO `usuarios` (`usuario`, `nombreU`, `apelU`, `doc`, `edad`, `tel`, `pass`) VALUES (?,?,?,?,?,?,?);";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, cajaUser.getText());
		            sentenciaP.setString(2, cajaNombre.getText());
		            sentenciaP.setString(3, cajaApel.getText());
		            sentenciaP.setString(4, cajaDoc.getText());
		            sentenciaP.setString(5, cajaEd.getText());
		            sentenciaP.setString(6, cajaTel.getText());
		            sentenciaP.setString(7, cajaContra.getText());
		            
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
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		cajaContra = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblNewLabel)
								.addComponent(lblContrasea)
								.addComponent(lblDocumento)
								.addComponent(lblTelefono)
								.addComponent(lblEdad))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cajaTel)
								.addComponent(cajaEd)
								.addComponent(cajaDoc)
								.addComponent(cajaUser)
								.addComponent(cajaApel)
								.addComponent(cajaNombre)
								.addComponent(cajaContra)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(lblRegistroDeUsuario))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(botonIngreU)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblRegistroDeUsuario)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(cajaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(cajaApel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cajaUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(cajaContra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDocumento))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdad))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addGap(27)
					.addComponent(botonIngreU)
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
