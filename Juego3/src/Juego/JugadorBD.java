package Juego;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorBD {


	private Connection conn;


	private Jugador jugador;


	private java.sql.Statement sqlStmnt = null;


	public JugadorBD(Jugador j, Connection c) {
		this.jugador = j;
		this.conn = c;
	}

	public int  insertarJugador() {
		int result = -1; // el error

		try {
			sqlStmnt = conn.createStatement();
			
			String sql = "INSERT INTO jugador (nombre, apellido, edad) " + "VALUES ('" + jugador.getNombre()
					+ "', '" + jugador.getApellidos() + "', "
					+ Integer.parseInt(jugador.getEdad()) + ")";
			sqlStmnt.execute(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = sqlStmnt.getGeneratedKeys();
			if (rs.next()) {
			    result = rs.getInt(1);
			}
			;

		} catch (SQLException se) {
			// Consulta ERROR
			se.printStackTrace();
		} catch (Exception e) {
			// Otros errores
			e.printStackTrace();
		} finally {
			try {
				if (sqlStmnt != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}

}
