package clases.dao;

import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import clases.Departamento;

public class DepartamentoDAO {

	ODB odb;
	
	public DepartamentoDAO(ODB odb) {
		this.odb = odb;
	}

	public Departamento datosDepartamento() {
		Departamento d = new Departamento();
		int codigo = -1;
		String nombre = "";
		String loc = "";
		boolean existe = false;
		try {
			System.out.println("Código del nuevo departamento:");
			codigo = new Scanner(System.in).nextInt();
			// Comprobar si departamento existe
			Objects<Departamento> departamentos = odb.getObjects(Departamento.class);

			while (departamentos.hasNext()) {
				if (codigo == departamentos.next().getDeptNo()) {
					existe = true;
					System.out.println("\nYa existe un departamento con ese código\n");
				} // if
			} // while
			if (existe == false) {
				System.out.println("Nombre del nuevo departamento:");
				nombre = new Scanner(System.in).next();
				System.out.println("Localidad del nuevo departamento:");
				loc = new Scanner(System.in).next();
				d.setDeptNo(codigo);
				d.setDnombre(nombre);
				d.setLoc(loc);
				return d;
			} else {
				return null;
			} // if
		} catch (Exception e) {
			System.out.println("\nDatos introducidos no válidos\n");
			return null;
		}
	}

	
}
