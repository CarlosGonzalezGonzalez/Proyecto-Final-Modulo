package ministro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import configuration.Configuration;

public class InterfazEliminarDirector extends JFrame{
	
	JLabel lblEliminar;
	JTextField idField;
	JButton btnEliminar;
	
	public InterfazEliminarDirector(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_ELIMINAR_DIRECTOR));
		this.setSize(350, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.lblEliminar = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_BUSCAR_DIRECTOR));
		this.idField = new JTextField();
		this.btnEliminar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ELIMINAR));
		
		BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
		
        cargarCentro();
        cargarSur();
        
        MiActionListenerEliminar malb = new MiActionListenerEliminar(this,idField);
        btnEliminar.addActionListener(malb);
	}
	
	private void cargarCentro(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		panel.add(lblEliminar);
		panel.add(idField);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	private void cargarSur(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(btnEliminar);
		
		this.getContentPane().add(panel,BorderLayout.SOUTH);
	}
	
}
