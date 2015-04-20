package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import configuration.Configuration;

public class ServidorHilo extends Thread{
	
	Socket s1 = null;
	BaseDeDatos bd = null;
	
	BufferedReader entrada = null;
    PrintWriter salida = null;
	
	public ServidorHilo(Socket s1,BaseDeDatos bd) {
        this.s1 = s1;
        this.bd = bd;
    }
	
	@Override
	public void run(){
		try{
			entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
	        salida = new PrintWriter(s1.getOutputStream(), true);
	        
	        // Recogemos los parametros del cliente
	        String[] parametros = entrada.readLine().split("/");
	        
	        switch(parametros[0]){
	        	case Configuration.LOGIN:
	        		String categoria = bd.buscarCategoria(parametros[1],parametros[2]);
	        		System.out.println(categoria);
	        		break;
	        }
	        
		} catch (IOException ioe) {
            ioe.getMessage();
        }
	}

}
