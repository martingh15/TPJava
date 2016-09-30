package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import logic.CtrlABMPersonaje;
import entidades.Personaje;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearPJ {
	private CtrlABMPersonaje controladorPj;

	//Buscar en la base de datos el ultimo usado
	//private static int contadorID = 0;
	
	private JFrame frmCreacionDePersonaje;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPJ window = new CrearPJ();
					window.frmCreacionDePersonaje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearPJ() {
		controladorPj = new CtrlABMPersonaje();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreacionDePersonaje = new JFrame();
		frmCreacionDePersonaje.setTitle("Creacion de Personaje");
		frmCreacionDePersonaje.setBounds(100, 100, 450, 450);
		frmCreacionDePersonaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblId = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setText( String.valueOf(controladorPj.recuperarID() ) );
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarPersonaje(Integer.parseInt(txtID.getText()));
			}
		});
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearPersonaje();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarPersonaje(Integer.parseInt(txtID.getText()));
			}


		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarPersonaje(Integer.parseInt(txtID.getText()));
			}
		});
		
		JLabel lblAtributos = new JLabel("Atributos");
		lblAtributos.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frmCreacionDePersonaje.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBorrar)
									.addGap(18)
									.addComponent(btnModificar)
									.addGap(18)
									.addComponent(btnCrear)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblId))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar))
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(200, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblAtributos, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(301, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(lblAtributos, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrear)
						.addComponent(btnModificar)
						.addComponent(btnBorrar))
					.addGap(20))
		);
		
		JLabel lblVida = new JLabel("Vida");
		
		JLabel lblEnergia = new JLabel("Energia");
		
		JLabel lblDefensa = new JLabel("Defensa");
		
		JLabel lblEvasion = new JLabel("Evasion");
		
		JLabel lblTotal = new JLabel("Total");
		
		txtVida = new JTextField();
		txtVida.setColumns(10);
		
		txtEnergia = new JTextField();
		txtEnergia.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.setColumns(10);
		
		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setText("200");
		txtTotal.setEnabled(false);
		txtTotal.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVida)
						.addComponent(lblDefensa)
						.addComponent(lblEnergia)
						.addComponent(lblEvasion)
						.addComponent(lblTotal))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(244, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEvasion)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmCreacionDePersonaje.getContentPane().setLayout(groupLayout);
	}
	
	public void crearPersonaje()
	{
		Personaje p = new Personaje();
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntosTotales(Integer.parseInt(txtTotal.getText()));
		p.setNombre(txtNombre.getText());
		p.setId(controladorPj.recuperarID());
		controladorPj.agregarPersonaje(p);
		limpiarCampos();
		JOptionPane.showMessageDialog(null, "Personaje agregado", "Personaje Agregado!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void limpiarCampos()
	{
		txtVida.setText("");
		txtNombre.setText("");
		txtEnergia.setText("");
		txtDefensa.setText("");
		txtEvasion.setText("");
		txtTotal.setText("200");
		txtID.setText(String.valueOf(controladorPj.recuperarID()));
	}
	
	public void buscarPersonaje(int id)
	{
		Personaje p = controladorPj.busca(id);
		
		txtNombre.setText(p.getNombre());
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		txtTotal.setText(String.valueOf(p.getPuntosTotales()));
		txtVida.setText(String.valueOf(p.getVida()));
	}
	
	public void borrarPersonaje(int id)
	{
		controladorPj.borrarPersonaje(id);
		JOptionPane.showMessageDialog(null, "Personaje BORRADO", "Personaje BORRADO!", JOptionPane.INFORMATION_MESSAGE);
		limpiarCampos();
	}
	
	public void modificarPersonaje(int id) 
	{
		Personaje p = new Personaje();
		//Hacer metodo mapear formulario
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntosTotales(Integer.parseInt(txtTotal.getText()));
		p.setNombre(txtNombre.getText());
		p.setId(id);
		controladorPj.modificar(p);
		limpiarCampos();
		JOptionPane.showMessageDialog(null, "Personaje modificado", "Personaje modificado!", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
