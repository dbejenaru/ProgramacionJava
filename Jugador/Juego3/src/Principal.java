import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField jnombre;
	private JTextField japellidos;
	private JTextField jedad;
	private JTextField jid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Jugador player1=new Jugador(); //aqui el player1 es como una variable que va a coger todos los datos a la clase jugador.
		player1.setNombre("Constantin");
		player1.setApellidos("Bejenaru");
		player1.setEdad(36);
		player1.setId(0025);
		System.out.println(player1.toString());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jnombre = new JTextField();
		jnombre.setBounds(10, 46, 86, 20);
		contentPane.add(jnombre);
		jnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 21, 46, 14);
		contentPane.add(lblNombre);
		
		japellidos = new JTextField();
	//	japellidos.setText(String.valueOf(player1.apellidos)); Queria mostrar los valores aqui. 
		japellidos.setBounds(10, 105, 86, 20);
		contentPane.add(japellidos);
		japellidos.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 77, 61, 14);
		contentPane.add(lblApellidos);
		
		jedad = new JTextField();
		jedad.setBounds(10, 161, 86, 20);
		contentPane.add(jedad);
		jedad.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 136, 46, 14);
		contentPane.add(lblEdad);
		
		jid = new JTextField();
		jid.setBounds(10, 222, 86, 20);
		contentPane.add(jid);
		jid.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 197, 46, 14);
		contentPane.add(lblId);
	}

	private String Jugador(JTextField apellidos2) {
		// TODO Auto-generated method stub
		return null;
	}
}
