import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class SesionU extends JFrame {

	private JPanel contentPane;
	private JTextField cajaUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */	

	/**
	 * Create the frame.
	 */
	public SesionU() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel LabelUser = new JLabel("Usuario");
		
		JButton botonIngre = new JButton("Ingresar");
		botonIngre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsu ventanaU = new VentanaUsu();
				ventanaU.setVisible(true);
				ventanaU.setLocationRelativeTo(null);
			}
		});
		
		JButton botonRe = new JButton("Registrar");
		botonRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegisU iRegistro = new VentanaRegisU();
				iRegistro.setVisible(true);
				iRegistro.setLocationRelativeTo(null);
			}
		});
		
		JLabel LaberPass = new JLabel("Contrase\u00F1a");
		
		cajaUser = new JTextField();
		cajaUser.setColumns(10);
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(botonIngre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addComponent(botonRe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
					.addGap(58))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(cajaUser, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(LabelUser)))
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(LaberPass)
							.addGap(69))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(44))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LaberPass)
						.addComponent(LabelUser))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(botonIngre)
					.addGap(18)
					.addComponent(botonRe)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
