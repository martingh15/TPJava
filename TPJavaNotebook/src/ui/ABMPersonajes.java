package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.CtrlABMPersonaje;
import utils.ApplicationException;
import utils.SuperLogger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.Level;

import entidades.Personaje;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMPersonajes extends JDialog {

	private JPanel contentPane;
	private CtrlABMPersonaje controladorPj;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtTotal;

	/**
	 * Create the frame.
	 */
	public ABMPersonajes() {
		setModal(true);
		setTitle("Creacion de Personaje");
		controladorPj = new CtrlABMPersonaje();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				buscar();
			}
		});
		
		JLabel label = new JLabel("Atributos");
		label.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Personaje p = MapearDeFormulario();
				p.setId(Integer.parseInt(txtID.getText()));
				controladorPj.borrarPersonaje(p);
				notifyUser("Personaje borrado");
				limpiarCampos();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarPersonaje();
			}
		});
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearPersonaje();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblNombre))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar))
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBorrar)
									.addGap(41)
									.addComponent(btnModificar)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCrear)))))
					.addContainerGap(84, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnModificar)
						.addComponent(btnCrear))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JLabel lblVida = new JLabel("Vida");
		
		JLabel lblEnergia = new JLabel("Energia");
		
		JLabel lblDefensa = new JLabel("Defensa");
		
		JLabel lblEvasion = new JLabel("Evasion");
		
		JLabel lblRestante = new JLabel("Restante");
		
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
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVida)
						.addComponent(lblRestante)
						.addComponent(lblEvasion)
						.addComponent(lblDefensa)
						.addComponent(lblEnergia))
					.addGap(81)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEvasion)
						.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRestante)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void buscar() {
		try {
			Personaje p = controladorPj.busca(mapeaID());		
			if(p!=null){
				
					MapearAFormulario(p); }
			else {
				throw new ApplicationException();
			}
			
		} catch (ApplicationException ae) {
			// TODO Auto-generated catch block
			notifyUser("Personaje no encontrado",ae, Level.DEBUG);
		}
		
	}

	private Personaje mapeaID() {
		Personaje p = new Personaje();
		p.setId(Integer.parseInt(txtID.getText()));
		return p;
	}
	
	public void MapearAFormulario(Personaje p){
		if(p.getId()>0) txtID.setText(String.valueOf(p.getId()));
		txtID.setText(String.valueOf(p.getId()));
		txtNombre.setText(p.getNombre());
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtEnergia.setText(String.valueOf(p.getEnergia()));
		txtEvasion.setText(String.valueOf(p.getEvasion()));
		txtTotal.setText(String.valueOf(p.getPuntosTotales()));
		txtVida.setText(String.valueOf(p.getVida()));
	}
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Warning!", JOptionPane.INFORMATION_MESSAGE);
	}

	private void notifyUser(String mensaje, Exception e, Level l) {
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
	
	
	
	public void limpiarCampos()
	{
		txtVida.setText("");
		txtNombre.setText("");
		txtEnergia.setText("");
		txtDefensa.setText("");
		txtEvasion.setText("");
		txtTotal.setText("200");
		txtID.setText("");
	}
	
	public void modificarPersonaje() 
	{
		if(validarDatos()) {
			
			Personaje p = MapearDeFormulario();
			p.setId(Integer.parseInt(txtID.getText()));
			controladorPj.modificar(p);
			notifyUser("Personaje modificado");
			limpiarCampos();
			}		
	}
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setPuntosTotales(Integer.parseInt(txtTotal.getText()));
		p.setNombre(txtNombre.getText());
		
		return p;
	}
	
	public boolean validarDatos() 
	{
		boolean valido=true;
		if(txtNombre.getText().trim().length()==0
			|| txtDefensa.getText().trim().length()==0
			|| txtVida.getText().trim().length()==0
			|| txtEnergia.getText().trim().length()==0
			|| txtEvasion.getText().trim().length()==0){
			valido=false;
			notifyUser("Complete todos los campos");
		}
		if(valido && !txtID.getText().matches("[0-9]*")){
			valido=false;
			notifyUser("Ingrese un entero");
		}
		if(!validarPuntos())	
		{
			valido = false;
		}
		return valido;

	}
	
	public boolean validarPuntos() {
		boolean valido = true;
		int acumulador = 0;
		int  puntosMax = 200;
		
		acumulador = acumulador + Integer.parseInt(txtVida.getText());
		acumulador = acumulador + Integer.parseInt(txtDefensa.getText());
		acumulador = acumulador + Integer.parseInt(txtEnergia.getText());
		acumulador = acumulador + Integer.parseInt(txtEvasion.getText());
		if(acumulador <= puntosMax) 
		{
			puntosMax = puntosMax - acumulador;
			valido = true;
		} else
		{
			puntosMax = puntosMax - acumulador;
			txtTotal.setText(String.valueOf(puntosMax));
			notifyUser("Usted asigno mas puntos de lo permitido (puntos totales)");
			valido = false;
		}
		if(Integer.parseInt(txtDefensa.getText()) > 20)
		{
			notifyUser("La defensa no puede exceder los 20 puntos");
			valido = false;
		}
		if(Integer.parseInt(txtEvasion.getText()) > 80)
		{
			notifyUser("La evasion no puede exceder los 80 puntos");
			valido = false;
		}		
		txtTotal.setText(String.valueOf(puntosMax));
		return valido;
		
	}
	
	public void crearPersonaje()
	{
		if(validarDatos()) {
		try {
			Personaje p = MapearDeFormulario();
			p.setId(controladorPj.recuperarID());
			controladorPj.agregarPersonaje(p);
			limpiarCampos();
			notifyUser("Personaje Agregado");
		} catch (ApplicationException ae) {
			notifyUser(ae.getMessage(),ae, Level.DEBUG);
		}
		}
	}
}
