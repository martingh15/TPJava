package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.Level;

import entidades.Personaje;
import logic.CtrlCombate;
import utils.ApplicationException;
import utils.SuperLogger;
import utils.ReproduceAudio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Combate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPersonaje1;
	private JTextField txtPersonaje2;
	private JTextField txtVida1;
	private JTextField txtEnergia1;
	private JTextField txtVida2;
	private JTextField txtEnergia2;
	private JTextField txtEvasion1;
	private JTextField txtDefensa1;
	private JTextField txtEvasion2;
	private JTextField txtDefensa2;
	private JTextField txtTurno;
	private JButton btnAtaque;
	private JButton btnDefender;
	private JLabel lblEnergiaAUsar;
	private JTextField txtEnergiaUsar;
	private Personaje p1 = new Personaje();
	private Personaje p2 = new Personaje();
	private CtrlCombate cc = new CtrlCombate();
	int turno=1;
	private ReproduceAudio rep = new ReproduceAudio();

	/**
	 * Create the dialog.
	 */
	public Combate() {
		setModal(true);
		setBounds(100, 100, 466, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblPersonaje = new JLabel("Personaje 1:");
		JLabel lblPersonaje_1 = new JLabel("Personaje 2:");
		txtPersonaje1 = new JTextField();
		txtPersonaje1.setEnabled(false);
		txtPersonaje1.setColumns(10);
		txtPersonaje2 = new JTextField();
		txtPersonaje2.setEnabled(false);
		txtPersonaje2.setColumns(10);
		JLabel lblVida1 = new JLabel("Vida:");
		JLabel lblEnergia1 = new JLabel("Energia:");
		JLabel lblEvasion1 = new JLabel("Evasion:");
		JLabel lblDefensa1 = new JLabel("Defensa:");
		JLabel lblVida2 = new JLabel("Vida:");
		JLabel lblEnergia2 = new JLabel("Energia:");
		JLabel lblEvasion2 = new JLabel("Evasion:");
		JLabel lblDefensa2 = new JLabel("Defensa:");
		
		txtVida1 = new JTextField();
		txtVida1.setEnabled(false);
		txtVida1.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setEnabled(false);
		txtEnergia1.setColumns(10);
		
		txtVida2 = new JTextField();
		txtVida2.setEnabled(false);
		txtVida2.setColumns(10);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setEnabled(false);
		txtEnergia2.setColumns(10);
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setEnabled(false);
		txtEvasion1.setColumns(10);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setEnabled(false);
		txtDefensa1.setColumns(10);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setEnabled(false);
		txtEvasion2.setColumns(10);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setEnabled(false);
		txtDefensa2.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno:");
		
		txtTurno = new JTextField();
		txtTurno.setEnabled(false);
		txtTurno.setColumns(10);
		
		btnAtaque = new JButton("Atacar");
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rep.audioAtaque();
				atacar();
				
			}
		});
		
		btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defender();
			}

			
		});
		
		lblEnergiaAUsar = new JLabel("Energia a usar:");
		
		txtEnergiaUsar = new JTextField();
		txtEnergiaUsar.setToolTipText("Ingrese energia para el ataque");
		txtEnergiaUsar.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblEvasion1)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVida1)
								.addComponent(lblEnergia1))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTurno)
								.addComponent(lblDefensa1)))
						.addComponent(lblPersonaje))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtPersonaje1)
						.addComponent(txtVida1)
						.addComponent(txtEnergia1)
						.addComponent(txtDefensa1)
						.addComponent(txtEvasion1)
						.addComponent(txtTurno))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPersonaje_1)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblEvasion2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDefensa2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVida2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPersonaje2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblEnergiaAUsar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEnergiaUsar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addComponent(btnDefender))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(268, Short.MAX_VALUE)
							.addComponent(btnAtaque, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGap(96))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPersonaje)
						.addComponent(lblPersonaje_1)
						.addComponent(txtPersonaje2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPersonaje1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVida2)
								.addComponent(lblVida1)
								.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergia2)
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEvasion2)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDefensa2)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergia1)
								.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEvasion1)
								.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDefensa1)
								.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTurno)
						.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(btnAtaque)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergiaAUsar)
								.addComponent(txtEnergiaUsar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(btnDefender)))
					.addGap(70))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	public void MapearAFormulario(Personaje per1, Personaje per2) {
	
			txtPersonaje1.setText(per1.getNombre());
			txtDefensa1.setText(String.valueOf(per1.getDefensa()));
			txtEnergia1.setText(String.valueOf(per1.getEnergia()));
			txtEvasion1.setText(String.valueOf(per1.getEvasion()));
			txtVida1.setText(String.valueOf(per1.getVida()));
			
			txtPersonaje2.setText(per2.getNombre());
			txtDefensa2.setText(String.valueOf(per2.getDefensa()));
			txtEnergia2.setText(String.valueOf(per2.getEnergia()));
			txtEvasion2.setText(String.valueOf(per2.getEvasion()));
			txtVida2.setText(String.valueOf(per2.getVida()));
			
			txtTurno.setText(per1.getNombre());
		
	}
	
	public void cargarPersonajes(Personaje per1, Personaje per2) {
		p1 = per1;
		p2 = per2;
		MapearAFormulario(p1,p2);
		cc.seteaPer(p1,p2);
	}
	
	private void atacar() {
		try {
			if (turno == 1)
			{
				if(cc.validaEnergia(Integer.parseInt(txtEnergiaUsar.getText()),1)){
			     if(!cc.evadir(1))
			     {
				txtVida2.setText(String.valueOf(cc.quitaVida(txtEnergiaUsar.getText(),1)));
				
				  }
				else 
				{
					notifyUser("Ataque evadido");
				}
			     txtEnergia1.setText(String.valueOf(cc.quitaEnergia(txtEnergiaUsar.getText(),1))); 
				if(cc.validarPartida(turno)) 
				{
					notifyUser("El jugador "+txtPersonaje1.getText()+" ha ganado la partida. Tiene 10 puntos mas para asignar!");
					this.dispose();
				};
				
				txtTurno.setText(p2.getNombre());
				turno = 2;
				}
				else { throw new ApplicationException(); }
				
			}
			else //if (String.valueOf(txtTurno.getText()) == String.valueOf(txtPersonaje2.getText()))
			{
				if(cc.validaEnergia(Integer.parseInt(txtEnergiaUsar.getText()),2)){
					if(!cc.evadir(2))
				     {
				txtVida1.setText(String.valueOf(cc.quitaVida(txtEnergiaUsar.getText(),2))); 
				
				     }
					else 
					{
						notifyUser("Ataque evadido");
					}
					txtEnergia2.setText(String.valueOf(cc.quitaEnergia(txtEnergiaUsar.getText(),2))); 
				if(cc.validarPartida(turno)) 
				{
					notifyUser("El jugador "+txtPersonaje2.getText()+" ha ganado la partida. Tiene 10 puntos mas para asignar!");
					this.dispose();
				};
				txtTurno.setText(p1.getNombre());
				turno = 1;
				}
				else { throw new ApplicationException(); }
				
			}
		} catch (ApplicationException ae) {
			notifyUser("Ingrese una cantidad de energia valida",ae, Level.DEBUG);
		} 
	}
	
	private void defender() {
		if (turno == 1)
		{
			txtEnergia1.setText(String.valueOf(cc.recuperaEnergia(1)));
			txtVida1.setText(String.valueOf(cc.recuperaVida(1)));
			txtTurno.setText(p2.getNombre());
			turno = 2;
		}
		else
		{
			txtEnergia2.setText(String.valueOf(cc.recuperaEnergia(2))); 
			txtVida2.setText(String.valueOf(cc.recuperaVida(2)));
			txtTurno.setText(p1.getNombre());
			turno = 1;
		}
	}
	
	
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Warning!", JOptionPane.INFORMATION_MESSAGE);
	}

	private void notifyUser(String mensaje, Exception e, Level l) {
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
}
