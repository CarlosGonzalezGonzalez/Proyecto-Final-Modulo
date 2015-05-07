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
import directores.listeners.MiActionListenerCrearProfesor;

public class InterfazCrearProfesor extends JFrame{
	// JLabels
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblIdDirector;
	private JLabel lblUsuario;
	private JLabel lblPass;
	// JTextFields
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField idDirectorField;
	private JTextField usuarioField;
	private JTextField passField;
	// JButtons
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public InterfazCrearProfesor(){
		super(Configuration.getInstance().getProperty(Configuration.TEXTO_CREAR_PROFESOR));
		this.setSize(350,270);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.lblNombre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_NOMBRE));
		this.lblApellidos = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_APELLIDOS));
		this.lblIdDirector = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_ID_DIRECTOR));
		this.lblUsuario = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_USUARIO));
		this.lblPass = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_PASSWORD));
		this.nombreField = new JTextField();
		this.apellidosField = new JTextField();
		this.idDirectorField = new JTextField();
		this.usuarioField = new JTextField();
		this.passField = new JTextField();
		this.btnAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		this.btnCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		
		cargarCentro();
		cargarSur();
		
		MiActionListenerCrearProfesor malcp = new MiActionListenerCrearProfesor(this,nombreField,apellidosField,idDirectorField,
				usuarioField,passField);
		btnAceptar.addActionListener(malcp);
		btnCancelar.addActionListener(malcp);
	}

	public void cargarCentro(){
		JPanel panel = new JPanel();
		GridLayout gl = new GridLayout(5,2);
		panel.setLayout(gl);
		
		panel.add(lblNombre);
		panel.add(nombreField);
		panel.add(lblApellidos);
		panel.add(apellidosField);
		panel.add(lblIdDirector);
		panel.add(idDirectorField);
		panel.add(lblUsuario);
		panel.add(usuarioField);
		panel.add(lblPass);
		panel.add(passField);
		
		this.getContentPane().add(panel,BorderLayout.CENTER);
		
	}
	
	public void cargarSur(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(btnAceptar);
        panel.add(btnCancelar);
        
        this.getContentPane().add(panel,BorderLayout.SOUTH);
	}
	
}
