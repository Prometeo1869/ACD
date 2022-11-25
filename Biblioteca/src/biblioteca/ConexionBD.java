package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	private Connection conn;
	private Statement stmt;

	public ConexionBD() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "EXAMEN", "EXAMEN");  
		stmt = conn.createStatement();
	}

	public void deconectar() throws SQLException {
		stmt.close();
		conn.close();
	}

	public Connection getConn() {
		return conn;
	}

	public Statement getStmt() {
		return stmt;
	}
	
	
}
