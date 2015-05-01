package ministro;

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
				
				salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_BUCAR_DIRECTOR) + 
	            		"/" + id);
				String[] datos = entrada.readLine().split("/");
				
				// Nos aseguramos de que hay algun director con el id que buscamos
				if(datos[0].equals(" ")){
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.ID_NO_VALIDO));
				}else{
					InterfazModificarDirector imd = new InterfazModificarDirector(datos);
					imd.setVisible(true);
				}
				
			} catch (UnknownHostException ex) {
	            System.out.println("Servidor no encontrado");
	        } catch (IOException ex) {
	            System.out.println("Error");
	        }
            
		}
		
		
	}

}
