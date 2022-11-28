package main;

import java.math.BigDecimal;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import model.Alumno;
import model.Asignatura;

public class Principal {

	public static void main(String[] args) {
		
		AsignaturaDAO asignaturas = new AsignaturaDAO();
		
		System.out.println(asignaturas.consultaAsignatura("Matemáticas"));

	}
}
