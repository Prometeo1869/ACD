package biblioteca;

import java.util.Objects;

public class Libro {

	private int id_libro;
	private String titulo;
	int num_ejemplares;
	private String editorial;
	int num_paginas;
	private String fecha_edicion;
	
	public Libro(int id_libro, String titulo, int num_ejemplares, String editorial, int num_paginas,
			String fecha_edicion) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.num_ejemplares = num_ejemplares;
		this.editorial = editorial;
		this.num_paginas = num_paginas;
		this.fecha_edicion = fecha_edicion;
	}

	public Libro(int id) { 
		this.id_libro = id;
	}
	
	public Libro() { 
		
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNum_ejemplares() {
		return num_ejemplares;
	}

	public void setNum_ejemplares(int num_ejemplares) {
		this.num_ejemplares = num_ejemplares;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}

	public String getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(String fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return id_libro == other.id_libro;
	}

	@Override
	public String toString() {
		return "Libro [id:" + id_libro + ", titulo:" + titulo + ", num_ejemplares:" + num_ejemplares
				+ ", editorial:" + editorial + ", num_paginas:" + num_paginas + ", fecha_edicion:" + fecha_edicion
				+ "]\n";
	}

	

	
}
