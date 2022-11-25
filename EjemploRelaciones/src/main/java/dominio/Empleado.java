package dominio;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Empleado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_completo", unique = true)
	private String nombre;
	private String nif;
	private Integer edad;
	/*
	@OneToOne
	private Compartimento compartimentoAsignado;
	
	public void setCompartimentoAsignado(Compartimento compartimento) {
		this.compartimentoAsignado = compartimento;
		
	}
	*/
	@ManyToOne
	private Departamento departamento;
	
	
	
	public void setNombre(String string) {
		this.nombre = string;
		
	}

	public void setNif(String string) {
		this.nif = string;
	}

	public void setEdad(int i) {
		this.edad = i;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
}
