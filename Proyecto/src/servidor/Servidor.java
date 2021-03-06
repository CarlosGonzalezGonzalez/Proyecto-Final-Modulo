package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import configuration.Configuration;

public class Servidor {
	private final static String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS usuarios"
			+ "(nombre VARCHAR(15) PRIMARY KEY, "
			+ "pass VARCHAR(15), "
			+ "categoria VARCHAR(15))" + "ENGINE=InnoDB";
	private final static String CREATE_TABLE_DIRECTORES = "CREATE TABLE IF NOT EXISTS directores "
			+ "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+ "nombre VARCHAR(15), "
			+ "apellidos VARCHAR(35), "
			+ "comunidad VARCHAR(40))" + "ENGINE=InnoDB";
	private final static String CREATE_TABLE_PROFESORES = "CREATE TABLE IF NOT EXISTS profesores "
			+ "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+ "nombre VARCHAR(15), "
			+ "apellidos VARCHAR(35), "
			+ "iddirector INTEGER)" + "ENGINE=InnoDB";
	private final static String ALTER_TABLE_PROFESORES = "ALTER TABLE profesores ADD CONSTRAINT directores FOREIGN KEY (iddirectores)"
			+ " REFERENCES directores (id)";
	
	public static void main(String[] args) {
		BaseDeDatos bd = new BaseDeDatos();
		
		// Nos conectamos a la base de datos del proyecto nada mas iniciar el servidor
		// y creamos la tabla usuarios si no existe
		bd.conectarBD();
		bd.crearTabla(CREATE_TABLE_USERS);
		bd.crearTabla(CREATE_TABLE_DIRECTORES);
		bd.crearTabla(CREATE_TABLE_PROFESORES);
		bd.crearTabla(ALTER_TABLE_PROFESORES);
		
		Socket s1 = null;
		try {
			ServerSocket ss1 = new ServerSocket(5000);
			System.out.println("Arrancado");
			
			while (true) {
				s1 = ss1.accept();

				Thread t = new ServidorHilo(s1,bd);
				t.start();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}