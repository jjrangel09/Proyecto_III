import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class SesionA extends JFrame {

	private JPanel contentPane;
	private JTextField User;
	static private DBManager database = new DBManager();
	private JPasswordField pass;

	public SesionA() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][][][grow][][][grow]", "[][][][][]"));

		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		panel.add(lblIniciarSesion, "cell 1 0");

		JLabel lblUsuario = new JLabel("Usuario:");
		panel.add(lblUsuario, "cell 1 2 2 1");

		User = new JTextField();
		panel.add(User, "cell 4 2,growx");
		User.setColumns(10);

		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		panel.add(lblPass, "cell 1 3 2 1");

		JButton InitSesion = new JButton("Iniciar Sesion");
		InitSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				VentanaAdmin ventana = new VentanaAdmin();
        		ventana.setVisible(true);
				/*String usuario = User.getText();
				String contrasena = pass.getText();
				try {
					String query = "SELECT pass FROM administradores WHERE usuario = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, usuario);

		            ResultSet resultado = sentenciaP.executeQuery();

		            while (resultado.next()) {
		            	if(resultado.getString("pass").equals(contrasena)) {
		            		VentanaAdmin ventana = new VentanaAdmin();
		            		ventana.setVisible(true);
		            	}
		                
		            }
		            
		            sentenciaP.close();
		            database.close();		            
		        } catch (SQLException e) {
		        	JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error!", JOptionPane.ERROR_MESSAGE, null);
		            System.out.println(e.getMessage());
		        }*/
			};
		});
		
		pass = new JPasswordField();
		panel.add(pass, "cell 4 3,growx");
		panel.add(InitSesion, "cell 4 4");
	}

}
