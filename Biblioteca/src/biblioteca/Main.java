package biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConexionBD conexion = null;
		LibroBD libros = null;
		try {
			conexion = new ConexionBD();
			libros = new LibroBD(conexion);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Clase no encontrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DE CONEXIÓN");
		}

		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			case 1 -> {
				int id, opcion = 0;
				String titulo;
				String editorial;
				System.out.println("ID:");
				id = new Scanner(System.in).nextInt();

				try {
					ResultSet rs = conexion.getStmt().executeQuery("SELECT ID_LIBRO FROM LIBROS");
					System.out.println(rs.getInt("ID_LIBRO"));
					if (id == rs.getInt("ID_LIBRO")) {

						menuModificar();
						opcion = new Scanner(System.in).nextInt();
						switch (opcion) {
						case 1 -> {
							System.out.println("Nuevo título: ");
							titulo = new Scanner(System.in).nextLine();
							libros.cambiarTitulo(id, titulo);
						}
						case 2 -> {
							System.out.println("Nueva editorial: ");
							editorial = new Scanner(System.in).nextLine();
							libros.cambiarEditorial(id, editorial);
						}
						default -> {
							System.out.println("Opción elegida no válida");
						}
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}
			}
			case 2 -> {
				int opcion = 0;
				String titulo, editorial;
				menuModificar();
				opcion = new Scanner(System.in).nextInt();
				switch (opcion) {
				case 1 -> {
					System.out.println("Título: ");
					titulo = new Scanner(System.in).nextLine();
					try {
						System.out.println(libros.mostrarTitulo(titulo));
					} catch (SQLException e) {
						System.out.println("NO SE HA ENCONTRADO EL TÍTULO BUSCADO");
					}
				}
				case 2 -> {
					System.out.println("Editorial: ");
					editorial = new Scanner(System.in).nextLine();
					try {
						System.out.println(libros.mostrarEditorial(editorial));
					} catch (SQLException e) {
						System.out.println("NO SE HA ENCONTRADO LA EDITORIAL BUSCADA");
					}
				}
				default -> {
					System.out.println("Opción elegida no válida");
				}
				}
			}
			case 3 -> {
				
			}
			case 5 -> {
				try {
					conexion.deconectar();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR EN LA DESCONEXIÓN");
				}
			}
			}
		} while (opc != 5);

	}

	private static void menuModificar() {
		// TODO Auto-generated method stub
		System.out.println("+--------------+");
		System.out.println("| 1. Titulo    |");
		System.out.println("| 2. Editorial |");
		System.out.println("+--------------+");
	}

	private static void menu() {
		System.out.println("+-------------------------------------------+");
		System.out.println("| 1. Modificar libro                        |");
		System.out.println("| 2. Consulta de libros                     |");
		System.out.println("| 3. Préstamo de libros                     |");
		System.out.println("| 4. Listado de libros prestados a un socio |");
		System.out.println("| 5. Salir                                  |");
		System.out.println("+-------------------------------------------+");
	}

	private static Libro pedirDatos(ConexionBD con) {
		Libro nuevo = new Libro();
		int id;
		String nombre, autor;
		String fecha;

		ResultSet rs;
		try {
			boolean salida = false;
			do {
				System.out.println("ID: ");
				id = new Scanner(System.in).nextInt();
				rs = con.getStmt().executeQuery("SELECT * FROM libro WHERE id=" + id);
				if (rs.next()) {
					System.out.println("Ya existe un libro con ese identificador, prueba con otro");
					new LibroBD(con).mostrarTodos();
					salida = true;
				} else {
					salida = false;
				}
			} while (salida);
			nuevo.setId_libro(id);
			System.out.println("Título:");
			nombre = new Scanner(System.in).nextLine();
			System.out.println("Autor:");
			autor = new Scanner(System.in).nextLine();
			System.out.println("Fecha de publicación (DD/MM/AAAA):");
			fecha = new Scanner(System.in).next();
			nuevo.setTitulo(nombre);
			nuevo.setEditorial(autor);
			nuevo.setFecha_edicion(fecha);
		} catch (NullPointerException e) {
		} catch (SQLException e) {
			System.out.println("ERROR PEDIR DATOS");
			e.printStackTrace();
		}

		return nuevo;
	}

}
