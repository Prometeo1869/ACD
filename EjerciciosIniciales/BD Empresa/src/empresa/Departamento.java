package empresa;

import java.util.Objects;

public class Departamento {
	int deptNo;
	String dNombre, loc;
	
	public Departamento(int deptNo, String dNombre, String loc) {
		this.deptNo = deptNo;
		this.dNombre = dNombre;
		this.loc = loc;
	}

	public Departamento() {	
	}

	public Departamento(int deptNo) {
		this.deptNo = deptNo;
		this.dNombre = "";
		this.loc = "";
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdNombre() {
		return dNombre;
	}

	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departamento [" + deptNo + ", Nombre=" + dNombre + ", loc=" + loc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return deptNo == other.deptNo;
	}
	
	
}
