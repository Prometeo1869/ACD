package main;

import dominio.Departamento;
import dominio.Empleado;
import jakarta.persistence.EntityManager;
import util.JpaUtil;
import jakarta.persistence.TypedQuery;

//Para que funcione hay que cambiar el persistence de create a update
public class Principal2 {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		TypedQuery<Departamento> departamentos = em.createQuery("select d from Departamento d", Departamento.class);
		for (Departamento d : departamentos.getResultList()) {
			System.out.println("Departamento :" + d.getNombre());
			for (Empleado e : d.getEmpleados()) {
				System.out.println("Empleado : " + e.getNombre());
			}
		}
		em.close();
	}
}