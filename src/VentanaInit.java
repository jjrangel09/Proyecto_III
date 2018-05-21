import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaInit extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		
		VentanaInit frame = new VentanaInit();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public VentanaInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 250, 290, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBienvenidoAlSistema = new JLabel(
				"Bienvenido a MUSICAUDEC2018.");

		JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione un rol para continuar.");

		JButton btnListadoDeAutomoviles = new JButton("Administrador");
		btnListadoDeAutomoviles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				SesionA sesion = new SesionA();
				sesion.setVisible(true);
				sesion.setLocationRelativeTo(null);
			}
		});
		JButton btnAsignacionDePuntajes = new JButton("Usuarios");
		btnAsignacionDePuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				SesionU iVentanaU = new SesionU();
				iVentanaU.setVisible(true);
				iVentanaU.setLocationRelativeTo(null);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListadoDeAutomoviles, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
						.addComponent(btnAsignacionDePuntajes, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblSeleccioneUnaOpcion)
							.addComponent(lblBienvenidoAlSistema)))
					.addGap(102))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblBienvenidoAlSistema)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSeleccioneUnaOpcion)
					.addGap(35)
					.addComponent(btnListadoDeAutomoviles)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAsignacionDePuntajes)
					.addGap(130))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
