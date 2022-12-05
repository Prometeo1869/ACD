package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	public MatriculacionPK realizarMatriculacion(String dni, String codigo, BigDecimal nota) {
		AlumnoDAO alumnos = new AlumnoDAO();
		AsignaturaDAO asignaturas = new AsignaturaDAO();
		Matriculacion matricula = new Matriculacion();
		Alumno alumno = alumnos.consultaAlumo(dni);
		Asignatura asignatura = asignaturas.consutaAsignaturaCodigo(codigo);
		if (alumno != null && asignatura != null) {
			EntityManager em = JpaUtil.getEntityManager();
			try {
				MatriculacionPK matriculacionID = new MatriculacionPK();
				matriculacionID.setDni(dni);
				matriculacionID.setCodAsignatura(codigo);
				matricula.setId(matriculacionID);
				matricula.setNota(nota);

				em.getTransaction().begin();
				em.persist(matricula);
				em.getTransaction().commit();
				return matriculacionID;
			} catch (Exception ex) {
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
		String cadena = "";
		if (asignatura == null) {
			return "\nNO EXISTE ASIGNATURA CON ESE TÍTULO";
		} else {
			ArrayList<Alumno> alumnos = consultaMatriculaAsignatura(asignatura);
			if (alumnos == null) {
				return "\nNO EXITEN ALUMNOS EN ESA ASIGNATURA";
			} else {
				for(Alumno a: alumnos) {
					EntityManager em = JpaUtil.getEntityManager();
					Matriculacion matriculacion = new Matriculacion();
					TypedQuery<Matriculacion> matri = em.createQuery("select a from Matriculacion a where a.asignatura='"
							+ asignatura.getCodigo() + "' AND a.alumno='" + a.getDni() + "'", Matriculacion.class);
					
					matriculacion = matri.getSingleResult();
					em.close();
					cadena += "" + a.getNombre() + " " + a.getApellidos() + ", Nota: "
							+ matriculacion.getNota() + "\n";
					
				}
				return cadena;
			}
		}

	}

	public ArrayList<Alumno> consultaMatriculaAsignatura(Asignatura asignatura) {
		EntityManager em = JpaUtil.getEntityManager();
		List<Matriculacion> matriculaciones = new ArrayList<>();
		try {
			TypedQuery<Matriculacion> lista = em.createQuery(
					"select a from Matriculacion a where a.asignatura='" + asignatura.getCodigo() + "'",
					Matriculacion.class);

			matriculaciones = lista.getResultList();
		} catch (Exception e) {
			return null;
		}
		em.close();
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		for (Matriculacion a : matriculaciones) {
			listaAlumnos.add(a.getAlumno());
		}
		return listaAlumnos;
	}
}
