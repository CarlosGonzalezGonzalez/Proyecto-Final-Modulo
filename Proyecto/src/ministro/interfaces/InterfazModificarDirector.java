package ministro.interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ministro.listeners.MiActionListenerInterfazModificarDirector;
import configuration.Configuration;

public class InterfazModificarDirector extends JFrame{
	
	JLabel lblId;
	JLabel lblNombre;
	JTextField nombreField;
	JLabel lblApellidos;
	JTextField apellidosField;
	JLabel lblComunidad;
	JTextField comunidadField;
	JButton btnAceptar;
	JButton btnCancelar;
	
	public InterfazModificarDirector(String[] datos){
		/*
		  datos[0] --> id
		  datos[1] --> nombre
		  datos[2] --> apellidos
		  datos[3] --> comunidad
		  datos[4] --> pass
		*/
		super(Configuration.getInstance().getProperty(Configuration.TITULO_MODIFICAR_DIRECTOR));
		
		this.setSize(600,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.lblId = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_ID) + datos[0]);
		this.lblNombre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_NOMBRE));
		this.nombreField = new JTextField(datos[1]);
		this.lblApellidos = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_APELLIDOS));
		this.apellidosField = new JTextField(datos[2]);
		this.lblComunidad = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_COMUNIDAD));
		this.comunidadField = new JTextField(datos[3]);
		this.btnAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		this.btnCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		
		cargarNorte();
		cargarCentro();
		cargarSur();
		
		MiActionListenerInterfazModificarDirector malimd = new MiActionListenerInterfazModificarDirector(this,
				nombreField,apellidosField,comunidadField,datos[0]);
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
		subPanel3.add(lblComunidad);
		subPanel3.add(comunidadField);
		
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
