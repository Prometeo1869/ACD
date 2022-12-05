package application;

import java.math.BigDecimal;
import java.util.Scanner;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.MatriculaDAO;
import model.Alumno;
import model.Asignatura;
import model.MatriculacionPK;

public class Principal {

	public static void main(String[] args) {

		AlumnoDAO listaAlumnos = new AlumnoDAO();
		AsignaturaDAO listaAsignaturas = new AsignaturaDAO();
		MatriculaDAO listaMatriculaciones = new MatriculaDAO();

		int opc = 0;

		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1:
				Alumno nuevoAlumno = new Alumno();
				System.out.println("DNI:");
				nuevoAlumno.setDni(new Scanner(System.in).next());
				System.out.println("Nombre:");
				nuevoAlumno.setNombre(new Scanner(System.in).next());
				System.out.println("Apellidos:");
				nuevoAlumno.setApellidos(new Scanner(System.in).next());
				System.out.println("Domicilio:");
				nuevoAlumno.setDomicilio(new Scanner(System.in).next());
				System.out.println("Telefono:");
				nuevoAlumno.setTelefono(new Scanner(System.in).next());
				System.out.println("Tipo de acceso (0 ó 1):");
				nuevoAlumno.setTipoacceso(new Scanner(System.in).nextBigDecimal());

				if (listaAlumnos.altaAlumno(nuevoAlumno)) {
					System.out.println("\nAlta de alumno correcta");
				} else {
					System.out.println("\nNo se ha podido hacer el alta porque ya existe el alumno");
				}
				break;
			case 2:
				Asignatura nuevaAsignatura = new Asignatura();
				System.out.println("Código:");
				nuevaAsignatura.setCodigo(new Scanner(System.in).next());
				System.out.println("Título:");
				nuevaAsignatura.setTitulo(new Scanner(System.in).next());
				System.out.println("Créditos:");
				nuevaAsignatura.setCreditos(new Scanner(System.in).nextBigDecimal());

				if (listaAsignaturas.altaAsignatura(nuevaAsignatura)) {
					System.out.println("\nAlta de asignatura correcta");
				} else {
					System.out.println("\nNo se ha podido hacer el alta porque ya existe la asignatura");
				}
				break;
			case 3:
				System.out.println("DNI del alumno:");
				String dni = new Scanner(System.in).next();
				if (listaAlumnos.bajaAlumno(dni)) {
					System.out.println("\nBaja de alumno realizada correctamente");
				} else {
					System.out.println("\nNo se ha podido hacer la baja porque no existe ningún alumno con ese DNI");
				}
				break;
			case 4:
				System.out.println("DNI del alumno:");
				String dniConsulta = new Scanner(System.in).next();
				if (listaAlumnos.consultaAlumo(dniConsulta) == null) {
					System.out.println("\nNo se encuentra alumno con ese DNI en la base de datos");
				} else {
					System.out.println("\n" + listaAlumnos.consultaAlumo(dniConsulta).toString());
				}
				break;
			case 5:
				System.out.println("Título de la asignatura:");
                String titulo = new Scanner(System.in).next();
                if (listaAsignaturas.consultaAsignaturaTitulo(titulo) == null) {
					System.out.println("\nNo se encuentra asignatura con ese título en la base de datos");
				} else {
					System.out.println("\n" + listaAsignaturas.consultaAsignaturaTitulo(titulo).toString());
				}
				break;
			case 6:
				System.out.println("DNI del alumno:");
				String dniMatricula = new Scanner(System.in).next();
				System.out.println("Código de asignatura:");
				String codigoMatricula = new Scanner(System.in).next();
	            System.out.println("Nota:");
	            BigDecimal nota = new Scanner(System.in).nextBigDecimal();
	            MatriculacionPK codMatricula = listaMatriculaciones.realizarMatriculacion(dniMatricula, codigoMatricula, nota);

	            if (codMatricula == null) {
					System.out.println("\nNo se puede realizar la matriculación");
				} else {
					System.out.println("\n" + codMatricula.toString());
				}
				break;
			case 7:
				System.out.println("Título de asignatura:");
				String tituloConsulta = new Scanner(System.in).next();
				System.out.println(listaMatriculaciones.consultaAlumnos(tituloConsulta));
			}
		} while (opc != 8);
	}

	static void menu() {
		System.out.println("+-----------------------------------------+");
		System.out.println("| 1. Alta de alumno                       |");
		System.out.println("| 2. Alta de asignatura                   |");
		System.out.println("| 3. Bajas de alumno                      |");
		System.out.println("| 4. Consulta de alumno por identificador |");
		System.out.println("| 5. Consulta de asignatura por título    |");
		System.out.println("| 6. Realizar matriculación               |");
		System.out.println("| 7. Consulta de alumnos por asignatura   |");
		System.out.println("| 8. Salir                                |");
		System.out.println("+-----------------------------------------+");
	}
}
