package examen;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		ConexionBD conexion = new ConexionBD();
		try {
			ResultSet rs = conexion.getStmt().executeQuery("SELECT * FROM LIBROS WHERE ID_LIBRO=1");
			rs.next();
			System.out.println(rs.getString("TITULO"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
