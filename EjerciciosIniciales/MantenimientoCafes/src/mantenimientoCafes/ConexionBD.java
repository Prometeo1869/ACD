package mantenimientoCafes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	Connection conn;
	Statement stmt;

	
	public ConexionBD() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "usuario", "usuario"); //172.17.0.2
			stmt = conn.createStatement();
		} catch (SQLException ex) {
			System.out.println("\n--- SQLException capturada ---\n");
			while (ex != null) {
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
	}
	}
	
	public void deconectar() {
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("\n--- SQLException capturada ---\n");
			while (ex != null) {
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
		}
	}
}
