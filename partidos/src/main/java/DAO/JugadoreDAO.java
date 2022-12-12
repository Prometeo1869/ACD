package DAO;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Equipo;
import model.Jugadore;
import util.JPAUtil;

public class JugadoreDAO {
	
	/*Método para saber si un jugador existe por id del jugador
	 * @return jugador -> Devuelve el jugador si exite / null si no existe
	*/ 
	public Jugadore consultaJugador(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Jugadore jugador = new Jugadore();
		try {
			jugador = em.find(Jugadore.class, id);
		} catch (Exception e) {
			return null;
		}
		em.close();

		return jugador;
	}
	
	public ArrayList<Jugadore> consultaPorEquipo(Equipo equipo) {
		
			EntityManager em = JPAUtil.getEntityManager();
			List<Jugadore> jugadores = new ArrayList<>();
			try {
				TypedQuery<Jugadore> lista = em.createQuery(
						"select a from Jugadore a where a.equipo='" + equipo.getNombreEquipo() + "'",
						Jugadore.class);

				jugadores = lista.getResultList();
			} catch (Exception e) {
				return null;
			}
			em.close();
			
			ArrayList<Jugadore> listaJugadores = new ArrayList<>();
			
				listaJugadores.addAll(jugadores);
			
			return listaJugadores;
	}
}
