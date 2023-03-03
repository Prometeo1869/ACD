package acd.iesvalleinclan.app;

import java.time.LocalDate;
import java.util.Scanner;

import org.bson.Document;

import acd.iesvalleinclan.app.controlador.Consultas;
import acd.iesvalleinclan.app.dominio.Actividades;
import acd.iesvalleinclan.app.dominio.Socios;
import acd.iesvalleinclan.app.dominio.UsoGimnasio;

public class Aplicacion {
	public static void main(String[] args) {

		Consultas consultas = new Consultas(); // Controlador, donde están los métodos para hacer las consultas
		int opc = 0; // Opciones de menú

		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1: // Mostrar todo socios.
				String cadena = "";
				for (Document a : consultas.findAllSocios()) {
					cadena += String.valueOf(a) + "\n";
				}
				System.out.println(cadena);

				break;

			case 2:
				String cadena2 = "";
				for (Document a : consultas.findAllActividades()) {
					cadena2 += String.valueOf(a) + "\n";
				}
				System.out.println(cadena2);

				break;

			case 3:
				String cadena3 = "";
				for (Document a : consultas.findAllUsoGimnasio()) {
					cadena3 += String.valueOf(a) + "\n";
				}
				System.out.println(cadena3);

				break;
			case 4:
				String titulo = "";
				do {
					System.out.println("Escriba el nombre de la colección:\n");
					titulo = new Scanner(System.in).next();
					if (!titulo.equals("socios") && !titulo.equals("actividades") && !titulo.equals("uso_gimansio")) {
						System.out.println("ERROR!! COLECCIÓN NO VALIDA\n");
					}
				} while (!titulo.equals("socios") || !titulo.equals("actividades") || !titulo.equals("uso_gimansio"));
				pedirDatos(titulo);
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:
				consultas.cerrarConexion();

				break;
			}
		} while (opc != 7);
	}

	private static void pedirDatos(String titulo) {
		Consultas consultas = new Consultas();
		Document nuevo = new Document();
		
		if (titulo.equals("socios")) {
			Socios socio = new Socios();
			System.out.println("ID:");
			socio.setId(new Scanner(System.in).nextInt());
			System.out.println("NOMBRE:");
			socio.setNombre(new Scanner(System.in).next());
			System.out.println("FECHA DE ALTA:");
			socio.setFecha_alt(LocalDate.now().toString());
			System.out.println("DIRECCIÓN:");
			socio.setDireccion(new Scanner(System.in).next());
			System.out.println("CUOTA FIJA:");
			socio.setCuota_fija(new Scanner(System.in).nextInt());

			nuevo = new Document("_id", socio.getId()).append("NOMBRE", socio.getNombre())
					.append("FECHA_ALT", socio.getFecha_alt()).append("DIRECCION", socio.getDireccion())
					.append("CUOTA_FIJA", socio.getCuota_fija());
			
			consultas.insertarDocumentoSocios(nuevo);
		}
		if (titulo.equals("actividades")) {
			Actividades actividades = new Actividades();
			System.out.println("ID:");
			actividades.setId(new Scanner(System.in).nextInt());
			System.out.println("NOMBRE:");
			actividades.setNombre(new Scanner(System.in).next());
			System.out.println("TIPO:");
			actividades.setTipo(new Scanner(System.in).nextInt());
			
			nuevo = new Document("_id", actividades.getId())
					.append("NOMBRE", actividades.getNombre())
					.append("_tipo", actividades.getTipo());
			
			consultas.insertarDocumentoActividades(nuevo);
		}
		if(titulo.equals("uso_gimnasio")) {
			UsoGimnasio uso = new UsoGimnasio();
			
			
			
			
		}
		

		consultas.cerrarConexion();
	}

	static void menu() {
		System.out.println("\n1) Mostrar todo socios.");
		System.out.println("2) Mostrar todo actividades.");
		System.out.println("3) Mostrar todo uso_gimansio.");
		System.out.println(
				"4) Insertar un documento en cualquier colección. Se le pasa el nombre de la colección y el documento a insertar.");
		System.out.println("5) Eliminar un documento de cualquier colección.");
		System.out.println(
				"6) Crea las clases y paquetes necesarios respetando todas las normas seguidas durante el curso\n");
		// (MVC, clases DAO, estructura modular, petición, visualización de datos y
		// mensajes de error en la vista, etc).
	}
}
