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

public class MiActionListenerInterfazModificarDirector implements ActionListener{
	private final static String CASO_ACEPTAR = "Aceptar";
	private final static String CASO_CANCELAR = "Cancelar";

	private JFrame frame;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField comunidadField;
	
	private String nombre;
	private String apellidos;
	private String comunidad;
	private int id;
	
	public MiActionListenerInterfazModificarDirector(JFrame frame,JTextField nombreField,JTextField apellidosField,
			JTextField comunidadField,String id){
		this.frame = frame;
		this.nombreField = nombreField;
		this.apellidosField = apellidosField;
		this.comunidadField = comunidadField;
		this.nombre = "";
		this.apellidos = "";
		this.comunidad = "";
		this.id = Integer.parseInt(id);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case CASO_ACEPTAR:
				
				this.nombre = nombreField.getText();
				this.apellidos = apellidosField.getText();
				this.comunidad = comunidadField.getText();
				
				try {
					Socket s1 = new Socket("localhost", 5000);
					
					BufferedReader entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
					PrintWriter salida = new PrintWriter(s1.getOutputStream(),true);
					
					salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_MODIFICAR_DIRECTOR) + "/"
							+ id + "/" + nombre + "/" + apellidos + "/" + comunidad);
					
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.DIRECTOR_MODIFICADO));
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
