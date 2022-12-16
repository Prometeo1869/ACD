package clases.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import clases.Departamento;
import clases.Empleado;

public class EmpleadoDAO {
	
	ODB odb;

	public EmpleadoDAO(ODB odb) {
		this.odb = odb;
	}

	public Empleado datosEmpleado() {
		Empleado e = new Empleado();
		int codigo = -1;
		String apellido = "";
		String oficio = "";
		Empleado dir = null;
		java.sql.Date fechaAlt = Date.valueOf(LocalDate.now());
		float salario = 0;
		float comision = 0;
		Departamento dept = null;
		boolean existe = false;
		try {
			System.out.println("Código del nuevo empleado:");
			codigo = new Scanner(System.in).nextInt();
			// Comprobar si empleado existe
			if (existeEmpleado(codigo)) {	//Ya existe empleado con ese ćodigo
				System.out.println("\nYa existe un empleado con ese código\n");
				return null;
			} else { 						// No existe un empleado con ese código
				// Comprobar si existe el director
				System.out.println("Código del director:");
				int codDir = new Scanner(System.in).nextInt();
				if (!existeEmpleado(codDir)) {
					System.out.println("\nNo existe un empleado con ese código\n");
					return null;
				} else {
					
				}	
			} // if

		} catch (Exception ex) {
			System.out.println("\nDatos introducidos no válidos\n");
		}

		return null;
	}
	
	private static boolean existeEmpleado(int codigo) {
		ODB odb = ODBFactory.open("neodatis.bd");
		Objects<Empleado> empleados = odb.getObjects(Empleado.class);
        try {
        	while (empleados.hasNext()) {
				if (codigo == empleados.next().getEmpNo()) {
					System.out.println("\nYa existe un empleado con ese código\n");
					return true;
				} // if
			} // while
            odb.close();
            return true;
        } catch (Exception e) {
            odb.close();
            return false;
        }
	}
	
}
