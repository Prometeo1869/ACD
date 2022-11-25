package dominio;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Compartimento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descripcion;
	private Empleado empleadoResidente;
	
	@OneToOne(mappedBy="compartimentoAsignado")
	public Empleado getEmpleadoResidente() {
		return empleadoResidente;
	}

	public void setDescripción(String string) {
		this.descripcion = string;	
	}
	
}
