package dao;

import jakarta.persistence.EntityManager;
import model.Alumno;
import util.JpaUtil;

public class AlumnoDAO {

	public AlumnoDAO() {
	
	}
	/**
	 * Alta de alumno: Reciben un objeto alumno y devuelven un valor boolean
	 * indicando el éxito de la operación. No se puede dar de alta un alumno que
	 * ya exista.
	 */
	public boolean altaAlumno(Alumno alumno) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(alumno);
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
	 * Bajas de alumno: Recibe el identificador del alumno y devuelve un valor
	 * boolean indicando el éxito de la operación. No se puede dar de baja al
	 * alumno si está matriculado en alguna asignatura.
	 */
	public boolean bajaAlumno(String dni) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Alumno.class, dni));
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
	 * Consulta de alumno por identificador: Recibe el identificador del alumno y
	 * devuelve el objeto o null si no lo encuentra. 
	 */
	public Alumno consultaAlumo(String dni) {
		
		EntityManager em = JpaUtil.getEntityManager();
		Alumno empleado = em.find(Alumno.class, dni);
		em.close();

		return empleado;
	}
}
