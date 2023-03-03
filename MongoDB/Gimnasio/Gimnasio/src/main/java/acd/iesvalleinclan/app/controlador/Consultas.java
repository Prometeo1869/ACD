package acd.iesvalleinclan.app.controlador;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import acd.iesvalleinclan.app.repositorio.Conexion;

public class Consultas {
	
	Conexion conn;		

	/**
	 * Constructor, establece la conexión con la colección y la base de datos
	 * a través de la clase Conexión
	 */
	public Consultas() {
		conn = new Conexion(); 
	}

	public void cerrarConexion() {
		conn.close();
	}
	
	//RECUPERAR COLECCIONES
	public FindIterable<Document> findAllSocios() {
		return conn.getColSocios().find();
	}
	
	public FindIterable<Document> findAllActividades() {
		return conn.getColActividades().find();
	}

	public FindIterable<Document> findAllUsoGimnasio() {
		return conn.getColUsoGimnasio().find();
	}
	
	//INSERTAR DOCUMENTOS
	public void insertarDocumentoSocios(Document docu) {
		conn.getColSocios().insertOne(docu);
	}
	public void insertarDocumentoActividades(Document docu) {
		conn.getColActividades().insertOne(docu);
	}
	public void insertarDocumentoUsoGimnasio(Document docu) {
		conn.getColUsoGimnasio().insertOne(docu);
	}
}
