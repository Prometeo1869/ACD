package clases;

public class Paises {
	int id;
	String nombrePais;
	
	
	
	public Paises(int id, String nombrePais) {
		super();
		this.id = id;
		this.nombrePais = nombrePais;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombrePais() {
		return nombrePais;
	}



	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}



	@Override
	public String toString() {
		return "Paises [nombre: " + nombrePais + "]";
	}
	
	
}
