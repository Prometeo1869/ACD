package aplicacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.EquipoDAO;
import DAO.EstadisticaDAO;
import DAO.JugadoreDAO;
import model.Equipo;
import model.Estadistica;
import model.EstadisticaPK;
import model.Jugadore;

public class Principal {

	public static void main(String[] args) {
		EstadisticaDAO listaEstadisticas = new EstadisticaDAO();
		JugadoreDAO listaJugadores = new JugadoreDAO();
		EquipoDAO listaEquipos = new EquipoDAO();

		int opc = 0;
		do {
			menu();
			opc = new Scanner(System.in).nextInt();
			switch (opc) {
			/*
			 * a. INSERTAR ESTADÍSTICAS POR JUGADOR: Se solicitarán los datos de las
			 * estadísticas del jugador comprobando que el jugador exista y que no se haya
			 * introducido ya esa estadística. Los datos no obligatorios que no se
			 * introduzcan tendrán el valor nulo.
			 */
			case 1:
				System.out.println("Id del jugador");
				long id = new Scanner(System.in).nextLong();
				// Comprobar si el jugador existe
				Jugadore jugador = listaJugadores.consultaJugador(id);
				if (jugador == null) { // No existe
					System.out.println("No existe el jugador");
				} else { // Si existe
					System.out.println("Temporada: ");
					String temporada = new Scanner(System.in).next();
					EstadisticaPK idEstadistica = new EstadisticaPK(temporada, id);
					// Comprobar si existe la estadistica
					if (listaEstadisticas.comprobarEstadisticaPK(idEstadistica)) { // Si existe
						System.out.println("Ya existe esta estadistca para este jugador");
					} else { // No existe
						// Método para pedir datos de las estadisticas
						Estadistica estadistica = pedirDatosEstadisticas(idEstadistica, jugador);
						// Método para insertar estadisticas
						listaEstadisticas.insertarEstadistica(estadistica);
						System.out.println("Estadisticas introducidas");
					}
				}
				break;
			/*
			 * b. MOSTRAR ESTADÍSTICAS: Se solicitará el código de un jugador, y si existe,
			 * se mostrará todos los datos sobre sus estadísticas. En otro caso se mostrará
			 * el mensaje correspondiente.
			 */
			case 2:
				System.out.println("Id del jugador");
				long id2 = new Scanner(System.in).nextLong();
				// Comprobar si el jugador existe
				Jugadore jugador2 = listaJugadores.consultaJugador(id2);
				ArrayList<Estadistica> estadisticas2 = listaEstadisticas.consultaJugador(id2);
				
				if (jugador2 == null) { // No existe
					System.out.println("No existe el jugador");
				} else { // Si existe
					System.out.println(mostrarEstadisticas(jugador2));

				}
				break;
			/*
			 * c. LISTADO DE JUGADORES POR EQUIPO: Se debe mostrar por cada equipo la lista
			 * de sus jugadores (número de jugador, nombre y altura en metros). El listado
			 * debe aparecer ordenado por equipo. Debe mostrar también el número de equipos
			 * que hay.
			 */
			case 3:
				/**
				 * El método mostrarTodo devolvera una cadena con el formato especificado
				 */
				System.out.println(mostarEquipos(listaEquipos));
				break;
			}
		} while (opc != 4);

	}

	private static String mostarEquipos(EquipoDAO dao) {
		ArrayList<Equipo> lista = dao.onsultarTodos();
		JugadoreDAO jugadores = new JugadoreDAO();
		String cadena = "";
		cadena += "Número de equipos: " + lista.size() + "\n";
		for (Equipo e : lista) {
			cadena += "Equipo: " + e.getNombreEquipo() + "\n";
			try {
			for (Jugadore j : jugadores.consultaPorEquipo(e)) {
				cadena += j.getIdJugador() + ", " + j.getNombre() + ", " + j.getAltura() + "\n";
			}
			} catch (NullPointerException ex) {}
			cadena += "======================================================\n";
		}
		return cadena;
	}

	/**
	 * Método para pedir los Datos de las estadísticas
	 * 
	 * @param idEstadistica > identificador de la estadística
	 * @param jugador       > jugador de la estadística
	 * @return estadistica
	 */
	private static Estadistica pedirDatosEstadisticas(EstadisticaPK idEstadistica, Jugadore jugador) {

		System.out.println("ASISTENCIAS_POR_PARTIDO");
		BigDecimal asistenciasPorPartido = new Scanner(System.in).nextBigDecimal();
		System.out.println("PUNTOS_POR_PARTIDO");
		BigDecimal puntosPorPartido = new Scanner(System.in).nextBigDecimal();
		System.out.println("REBOTES_POR_PARTIDO");
		BigDecimal rebotesPorPartido = new Scanner(System.in).nextBigDecimal();
		System.out.println("TAPONES_POR_PARTIDO");
		BigDecimal taponesPorPartido = new Scanner(System.in).nextBigDecimal();
		Estadistica estadistica = new Estadistica(idEstadistica, asistenciasPorPartido, puntosPorPartido,
				rebotesPorPartido, taponesPorPartido, jugador);
		return estadistica;
	}

	/**
	 * Método para mostrar las estadísticas especificadas en el ejercicio b.
	 * 
	 * @return cadena
	 */
	public static String mostrarEstadisticas(Jugadore j) {
		EstadisticaDAO listaEstadisticas = new EstadisticaDAO();
		String cadena = "";
		cadena += "Datos del jugador: " + j.getIdJugador() + "\n";
		cadena += "Jugador: " + j.getNombre() + "\n";
		cadena += "Temporada\tpuntos\tasistencias\ttapones\trebotes\n";
		try {
			ArrayList<Estadistica> estadisticas = listaEstadisticas.consultaJugador(j.getIdJugador());

			for (Estadistica e : estadisticas) {
				cadena += e.getId().getTemporada() + "\t";
				cadena += e.getPuntosPorPartido() + "\t";
				cadena += e.getAsistenciasPorPartido() + "\t";
				cadena += e.getTaponesPorPartido() + "\t";
				cadena += e.getRebotesPorPartido() + "\n";
			}
			cadena += "Número de registros: " + estadisticas.size();
		} catch (Exception e) {
			cadena += "NO HAY ESTADÍSTICAS REGISTRADAS PARA ESTE JUGADOR";
		}
		return cadena;
	}

	static void menu() {
		System.out.println("+---------------------------------------+");
		System.out.println("| 1. Insertar estadísticas por juador   |");
		System.out.println("| 2. Mostrar estadísticas de un jugador |");
		System.out.println("| 3. Listado de jugadores por equipo    |");
		System.out.println("| 4. Salir                              |");
		System.out.println("+---------------------------------------+");
	}
}
