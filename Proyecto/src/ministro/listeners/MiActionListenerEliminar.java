package ministro.listeners;

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

public class MiActionListenerEliminar implements ActionListener {

	private JFrame frame;
	private JTextField idField;
	private String id;

	public MiActionListenerEliminar(JFrame frame, JTextField idField) {
		this.frame = frame;
		this.idField = idField;
		this.id = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.id = idField.getText();

		if (id.equals("")) {
			JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.COMPLETAR_ID));
		} else {
			try {

				Socket s1 = new Socket("localhost", 5000);

				BufferedReader entrada = new BufferedReader(new InputStreamReader(s1.getInputStream()));
				PrintWriter salida = new PrintWriter(s1.getOutputStream(), true);

				salida.println(Configuration.getInstance().getProperty(Configuration.TITULO_ELIMINAR_DIRECTOR) + 
	            		"/" + id);
				
				String[] datos = entrada.readLine().split("/");
				if(!datos[0].equals(" ")){
					salida.println("continuar");
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.DIRECTOR_ELIMINADO));
				}else{
					salida.println("salir");
					JOptionPane.showMessageDialog(frame, Configuration.getInstance().getProperty(Configuration.ID_NO_VALIDO));
				}
				frame.dispose();
			} catch (UnknownHostException ex) {
				System.out.println("Servidor no encontrado");
			} catch (IOException ex) {
				System.out.println("Error");
			}
		}
	}
}
