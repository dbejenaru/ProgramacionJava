package Ventanas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Juego extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -121334170071261839L;
	private int[] numerosAlmacenadosDados3=new int[3];
	private int[] numerosAlmacenadosDados6=new int [2];
	private int numerosAlmacenadosDados12;
	
	private JPanel contentPane_1_1;
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
		contentPane_1_1 = new JPanel();
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
				
		message = new JLabel("Bienvenido");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		punctuacion = new JLabel("Empezamos");
		punctuacion.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado1 = new JLabel("");
		dado1.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado2 = new JLabel("");
		dado2.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado3 = new JLabel("");
		dado3.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado4 = new JLabel("");
		dado4.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado5 = new JLabel("");
		dado5.setHorizontalAlignment(SwingConstants.CENTER);
		
		dado6 = new JLabel("");
		dado6.setHorizontalAlignment(SwingConstants.CENTER);
		//SUMA////////////////////////////////////
		suma = new JButton("+");
		suma.setFont(new Font("Tahoma", Font.BOLD, 16));
		suma.setForeground(Color.RED);
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
		//RESTA/////////////////////////
		resta = new JButton("-");
		resta.setFont(new Font("Tahoma", Font.BOLD, 16));
		resta.setForeground(Color.BLUE);
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
		///////////////////////////////
		resultados = new JTextField();
		resultados.setEditable(false);
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
		//REPETIR/////////////
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
		
		resultadosOK = new JLabel("Resultado");
		resultadosOK.setForeground(Color.GREEN);
		resultadosOK.setBackground(Color.GREEN);
		resultadosOK.setFont(new Font("Tahoma", Font.BOLD, 14));
		resultadosOK.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane_1_1 = new GroupLayout(contentPane_1_1);
		gl_contentPane_1_1.setHorizontalGroup(
			gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
								.addComponent(dado1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(dado4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
								.addComponent(dado2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(dado5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(58)
									.addComponent(punctuacion, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addComponent(dado3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(167)
									.addComponent(resta, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(48)
									.addComponent(message, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(68)
									.addComponent(suma, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(58)
									.addComponent(resultados, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(68)
									.addComponent(mathdice, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addComponent(dado6, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(151)
							.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
								.addComponent(repetir, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addComponent(resultadosOK, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_contentPane_1_1.setVerticalGroup(
			gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addGap(14)
							.addComponent(dado1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(dado4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addGap(14)
							.addComponent(dado2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(dado5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(34)
									.addComponent(punctuacion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(14)
									.addComponent(dado3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(68)
									.addComponent(resta, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(message, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane_1_1.createSequentialGroup()
									.addGap(68)
									.addComponent(suma, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(8)
							.addComponent(resultados, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(mathdice, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(1)
					.addGroup(gl_contentPane_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(dado6, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane_1_1.createSequentialGroup()
							.addComponent(repetir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(resultadosOK, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane_1_1.setLayout(gl_contentPane_1_1);
		
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
