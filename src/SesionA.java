import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPasswordField pass;

	public SesionA() {
		boolean sesion = true;
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
				if (sesion) {
					VentanaAdmin ventanaA = new VentanaAdmin();
					ventanaA.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error!", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		
		pass = new JPasswordField();
		panel.add(pass, "cell 4 3,growx");
		panel.add(InitSesion, "cell 4 4");
	}

}
