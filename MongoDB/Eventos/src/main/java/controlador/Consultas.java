package controlador;

import repositorio.Conexion;

public class Consultas {

	Conexion conn;		

	/**
	 * Constructor, establece la conexión con la colección y la base de datos
	 * a través de la clase Conexión
	 */
	public Consultas() {
		conn = new Conexion(); 
	}
	
	public String mensaje() {
		return conn.getMensaje();
	}
	
}
