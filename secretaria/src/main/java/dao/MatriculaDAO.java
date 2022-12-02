package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Alumno;
import model.Asignatura;
import model.Matriculacion;
import model.MatriculacionPK;
import util.JpaUtil;

public class MatriculaDAO {
	

	/**
	 * Realizar matriculación: Recibe el identificador del alumno y de la
	 * asignatura. Comprueba la existencia de ambos, solicita la nota y almacena la
	 * matrícula controlando que no haya una matrícula igual. Devuelve el
	 * identificador de la matrícula.
	 */
	public MatriculacionPK realizarMatriculacion(String dni, String codigo) {
		AlumnoDAO alumnos = new AlumnoDAO();
		AsignaturaDAO asignaturas = new AsignaturaDAO();
		Matriculacion matricula = new Matriculacion();
		if (alumnos.consultaAlumo(dni) != null && asignaturas.consutaAsignaturaCodigo(codigo) != null) {

			MatriculacionPK matriculacionID = new MatriculacionPK();
			matriculacionID.setDni(dni);
			matriculacionID.setCodAsignatura(codigo);
			matricula.setId(matriculacionID);

			System.out.println("Nota:");
			BigDecimal nota = new Scanner(System.in).nextBigDecimal();
			matricula.setNota(nota);

			EntityManager em = JpaUtil.getEntityManager();
			try {
				em.getTransaction().begin();
				em.persist(matricula);
				em.getTransaction().commit();
				return matriculacionID;
			} catch (Exception ex) {
				ex.printStackTrace();
				em.getTransaction().rollback();
				return null;
			} finally {
				em.close();
			}

		} else {
			return null;
		}
	}

	/**
	 * Consulta de alumnos por asignatura : Recibe el título de la asignatura,
	 * comprueba la existencia de ésta y muestra el nombre, apellidos y nota de cada
	 * alumnos matriculado en dicha asignatura.
	 */
	public String consultaAlumnos(String titulo) {
		AlumnoDAO alumLista = new AlumnoDAO();
		AsignaturaDAO asigLista = new AsignaturaDAO();
		Asignatura asignatura = asigLista.consultaAsignaturaTitulo(titulo);
		if(asignatura == null) {
			return "NO EXISTE ASIGNATURA CON ESE TÍTULO";
		} else {
			Alumno alumno = consultaMatriculaAsignatura(asignatura);
			if(alumno == null) {
				return "NO EXITE ALUMNO EN ESA ASIGNATURA";
			} else {
				EntityManager em = JpaUtil.getEntityManager();
				Matriculacion matriculacion = new Matriculacion();
				TypedQuery<Matriculacion> matri = em.createQuery(
						"select a from Matricula a where a.COD_ASIGNATURA='" + asignatura.getCodigo() 
						+ "AND a.DNI=" + alumno.getDni(), Matriculacion.class);
			
				matriculacion = matri.getSingleResult();
				
				em.close();
				
				String cadena = "" + alumno.getNombre() + " " + alumno.getApellidos() + ", Nota: " + matriculacion.getNota(); 
				return cadena;
			}
		}
		
	}
	
	public Alumno consultaMatriculaAsignatura(Asignatura asignatura) {
		EntityManager em = JpaUtil.getEntityManager();
		Matriculacion matriculacion = new Matriculacion();
		
		TypedQuery<Matriculacion> matri = em.createQuery(
				"select a from Matricula a where a.COD_ASIGNATURA='" + asignatura.getCodigo() + "'",
				Matriculacion.class);
	
		matriculacion = matri.getSingleResult();
		
		em.close();

		return matriculacion.getAlumno();
	}
}























