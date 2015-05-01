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

public class InterfazCrearDirector extends JFrame{
	
	// Labels
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JLabel lblComunidad;
	// TextFields
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField usuarioField;
	private JTextField passField;
	private JTextField comunidadField;
	// JButtons
	private JButton btnAceptar;
	private JButton btnCancelar;
	// JPanel
	private JPanel panel1;
	private JPanel panel2;
	
	public InterfazCrearDirector(){
		super(Configuration.getInstance().getProperty(Configuration.TEXTO_CREAR_DIRECTOR));
		this.setSize(350,270);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.lblNombre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_NOMBRE));
		this.lblApellidos = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_APELLIDOS));
		this.lblUsuario = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_USUARIO));
		this.lblPass = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_PASSWORD));
		this.lblComunidad = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_COMUNIDAD));
		this.nombreField = new JTextField();
		this.apellidosField = new JTextField();
		this.usuarioField = new JTextField();
		this.passField = new JTextField();
		this.comunidadField = new JTextField();
		this.btnAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		this.btnCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		
		cargarPanel1();
		cargarPanel2();
		
		MiActionListenerCrearDirector malcd = new MiActionListenerCrearDirector(this,nombreField,apellidosField,
				usuarioField,passField,comunidadField);
		btnAceptar.addActionListener(malcd);
		btnCancelar.addActionListener(malcd);
	}

	private void cargarPanel1(){
		GridLayout gl = new GridLayout(5,2);
		panel1.setLayout(gl);
		
		panel1.add(lblNombre);
		panel1.add(nombreField);
		panel1.add(lblApellidos);
		panel1.add(apellidosField);
		panel1.add(lblUsuario);
		panel1.add(usuarioField);
		panel1.add(lblPass);
		panel1.add(passField);
		panel1.add(lblComunidad);
		panel1.add(comunidadField);
		
		this.getContentPane().add(panel1,BorderLayout.CENTER);;
	}
	
	private void cargarPanel2(){
		panel2.setLayout(new FlowLayout());
        panel2.add(btnAceptar);
        panel2.add(btnCancelar);
        
        this.getContentPane().add(panel2,BorderLayout.SOUTH);
	}
	
}
