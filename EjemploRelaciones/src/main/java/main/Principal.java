package main;

import dominio.Compartimento;
import dominio.Departamento;
import dominio.Empleado;
import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class Principal {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		//PARA ManyToOne
		//Crear un Departamento
		Departamento departamento = new Departamento();
		departamento.setNombre("Ventas");
		//Crear el empleado 1
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Ana");
		empleado1.setNif("222");
		empleado1.setEdad(25);
		empleado1.setDepartamento(departamento);
		//Almacenar el empleado 1
		em.persist(empleado1);
		// Crear el empleado 2
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Pepe");
		empleado2.setNif("333");
		empleado2.setEdad(44);
		empleado2.setDepartamento(departamento);
		//Almacenar el empleado 2
		em.persist(empleado2);
		//Añadir los empleados al departamento
		departamento.getEmpleados().add(empleado1);
		departamento.getEmpleados().add(empleado1);
		//Almacenar el departamento
		em.persist(departamento);
		//PARA OneToOne
		/* 
		// Crear la entidad Compartimento
		Compartimento compartimento = new
		Compartimento();
		compartimento.setDescripción("Planta baja, compartimento 1");
		//Almacenar el compartimento
		em.persist(compartimento);
		// Crear la entidad Empleado
		Empleado empleado = new Empleado();
		empleado.setNombre("Ana");
		empleado.setCompartimentoAsignado(compartimento);
		//Almacenar el empleado
		em.persist(empleado);
		*/
		em.getTransaction().commit();
		em.close();
		
	}
}
