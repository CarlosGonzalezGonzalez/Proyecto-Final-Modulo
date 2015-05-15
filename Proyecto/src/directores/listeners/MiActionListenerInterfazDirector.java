package directores.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import configuration.Configuration;
import directores.interfaces.InterfazBuscarProfesor;
import directores.interfaces.InterfazCrearProfesor;
import directores.interfaces.InterfazEliminarProfesor;

public class MiActionListenerInterfazDirector implements ActionListener{

	private JFrame frame;
	
	public MiActionListenerInterfazDirector(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case Configuration.CREARPROFESOR:
				InterfazCrearProfesor icp = new InterfazCrearProfesor();
				icp.setVisible(true);
				break;
			case Configuration.MODIFICARPROFESOR:
				InterfazBuscarProfesor ibp = new InterfazBuscarProfesor();
				ibp.setVisible(true);
				break;
			case Configuration.ELIMINARPROFESOR:
				InterfazEliminarProfesor iep = new InterfazEliminarProfesor();
				iep.setVisible(true);
				break;
		}
		
	}

	
	
}
