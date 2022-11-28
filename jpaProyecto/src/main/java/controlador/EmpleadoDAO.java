package controlador;

import dominio.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

public class EmpleadoDAO {

	EntityManagerFactory emp = Persistence.createEntityManagerFactory("jpaProyecto");

	public EmpleadoDAO() {

	}

	public boolean insertarNuevo(Object empleado) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(empleado);
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

	public Empleado encontrarUno(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Empleado empleado = em.find(Empleado.class, id);
		em.close();

		return empleado;
	}

	public void encontrarTodos() {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Empleado> empleados = em.createQuery("select e from Empleado e", Empleado.class);
		for (Empleado e : empleados.getResultList()) {
			System.out.println(e.toString());
		}
		em.close();
	}

	public boolean borrar(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Empleado.class, id));
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

	public boolean actualizar(Object empleado) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(empleado);
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
}
