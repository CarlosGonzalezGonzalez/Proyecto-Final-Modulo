package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ministro.interfaces.InterfazMinistro;
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
	        		categoria = categoria.toLowerCase();
	        		// Dependiendo del usuario logeado cargaremos un cliente u otro
	        		switch(categoria){
	        			case Configuration.MINISTRO:
	        				InterfazMinistro ministroView = new InterfazMinistro();
	        				ministroView.setVisible(true);
	        				break;
	        			case Configuration.DIRECTOR:
	        				break;
	        			case Configuration.PROFESOR:
	        				break;
	        			case Configuration.PADRES:
	        				break;
	        		}
	        		break;
	        	case Configuration.CREARDIRECTOR:
	        		/*
	        		  parametros[1] --> nombre
	        		  parametros[2] --> apellidos
	        		  parametros[3] --> usuario
	        		  parametros[4] --> pass
	        		  parametros[5] --> comunidad
	        		*/	        		
	        		
	        		bd.crearUsuario(parametros[3], parametros[4], "director");
	        		bd.crearDirector(parametros[1], parametros[2], parametros[5]);
	        		break;
	        	case Configuration.BUSCARDIRECTOR:
	        		/*
	        		  parametros[1] --> id
	        		*/
	        		String datos = bd.buscarDirector(parametros[1]);
	        		
	        		salida.println(datos);
	        		break;
	        	case Configuration.MODIFICARDIRECTOR:
	        		/*
	        		  parametros[1] --> id
	        		  parametros[2] --> nombre
	        		  parametros[3] --> apellidos
	        		  parametros[4] --> comunidad
	        		*/
	        		
	        		bd.modificarDirector(Integer.parseInt(parametros[1]),parametros[2],
	        				parametros[3],parametros[4]);
	        		
	        		break;
	        	case Configuration.ELIMINARDIRECTOR:
	        		/*
	        		  parametros[1] --> id
	        		*/
	        		datos = bd.buscarDirector(parametros[1]);
	        		salida.println(datos);
	        		
	        		String seguir = entrada.readLine();
	        		
	        		if(seguir.equalsIgnoreCase("continuar")){
	        			bd.eliminarDirector(datos);
	        		}
	        		
	        		break;
	        }
	        
		} catch (IOException ioe) {
            ioe.getMessage();
        }
	}

}
