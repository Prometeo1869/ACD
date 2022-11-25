package xstream1;

import java.io.Serializable;
import java.util.Objects;

public class Cpersona implements Serializable { 

	String nombre, apellido, telefono;

	public Cpersona(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	public Cpersona(String nombre) {
		this.nombre = nombre;
		this.apellido = "";
		this.telefono = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "[" + nombre + " " + apellido + ", " + telefono + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Cpersona otraPersona = (Cpersona) obj;
		return this.nombre.equals(otraPersona.nombre);
	}
	
	
}