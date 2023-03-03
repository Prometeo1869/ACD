package controlador;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Aggregates.*;

import dominio.Evento;
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
		FindIterable<Document> iterable =  conn.getColl().find(new Document("_id", id));
		return iterable.first();
	}

	public Document consultarPorNombre(String nombre) {
		FindIterable<Document> iterable =  conn.getColl().find(new Document("nombre", nombre));

		return iterable.first();
	}

	public FindIterable<Document> consultaPorOrden(int orden) {
		return conn.getColl().find().sort(new Document("precio", orden));
	}

	public FindIterable<Document> consultaTodos() {
		return conn.getColl().find().sort(new Document("id", 1));
	}

	public void editar(int id, Document doc) {
		conn.getColl().replaceOne(new Document("_id", id), doc);
	}

	public void cambioCiudad() {
		conn.getColl().updateMany(new
				Document("ciudad", "Madrid"),
				 new Document("$set", new Document("ciudad", "Sevilla")));
	}

	public AggregateIterable<Document> precioMax() {
		AggregateIterable<Document> iterable = conn.getColl()
				.aggregate(Arrays.asList(Aggregates.group("Evento más caro", Accumulators.max("max", "$precio"))));
		return iterable;
	}

	public AggregateIterable<Document> sumaPrecio() {
		AggregateIterable<Document> iterable = conn.getColl()
				.aggregate(Arrays.asList(Aggregates.group("Precio de todos los eventos", Accumulators.sum("total", "$precio"))));
		return iterable;
	}

	public void borrar(int id) {
		conn.getColl().deleteOne(new Document("_id", id));
	}

	public void borrarTodos() {
		conn.getColl().deleteMany(new Document());
	}

	public void borrarColeccion() {
		conn.getColl().drop();
	}
	
	
}
