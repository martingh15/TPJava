package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.logging.log4j.Level;

import data.DataPersonaje;
import entidades.Personaje;
import logic.CtrlABMPersonaje;
import utils.ApplicationException;
import utils.SuperLogger;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JTextField txtPersonaje1;
	private JTextField txtPersonaje2;
	private DataPersonaje dataPer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		dataPer = new DataPersonaje();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPersonajes = new JButton("Personajes");
		btnPersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ABMPersonajes ventanaABMPer = new ABMPersonajes();
				ventanaABMPer.setVisible(true);
			
			
			}
		});
		
		JLabel lblBienvenido = new JLabel("Bienvenido!!");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPersonaje = new JLabel("Personaje 1");
		
		JLabel lblPersonaje_1 = new JLabel("Personaje 2");
		
		txtPersonaje1 = new JTextField();
		txtPersonaje1.setColumns(10);
		
		txtPersonaje2 = new JTextField();
		txtPersonaje2.setColumns(10);
		
		JButton btnCombate = new JButton("Combate");
		btnCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atacar();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addComponent(lblBienvenido))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPersonaje)
								.addComponent(btnPersonajes)
								.addComponent(lblPersonaje_1))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPersonaje2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPersonaje1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(275, Short.MAX_VALUE)
					.addComponent(btnCombate)
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblBienvenido)
					.addGap(18)
					.addComponent(btnPersonajes)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPersonaje)
						.addComponent(txtPersonaje1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPersonaje_1)
						.addComponent(txtPersonaje2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCombate)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	private boolean validarPersonajes() {
		boolean valido=false;
		Personaje p1 = new Personaje();
		p1.setNombre(txtPersonaje1.getText());
		
		Personaje p2 = new Personaje();
		p2.setNombre(txtPersonaje2.getText());
		
		if(dataPer.coincideNombre(p1) && dataPer.coincideNombre(p2))
		{
			valido = true;
		}
		//Manejar excepcion si no coincide
		
	
		return valido;
	}
	
	private void atacar() {
		try {
			if(validarPersonajes())
			{
				Personaje per1 = new Personaje();
				Personaje per2 = new Personaje();
				per1 = dataPer.getByName(txtPersonaje1.getText());
				per2 = dataPer.getByName(txtPersonaje2.getText());				
				Combate ventanaCombate = new Combate(per1,per2);
				ventanaCombate.setVisible(true);
			}
			else
			{
				throw new ApplicationException();
			}
		} catch (ApplicationException ae) {
			// TODO Auto-generated catch block
			notifyUser("Nombre/s de personaje/s incorrecto/s",ae, Level.DEBUG);
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
