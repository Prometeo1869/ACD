package DAO;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Estadistica;
import model.EstadisticaPK;
import model.Jugadore;
import util.JPAUtil;

public class EstadisticaDAO {

	public boolean comprobarEstadisticaPK(EstadisticaPK id) {
		boolean existe = false;
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Estadistica> estadisticas = em.createQuery("SELECT e FROM Estadistica e", Estadistica.class);

		for (Estadistica e : estadisticas.getResultList()) {
			if(e.getId().equals(id)) {
				existe = true;
			}
		}
		em.close();

		return existe;
	}
	
	public void insertarEstadistica(Estadistica estadistica) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(estadistica);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public ArrayList<Estadistica> consultaJugador(long idJugador) {
		JugadoreDAO jugadores = new JugadoreDAO();
		EntityManager em = JPAUtil.getEntityManager();
		Jugadore jugador = em.find(Jugadore.class, idJugador);
		List<Estadistica> estadisticas = new ArrayList<>();
		try {
			TypedQuery<Estadistica> lista = em.createQuery(
					"select a from Estadistica a where a.jugadore=" + idJugador + "",
					Estadistica.class);

			estadisticas = lista.getResultList();
		} catch (Exception e) {
			return null;
		}
		em.close();
		
		return (ArrayList<Estadistica>) estadisticas;
	}
	
	
	
	
}
