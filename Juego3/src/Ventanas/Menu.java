package Ventanas;


import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Ventanas.Juego;
import Ventanas.Login;
import Ventanas.Perfil;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private CardLayout cardLayout;

	// Almacena Jugador
	private Jugador jugador;

	// Ventana Juego
	private Juego ventanaJuego;

	// Ventana Perfil
	private Perfil ventanaPerfil;

	final static String VentanaJ = "Ventana Jugar";
	final static String VentanaP = "Ventana Perfil";

	public Menu(Jugador jugador1) {
		jugador = jugador1;
		
		ventanaJuego = new Juego(jugador1);
		ventanaPerfil = new Perfil(jugador1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);

		// A�ado las ventanas al contenedor
		contentPane.add(ventanaJuego.getContentPane(), VentanaJ);
		contentPane.add(ventanaPerfil.getContentPane(), VentanaP);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);

		JMenuItem mntmJuego = new JMenuItem("Juego");
		mnVentanas.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, VentanaJ);
			}
		});

		JSeparator separator = new JSeparator();
		mnVentanas.add(separator);

		JMenuItem mntmPerfil = new JMenuItem("El perfil");
		mnVentanas.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, VentanaP);
			}
		});

	}

	// Texto de BIENVENIDA JUGADOR
	// Setter
	public void setJugador(Jugador jugador1) {
		jugador  = jugador1;

	}

	public void habilitarJuego() {

		cardLayout.show(contentPane, VentanaJ);
	}
}
