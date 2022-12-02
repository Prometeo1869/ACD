package main;

import java.math.BigDecimal;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.MatriculaDAO;
import model.Alumno;
import model.Asignatura;

public class Principal {

	public static void main(String[] args) {
		
		MatriculaDAO matri = new MatriculaDAO();
		System.out.println(matri.consultaAlumnos("Matemáticas"));

	}
}
