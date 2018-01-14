package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import Ventanas.Login;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Juego extends JPanel {
	private int[] numerosAlmacenadosDados3=new int[3];
	private int[] numerosAlmacenadosDados6=new int [2];
	private int numerosAlmacenadosDados12;
	
	private JPanel contentPane;
	private Jugador j;
	private JLabel message;
	private JTextField resultados;
	JLabel nombreJugador;
	JLabel punctuacion;
	private JLabel dado1, dado2, dado3;
	private JLabel dado4, dado5;
	private JLabel dado6;
	private JButton suma, resta, mathdice, repetir;
	
	private JLabel resultadosLabel;
	private JLabel resultadosOK;
		

	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	private ImageIcon dadoGris;
	private Random dado=new Random();
	
	
	
	private boolean tocaNumero=true;
	private int operacion=0;
	private int numerosIntroducidos=0;
	private boolean esSuma=true;

	public Juego() 
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = this;
		//contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		setLayout(null);
				
		message = new JLabel("Bienvenido");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(206,11,218,23);
		contentPane.add(message, BorderLayout.CENTER);
		
		JLabel punctuacion = new JLabel("Empezamos");
		punctuacion.setHorizontalAlignment(SwingConstants.CENTER);
		punctuacion.setBounds(216, 45, 208, 23);
		
		contentPane.add(punctuacion);
		
		dado1 = new JLabel("");
		dado1.setHorizontalAlignment(SwingConstants.CENTER);
		dado1.setBounds(10, 25, 65, 62);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setHorizontalAlignment(SwingConstants.CENTER);
		dado2.setBounds(83, 25, 65, 62);
		contentPane.add(dado2);
		
		dado3 = new JLabel("");
		dado3.setHorizontalAlignment(SwingConstants.CENTER);
		dado3.setBounds(158, 25, 65, 62);
		contentPane.add(dado3);
		
		dado4 = new JLabel("");
		dado4.setHorizontalAlignment(SwingConstants.CENTER);
		dado4.setBounds(10, 98, 65, 62);
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setHorizontalAlignment(SwingConstants.CENTER);
		dado5.setBounds(83, 98, 65, 62);
		contentPane.add(dado5);
		
		dado6 = new JLabel("");
		dado6.setHorizontalAlignment(SwingConstants.CENTER);
		dado6.setBounds(10, 171, 65, 62);
		contentPane.add(dado6);
		//SUMA////////////////////////////////////
		suma = new JButton("+");
		suma.setFont(new Font("Tahoma", Font.BOLD, 16));
		suma.setForeground(Color.RED);
		suma.setBounds(226, 79, 89, 23);
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
		contentPane.add(suma);
		//RESTA/////////////////////////
		resta = new JButton("-");
		resta.setFont(new Font("Tahoma", Font.BOLD, 16));
		resta.setForeground(Color.BLUE);
		resta.setBounds(325, 79, 89, 23);
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
		contentPane.add(resta);
		///////////////////////////////
		resultados = new JTextField();
		resultados.setEditable(false);
		resultados.setBounds(216, 110, 208, 29);
		contentPane.add(resultados);
		resultados.setColumns(10);
		//MATHDICE//////////////////
		mathdice = new JButton("MATHDICE");
		mathdice.setBounds(226, 147, 183, 23);
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
						j.setPuntos(j.getPuntos()+5);
						punctuacion.setText("Tu punctuacion es: "+j.getPuntos());
					}
					else
					{
						resultadosOK.setText("Intenta otra vez");
						mathdice.setEnabled(true);
					}
				}
			}
		});
		contentPane.add(mathdice);
		//REPETIR/////////////
		repetir = new JButton("REPETIR");
		repetir.setBounds(226, 171, 183, 23);
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
		contentPane.add(repetir);
		
		resultadosOK = new JLabel("Resultado");
		resultadosOK.setForeground(Color.GREEN);
		resultadosOK.setBackground(Color.GREEN);
		resultadosOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultadosOK.setHorizontalAlignment(SwingConstants.CENTER);
		resultadosOK.setBounds(226, 208, 188, 25);
		contentPane.add(resultadosOK);
		
		resultadosLabel = new JLabel("");
		resultadosLabel.setBounds(223, 244, 201, 14);
		add(resultadosLabel);
		////////////////////////////////////
		inicializarBotones();
		
	}

	public void setJugador(Jugador j) 
	{
		// se genera si se requiere cuando se declara en la ventana login
		this.j=j;
		message.setText("Hola " +j.getNombre()+ " bienvenido al juego.");
		punctuacion.setText("Tu punctuacion es: "+j.getPuntos());
		
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
			dados3[i]=new ImageIcon(getClass().getResource("dados/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for(int i=0; i<dados6.length; i++)
		{
			dados6[i]=new ImageIcon(getClass().getResource("dados/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for (int i=0; i<dados12.length; i++)
		{
			dados12[i]=new ImageIcon(getClass().getResource("dados/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadoGris=new ImageIcon(getClass().getResource("dados/dadogris.png"));
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
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
