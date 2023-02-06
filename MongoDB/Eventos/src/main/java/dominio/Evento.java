package dominio;

/**
 * Clase Evento con los mismos atributos que los documento de la base de datos "eventos"
 * 
 * @author Juan Cebrián
 *
 */
public class Evento {
	int id;
	String nombre, fecha, ciudad;
	float precio;
	
	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public Evento(int id, String nombre, String fecha, String ciudad, float precio) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.precio = precio;
	}
	//CONSTRUCTOR VACIO
	public Evento() {	}

	//GETTER & SETTER
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { this.fecha = fecha;}
	public String getCiudad() { return ciudad; }
	public void setCiudad(String ciudad) { this.ciudad = ciudad; }
	public float getPrecio() { return precio; }
	public void setPrecio(float precio) { this.precio = precio; }
	
	
	//TO STRING
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", ciudad=" + ciudad + ", precio="
				+ precio + "]";
	}
	
}
