import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentanaUsu extends JFrame {
	static private DBManager database = new DBManager();
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField CajaBuscar;
	private JTable table_3;

	public VentanaUsu(String uSesion) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 864, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Listado de canciones", null, panel, null);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			private DefaultTableModel m;
			public void actionPerformed(ActionEvent e) {
				int seleccion = table.getSelectedRow();
				try {
					@SuppressWarnings("unused")
					String cancion, nombreC, precio;
					int copias = 1;
					if(seleccion == -1) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una cancion de la tabla!", "error", JOptionPane.ERROR_MESSAGE);
					}else {
						m = (DefaultTableModel) table.getModel();
						cancion = table.getValueAt(seleccion, 3).toString();
						nombreC = uSesion;
						precio = table.getValueAt(seleccion, 6).toString();
						try {
							String query = "INSERT INTO `cancionesv` (`cancion`, `copias`, `precio`, `nombreC`) VALUES (?,?,?,?);";
				            PreparedStatement sentenciaP = database.open().prepareStatement(query);
				            	sentenciaP.setString(1, cancion);
				            	sentenciaP.setInt(2, copias);
				            	sentenciaP.setString(3, precio);
				            	sentenciaP.setString(4, uSesion);
				            	sentenciaP.executeUpdate();
				            	JOptionPane.showMessageDialog(null, "Comprado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE, null);
					            sentenciaP.close();
					            database.close();		            
				        } catch (SQLException ae) {
				        	JOptionPane.showMessageDialog(null, "No se puede iniciar", "Error!", JOptionPane.ERROR_MESSAGE, null);
				            System.out.println(ae.getMessage());
				        }
						
					}
				} catch (Exception e2) {
					
				}
			}
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarTabla(1);
				llenarTabla1();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(180)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addContainerGap())
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Imagen", "Nombre Artista", "Album",
				"Cancion", "Genero", "Duracion", "Precio", "Calidad", "Tamaño(MB)" }));
		
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Buscar", null, panel_1, null);

		JScrollPane scrollPane_1 = new JScrollPane();

		CajaBuscar = new JTextField();
		CajaBuscar.setColumns(10);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Imagen", "Nombre Artista", "Album",
				"Cancion", "Genero", "Duracion", "Precio", "Calidad", "Tamaño(MB)" }));
		DefaultTableModel model_2 = (DefaultTableModel) table_1.getModel();
		scrollPane.setViewportView(table);

		JButton botonCancion = new JButton("Cancion");
		botonCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
		            String query = "SELECT * FROM canciones WHERE nombre = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, CajaBuscar.getText());

		            ResultSet resultado = sentenciaP.executeQuery();

		            while (resultado.next()) {
		            	
		            	model_2.addRow(new Object[] { null, resultado.getString("artista"), resultado.getString("album"),
								resultado.getString("nombre"), resultado.getString("genero"), resultado.getString("duracion"),
								resultado.getString("precio"), resultado.getString("calidad"), resultado.getString("tamaño") });
		            }
		            
		            sentenciaP.close();
		            database.close();
		            
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			}
		});
		
		JButton BotonArtista = new JButton("Artista");
		BotonArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
		            String query = "SELECT * FROM canciones WHERE artista = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, CajaBuscar.getText());

		            ResultSet resultado = sentenciaP.executeQuery();

		            while (resultado.next()) {
		            	
		            	model_2.addRow(new Object[] { null, resultado.getString("artista"), resultado.getString("album"),
								resultado.getString("nombre"), resultado.getString("genero"), resultado.getString("duracion"),
								resultado.getString("precio"), resultado.getString("calidad"), resultado.getString("tamaño") });
		            }
		            
		            sentenciaP.close();
		            database.close();
		            
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			}
		});

		JButton botonDisco = new JButton("Album");
		botonDisco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				try {
		            String query = "SELECT * FROM canciones WHERE album = ?;";
		            PreparedStatement sentenciaP = database.open().prepareStatement(query);
		            sentenciaP.setString(1, CajaBuscar.getText());

		            ResultSet resultado = sentenciaP.executeQuery();

		            while (resultado.next()) {
		            	
		            	model_2.addRow(new Object[] { null, resultado.getString("artista"), resultado.getString("album"),
								resultado.getString("nombre"), resultado.getString("genero"), resultado.getString("duracion"),
								resultado.getString("precio"), resultado.getString("calidad"), resultado.getString("tamaño") });
		            }
		            
		            sentenciaP.close();
		            database.close();
		            
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(CajaBuscar, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
								.addComponent(botonDisco, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(BotonArtista, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(botonCancion, GroupLayout.PREFERRED_SIZE, 85,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(CajaBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(BotonArtista)
										.addComponent(botonDisco).addComponent(botonCancion)))
						.addContainerGap(24, Short.MAX_VALUE)));


		scrollPane_1.setViewportView(table_1);
		panel_1.setLayout(gl_panel_1);

		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Compras", null, tabbedPane_1, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane_1.addTab("Canciones", null, scrollPane_3, null);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cancion", "copias", "Precio"}));
		DefaultTableModel model_4 = (DefaultTableModel) table_3.getModel();
		try {
            String query = "SELECT * FROM cancionesv ;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
            	
            	model_4.addRow(new Object[] {resultado.getString("cancion"), resultado.getString("copias"),
						resultado.getString("precio"), resultado.getString("nombreC")});
            }
            
            sentenciaP.close();
            database.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		scrollPane_3.setViewportView(table_3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 828, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void limpiarTabla(int a) {
		DefaultTableModel tb = (DefaultTableModel) table.getModel();
		int f = table.getRowCount()-1;
		switch(a) {
			case 1:
				for(int i = f; i >=0; i--) {
					tb.removeRow(tb.getRowCount()-1);
				}
		}
	}
	
	public void llenarTabla1() {
		DefaultTableModel model_1 = (DefaultTableModel) table.getModel();
		try {
			String query = "SELECT * FROM canciones;";
			PreparedStatement sentenciaP = database.open().prepareStatement(query);
			ResultSet resultado = sentenciaP.executeQuery();

			while (resultado.next()) {
				model_1.addRow(new Object[] { null, resultado.getString("artista"), resultado.getString("album"),
						resultado.getString("nombre"), resultado.getString("genero"), resultado.getString("duracion"),
						resultado.getString("precio"), resultado.getString("calidad"), resultado.getString("tamaño") });
			}

			sentenciaP.close();
			database.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
