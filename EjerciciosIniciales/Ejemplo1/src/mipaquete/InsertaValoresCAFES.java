package mipaquete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertaValoresCAFES {
public static void main(String[] args) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (Exception ex) {
ex.printStackTrace();
}
try{
Connection conn = DriverManager.getConnection
("jdbc:oracle:thin:@172.17.0.2:1521:xe","usuario", "usuario");
Statement stmt = conn.createStatement();
stmt.executeUpdate("INSERT INTO CAFES " +
"VALUES ('Colombia', 101, 7.99, 0, 0)");
stmt.executeUpdate("INSERT INTO CAFES " +
 "VALUES ('Brasil_Torrefacto', 49, 8.99, 0, 0)");
stmt.executeUpdate("INSERT INTO CAFES " +
 "VALUES ('Espresso', 150, 9.99, 0, 0)");
stmt.executeUpdate("INSERT INTO CAFES " +
 "VALUES ('Colombia_Descaf', 101, 8.99, 0, 0)");
stmt.executeUpdate("INSERT INTO CAFES " +
 "VALUES ('Brasil_Torrefacto_Descaf', 49, 9.99, 0, 0)");
stmt.close();
conn.close();
} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
}
}
}