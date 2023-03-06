package acd.iesvalleinclan.app.dao;

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
	
	public Document findSocioById(String id) {
		FindIterable<Document> iterable = conn.getColSocios().find(new Document("_id", id));
		
		return iterable.first();
	}

	public Document findActById(String id) {
		FindIterable<Document> iterable = conn.getColActividades().find(new Document("_id" , id));
		
		return iterable.first();
	}

	public void eliminarSocio(String id) {
		conn.getColSocios().deleteOne(new Document("_id", id));
	}
	
	public void eliminarActividad(String id) {
		conn.getColActividades().deleteOne(new Document("_id", id));
	}
	
	public void eliminarUso(String id) {
		conn.getColUsoGimnasio().deleteOne(new Document("_id", id));
	}
}
