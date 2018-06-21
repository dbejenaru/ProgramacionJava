package Ventanas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;

import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Juego extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private JPanel contentPane;
	private JPanel contentPane;
	
	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	private ImageIcon dadoGris;
	private Random dado=new Random();
	
	private int[] numerosAlmacenadosDados3=new int[3];
	private int[] numerosAlmacenadosDados6=new int [2];
	private int numerosAlmacenadosDados12;
	
	
	private Jugador player1;
	JLabel nombreJugador;
	JLabel punctuacion;
	
	private JLabel dado1, dado2, dado3;
	private JLabel dado4, dado5;
	private JLabel dado6;
	private JButton suma, resta, mathdice, repetir;
	
	private JTextField resultados;
	
	private boolean tocaNumero=true;
	private int operacion=0;
	private int numerosIntroducidos=0;
	private boolean esSuma=true;
	
	
	//private JLabel message;
	
	 
	 
	
	
	private JLabel resultadosLabel;
	private JLabel resultadosOK;
	
	

	public Juego(Jugador jugador1) 
	{
		
	//	setBounds(50, 50, 1000, 530);
	//	contentPane = this;
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	contentPane.setLayout(null);
	//	setLayout(null);
		
		
		///
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

				
	//	message = new JLabel("Bienvenido");
	//	message.setHorizontalAlignment(SwingConstants.CENTER);
		
		punctuacion = new JLabel("Empezamos");
		punctuacion.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado1 = new JLabel("");
		dado1.setBounds(10, 10, 150, 150);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setBounds(160, 10, 150, 150);
		contentPane.add(dado2);
				
		dado3 = new JLabel("");
		dado3.setBounds(210, 10, 150, 150);
		contentPane.add(dado3);
				
		dado4 = new JLabel("");
		dado4.setBounds(10, 160, 150, 150);
		contentPane.add(dado4);
				
		dado5 = new JLabel("");
		dado5.setBounds(160, 160, 150, 150);
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setBounds(10, 310, 150, 150);
		contentPane.add(dado6);
		
		//SUMA////////////////////////////////////
		suma = new JButton("+");
		
		suma.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!tocaNumero)
				{
					resultados.setText(resultados.getText()+"+");
					tocaNumero=true;
					esSuma=true;
				}
			}
		});
		suma.setFont(new Font("Tahoma", Font.BOLD, 16));
		suma.setBounds(510, 78, 195, 63);
		suma.setForeground(Color.RED);
		contentPane.add(suma);
		
		
		//RESTA/////////////////////////
		resta = new JButton("-");
		resta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!tocaNumero)
				{
					resultados.setText(resultados.getText()+"-");
					tocaNumero=true;
					esSuma=false;
				}
			}
		});
		resta.setFont(new Font("Tahoma", Font.BOLD, 16));
		resta.setForeground(Color.BLUE);
		resta.setBounds(710, 78, 195, 63);
		contentPane.add(resta);
		
		nombreJugador = new JLabel("Bienvenido");
		nombreJugador.setFont(new Font("Tahoma", Font.BOLD, 16));
		nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador.setBounds(510, 5, 465, 39);
		contentPane.add(nombreJugador);
		
		
		///////////////////////////////
		resultados = new JTextField();
		resultados.setEditable(false);
		resultados.setBounds(510, 160, 464, 63);
		resultados.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(resultados);
		resultados.setColumns(10);
		
		//MATHDICE//////////////////
		mathdice = new JButton("MATHDICE");
		mathdice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(numerosIntroducidos>1)
				{
					resultadosLabel.setText("Tu operacion es "+String.valueOf(operacion));
					repetir.setEnabled(true);
					if((numerosAlmacenadosDados12+1)==operacion)
					{
						resultadosOK.setText("Correcto");
						mathdice.setEnabled(false);
						player1.setPunctuacion(player1.getPunctuacion()+5);
						punctuacion.setText("Tu punctuacion es: "+player1.getPunctuacion());
					}
					else
					{
						resultadosOK.setText("Intenta otra vez");
						mathdice.setEnabled(true);
					}
				}
			}
		});
		mathdice.setFont(new Font("Tahoma", Font.BOLD, 16));
		mathdice.setBounds(510, 236, 464, 63);
		contentPane.add(mathdice);
		
		resultadosLabel = new JLabel("");
		resultadosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultadosLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		resultadosLabel.setBounds(510, 467, 464, 52);
		contentPane.add(resultadosLabel);
		
		resultadosOK = new JLabel("");
		resultadosOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultadosOK.setHorizontalAlignment(SwingConstants.CENTER);
		resultadosOK.setBounds(510, 408, 464, 14);
		contentPane.add(resultadosOK);
		
		
		
		
		//REPETIR////////////////////////////////// 
		repetir = new JButton("REPETIR");
		repetir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				inicializarBotones();
				mathdice.setEnabled(true);
				repetir.setEnabled(false);
			}
			
		});
		repetir.setEnabled(false);
		repetir.setFont(new Font("Tahoma", Font.BOLD, 16));
		repetir.setBounds(510, 310, 464, 63);
		contentPane.add(repetir);
		
		//////////////////////////////////////////////
		
		punctuacion =new JLabel ("Puntuacion: 0");
		punctuacion.setHorizontalAlignment(SwingConstants.CENTER);
		punctuacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		punctuacion.setBounds(510, 35, 464, 32);
		contentPane.add(punctuacion);
		
		////////////////////////////////////
	inicializarBotones();
		
	}

	public void setJugador(Jugador player) 
	{
		// se genera si se requiere cuando se declara en la ventana login
		this.player1=player;
		nombreJugador.setText("Hola " +player.getNombre()+ " bienvenido al juego.");
		punctuacion.setText("Tu punctuacion es: "+player.getPunctuacion());
		
	}
	private void setOperacion(int num)
	{
		numerosIntroducidos++;
		if(numerosIntroducidos>1)
		{
			if(esSuma) 
				operacion=operacion+num;
			else
				operacion=operacion-num;
		} 
		else
		{
			operacion=num;
		}
	}
	
	private void inicializarBotones()
	{
		for(int i=0; i<dados3.length; i++)
		{
			dados3[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for(int i=0; i<dados6.length; i++)
		{
			dados6[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for (int i=0; i<dados12.length; i++)
		{
			dados12[i]=new ImageIcon(getClass().getResource("img/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadoGris=new ImageIcon(getClass().getResource("img/dadogris.png"));
		//dados 3 caras		
				for(int i=0;i<numerosAlmacenadosDados3.length; i++)
					numerosAlmacenadosDados3[i]=dado.nextInt(3);
				dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
				dado1.setName("1");
				dado1.setIcon(dados3[numerosAlmacenadosDados3[1]]);
				dado2.setName("2");
				dado1.setIcon(dados3[numerosAlmacenadosDados3[2]]);
				dado3.setName("3");
				dado1.addMouseListener(new ListenerDados());
				dado2.addMouseListener(new ListenerDados());
				dado3.addMouseListener(new ListenerDados());
		//dados 6 caras
				for (int i=0;i<numerosAlmacenadosDados6.length;i++)
					numerosAlmacenadosDados6[i]=dado.nextInt(6);
				dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
				dado4.setName("4");
				dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
				dado5.setName("5");
				dado4.addMouseListener(new ListenerDados());
				dado5.addMouseListener(new ListenerDados());
		//dados 12 caras
				numerosAlmacenadosDados12=dado.nextInt(12);
				dado6.setIcon(dados12[numerosAlmacenadosDados12]);
				resultadosLabel.setText("");
				resultadosOK.setText("");
				resultados.setText("");
		// resetear//////////////////
				tocaNumero=true;
				operacion=0;
				numerosIntroducidos=0;
				esSuma=true;
	}
	
	private class ListenerDados implements MouseListener
	{
		public void mouseClicked(MouseEvent e)
		{
			JLabel dado = (JLabel) e.getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			if(tocaNumero)
			{
				if(numeroDado<4)
					resultados.setText(resultados.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
				else
					resultados.setText(resultados.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
				dado.removeMouseListener(this);
				dado.setIcon(dadoGris);
				tocaNumero=false;
				if (numeroDado<4)
					setOperacion(numerosAlmacenadosDados3[numeroDado-1]+1);
				else
					setOperacion(numerosAlmacenadosDados6[numeroDado-4]+1);
			}
		}
		public void mouseEntered(MouseEvent e)
		{
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}
}
