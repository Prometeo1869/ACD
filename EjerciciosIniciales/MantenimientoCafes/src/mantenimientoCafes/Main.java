package mantenimientoCafes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CafeBD cafes = new CafeBD();
		List<Cafe> todos = new ArrayList<>();
		todos = cafes.mostarTodo();
		
		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();

			switch (opc) {
			case 1 -> {
				String nombre;
				int ventas;
				System.out.println("Nombre del caféa actualizar:");
				nombre = new Scanner(System.in).next();
				Cafe aux = new Cafe(nombre);
				if (todos.contains(aux)) {
					System.out.println("Número de ventas:");
					ventas = new Scanner(System.in).nextInt();
					cafes.actualizarCafe(nombre, ventas);
				} else {
					System.out.println("No existe el registro que quiere actualizar");
				}
			}
			case 2 -> {
				Cafe cafe, aux;
				String nombre;
				int proveedor, ventas, total;
				float precio;
				System.out.println("Nombre del caféa actualizar:");
				nombre = new Scanner(System.in).next();
				aux = new Cafe(nombre);
				todos = cafes.mostarTodo();
				boolean b = true;
				for (Cafe cafe2 : todos) {
					if (cafe2.equals(aux))
						b = false;
				}
				if (b) {
					System.out.println("ID del proveedor:");
					proveedor = new Scanner(System.in).nextInt();
					System.out.println("Precio:");
					precio = new Scanner(System.in).nextFloat();
					System.out.println("Número de ventas:");
					ventas = new Scanner(System.in).nextInt();
					System.out.println("Total:");
					total = new Scanner(System.in).nextInt();
					cafe = new Cafe(nombre, proveedor, precio, ventas, total);
					cafes.addCafe(cafe);
				} else {
					System.out.println("El cafe " + nombre + " ya existe");
				}
			}
			case 3 -> {
				String nombre;
				System.out.println("Nombre:");
				nombre = new Scanner(System.in).nextLine();
				System.out.println(cafes.mostarCafe(nombre));
				if (cafes.mostarCafe(nombre) != null) {
					String respuesta = "";
					do {
						System.out.println("¿Estás seguro? si/no");
						respuesta = new Scanner(System.in).next();
						if(!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
							System.out.println("Por favor, responda: si/no");
						}
						if(respuesta.equalsIgnoreCase("si")) {
							cafes.borrarCafe(nombre);
						}
					} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));
				} else {
					System.out.println("No existe el registro que quiere borrar");
				}
			}
			case 4 -> {
				String nombre;
				System.out.println("Nombre:");
				nombre = new Scanner(System.in).nextLine();
				Cafe aux = new Cafe(nombre);
				if (todos.contains(aux)) {
					System.out.println(cafes.mostarCafe(nombre));
				} else {
					System.out.println("No existe ningún registro con ese nombre");
				}
			}
			case 5 -> {
				todos = cafes.mostarTodo();
				System.out.println(todos.toString());
			}
			case 6 -> {
				cafes.conexion.deconectar();
			}
			}
		} while (opc != 6);
	}

	static void menu() {
		System.out.println("+-------------------------+");
		System.out.println("|1. Actualizar un café    |");
		System.out.println("|2. Añadir un nuevo café  |");
		System.out.println("|3. Borrar un café        |");
		System.out.println("|4. Mostrar               |");
		System.out.println("|5. Mostrar todos         |");
		System.out.println("|6. Salir                 |");
		System.out.println("+-------------------------+");
	}
}
