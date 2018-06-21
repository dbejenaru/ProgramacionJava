package Juego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class ConexionBD {
	private String HOST; //elimina la inicializacion a null
	private String BD;
	private String user;
	private String pass;
	private String url;

	private Connection conn = null;

	private static ConexionBD instance;
//	private static ConexionBD instance = null;

	public ConexionBD() {
		
	}
	
	
	public ConexionBD(String HOST, String BBDD, String USER, String PASS) {
		this.HOST = HOST;
		this.BD = BBDD;
		this.user = USER;
		this.pass = PASS;
		// this.url = "jdbc:mysql://localhost:3306/jugador";
		this.url = "jdbc:mysql://" + this.HOST + "/" + this.BD;
	
		//	this.url = "http://localhost/phpmyadmin/index.php?db=mysql&token=c16455a6b47364d162befe9f843053d9";
	}
	/// wamp server
	// http://localhost:8080/phpmyadmin/sql.php?db=jugador&table=jugador
	// 3306 8081 8081
	//

	public boolean connectBD() {
		boolean result = true;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException ex) {
				Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
				result = false;
			} catch (IllegalAccessException ex) {
				Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
				result = false;
			}

			conn = DriverManager.getConnection(url, user, pass);

			if (conn != null) {
				System.out.println("Hay conexion " + url );
				// conn.close();
			}
		} catch (SQLException ex) {
			System.out.println("El enlace no es correcto " + url);
			result = false;
		} catch (ClassNotFoundException ex2) {
			System.out.println(ex2);
			result = false;
		}

		return result;
	}

	public static ConexionBD getInstance() {
		if (instance == null) {
			instance = new ConexionBD();
		}
		return instance;
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
