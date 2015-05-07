package ministro.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ministro.listeners.MiActionListenerInterfazMinistro;
import configuration.Configuration;

public class InterfazMinistro extends JFrame{
	
	private JButton btnCrearDirector;
	private JButton btnModificarDirector;
	private JButton btnEliminarDirector;
	private JButton btnVerNotas;
	
	public InterfazMinistro(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_MINISTRO));
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        
        cargarOeste();
        
        // Listeners
        MiActionListenerInterfazMinistro miml = new MiActionListenerInterfazMinistro(this);
        btnCrearDirector.addActionListener(miml);
        btnModificarDirector.addActionListener(miml);
        btnEliminarDirector.addActionListener(miml);
        btnVerNotas.addActionListener(miml);
		
	}
	
	private void cargarOeste(){
		JPanel panel = new JPanel();
		
		Dimension d = new Dimension(500, 200);
		
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(box);
        
		// Creamos los botones
        btnCrearDirector = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CREAR_DIRECTOR));
        btnModificarDirector = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_MODIFICAR_DIRECTOR));
        btnEliminarDirector = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ELIMINAR_DIRECTOR));
        btnVerNotas = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_VER_NOTAS));
        
        // Modificamos el tamaño de los botones
        btnCrearDirector.setMaximumSize(d);
        btnModificarDirector.setMaximumSize(d);
        btnEliminarDirector.setMaximumSize(d);
        btnVerNotas.setMaximumSize(d);
        
        // Añadimos los botones
        panel.add(btnCrearDirector);
        panel.add(btnModificarDirector);
        panel.add(btnEliminarDirector);
        panel.add(btnVerNotas);
        
        
        
        // Posicion en el layout
        this.getContentPane().add(panel, BorderLayout.WEST);
	}
}
