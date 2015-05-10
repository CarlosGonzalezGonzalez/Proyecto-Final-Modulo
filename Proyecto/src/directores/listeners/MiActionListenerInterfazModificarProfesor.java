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

public class MiActionListenerInterfazModificarProfesor implements ActionListener{
	private final static String CASO_ACEPTAR = "Aceptar";
	private final static String CASO_CANCELAR = "Cancelar";
	
	private JFrame frame;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField idDirectorField;
	
	private String nombre;
	private String apellidos;
	private int idDirector;
	private int id;
	
	public MiActionListenerInterfazModificarProfesor(JFrame frame,JTextField nombreField,JTextField apellidosField,
			JTextField idDirectorField,String id){
		this.frame = frame;
		this.nombreField = nombreField;
		this.apellidosField = apellidosField;
		this.idDirectorField = idDirectorField;
		this.nombre = "";
		this.apellidos = "";
		this.idDirector = 0;
		this.id = Integer.parseInt(id);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case CASO_ACEPTAR:
				
				this.nombre = nombreField.getText();
				this.apellidos = apellidosField.getText();
				this.idDirector = Integer.parseInt(idDirectorField.getText());
				
				try{
					Socket s1 = new Socket("localhost", 5000);
					
					BufferedReader entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
					PrintWriter salida = new PrintWriter(s1.getOutputStream(),true);
					
					salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_MODIFICAR_PROFESOR) + "/"
							+ id + "/" + nombre + "/" + apellidos + "/" + idDirector);
					
					JOptionPane.showMessageDialog(frame,
							Configuration.getInstance().getProperty(Configuration.TEXTO_PROFESOR_MODIFICADO));
					
					frame.dispose();
				} catch (UnknownHostException ex) {
		            System.out.println("Servidor no encontrado");
		        } catch (IOException ex) {
		            System.out.println("Error");
		        }
				
				break;
			case CASO_CANCELAR:
				frame.dispose();
				break;
		}
		
	}

}
