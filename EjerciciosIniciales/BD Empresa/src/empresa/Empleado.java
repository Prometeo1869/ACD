package empresa;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado {

	int empNo, dir, salario, comision, deptNo;
	String apellido, oficio;
	LocalDate fechaAlta;
	
	public Empleado(int empNo, String apellido, String oficio, int dir, String fechaAlta, int salario, int comision, int deptNo) {
		this.empNo = empNo;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlta = LocalDate.parse(fechaAlta);
		this.salario = salario;
		this.comision = comision;
		this.deptNo = deptNo;
	}
	
	public Empleado() {}
	
	public Empleado(int empNo) {
		this.empNo = empNo;
		this.apellido = "";
		this.oficio = "";
		this.dir = 0;
		this.fechaAlta = LocalDate.parse("01-01-2000");
		this.salario = 0;
		this.comision = 0;
		this.deptNo = 0;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = LocalDate.parse(fechaAlta);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return empNo == other.empNo;
	}

	@Override
	public String toString() {
		return "Empleado [empNo=" + empNo + ", dir=" + dir + ", salario=" + salario + ", comision=" + comision
				+ ", deptNo=" + deptNo + ", apellido=" + apellido + ", oficio=" + oficio + ", fechaAlta=" + fechaAlta
				+ "]\n";
	}
	
	
	
}
