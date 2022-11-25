package empresa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoBD {
	
	GestionBD conexion; 
	
	public DepartamentoBD() {
		this.conexion = new GestionBD();
	}

	public DepartamentoBD(GestionBD conexion) {
		this.conexion = conexion;
	}
	
	public Departamento getDepartamento(int deptNo) throws SQLException {
		Departamento d;
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT DEPART.* FROM DEPART");
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("DEPT_NO") == deptNo);
		}
		rs.previous();
		d = new Departamento(deptNo, rs.getString(2), rs.getString(3));
		return d;
	}

	public String nombre_dep(int deptNo) {
		try {
			ResultSet rs;
			rs = conexion.stmt.executeQuery("SELECT * FROM DEPART WHERE DEPT_NO=" + deptNo);
			rs.next();
			return "Nombre: " + rs.getString("DNOMBRE") + ", Localidad: " +rs.getString("LOC");
		} catch (SQLException e) {
			return "inexistente";
		}
	}

	public boolean buscarDepartameto(int deptNo) throws SQLException {
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT DEPT_NO FROM DEPART");
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("DEPT_NO") == deptNo);
		}
		return encontrado;
	}
	
	public void addDepartamento(Departamento d) throws SQLException {
		ResultSet rs = conexion.getStmt().executeQuery("SELECT EMPLE.* FROM EMPLE");
		rs.moveToInsertRow();
		rs.updateInt(1, d.getDeptNo());
		rs.updateString(2, d.getdNombre());
		rs.updateString(3, d.getLoc());
		rs.insertRow();
	}
	
	public void borrarDepartamento(int deptNo) throws SQLException {
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT DEPART.* FROM DEPART");
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("DEPT_NO") == deptNo);
		}
		rs.previous();
		rs.deleteRow();
	}
	
}
