package profesores.interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import configuration.Configuration;

public class InterfazCrearAlumno extends JFrame{

	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTlf;
	private JLabel lblPadre;
	private JLabel lblMadre;
	
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField tlfField;
	private JTextField padreField;
	private JTextField madreField;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public InterfazCrearAlumno(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_CREAR_ALUMNO));
		this.setSize(350,270);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.lblNombre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_NOMBRE));
		this.lblApellidos = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_APELLIDOS));
		this.lblTlf = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_TELEFONO));
		this.lblPadre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_PADRE));
		this.lblMadre = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_MADRE));
		this.nombreField = new JTextField();
		this.apellidosField = new JTextField();
		this.tlfField = new JTextField();
		this.padreField = new JTextField();
		this.madreField = new JTextField();
		this.btnAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		this.btnCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		
		cargarCentro();
		cargarSur();
	}
	
	public void cargarCentro(){
		JPanel panel = new JPanel();
		GridLayout gl = new GridLayout(5,2);
		panel.setLayout(gl);
		
		panel.add(lblNombre);
		panel.add(nombreField);
		panel.add(lblApellidos);
		panel.add(apellidosField);
		panel.add(lblTlf);
		panel.add(tlfField);
		panel.add(lblPadre);
		panel.add(padreField);
		panel.add(lblMadre);
		panel.add(madreField);
		
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
