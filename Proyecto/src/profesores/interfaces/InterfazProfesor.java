package profesores.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import profesores.listeners.MiActionListenerInterfazProfesor;
import configuration.Configuration;

public class InterfazProfesor extends JFrame{
	
	private JButton btnCrearAlumno;
	private JButton btnModificarAlumno;
	private JButton btnEliminarAlumno;
	
	public InterfazProfesor(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_PROFESOR));
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
		
        cargarCentro();
        
        MiActionListenerInterfazProfesor malip = new MiActionListenerInterfazProfesor(this);
        btnCrearAlumno.addActionListener(malip);
        btnModificarAlumno.addActionListener(malip);
        btnEliminarAlumno.addActionListener(malip);
	}
	
	public void cargarCentro(){
		JPanel panel = new JPanel();
		
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        
        Dimension d = new Dimension(500, 200);
        
		this.btnCrearAlumno = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CREAR_ALUMNO));
		this.btnModificarAlumno = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_MODIFICAR_ALUMNO));
		this.btnEliminarAlumno = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ELIMINAR_ALUMNO));
		
		this.btnCrearAlumno.setMaximumSize(d);
		this.btnModificarAlumno.setMaximumSize(d);
		this.btnEliminarAlumno.setMaximumSize(d);
		
		panel.add(btnCrearAlumno);
		panel.add(btnModificarAlumno);
		panel.add(btnEliminarAlumno);
		
		 // Posicion en el layout
        this.getContentPane().add(panel, BorderLayout.CENTER);
	}
}
