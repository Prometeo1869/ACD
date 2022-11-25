package paquete;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Empleado {
	int id, departamento;
	String apellido;
	double salario;
	
	public Empleado(int id, String apellido, int departamento, double salario) {
		this.id = id;
		this.departamento = departamento;
		this.apellido = apellido;
		this.salario = salario;
	}

	public Empleado() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void leerFichero(RandomAccessFile file) throws IOException {
		try {
			int id = file.readInt();
			String apellido = "";
			for(int i = 0; i<10; i++){
				char esLetra = file.readChar();
				if (Character.isLetter(esLetra)) {
					apellido+=esLetra;
				}
			}
			int dept = file.readInt();
			double salario = file.readDouble();
			this.id = id;
			this.apellido = apellido;
			this.departamento = dept;
			this.salario = salario;

		} catch (EOFException e) {
			System.out.println(e.getMessage());
		}
	}
}