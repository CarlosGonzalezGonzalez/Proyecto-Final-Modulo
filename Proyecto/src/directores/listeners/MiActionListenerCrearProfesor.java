package directores.listeners;

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
import entidades.Profesor;

public class MiActionListenerCrearProfesor implements ActionListener{
	private final static String CASO_ACEPTAR = "Aceptar";
	private final static String CASO_CANCELAR = "Cancelar";

	private JFrame frame;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField idDirectorField;
	private JTextField usuarioField;
	private JTextField passField;
	
	private String nombre;
	private String apellidos;
	private String idDirector;
	private String usuario;
	private String pass;
	
	public MiActionListenerCrearProfesor(JFrame frame,JTextField nombreField,JTextField apellidosField,
			JTextField idDirectorField,JTextField usuarioField,JTextField passField){
		this.frame = frame;
		this.nombreField = nombreField;
		this.apellidosField = apellidosField;
		this.idDirectorField = idDirectorField;
		this.usuarioField = usuarioField;
		this.passField = passField;
		this.nombre = "";
		this.idDirector = "";
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
		        
		        nombre = nombreField.getText();
		        apellidos = apellidosField.getText();
		        idDirector = idDirectorField.getText();
		        usuario = usuarioField.getText();
		        pass = passField.getText();
		        
		        // Comprobamos que se han introducido todos los datos
		        if(nombre.equals("") || apellidos.equals("") || idDirector.equals("") || usuario.equals("") || pass.equals("")){
		        	JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.COMPLETAR_DATOS));
		        }else{
		        	try {
		        		Socket s1 = new Socket("localhost", 5000);
			        	
			        	entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			            salida = new PrintWriter(s1.getOutputStream(),true);
			            
			            Profesor profesor = new Profesor(nombre,apellidos,idDirector,usuario,pass);
			            
			            salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_CREAR_PROFESOR)
			            		+ "/" + profesor.getNombre() + "/" + profesor.getApellidos() + "/"
			            		+ profesor.getIdDirector() + "/" + profesor.getUsuario() + "/"
			            		+ profesor.getPass());
			            
			            JOptionPane.showMessageDialog(frame,
			            		Configuration.getInstance().getProperty(Configuration.PROFESOR_CREADO));
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
