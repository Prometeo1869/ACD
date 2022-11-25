package mipaquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertarDDL {
	private static String createTableCafes;

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			System.out.println("Declaración DDL:");
			createTableCafes = new Scanner(System.in).nextLine();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "usuario", "usuario");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(createTableCafes);
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("\n--- SQLException capturada ---\n");
			while (ex != null) {
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
		}
	}
}