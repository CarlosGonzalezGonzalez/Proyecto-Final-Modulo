package directores.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import configuration.Configuration;
import directores.interfaces.InterfazModificarProfesor;

public class MiActionListenerBuscar implements ActionListener{

	private JFrame frame;
	private JTextField idField;
	private String id;
	
	public MiActionListenerBuscar(JFrame frame,JTextField idField){
		this.frame = frame;
		this.idField = idField;
		this.id = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.id = this.idField.getText();
		
		if(id.equals("")){
			JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.COMPLETAR_ID));
		}else{
			try {
				Socket s1 = new Socket("localhost", 5000);
				
				BufferedReader entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
				PrintWriter salida = new PrintWriter(s1.getOutputStream(),true);
				
				salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_BUSCAR_PROFESOR) + 
	            		"/" + id);
				String[] datos = entrada.readLine().split("/");
				
				// Nos aseguramos de que hay algun profesor con el id que buscamos
				if(datos[0].equals(" ")){
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.ID_NO_VALIDO));
				}else{
					InterfazModificarProfesor imp = new InterfazModificarProfesor(datos);
					imp.setVisible(true);
					frame.dispose();
				}
				
			} catch (UnknownHostException ex) {
	            System.out.println("Servidor no encontrado");
	        } catch (IOException ex) {
	            System.out.println("Error");
	        }
            
		}
	}
}
