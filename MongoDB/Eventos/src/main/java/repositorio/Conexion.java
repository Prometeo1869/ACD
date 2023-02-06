package repositorio;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
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
	private MongoCollection<Document> coll;	// Colección 
	private String mensaje;
	
	/**
	 * Constructor, asigna los datos de la colección a la que queremos conectarnos
	 */
	public Conexion() {
		try {
			mongoClient = new MongoClient("127.17.0.2", 27017);
			db = mongoClient.getDatabase("eventos");
			coll = db.getCollection("eventos");
			mensaje = "Conexión realizada";
		} catch (Exception e) {
			mensaje = "ERROR de conexión";
		}	
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public void close() {
		mongoClient.close();
	}

	public MongoCollection<Document> getColl() {
		mensaje = "DOCUMENTO INSERTADO";
		return coll;
	}

	public Document findById(int id) {
		FindIterable<Document> iterable =  coll.find(new Document("_id", id));
		return iterable.first();
	}

	public String findByNombre(String nombre) {
		FindIterable<Document> iterable =  coll.find(new Document("nombre", nombre));

		return String.valueOf(iterable.first());
	}

	public char[] findByOrden(int orden) {
		FindIterable<Document> iterable =  coll.find().ord);

		return String.valueOf(iterable.first());
	}

	
	
	
}
