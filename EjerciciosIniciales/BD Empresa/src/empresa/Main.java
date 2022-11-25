package empresa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * Conexión con la base de datos
		 */
		GestionBD conexion = new GestionBD();
		EmpleadoBD empleados = new EmpleadoBD(conexion);
		DepartamentoBD departamentos = new DepartamentoBD(conexion);

		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();

			switch (opc) {
			case 1:
				agregarEmpleado(empleados, departamentos);
				break;
			case 2:
				subirSalario(empleados, departamentos);
				break;
			case 3:
				consultaDatos(empleados);
				break;
			case 4:
				altaNuevoDepartamento(departamentos);
				break;
			case 5: 
				borrarDepartamento(empleados, departamentos);
				break;
			case 6:
				System.out.println("No me ha dado tiempo de hacer la navegación");
				break;
			case 7:
				conexion.desconectar();
				break;
			}
		} while (opc != 7);

	}

	private static void borrarDepartamento(EmpleadoBD empleados, DepartamentoBD departamentos) throws SQLException {
		System.out.println("Número de Departamento: ");
		int num = new Scanner(System.in).nextInt();
		if(!departamentos.buscarDepartameto(num)) {
			System.out.println("El departamento " + num + " no existe");
		} else {
			if(empleados.hayEmpleadosEnDepartamento(num)) {
				System.out.println("Imposible eliminar departamento, tiene empleados");
			} else {
				departamentos.borrarDepartamento(num);
			}
		}
		
	}

	private static void altaNuevoDepartamento(DepartamentoBD departamentos) throws SQLException {
		Departamento nuevo;
		System.out.println("Número de Departamento: ");
		int dept_no = new Scanner(System.in).nextInt();
		if(departamentos.buscarDepartameto(dept_no)) {
			System.out.println("Ya existe ese departamento");
		} else {
		System.out.println("Nombre de departamento:");
		String nombre = new Scanner(System.in).next();
		
		System.out.println("Localidad:");
		String loc = new Scanner(System.in).next();
		nuevo = new Departamento(dept_no, nombre, loc);
		departamentos.addDepartamento(nuevo);
		System.out.println("Departamento insertado");
		}
	}

	private static void consultaDatos(EmpleadoBD empleados) throws SQLException {
		System.out.println("Numero de Empleado:");
		int numEmp = new Scanner(System.in).nextInt();
		if(!empleados.buscarEmpleado(numEmp)) {
			System.out.println("No existe empleado");
		} else {
			System.out.println(empleados.getEmpleado(numEmp).toString());
		}
		
	}

	private static void subirSalario(EmpleadoBD empleados, DepartamentoBD departamentos) {
		try {
			System.out.println("Departamento: ");
			int dep = new Scanner(System.in).nextInt();
			if (!departamentos.buscarDepartameto(dep)) {
				System.out.println("El departamento introducido no existe");
			} else {
				System.out.println("Incremento del salario:");
				int incremento = new Scanner(System.in).nextInt();
				empleados.subida_sal(dep, incremento);
				System.out.println("Subida realizada");
			}
		} catch (SQLException e) {
			System.out.println("No se ha realizado la actualización");
		}
	}

	private static void menu() {
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("| 1. Alta de Empleado                                             |");
		System.out.println("| 2. Actualización del salario a los empleados de un departamento |");
		System.out.println("| 3. Consulta de los datos de un empleado concreto                |");
		System.out.println("| 4. Altas de nuevos departamentos                                |");
		System.out.println("| 5. Bajas de departamentos                                       |");
		System.out.println("| 6. Navegación por la tabla Departamentos                        |");
		System.out.println("| 7. Salir                                                        |");
		System.out.println("+-----------------------------------------------------------------+");

	}

	private static void agregarEmpleado(EmpleadoBD empleados, DepartamentoBD departamentos) throws SQLException {

		int empNo, dir, salario, comision, deptNo;
		String apellido, oficio;
		LocalDate fechaAlta;
		Empleado e;
		System.out.println("Número de empleado:");
		empNo = new Scanner(System.in).nextInt();
		// Saber si el empleado ya existe
		if (empleados.buscarEmpleado(empNo)) {
			System.out.println("Ya existe el empleado");
		} else {
			System.out.println("Departamento:");
			deptNo = new Scanner(System.in).nextInt();
			// Saber si el departamento existe
			if (!departamentos.buscarDepartameto(deptNo)) {
				System.out.println("Imposible insertar el empleado, no existe el departamento introducido");
			} else {
				System.out.println("Salario:");
				salario = new Scanner(System.in).nextInt();
				if (salario <= 0) {
					System.out.println("El salario debe ser mayor de 0");
				} else {
					System.out.println("Id del director:");
					dir = new Scanner(System.in).nextInt();
					if (!empleados.buscarEmpleado(dir)) {
						System.out.println("No existe ese director");
					} else {
						fechaAlta = LocalDate.now();
						System.out.println("Comisión: ");
						comision = new Scanner(System.in).nextInt();
						System.out.println("Apellido:");
						apellido = new Scanner(System.in).next();
						System.out.println("Oficio:");
						oficio = new Scanner(System.in).next();
						e = new Empleado(empNo, apellido, oficio, dir, fechaAlta.toString(), salario, comision, deptNo);
						empleados.addEmpleado(e);
					}
				}
			}
		}

	}
}
