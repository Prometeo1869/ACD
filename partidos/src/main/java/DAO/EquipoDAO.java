package DAO;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Equipo;
import util.JPAUtil;

public class EquipoDAO {

	/**
	 * Devuelve una lista con todos los equipos de la base de datos
	 * @return lista
	 */
	public ArrayList<Equipo> onsultarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Equipo> lista = new ArrayList<>();
		TypedQuery<Equipo> equipos = em.createQuery("SELECT e FROM Equipo e", Equipo.class);

		for (Equipo e : equipos.getResultList()) {
			Equipo nuevo = new Equipo(
					e.getNombreEquipo(), 
					e.getCiudad(), 
					e.getDivision(), 
					e.getJugadores(),
					e.getPartidos1(), 
					e.getPartidos2());
			lista.add(nuevo);
		}
		em.close();

		return lista;
	}
	
}
