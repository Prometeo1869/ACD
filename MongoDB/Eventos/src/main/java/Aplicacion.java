import java.util.Scanner;

import controlador.Consultas;

public class Aplicacion {

	public static void main(String[] args) {
		
		Consultas consultas = new Consultas(); 	//Controlador, donde están los métodos para hacer las consultas
		System.out.println(consultas.mensaje());
		Scanner sc = new Scanner(System.in);
		int opc = 0; 							//Opciones de menú
		
		do {
			switch (opc) {
			case 1: 			//Insertar un documento en la colección
				
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
		System.out.println("| 4. Consultar las colección ordenadas por precio de forma ascendente o descendente.|");
		System.out.println("| 5. Editar un documento                                                            |");
		System.out.println("| 6. Editar documentos cuyo precio sea inferior a...                                |");
		System.out.println("| 7. Remplazar documento por id                                                     |");
		System.out.println("| 8. Consultar coleccines con nombre en mayúsculas y aplicando un descuento del 10% |");
		System.out.println("| 9. Consultar suma de los precios de los eventos de una ciudad                     |");
		System.out.println("| 10. Eliminar un documento de la colección por id                                  |");
		System.out.println("| 11. Borrar todos los documentos de la colección.                                  |");
		System.out.println("| 12. Eliminar la colección.                                                        |");
		System.out.println("| 13. Salir                                                                         |");
		System.out.println("+-----------------------------------------------------------------------------------+\n");
	}
}
