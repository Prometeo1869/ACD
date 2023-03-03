package acd.iesvalleinclan.app.repositorio;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * Clase para conectarse a la base de datos MongoDB
 * 
 * @author Juan Cebrián
 *
 */
public class Conexion {
	
	private MongoClient mongoClient; 		//IP y puerto de la conexión
	private MongoDatabase db;				//Base de Datos
	private MongoCollection<Document> c_actividades;	// Colección actividades
	private MongoCollection<Document> c_socios;			// Colección socios
	private MongoCollection<Document> c_uso_gimnasio;	// Colección uso_gimnasio

	/**
	 * Constructor, asigna los datos de la colección a la que queremos conectarnos
	 */
	public Conexion() {
		try {
			mongoClient = new MongoClient("127.17.0.2", 27017);
			db = mongoClient.getDatabase("gimnasio");
			c_actividades = db.getCollection("actividades");
			c_socios = db.getCollection("socios");
			c_uso_gimnasio = db.getCollection("uso_gimnasio");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Cierra conexion con la base de datos
	 */
	public void close() {
		mongoClient.close();
	}

	public MongoCollection<Document> getColActividades() {
		return c_actividades;
	}
	public MongoCollection<Document> getColSocios() {
		return c_socios;
	}
	public MongoCollection<Document> getColUsoGimnasio() {
		return c_uso_gimnasio;
	}
}