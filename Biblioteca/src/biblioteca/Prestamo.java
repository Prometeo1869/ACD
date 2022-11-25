package biblioteca;

public class Prestamo {

	int id_libro;
	int id_socio;
	String fecha_inicio;
	String fecha_fin;
	public Prestamo(int id_libro, int id_socio, String fecha_inicio, String fecha_fin) {
		this.id_libro = id_libro;
		this.id_socio = id_socio;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	public Prestamo() {
		
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public int getId_socio() {
		return id_socio;
	}
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	@Override
	public String toString() {
		return "Prestamos [id_libro=" + id_libro + ", id_socio=" + id_socio + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + "]";
	}
	
	
	
	
}
