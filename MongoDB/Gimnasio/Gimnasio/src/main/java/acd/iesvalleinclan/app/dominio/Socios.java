package acd.iesvalleinclan.app.dominio;
/**
 * Clase Socios con los mismos atributos que el documento "socios" de la base de datos "gimnasio"
 * 
 * @author Juan Cebrián
 *
 */
public class Socios {
	
    String id, nombre, fecha_alt, direccion;
    float cuota_fija;
    
	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public Socios(String id, String nombre, String fecha_alt, String direccion, float cuota_fija) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_alt = fecha_alt;
		this.direccion = direccion;
		this.cuota_fija = cuota_fija;
	}
	
	//CONSTRUCTOR VACIO
	public Socios() {
		super();
	}

	//GETTER & SETTER
	public String getId() { return id;	}
	public void setId(String id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getFecha_alt() { return fecha_alt; }
	public void setFecha_alt(String fecha_alt) { this.fecha_alt = fecha_alt; }
	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public float getCuota_fija() { return cuota_fija; }
	public void setCuota_fija(float cuota_fija) { this.cuota_fija = cuota_fija; }

	//TOSTRING
	@Override
	public String toString() {
		return "Socios [id=" + id + ", nombre=" + nombre + ", fecha_alt=" + fecha_alt + ", direccion=" + direccion
				+ ", cuota_fija=" + cuota_fija + "]";
	}
  
}
