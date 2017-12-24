package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DropMode;
import Ventanas.Juego;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jnombre;
	private JTextField japellidos;
	private JTextField jedad;
	private JTextField mensaje;
	private Login referencia;
	private Juego ventana_Juego;
	
	private Jugador player1=new Jugador();
	
	//public static void main(String[] args) 
	//{
		
			
		//EventQueue.invokeLater(new Runnable() 
		//{
		//	public void run() 
		//	{
		//		try 
		//		{
		//			Login frame = new Login();
		//			frame.setVisible(true);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//	}
		//});
	// }

	
	public Login(Juego vJ) 
	{
		referencia=this;
		ventana_Juego=vJ;
		setTitle("JuegoDados");
		
		player1.setNombre("");
		player1.setApellidos("");
		player1.setEdad(666);
		player1.setId(25);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jnombre = new JTextField();
		jnombre.setBounds(266, 45, 86, 20);
		contentPane.add(jnombre);
		jnombre.setColumns(10);
		// Un actionListener que se repite para todos los campos introducidos
		jnombre.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				player1.setNombre(jnombre.getText());
			}

		
		});
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setBounds(141, 48, 73, 14);
		contentPane.add(lblNombre);
		
		japellidos = new JTextField();
		japellidos.setBounds(266, 88, 86, 20);
		contentPane.add(japellidos);
		japellidos.setColumns(10);
		
		japellidos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				player1.setApellidos(japellidos.getText());
			}
		});
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.BLUE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(141, 91, 73, 14);
		contentPane.add(lblApellidos);
		
		jedad = new JTextField();
		jedad.setBounds(266, 133, 86, 20);
		contentPane.add(jedad);
		jedad.setColumns(10);
		
		jedad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(player1.isNumeric(jedad.getText())==true)
					player1.setEdad(Integer.parseInt(jedad.getText()));
				else
				player1.setEdad(666); 	// si el valor edad no es un numero, le pone 
										//"por defecto" el valor 666 de tal manera que luego enseña mensaje de error si aparece 666
			}
		});
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setForeground(Color.BLUE);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(141, 136, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblDatosJugador = new JLabel("Datos Jugador");
		lblDatosJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosJugador.setBounds(131, 11, 136, 27);
		contentPane.add(lblDatosJugador);
		
		JButton btnAJugar = new JButton("A JUGAR");
		btnAJugar.setForeground(Color.RED);
		btnAJugar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAJugar.setBounds(10, 178, 412, 23);
		contentPane.add(btnAJugar);
		
		btnAJugar.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent arg0)//al darle al boton, coprueba si los datos introducidos son validos
			{
			if (player1.getEdad()==666)
				mensaje.setText("Campo EDAD incorecto");
			else if (player1.espacios(player1.getNombre()))
				mensaje.setText("No se ha introducido el nombre");
			else if (player1.espacios(player1.getApellidos()))
				mensaje.setText("No se ha introducido el epellido");
			else
				mensaje.setText("El nuevo jugador: " +player1.getNombre()+" "+player1.getApellidos()+" tiene "+player1.getEdad()+" años.");
			ventana_Juego.setJugador(player1);
			ventana_Juego.setVisible(true);
			referencia.setVisible(false);
			
			}
				});
		
		mensaje = new JTextField();
		mensaje.setBounds(10, 209, 412, 33);
		contentPane.add(mensaje);
		mensaje.setColumns(10);
		
		
		player1.setNombre(jnombre.getText());
		player1.setApellidos(japellidos.getText());
		
		
		
	}

	//public Login(Juego vJuego) {
		// TODO Auto-generated constructor stub
	//}

	//private String Jugador(JTextField apellidos2) {
		// TODO Auto-generated method stub
	//	return null;
	//}
}
