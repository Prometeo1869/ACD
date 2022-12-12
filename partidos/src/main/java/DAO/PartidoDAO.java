package DAO;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Partido;
import util.JPAUtil;

public class PartidoDAO {

	public ArrayList<Partido> consultaTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		ArrayList<Partido> lista = new ArrayList<Partido>();
		TypedQuery<Partido> partidos = em.createQuery("SELECT e FROM Partido e", Partido.class);

		for (Partido p : partidos.getResultList()) {
			Partido nuevo = new Partido(
					p.getIdPartido(), 
					p.getPuntosLocal(), 
					p.getPuntosVisitante(), 
					p.getTemporada(),
					p.getEquipo1(), 
					p.getEquipo2());
			lista.add(nuevo);
		}
		em.close();

		return lista;
	}
	
}
