package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.EmpleadoDAO;
import dominio.Empleado;

public class Principal {

	public static void main(String[] args) {
		
		EmpleadoDAO empleados = new EmpleadoDAO();
		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1:
				empleados.encontrarTodos();
				break;
			case 2:
				try {
					System.out.println("Código del empleado:");
					Long code= new Scanner(System.in).nextLong();
					if(empleados.encontrarUno(code) != null) {
					System.out.println(empleados.encontrarUno(code));
					} else {
						System.out.println("El empleado no existe");
					}
				} catch (InputMismatchException e) {
					System.out.println("Formato de id no válido");
				}
				
				break;
			case 3: 
				try {
					System.out.println("Nombre: ");
					String nombre = new Scanner(System.in).next();
					System.out.println("DNI: ");
					String dni = new Scanner(System.in).next();
					System.out.println("Edad: ");
					int edad = new Scanner(System.in).nextInt();
					Empleado e = new Empleado(null, nombre, dni, edad);
					empleados.insertarNuevo(e);
				} catch (InputMismatchException e2) {
					System.out.println("Formato de Edad no valido");
				}
				break;
			case 4:
				try {
					System.out.println("Id de empleado que se quiere editar:");
					Long idE = new Scanner(System.in).nextLong();
					System.out.println("Nombre: ");
					String nombreNuevo = new Scanner(System.in).next();
					System.out.println("DNI: ");
					String dniNuevo = new Scanner(System.in).next();
					System.out.println("Edad: ");
					int edadNuevo = new Scanner(System.in).nextInt();
					Empleado eEditar = new Empleado(idE, nombreNuevo, dniNuevo, edadNuevo);
					empleados.actualizar(eEditar);
				} catch (InputMismatchException e2) {
					System.out.println("Formato no valido");
				}
				break;
			case 5: 
				try {
					System.out.println("Id del empleado a borrar:");
					Long idBorrar = new Scanner(System.in).nextLong();
					empleados.borrar(idBorrar);
				} catch (InputMismatchException e2) {
					System.out.println("Formato de Id no valido");
				}
				break;
			}
		} while (opc != 6);
	}

	static void menu() {
		System.out.println("\n+---------------------------------+");
		System.out.println("| 1. Mostrar todos los empleados  |");
		System.out.println("| 2. Mostrar un empleado          |");
		System.out.println("| 3. Insertar un nuevo empleado   |");
		System.out.println("| 4. Modicar empleado existente   |");
		System.out.println("| 5. Borrar empleado existente    |");
		System.out.println("| 6. Salir                        |");
		System.out.println("+---------------------------------+");

	}
}
