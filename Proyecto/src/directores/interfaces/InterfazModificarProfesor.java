package directores.interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import configuration.Configuration;
import directores.listeners.MiActionListenerInterfazModificarProfesor;

public class InterfazModificarProfesor extends JFrame{
	
	private JLabel lblId;
	private JLabel lblNombre;
	private JTextField nombreField;
	private JLabel lblApellidos;
	private JTextField apellidosField;
	private JLabel lblIdDirector;
	private JTextField idDirectorField;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public InterfazModificarProfesor(String[] datos){
		/*
		  datos[0] --> id
		  datos[1] --> nombre
		  datos[2] --> apellidos
		  datos[3] --> iddirector
		*/
		super(Configuration.getInstance().getProperty(Configuration.TITULO_MODIFICAR_PROFESOR));
		
		this.setSize(600,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.lblId = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_ID) + datos[0]);
		this.lblNombre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_NOMBRE));
		this.nombreField = new JTextField(datos[1]);
		this.lblApellidos = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_APELLIDOS));
		this.apellidosField = new JTextField(datos[2]);
		this.lblIdDirector = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_ID_DIRECTOR));
		this.idDirectorField = new JTextField(datos[3]);
		this.btnAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		this.btnCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		
		cargarNorte();
		cargarCentro();
		cargarSur();
		
		MiActionListenerInterfazModificarProfesor malimd = new MiActionListenerInterfazModificarProfesor(this,
				nombreField,apellidosField,idDirectorField,datos[0]);
		btnAceptar.addActionListener(malimd);
		btnCancelar.addActionListener(malimd);
	}
	
	public void cargarNorte(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(lblId);
		
		this.getContentPane().add(panel, BorderLayout.NORTH);
	}
	
	public void cargarCentro(){
		JPanel panel = new JPanel();
		GridLayout gl = new GridLayout(2,2);
		panel.setLayout(gl);
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new GridLayout(1,2));
		subPanel1.add(lblNombre);
		subPanel1.add(nombreField);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new GridLayout(1,2));
		subPanel2.add(lblApellidos);
		subPanel2.add(apellidosField);
		
		JPanel subPanel3 = new JPanel();
		subPanel3.setLayout(new GridLayout(1,2));
		subPanel3.add(lblIdDirector);
		subPanel3.add(idDirectorField);
		
		JPanel subPanel4 = new JPanel();
		subPanel4.setLayout(new GridLayout(1,2));
		
		panel.add(subPanel1);
		panel.add(subPanel2);
		panel.add(subPanel3);
		panel.add(subPanel4);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	public void cargarSur(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(btnAceptar);
        panel.add(btnCancelar);
        
        this.getContentPane().add(panel,BorderLayout.SOUTH);
	}
}
