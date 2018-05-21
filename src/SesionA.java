import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SesionA extends JFrame {

	private JPanel contentPane;
	private JTextField User;
	private JTextField pass;

	public SesionA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][][][][][][grow]", "[][][][][]"));
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		panel.add(lblIniciarSesion, "cell 1 0");
		
		JLabel lblUsuario = new JLabel("Usuario:");
		panel.add(lblUsuario, "cell 1 2 2 1");
		
		User = new JTextField();
		panel.add(User, "cell 4 2,growx");
		User.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		panel.add(lblPass, "cell 1 3 2 1");
		
		pass = new JTextField();
		panel.add(pass, "cell 4 3,growx");
		pass.setColumns(10);
		
		JButton InitSesion = new JButton("Iniciar Sesion");
		panel.add(InitSesion, "cell 4 4");
	}

}
