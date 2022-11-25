package biblioteca;

import java.sql.SQLException;

public class PrestamoBD {
	
	ConexionBD conexion;

	public PrestamoBD(ConexionBD conexion) {
		this.conexion = conexion;
	}

	public PrestamoBD() throws ClassNotFoundException, SQLException {
		this.conexion = new ConexionBD();
	}
}
