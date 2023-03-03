import java.util.Scanner;

import org.bson.Document;

import controlador.Consultas;
import dominio.Evento;

public class Aplicacion {

	public static void main(String[] args) {

		Consultas consultas = new Consultas(); // Controlador, donde están los métodos para hacer las consultas
		System.out.println(consultas.mensaje());
		int opc = 0; // Opciones de menú

		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1: // Insertar un documento en la colección
				Evento nuevo = pedirDatos(); // Método para pedir los Datos del nuevo documento
				Document doc = crearDocumento(nuevo); // Método para crear el nuevo documento con los datos de un Objeto
														// de la Clase Evento
				consultas.insertarDocumento(doc); // Método de la Clase Controlador Consultas para insertar un nuevo
													// Documento en la Base de Datos
				System.out.println(consultas.mensaje());

				break;
			case 2: // Consultar un documento por id
				System.out.println("Id:");
				int id = new Scanner(System.in).nextInt();
				if(!(consultas.consultarPorId(id) == null)) {
				System.out.println(consultas.consultarPorId(id));
				} else {
					System.out.println("No hay eventos con ese id");
				}

				break;
			case 3: // Consultar un documento por nombre
				System.out.println("Nombre:");
				String nombre = new Scanner(System.in).nextLine();
				if(!(consultas.consultarPorNombre(nombre) == null)) {
					System.out.println(consultas.consultarPorNombre(nombre));
					} else {
						System.out.println("No hay eventos con es nombre");
					}
				break;
			case 4: // Consultar las colección ordenadas por precio de forma ascendente
				String cadena = "";
				for (Document a: consultas.consultaPorOrden(1)) {
					cadena += String.valueOf(a) + "\n";
				}
				System.out.println(cadena);
				break;
			case 5: // Consultar las colección ordenadas por precio de forma descendente
				String cad = "";
				for (Document a: consultas.consultaPorOrden(-1)) {
					cad += String.valueOf(a) + "\n";
				}
				System.out.println(cad);
				break;
			case 6: // Editar un documento por id
				System.out.println("Id del evento a editar:");
				int	idEvento = new Scanner(System.in).nextInt();

				if((consultas.consultarPorId(idEvento) == null)) {
					System.out.println("No hay eventos con esa id");
				} else {
					Evento eventoEditar = pedirDatosSinId(idEvento);
					Document docEditar = crearDocumento(eventoEditar);

					consultas.editar(idEvento, docEditar);
				}		
				break;
			case 7: // Cambiar a Barcelona los eventos que sean de Madrid
				consultas.cambioCiudad();
				System.out.println("Cambio realizado");
				break;
			case 8: // Consultar evento más caro
				String cad2 = "";
				for (Document a: consultas.precioMax()) {
					cad2 += String.valueOf(a) + "\n";
				}
				System.out.println(cad2);
				
				break;
			case 9: // Consultar suma de los precios de los eventos de una ciudad
				String cad3 = "";
				for (Document a: consultas.sumaPrecio()) {
					cad3 += String.valueOf(a) + "\n";
				}
				System.out.println(cad3);
				break;
			case 10:// Eliminar un documento de la colección por id
				System.out.println("Id:");
				int idBorrar = new Scanner(System.in).nextInt();
				consultas.borrar(idBorrar);
				break;
			case 11:// Borrar todos los documentos de la colección
				consultas.borrarTodos();
				break;
			case 12:// Eliminar la colección
				consultas.borrarColeccion();
				break;
			case 13:// Salir
				consultas.cerrarConexion();
				break;
			}
		} while (opc != 13); // mientras la opción de menú sea distinta de 14 no saldrá del bucle

	}

	/**
	 * Método que muestra las distintas opciones del menú
	 */
	private static void menu() {
		System.out.println("\n+--------------------------------------------------------------------+");
		System.out.println("| 1. Insertar un documento en la colección.                            |");
		System.out.println("| 2. Consultar un documento por id                                     |");
		System.out.println("| 3. Consultar un documento por nombre                                 |");
		System.out.println("| 4. Consultar las colección ordenadas por precio de forma ascendente  |");
		System.out.println("| 5. Consultar las colección ordenadas por precio de forma descendente |");
		System.out.println("| 6. Editar un documento por id                                        |");
		System.out.println("| 7. Hacer descuento del 10% a todos los eventos                       |");
		System.out.println("| 8. Consultar evento más caro                                         |");
		System.out.println("| 9. Consultar suma de los precios de los eventos de una ciudad        |");
		System.out.println("| 10. Eliminar un documento de la colección por id                     |");
		System.out.println("| 11. Borrar todos los documentos de la colección                      |");
		System.out.println("| 12. Eliminar la colección                                            |");
		System.out.println("| 13. Salir                                                            |");
		System.out.println("+----------------------------------------------------------------------+\n");
	}

	/**
	 * Método para pedir los datos de un evento
	 * 
	 * @return Evento => Objeto de la Clase Evento con los mismos atributos que la
	 *         base de datos
	 */
	private static Evento pedirDatos() {
		Evento e = new Evento();

		System.out.println("Id:");
		e.setId(new Scanner(System.in).nextInt());

		System.out.println("Nombre:");
		e.setNombre(new Scanner(System.in).nextLine());

		System.out.println("Fecha:");
		e.setFecha(new Scanner(System.in).next());

		System.out.println("Ciudad:");
		e.setCiudad(new Scanner(System.in).nextLine());

		System.out.println("Precio:");
		e.setPrecio(new Scanner(System.in).nextFloat());

		return e;
	}
	
	/**
	 * Método para pedir los datos de un evento sin la id
	 * 
	 * @return Evento => Objeto de la Clase Evento con los mismos atributos que la
	 *         base de datos
	 */
	private static Evento pedirDatosSinId(int id) {
		Evento e = new Evento();
		e.setId(id);
		
		System.out.println("Nombre:");
		e.setNombre(new Scanner(System.in).nextLine());

		System.out.println("Fecha:");
		e.setFecha(new Scanner(System.in).next());

		System.out.println("Ciudad:");
		e.setCiudad(new Scanner(System.in).nextLine());

		System.out.println("Precio:");
		e.setPrecio(new Scanner(System.in).nextFloat());

		return e;
	}

	/**
	 * Método para crear un nuevo documento con los datos de un Objeto de la clase
	 * Evento
	 * 
	 * @param nuevo
	 * @return Document => Nuevo Documento
	 */
	private static Document crearDocumento(Evento nuevo) {
		Document doc = new Document("_id", nuevo.getId()).append("nombre", nuevo.getNombre())
				.append("fecha", nuevo.getFecha()).append("ciudad", nuevo.getCiudad())
				.append("precio", nuevo.getPrecio());

		return doc;
	}
}
