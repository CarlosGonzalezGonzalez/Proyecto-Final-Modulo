package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDeDatos {
	private final static String BUSCAR_USUARIO = "SELECT categoria FROM usuarios WHERE usuario = ? AND pass = ?";

	private Connection conexion = null;
	private Statement s = null;
	int rows = 0;

	public void conectarBD(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyecto",
					"root", "");
		} catch (SQLException e) {
			System.err.println("Error SQL al conectar a la BD");
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrada al conectar a la BD");
		}
	}
	
	public void crearTabla(String tabla){
		try {
			s = conexion.createStatement();
			rows = s.executeUpdate(tabla);
		} catch (SQLException e) {
		}
	}

	public String buscarCategoria(String usuario,String pass){
		PreparedStatement sentencia = null;
		String categoria = "";
		ResultSet rs = null;
		
		try {
			sentencia = conexion.prepareStatement(BUSCAR_USUARIO);
			sentencia.setString(1, usuario);
			sentencia.setString(2, pass);
			
			rs = sentencia.executeQuery();
			
			if(rs.next()){
				categoria = rs.getString(1);
			}
		} catch (SQLException e) {
			System.err.println("Error SQL al consultar pregunta");
		}
		
		return categoria;
		
	}
	
}
