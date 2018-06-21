package Ventanas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Ventanas.Juego;

import Juego.ConexionBD;
import Juego.Jugador;
import Juego.JugadorBD;

import java.awt.BorderLayout;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2815939040592627306L;
	// ATRIBUTOS
	public JPanel contentPane;
	public JTextField textFieldNOMBRE;
	public JTextField textFieldAPELLIDO1;
	public JTextField textFieldEDAD;
	private final JLabel lblJuegoMathDice = new JLabel("MathDice");
	public JTextArea textFieldCUADROTextoInferior;

	// Creo una etiqueta de referencia a un objeto tipo Inicio
	private Login login;
	// Permite acceso desde la ventana Inicio a la ventana Juego, pas�ndola como
	// referencia
	private Menu ventanasJuego;
	// Generamos un nuevo jugador
	private Jugador player;

	// Constructor Ventana de INICIO
	public Login() {
		// Creo el DAO Jugador
		player = new Jugador();

		// Asocio referencia al objeto creado que es tipo Registro
		login = this;

		// VENTANA
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 326);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiquetas (JLabel)
		lblJuegoMathDice.setBounds(155, 11, 152, 19);
		lblJuegoMathDice.setForeground(Color.BLUE);
		lblJuegoMathDice.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblJuegoMathDice);

		JLabel lblDatosDelJugador = new JLabel("Datos Jugador");
		lblDatosDelJugador.setBounds(61, 30, 342, 20);
		lblDatosDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelJugador.setBackground(Color.WHITE);
		lblDatosDelJugador.setForeground(Color.RED);
		lblDatosDelJugador.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(lblDatosDelJugador);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 57, 60, 20);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNombre);

		JLabel lblApellido1 = new JLabel("Apellido:");
		lblApellido1.setBounds(10, 88, 71, 14);
		lblApellido1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblApellido1);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(224, 116, 46, 14);
		lblEdad.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblEdad);

		// Entradas (JTextFile)
		textFieldNOMBRE = new JTextField();
		textFieldNOMBRE.setBounds(61, 57, 187, 20);
		contentPane.add(textFieldNOMBRE);
		textFieldNOMBRE.setColumns(10);
		// Listener esperando INTRO
		textFieldNOMBRE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si pulso Intro se muestra dato del Jugador
				player.setNombre(textFieldNOMBRE.getText());
			}
		});

		textFieldAPELLIDO1 = new JTextField();
		textFieldAPELLIDO1.setBounds(87, 85, 208, 20);
		contentPane.add(textFieldAPELLIDO1);
		textFieldAPELLIDO1.setColumns(10);
		// Listener esperando INTRO
		textFieldAPELLIDO1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si pulso Intro se muestra dato del Jugador
				player.setApellidos(textFieldAPELLIDO1.getText());
			}
		});

		

		textFieldEDAD = new JTextField();
		textFieldEDAD.setBounds(261, 113, 46, 20);
		contentPane.add(textFieldEDAD);
		textFieldEDAD.setColumns(10);
		// Listener esperando INTRO
		textFieldEDAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Si pulso Intro se muestra dato del Jugador
				player.setEdad(textFieldEDAD.getText());
			}
		});

		// Boton Juego
		JButton btnBotonJUGAR = new JButton("REGISTRATE para jugar");
		btnBotonJUGAR.setBounds(99, 159, 262, 31);
		btnBotonJUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Mensaje en la caja de texto inferior
				// de la ventana
				boolean sinErrores = true;

				switch (player.verificar(player)) {
				case 1:
					textFieldCUADROTextoInferior.setText("Falta NOMBRE o pulsar Intro");
					break;
				case 2:
					textFieldCUADROTextoInferior.setText("NOMBRE tiene que ser texto");
					break;
				case 3:
					textFieldCUADROTextoInferior.setText("Falta APELLIDO o pulsar Intro");
					break;
				case 4:
					textFieldCUADROTextoInferior.setText("El APELLIDO tiene que ser texto");
					break;
				case 6:
					textFieldCUADROTextoInferior.setText("EDAD no es un numero");
					break;
				default:
					String texto = "Nuevo JUGADOR: " + player.getNombre() + " " + player.getApellidos()  + " tiene " + player.getEdad() + " anyos.";
					textFieldCUADROTextoInferior.setText(texto);

					// Conexion a la base de datos
					ConexionBD conBD = new ConexionBD("localhost", "jugador", "root", "");

					if (conBD.connectBD()) {

						texto = texto + System.getProperty("line.separator") + "Conectado con Exito a la BBDD";
						textFieldCUADROTextoInferior.setText(texto);

						JugadorBD jugadorBD = new JugadorBD(player, conBD.getConnection());

						// Insertar Jugador en BBDD
						int result = jugadorBD.insertarJugador();
						if ( result > 0) {
							texto = texto + System.getProperty("line.separator")
									+ "Registrado con exito con el numero:" + String.valueOf(result);
							textFieldCUADROTextoInferior.setText(texto);

							ventanasJuego = new Menu(player);

							// Habilitar menu juego
							ventanasJuego.habilitarJuego();
							// Abro Jugar
							ventanasJuego.setVisible(true);
							// Cierro Registro
							// registro.setVisible(false);

						}

					}
					break;
				}

			}
		});

		btnBotonJUGAR.setForeground(new Color(199, 21, 133));
		btnBotonJUGAR.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnBotonJUGAR);

		textFieldCUADROTextoInferior = new JTextArea();
		textFieldCUADROTextoInferior.setBounds(10, 201, 428, 75);
		contentPane.add(textFieldCUADROTextoInferior);
		textFieldCUADROTextoInferior.setColumns(10);

	}

}
