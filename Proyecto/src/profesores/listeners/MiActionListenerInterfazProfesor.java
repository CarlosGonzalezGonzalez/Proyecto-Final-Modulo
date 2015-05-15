package profesores.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import profesores.interfaces.InterfazCrearAlumno;
import configuration.Configuration;

public class MiActionListenerInterfazProfesor implements ActionListener{

	private JFrame frame;
	
	public MiActionListenerInterfazProfesor(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case Configuration.CREARALUMNO:
				InterfazCrearAlumno ica = new InterfazCrearAlumno();
				ica.setVisible(true);
				break;
			case Configuration.MODIFICARALUMNO:
				/*InterfazModificarAlumno  ima = new InterfazModificarAlumno();
				ima.setVisible(true);*/
				break;
			case Configuration.ELIMINARALUMNO:
				/*InterfazEliminarAlumno iea = new InterfazEliminarAlumno();
				iea.setVisible(true);*/
				break;
		}
		
	}

}
