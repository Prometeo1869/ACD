package clases;

public class Jugadores {
	
	int id;
	String nombre;
	Paises pais;
	
	public Jugadores(int id, String nombre, Paises pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Jugadores [nombre=" + nombre + ", pais=" + pais.getNombrePais() + "]";
	}
	
	

}
