package directores.interfaces;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import configuration.Configuration;
import directores.listeners.MiActionListenerInterfazDirector;

public class InterfazDirector extends JFrame{
	
	private JButton btnCrearProfesor;
	private JButton btnModificarProfesor;
	private JButton btnEliminarProfesor;

	public InterfazDirector(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_DIRECTOR));
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        
        cargarCentro();
        
        MiActionListenerInterfazDirector malid = new MiActionListenerInterfazDirector(this);
        btnCrearProfesor.addActionListener(malid);
        btnModificarProfesor.addActionListener(malid);
        btnEliminarProfesor.addActionListener(malid);
	}
	
	public void cargarCentro(){
		JPanel panel = new JPanel();
		
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        
        Dimension d = new Dimension(500, 200);
        
		this.btnCrearProfesor = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CREAR_PROFESOR));
		this.btnModificarProfesor = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_MODIFICAR_PROFESOR));
		this.btnEliminarProfesor = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ELIMINAR_PROFESOR));
		
		this.btnCrearProfesor.setMaximumSize(d);
		this.btnModificarProfesor.setMaximumSize(d);
		this.btnEliminarProfesor.setMaximumSize(d);
		
		panel.add(btnCrearProfesor);
		panel.add(btnModificarProfesor);
		panel.add(btnEliminarProfesor);
		
		 // Posicion en el layout
        this.getContentPane().add(panel, BorderLayout.CENTER);
	}
}