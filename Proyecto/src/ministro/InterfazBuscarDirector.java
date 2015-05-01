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

public class InterfazBuscarDirector extends JFrame{
	
	JLabel lblBuscar;
	JTextField idField;
	JButton btnBuscar;

	public InterfazBuscarDirector(){
		super(Configuration.getInstance().getProperty(Configuration.TITULO_BUCAR_DIRECTOR));
		this.setSize(350, 150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.lblBuscar = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_BUSCAR_DIRECTOR));
		this.idField = new JTextField();
		this.btnBuscar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_BUSCAR));
		
		BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
		
        cargarCentro();
        cargarSur();
        
        MiActionListenerBuscar malb = new MiActionListenerBuscar(this,idField);
        btnBuscar.addActionListener(malb);
	}
	
	private void cargarCentro(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		panel.add(lblBuscar);
		panel.add(idField);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	private void cargarSur(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(btnBuscar);
		
		this.getContentPane().add(panel,BorderLayout.SOUTH);
	}
	
}
