package dao;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Alumno;
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
	public Asignatura consultaAsignaturaTitulo(String titulo) {
		EntityManager em = JpaUtil.getEntityManager();
		Asignatura asignatura = new Asignatura();

		try {
			TypedQuery<Asignatura> asignaturaTitulo = em
					.createQuery("select a from Asignatura a where a.titulo='" + titulo + "'", Asignatura.class);
			asignatura = asignaturaTitulo.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		em.close();

		return asignatura;
	}

	public Asignatura consutaAsignaturaCodigo(String codigo) {
		EntityManager em = JpaUtil.getEntityManager();
		Asignatura asignatura = new Asignatura();
		try {
		asignatura = em.find(Asignatura.class, codigo);
		} catch (Exception e) {
			return null;
		}
		em.close();

		return asignatura;
	}
}
