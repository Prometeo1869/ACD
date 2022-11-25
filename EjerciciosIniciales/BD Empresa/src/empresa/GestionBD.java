package empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {

	Connection conn;
	Statement stmt;

	
	public GestionBD() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "EMPRESA", "EMPRESA");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
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
	
	
	
	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}



	public Statement getStmt() {
		return stmt;
	}



	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}



	public void desconectar() {
		
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
