package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Asignatura;
import util.JpaUtil;

public class AsignaturaDAO {

	/**
	 * Alta de asignatura: recibe un objeto asignatura y devuelve un valor boolean
	 * indicando el éxito de la operación. No se puede dar de alta un asignatura que
	 * ya exista.
	 */
	public boolean altaAsignatura(Asignatura asignatura) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(asignatura);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	/**
	 * Consulta de asignatura por título: reciben el título de la asignatura y
	 * devuelve el objeto o null si no lo encuentra.
	 */
	public Asignatura consultaAsignatura(String titulo) {
/* VOY POR AQUIII /////////////////////////////////////////////////////////////////////////////////////////////
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Asignatura> asignaturas = em.createQuery("select a from asignatura a", Asignatura.class);
		Asignatura asignatura = new Asignatura();
		for (Asignatura a : asignaturas.getResultList()) {
			if (a.getTitulo().equals(titulo)) {
				asignatura = a;
				em.close();
				return asignatura;
			}
		}
		em.close();
		*/
		return null;

	}
}
