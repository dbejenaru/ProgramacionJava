package Juego;


public class Jugador {

	// Declaro ATRIBUTOS y TIPOS de la Clase
	private String nombre;
	private String apellidos;
	private String edad;
	private String punctuacion;

	// CONSTRUCTOR
	public Jugador() {
		init();
	}

	public void init() {
		this.nombre = "";
		this.apellidos = "";
		this.edad = "";
		this.punctuacion = "";

	}

	// METODOS (geters y seters)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

		public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
////
	public String getPunctuacion() {
		return punctuacion;
	}

	public void setPunctuacion(String punctuacion) {
		this.punctuacion = punctuacion;
	}
	
	
	
	// Verifica si edad es numero
	public boolean esNumero(String edad) {
		try {
			Integer.parseInt(edad);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Verificar si se completan los campos
	public boolean espaciosBlanco(String cad) {
		for (int i = 0; i < cad.length(); i++)
			if (cad.charAt(i) != ' ')
				return false;
		return true;
	}

	// Verifica si una cadena son espacios en blanco
	public int verificar(Jugador jugador1) {
		int valido = 0;

		// Verificar Nombre

		if (jugador1.getNombre().isEmpty()) {
			return 1;
		}

		if (esNumero(jugador1.getNombre())) {
			return 2;
		}

		// Verificar Apellido

		if (jugador1.getApellidos().isEmpty()) {
			return 3;
		}

		if (esNumero(jugador1.getApellidos())) {
			return 4;
		}
		
		return valido;
	}

	public String toString() {
		return this.nombre + "  " + this.apellidos + " " + this.edad;
	}
}