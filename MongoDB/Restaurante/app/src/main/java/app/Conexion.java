package app;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Conexion {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("127.17.0.2", 27017);
		
		MongoDatabase db = mongoClient.getDatabase("mibasededatos");
		MongoCollection<Document> coll = db.getCollection("libros");
		
		Document dbObj = (Document) coll.find(new Document("editorial", "Anaya")).first();
		System.out.println(dbObj.toJson());
		
		Document nuevo = new Document("codigo", 5)
				.append("nombre", "PSP")
				.append("pvp", 25.98)
				.append("editorial", "Anaya")
				.append("temas", Arrays.asList("Programación", "Pepelu", "TareasInfinitas"));
		
		coll.insertOne(nuevo);
		
		
		
		mongoClient.close();
	}
}
