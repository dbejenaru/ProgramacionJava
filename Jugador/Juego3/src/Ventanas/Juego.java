package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import Ventanas.Login;

public class Juego extends JFrame {

	private JPanel contentPane;
	private Jugador j;
	private JLabel message;


	
	//public static void main(String[] args) 
	//{
	//	EventQueue.invokeLater(new Runnable() 
	//	{
	//		public void run() {
	//			try {
	//				Juego frame = new Juego();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	
	public Juego() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		message = new JLabel("message");
		message.setBounds(10,28,302,14);
		contentPane.add(message, BorderLayout.CENTER);
	}

	public void setJugador(Jugador j) 
	{
		// se genera si se requiere cuando se declara en la ventana login
		this.j=j;
		message.setText("Hola " +j.getNombre()+ " bienvenido al juego.");
		
	}

}
