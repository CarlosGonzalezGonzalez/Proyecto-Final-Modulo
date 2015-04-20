package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import configuration.Configuration;

public class Servidor {
	
	public static void main(String[] args) {
		BaseDeDatos bd = new BaseDeDatos();
		
		// Nos conectamos a la base de datos del proyecto nada mas iniciar el servidor
		// y creamos la tabla usuarios si no existe
		bd.conectarBD();
		bd.crearTabla(Configuration.CREATE_TABLE_USERS);
		
		Socket s1 = null;
		try {
			ServerSocket ss1 = new ServerSocket(5000);
			
			while (true) {
				s1 = ss1.accept();
				System.out.println("Conectado ");

				Thread t = new ServidorHilo(s1,bd);
				t.start();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}