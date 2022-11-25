package biblioteca;

public class Socio {

	int id_socio;
	String nombre_socio;
	int edad;
	String direccion;
	public Socio(int id_socio, String nombre_socio, int edad, String direccion) {
		this.id_socio = id_socio;
		this.nombre_socio = nombre_socio;
		this.edad = edad;
		this.direccion = direccion;
	}
	public Socio() {
		
	}
	public int getId_socio() {
		return id_socio;
	}
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}
	public String getNombre_socio() {
		return nombre_socio;
	}
	public void setNombre_socio(String nombre_socio) {
		this.nombre_socio = nombre_socio;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Socio [id_socio=" + id_socio + ", nombre_socio=" + nombre_socio + ", edad=" + edad + ", direccion="
				+ direccion + "]";
	}
	
	
}
