import java.util.Scanner;

import org.bson.Document;

import controlador.Consultas;
import dominio.Evento;

public class Aplicacion {

	public static void main(String[] args) {
		
		Consultas consultas = new Consultas(); 	//Controlador, donde están los métodos para hacer las consultas
		System.out.println(consultas.mensaje());
		int opc = 0; 							//Opciones de menú
		
		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1: //Insertar un documento en la colección
				Evento nuevo = pedirDatos();			//Método para pedir los Datos del nuevo documento
				Document doc = crearDocumento(nuevo);	//Método para crear el nuevo documento con los datos de un Objeto de la Clase Evento
				consultas.insertarDocumento(doc);		//Método de la Clase Controlador Consultas para insertar un nuevo Documento en la Base de Datos 
				System.out.println(consultas.mensaje());
				
				break;
			case 2: //Consultar un documento por id
				System.out.println("Id:");
				int id = new Scanner(System.in).nextInt();
				System.out.println(consultas.consultarPorId(id));
				
				break;
			case 3:	//Consultar un documento por nombre 
				System.out.println("Nombre:");
				String nombre = new Scanner(System.in).nextLine();
				System.out.println(consultas.consultarPorNombre(nombre));
				
				break;
			case 4:	//Consultar las colección ordenadas por precio de forma ascendente o descendente
				System.out.println("Para orden Ascendente introduzca 1,\nPara orden Descendente introduzca 0");
				int orden = new Scanner(System.in).nextInt();
				System.out.println(consultas.consultaPorOrden(orden));
			case 5:	//Editar un documento
				
			case 6:	//Editar documentos cuyo precio sea inferior a...
				
			case 7:	//Remplazar documento por id
				
			case 8:	//Consultar coleccines con nombre en mayúsculas y aplicando un descuento del 10%
				
			case 9:	//Consultar suma de los precios de los eventos de una ciudad
				
			case 10://Eliminar un documento de la colección por id
				
			case 11://Borrar todos los documentos de la colección
				
			case 12://Eliminar la colección
				
			case 13://Salir 
				consultas.cerrarConexion();
			}
		} while(opc != 13); //mientras la opción de menú sea distinta de 13 no saldrá del bucle
		
	}

	/**
	 * Método que muestra las distintas opciones del menú
	 */
	private static void menu() {
		System.out.println("\n+-----------------------------------------------------------------------------------+");
		System.out.println("| 1. Insertar un documento en la colección.                                         |");
		System.out.println("| 2. Consultar un documento por id                                                  |");
		System.out.println("| 3. Consultar un documento por nombre                                              |");
		System.out.println("| 4. Consultar las colección ordenadas por precio de forma ascendente o descendente |");
		System.out.println("| 5. Editar un documento                                                            |");
		System.out.println("| 6. Editar documentos cuyo precio sea inferior a...                                |");
		System.out.println("| 7. Remplazar documento por id                                                     |");
		System.out.println("| 8. Consultar coleccines con nombre en mayúsculas y aplicando un descuento del 10% |");
		System.out.println("| 9. Consultar suma de los precios de los eventos de una ciudad                     |");
		System.out.println("| 10. Eliminar un documento de la colección por id                                  |");
		System.out.println("| 11. Borrar todos los documentos de la colección                                   |");
		System.out.println("| 12. Eliminar la colección                                                         |");
		System.out.println("| 13. Salir                                                                         |");
		System.out.println("+-----------------------------------------------------------------------------------+\n");
	}
	
	/**
	 * Método para pedir los datos de un evento
	 * @return Evento => Objeto de la Clase Evento con los mismos atributos que la base de datos
	 */
	private static Evento pedirDatos() {
		Scanner sc = new Scanner(System.in);
		Evento e = new Evento();
		
		System.out.println("Id:");
		e.setId(sc.nextInt());
		
		System.out.println("Nombre:");
		e.setNombre(sc.next());
		
		System.out.println("Fecha:");
		e.setFecha(sc.next());
		
		System.out.println("Ciudad:");
		e.setCiudad(sc.next());
		
		System.out.println("Precio:");
		e.setPrecio(sc.nextFloat());
		
		return e;
	}
	
	/**
	 * Método para crear un nuevo documento con los datos de un Objeto de la clase Evento
	 * 
	 * @param nuevo
	 * @return Document => Nuevo Documento
	 */
	private static Document crearDocumento(Evento nuevo) {
		Document doc = new Document("_id", nuevo.getId())
				.append("nombre", nuevo.getNombre())
				.append("fecha", nuevo.getFecha())
				.append("ciudad", nuevo.getCiudad())
				.append("precio", nuevo.getPrecio());
		
		return doc;
	}
}
