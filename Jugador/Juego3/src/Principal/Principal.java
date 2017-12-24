package Principal;
import Ventanas.Juego;
import Ventanas.Login;
import Juego.Jugador;

public class Principal 
{
	public static void main(String[] args) 
	{
		Juego vJuego=new Juego();
		Login login=new Login(vJuego);
		login.setVisible(true);
	}
	
}
