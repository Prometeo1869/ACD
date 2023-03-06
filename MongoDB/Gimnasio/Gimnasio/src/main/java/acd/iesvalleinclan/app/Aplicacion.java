package acd.iesvalleinclan.app;

import java.time.LocalDate;
import java.util.Scanner;

import org.bson.Document;

import acd.iesvalleinclan.app.dao.Consultas;
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
					if (!titulo.equals("socios") && !titulo.equals("actividades") && !titulo.equals("uso_gimnasio")) {
						System.out.println("ERROR!! COLECCIÓN NO VALIDA\n");
					}
				} while (titulo.equals("socios") && titulo.equals("actividades") && titulo.equals("uso_gimnasio"));
				pedirDatos(titulo);
				break;
			case 5:
				String titulo2 = "";
				do {
					System.out.println("Escriba el nombre de la colección:\n");
					titulo2 = new Scanner(System.in).next();
					if (!titulo2.equals("socios") && !titulo2.equals("actividades")
							&& !titulo2.equals("uso_gimnasio")) {
						System.out.println("ERROR!! COLECCIÓN NO VALIDA\n");
					}
				} while (titulo2.equals("socios") && titulo2.equals("actividades") && titulo2.equals("uso_gimnasio"));
				borrar(titulo2);

				break;
			case 6:
				consultas.cerrarConexion();

				break;
			}
		} while (opc != 6);
	}

	private static void borrar(String titulo) {
		Consultas consultas = new Consultas();
		Document nuevo = new Document();

		if (titulo.equals("socios")) {
			System.out.println("ID:");
			String id = new Scanner(System.in).next();
			if (consultas.findSocioById(id) == null) {
				System.out.println("No existe socio con es codigo");
			} else {
				consultas.eliminarSocio(id);
				System.out.println("Socio " + id + " eliminado");
			}
		}
		if (titulo.equals("actividades")) {
			System.out.println("ID:");
			String id = new Scanner(System.in).next();
			
			if (consultas.findSocioById(id) == null) {
				System.out.println("No existe socio con es codigo");
			} else {
				consultas.eliminarActividad(id);
				System.out.println("Actividad con id: " + id + ", eliminada");
			}
		}
		if (titulo.equals("uso_gimnasio")) {
			System.out.println("ID:");
			String id = new Scanner(System.in).next();
			consultas.eliminarUso(id);
			System.out.println("Uso_gimnasio con id: " + id + ", eliminado");
		}

		consultas.cerrarConexion();

	}

	private static void pedirDatos(String titulo) {
		Consultas consultas = new Consultas();
		Document nuevo = new Document();

		try {
			if (titulo.equals("socios")) {
				Socios socio = new Socios();
				System.out.println("ID:");
				socio.setId(new Scanner(System.in).next());
				System.out.println("NOMBRE:");
				socio.setNombre(new Scanner(System.in).next());
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
				actividades.setId(new Scanner(System.in).next());
				System.out.println("NOMBRE:");
				actividades.setNombre(new Scanner(System.in).next());
				System.out.println("TIPO:");
				actividades.setTipo(new Scanner(System.in).nextInt());

				nuevo = new Document("_id", actividades.getId()).append("NOMBRE", actividades.getNombre())
						.append("_tipo", actividades.getTipo());

				consultas.insertarDocumentoActividades(nuevo);
			}
			if (titulo.equals("uso_gimnasio")) {
				UsoGimnasio uso = new UsoGimnasio();
				System.out.println("CÓDIGO DE SOCIO:");
				String codSocio = new Scanner(System.in).next();
				if (consultas.findSocioById(codSocio) == null) {
					System.out.println("No existe socio con es codigo");
				} else {
					uso.setCodsocio(codSocio);
					System.out.println("CÓDIGO ACTIVIDAD:");
					String codAct = new Scanner(System.in).next();
					if (consultas.findActById(codAct) == null) {
						System.out.println("No existe actividad con es codigo");
					} else {
						uso.setCodactiv(codAct);
						System.out.println("HORA INICIO");
						uso.setHorainicio(new Scanner(System.in).nextInt());
						System.out.println("HORA FINAL");
						uso.setHorafinal(new Scanner(System.in).nextInt());
						System.out.println("FECHA");
						uso.setFecha(new Scanner(System.in).next());
					}
				}
				nuevo = new Document("CODSOCIO", uso.getCodsocio()).append("CODACTIV", uso.getCodactiv())
						.append("FECHA", uso.getFecha()).append("HORAINICIO", uso.getHorainicio())
						.append("HORAFINAL", uso.getHorafinal());

				consultas.insertarDocumentoUsoGimnasio(nuevo);
			}
		} catch (Exception e) {
			System.out.println("Error al introducir datos");
		}

		consultas.cerrarConexion();
	}

	static void menu() {
		System.out.println("\n1) Mostrar todo socios.");
		System.out.println("2) Mostrar todo actividades.");
		System.out.println("3) Mostrar todo uso_gimansio.");
		System.out.println("4) Insertar un documento en cualquier colección. Se le pasa el nombre de la colección y el documento a insertar.");
		System.out.println("5) Eliminar un documento de cualquier colección.");
		// Crea las clases y paquetes necesarios respetando todas las normas seguidas
		// durante el curso\n");
		// (MVC, clases DAO, estructura modular, petición, visualización de datos y
		// mensajes de error en la vista, etc).
	}
}
