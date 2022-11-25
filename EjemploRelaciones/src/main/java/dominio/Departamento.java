package dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Departamento implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String nombre;
	@OneToMany(mappedBy="departamento")
	private Collection<Empleado> empleados = new HashSet<>();
	
	public void setNombre(String string) {
		this.nombre = string;
	}

	@OneToMany(mappedBy="departamento")
	public Collection<Empleado> getEmpleados() {
		return this.empleados;
	}

	public String getNombre() {
		return this.nombre;
	}
	
}
