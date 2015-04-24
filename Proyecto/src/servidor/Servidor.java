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
			+ "comunidad VARCHAR(40))" + "ENGINE=InnoDB";
	
	
	public static void main(String[] args) {
		BaseDeDatos bd = new BaseDeDatos();
		
		// Nos conectamos a la base de datos del proyecto nada mas iniciar el servidor
		// y creamos la tabla usuarios si no existe
		bd.conectarBD();
		bd.crearTabla(CREATE_TABLE_USERS);
		bd.crearTabla(CREATE_TABLE_DIRECTORES);
		
		Socket s1 = null;
		try {
			ServerSocket ss1 = new ServerSocket(5000);
			
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