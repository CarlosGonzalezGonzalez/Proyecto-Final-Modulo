package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.Configuration;


public class BaseDeDatos {
	private final static String BUSCAR_USUARIO = "SELECT categoria FROM usuarios WHERE nombre = ? AND pass = ?";
	private final static String CREAR_USUARIO = "INSERT INTO usuarios(nombre,pass,categoria) VALUES (?,?,?)";
	private final static String CREAR_DIRECTOR = "INSERT INTO directores(nombre,apellidos,comunidad) VALUES (?,?,?)";
	
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
			System.err.println("La combinacion de usuario y contraseña no es correcta");
			System.err.println(e.getMessage());
		}
		
		return categoria;
		
	}
	
	public void crearUsuario(String usuario,String pass,String categoria){
		PreparedStatement sentencia = null;
		try{			
			sentencia = conexion.prepareStatement(CREAR_USUARIO);
			sentencia.setString(1, usuario);
			sentencia.setString(2, pass);
			sentencia.setString(3, categoria);
			
			int i = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error SQL al crear usuario");
			e.getMessage();
		}
	}
	
	public void crearDirector(String nombre,String apellidos,String comunidad){
		PreparedStatement sentencia = null;
		try{
			sentencia = conexion.prepareStatement(CREAR_DIRECTOR);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellidos);
			sentencia.setString(3, comunidad);
			
			int i = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error SQL al crear director");
			e.getMessage();
		}
	}
}
