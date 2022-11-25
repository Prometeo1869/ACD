package biblioteca;

import java.sql.SQLException;

public class SocioBD {

	ConexionBD conexion;

	public SocioBD(ConexionBD conexion) {
		this.conexion = conexion;
	}

	public SocioBD() throws ClassNotFoundException, SQLException {
		this.conexion = new ConexionBD();
	}
}
