package controlador;

import org.bson.Document;

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
	
	public void cerrarConexion() {
		conn.close();
	}
	
	public void insertarDocumento(Document docu) {
		conn.getColl().insertOne(docu);
	}
	
	public Document consultarPorId(int id) {
		
		return conn.findById(id);
	}

	public String consultarPorNombre(String nombre) {
		
		return conn.findByNombre(nombre);
	}

	public char[] consultaPorOrden(int orden) {
		// TODO Auto-generated method stub
		return conn.findByOrden(orden);
	}
	
}
