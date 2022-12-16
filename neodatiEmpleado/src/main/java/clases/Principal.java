package clases;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import clases.dao.DepartamentoDAO;
import clases.dao.EmpleadoDAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ODB odb = ODBFactory.open("neodatis.test");
		DepartamentoDAO depDAO = new DepartamentoDAO(odb);
		EmpleadoDAO empDAO = new EmpleadoDAO(odb);

		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();

			switch (opc) {
			case 1:
				Departamento d = depDAO.datosDepartamento();
				if (d != null) {
					odb.store(d);
					odb.commit();
					System.out.println("\nDepartamento creado correctamente\n");
				}
				break;
			case 2:
				Empleado e = empDAO.datosEmpleado();
				if (e != null) {
					odb.store(e);
					odb.commit();
				}
				break;
			case 13:
				odb.close();
			}
		} while (opc != 13);
	}

	static void menu() {
		System.out.println(" 1. Crear departamento ");
		System.out.println(" 2. Crear empleado ");
		System.out.println(" 3. Modificar departamento ");
		System.out.println(" 4. Modificar empleado ");
		System.out.println(" 5. Eliminar departamento ");
		System.out.println(" 6. Eliminar empleado ");
		System.out.println(" 7. Mostrar todos los departamentos ");
		System.out.println(" 8. Mostrar todos los empleados ");
		System.out.println(" 9. Apellidos de los empleados por departamento ");
		System.out.println(" 10. Número de empleados por nombre de departamento ");
		System.out.println(" 11. Empleados por apellido de su director ");
		System.out.println(" 12. Número de empleados por departamento ");
		System.out.println(" 13. Salir ");

	}
}
