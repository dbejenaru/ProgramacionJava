package Juego;
import java.sql.Connection; //para poder almacenar los jugadores (en este momento no se usa

public class Jugador 
{
	private String nombre, apellidos;
	private int edad, puntos, id;
	
	// introduce el nombre
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre (String nombre)
	{
		this.nombre = nombre;
	}
	// introduce el/los apellido/s
	public String getApellidos()
	{
		return apellidos;
	}
	public void setApellidos (String apellidos)
	{
		this.apellidos = apellidos;
	}
	// introduce la edad
	
	public int getEdad()
	{
		return edad;
	}
	public void setEdad (int edad)
	{
		this.edad = edad;
	}
	// introduce puntos
	public int getPuntos()
	{
		return puntos;
	}
	public void setPuntos (int puntos)
	{
		this.puntos = puntos;
	}
	// introduce ID
		public int getId()
		{
			return id;
		}
		public void setId (int id)
		{
			this.id = id;
		}
		public boolean isNumeric(String cadena)
		{
			try
			{
				Integer.parseInt(cadena);
				return true;
			}
			catch (NumberFormatException nfe)
			{
				return false;
			}
		}
		public boolean espacios(String cad)
		{
			for(int i=0; i<cad.length(); i++)
				if(cad.charAt(i) !=' ')
				return false;
				return true;
		}
		public String toString()
		{
		return "Se ha registrado el jugador: " +this.nombre+" "+this.apellidos+" que tiene "+this.edad+" años.";  
		}
}
