package ministro.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import configuration.Configuration;
import entidades.Director;

public class MiActionListenerCrearDirector implements ActionListener{
	private static final String CASO_ACEPTAR = "Aceptar";
	private static final String CASO_CANCELAR = "Cancelar";
	
	private JFrame frame;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField usuarioField;
	private JTextField passField;
	private JTextField comunidadField;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String pass;
	private String comunidad;
	
	
	public MiActionListenerCrearDirector(JFrame frame,JTextField nombreField,JTextField apellidosField,
			JTextField usuarioField,JTextField passField,JTextField comunidadField){
		this.frame = frame;
		this.nombreField = nombreField;
		this.apellidosField = apellidosField;
		this.usuarioField = usuarioField;
		this.passField = passField;
		this.comunidadField = comunidadField;
		
		this.nombre = "";
		this.apellidos = "";
		this.usuario = "";
		this.pass = "";
		this.comunidad = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case CASO_ACEPTAR:
				BufferedReader entrada = null;
		        PrintWriter salida = null;
		        
		        nombre = nombreField.getText();
		        apellidos = apellidosField.getText();
		        usuario = usuarioField.getText();
		        pass = passField.getText();
		        comunidad = comunidadField.getText();
				
				// Comprobamos que se han introducido todos los datos
				if(nombre.equals("") || (apellidos.equals("") || (usuario.equals("") ||
						(pass.equals("") || (comunidad.equals("")))))){ 
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.COMPLETAR_DATOS));
				}else{
					try {
			        	Socket s1 = new Socket("localhost", 5000);
			        	
			        	entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			            salida = new PrintWriter(s1.getOutputStream(),true);
			        	
			            Director director = new Director(nombre,apellidos,usuario,pass,comunidad);
			            
			            // Utilizaremos "/" como separador de parametros
			            salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_CREAR_DIRECTOR) + 
			            		"/" + director.getNombre() + "/" + director.getApellidos() + "/" + director.getUsuario() + 
			            		"/" + director.getPass() + "/" + director.getComunidad());
			            
			            JOptionPane.showMessageDialog(frame,
			            		Configuration.getInstance().getProperty(Configuration.DIRECTOR_CREADO));
			            frame.dispose();
			        } catch (UnknownHostException ex) {
			            System.out.println("Servidor no encontrado");
			        } catch (IOException ex) {
			            System.out.println("Error");
			        }
				}
				break;
			case CASO_CANCELAR:
				frame.dispose();
				break;
		}
		
		
	}

}
