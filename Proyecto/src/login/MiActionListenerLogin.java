package login;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import configuration.Configuration;

public class MiActionListenerLogin implements ActionListener{
	private static final String CASO_ACEPTAR = "Aceptar";
	private static final String CASO_CANCELAR = "Cancelar";

	private JFrame frame;
	private JTextField usuarioField;
	private JPasswordField passField;
	
	private String usuario;
	private String pass;
	private char[] textoPass;
	
	public MiActionListenerLogin(JFrame f,JTextField usuarioField,JPasswordField passField){
		this.frame = f;
		this.usuarioField = usuarioField;
		this.passField = passField;
		this.usuario = "";
		this.pass = "";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case CASO_ACEPTAR:
				BufferedReader entrada = null;
		        PrintWriter salida = null;
		        
		        usuario = usuarioField.getText();
		        textoPass = passField.getPassword();
		        for(char c : textoPass){
					pass += c;
				}
		        
		        if(usuario.equals("")){ // Si no se ha rellenado el campo usuario
		        	JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.USUARIO_VACIO));
		        }else if(pass.equals("")){ // Se ha rellenado el campo usuario pero no la contraseña
		        	JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.PASS_VACIO));
		        }else{ // Se han rellenado todos los campos
		        	// Nos conectamos al servidor para buscar el usuario
		        	try {
			        	Socket s1 = new Socket("localhost", 5000);
			        	
			        	entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			            salida = new PrintWriter(s1.getOutputStream(),true);
			        	
			            // Utilizamos el titulo de la interfaz como identificador del cliente que se va a conectar
			            // y le pasamos los parametros usuario y pass para localizar al usuario
			            // Utilizaremos "/" como separador de parametros
			            salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_LOGIN) +
			            		"/" + usuario + "/" + pass);
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
