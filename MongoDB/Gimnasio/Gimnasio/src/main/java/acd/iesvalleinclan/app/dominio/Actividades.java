package acd.iesvalleinclan.app.dominio;

/**
 * Clase Actividades con los mismos atributos que el documento "actividades" de la base de datos "gimnasio"
 * 
 * @author Juan Cebrián
 *
 */
public class Actividades {

	int id;
	String nombre;
	int tipo;
	
	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public Actividades(int id, String nombre, int tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	//CONSTRUCTOR VACIO
	public Actividades() {
		super();
	}

	//GETTER & SETTER
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public int getTipo() { return tipo; }
	public void setTipo(int tipo) { this.tipo = tipo; }
	
	//TOSTRING
	@Override
	public String toString() {
		return "Actividades [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
}
