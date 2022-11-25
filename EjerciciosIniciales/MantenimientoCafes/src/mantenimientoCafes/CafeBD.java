package mantenimientoCafes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CafeBD {
	
	ConexionBD conexion;

	public CafeBD() {
		this.conexion = new ConexionBD();
	}

	public void actualizarCafe(String nombre, int ventas) {
		try {
			conexion.stmt.executeUpdate("UPDATE cafes SET ventas=" + ventas + " WHERE cafe_nombre='" + nombre + "'");
		} catch (SQLException e) {
			System.out.println("No se ha podido actualizar la BD");
		}
	}

	public void addCafe(Cafe cafe) {
		try {
			conexion.stmt
					.executeUpdate("INSERT INTO CAFES VALUES ('" + cafe.getCafeNombre() + "', " + cafe.getProveedor()
							+ ", " + cafe.getPrecio() + ", " + cafe.getVentas() + " , " + cafe.getTotal() + ")");
		} catch (SQLException e) {
			System.out.println("No se ha podido añadir un nuevo café a la BD");
		}
	}

	public void borrarCafe(String nombre) {
		try {
			conexion.stmt.executeUpdate("DELETE FROM CAFES WHERE CAFE_NOMBRE='" + nombre + "'");
		} catch (SQLException e) {
			System.out.println("No se ha podido borrar un café a la BD");
		}
	}

	public Cafe mostarCafe(String nombre) {
		Cafe cafe = new Cafe(nombre);
		try {
			ResultSet rs;
			rs = conexion.stmt.executeQuery("SELECT * FROM cafes WHERE cafe_nombre='" + nombre + "'");
			rs.next();
			cafe.setCafeNombre(rs.getString("CAFE_NOMBRE"));
			cafe.setProveedor(rs.getInt("PROV_ID"));
			cafe.setPrecio(rs.getFloat("PRECIO"));
			cafe.setVentas(rs.getInt("VENTAS"));
			cafe.setTotal(rs.getInt("TOTAL"));

		} catch (SQLException e) {
			return null;
		}
		return cafe;
	}

	public ArrayList<Cafe> mostarTodo() {
		ArrayList<Cafe> lista = new ArrayList<>();
		try {
			ResultSet rs;
			rs = conexion.stmt.executeQuery("SELECT * FROM cafes");
			while (rs.next()) {
				Cafe cafe = new Cafe();
				cafe.setCafeNombre(rs.getString("CAFE_NOMBRE"));
				cafe.setProveedor(rs.getInt("PROV_ID"));
				cafe.setPrecio(rs.getFloat("PRECIO"));
				cafe.setVentas(rs.getInt("VENTAS"));
				cafe.setTotal(rs.getInt("TOTAL"));
				lista.add(cafe);
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido crear el objeto Cafe");
		}
		return lista;
	}

}
