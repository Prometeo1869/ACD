package empresa;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class EmpleadoBD {

	GestionBD conexion;
	
	public EmpleadoBD() {
		this.conexion = new GestionBD();
	}
	
	public EmpleadoBD(GestionBD conexion) {
		this.conexion = conexion;
	}
	
	public Empleado getEmpleado(int empNo) throws SQLException {
		Empleado e;
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT EMPLE.* FROM EMPLE");
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("EMP_NO") == empNo);
		}
		rs.previous();
		e = new Empleado(empNo, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5).toString(), rs.getInt(6), rs.getInt(7), rs.getInt(8));
		return e;
	}
	
	public void subida_sal(int deptNo, int incrementoSalario) throws SQLException {
		CallableStatement cstmt = conexion.getConn().prepareCall("{call SUBIDA_SAL(?,?)}");
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.setInt(1, deptNo);
		cstmt.setInt(2, incrementoSalario);
		cstmt.execute();
	}
	
	public void addEmpleado(Empleado e) throws SQLException {
		ResultSet rs = conexion.getStmt().executeQuery("SELECT EMPLE.* FROM EMPLE");
		rs.moveToInsertRow();
		rs.updateInt(1, e.getEmpNo());
		rs.updateString(2, e.getApellido());
		rs.updateString(3, e.getOficio());
		rs.updateInt(4, e.getDir());
		rs.updateDate(5, new java.sql.Date(System.currentTimeMillis()));
		rs.updateInt(6, e.getSalario());
		rs.updateInt(7, e.getComision());
		rs.updateInt(8, e.getDeptNo());
		rs.insertRow();
	}
	
	public boolean buscarEmpleado(int empNo) throws SQLException {
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT EMPLE.* FROM EMPLE");
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("EMP_NO") == empNo);
		}
		return encontrado;
	}
	
	public boolean buscarEmpleado(Empleado e) throws SQLException {
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT EMP_NO FROM EMPLE");
		
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("EMP_NO") == e.getEmpNo());
		}
		return encontrado;
	}
	
	public boolean hayEmpleadosEnDepartamento(int dept_no) throws SQLException {
		boolean encontrado = false;
		
		ResultSet rs = conexion.getStmt().executeQuery("SELECT DEPT_NO FROM EMPLE");
		
		while(rs.next() && !encontrado) {
			encontrado = (rs.getInt("DEPT_NO") == dept_no);
		}
		return encontrado;
	}
	
}
