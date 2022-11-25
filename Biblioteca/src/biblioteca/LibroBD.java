package biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroBD {

	ConexionBD conexion;

	public LibroBD(ConexionBD conexion) {
		this.conexion = conexion;
	}

	public LibroBD() throws ClassNotFoundException, SQLException {
		this.conexion = new ConexionBD();
	}

	public void cambiarTitulo(int id, String titulo) throws SQLException {
		conexion.getStmt().executeUpdate("UPDATE libros SET nombre='" + titulo + "' WHERE id_libro=" + id);
	}

	public void cambiarEditorial(int id, String editorial) throws SQLException {
		conexion.getStmt().executeUpdate("UPDATE libros SET editorial='" + editorial + "' WHERE id_libro=" + id);
	}

	public ArrayList<Libro> mostrarTitulo(String titulo) throws SQLException {
		ArrayList<Libro> lista = new ArrayList<>();
		Libro libro;
		ResultSet rs = conexion.getStmt().executeQuery("SELECT * FROM LIBROS WHERE TITULO='" + titulo + "'");
		while(rs.next()) {
			libro = new Libro(rs.getInt("ID_LIBRO"), titulo, rs.getInt("NUM_EJEMPLARES"), rs.getString("EDITORIAL"), rs.getInt("NUM_PAGINAS"), rs.getDate("FECHA_EDICION").toString());
			lista.add(libro);
		}
		return lista;
	}

	public ArrayList<Libro> mostrarEditorial(String editorial) throws SQLException {
		ArrayList<Libro> lista = new ArrayList<>();
		Libro libro;
		ResultSet rs = conexion.getStmt().executeQuery("SELECT * FROM LIBROS WHERE EDITORIAL='" + editorial + "'");
		while(rs.next()) {
			libro = new Libro(rs.getInt("ID_LIBRO"), rs.getString("TITULO"), rs.getInt("NUM_EJEMPLARES"), editorial, rs.getInt("NUM_PAGINAS"), rs.getDate("FECHA_EDICION").toString());
			lista.add(libro);
		}
		return lista;
	}

}
