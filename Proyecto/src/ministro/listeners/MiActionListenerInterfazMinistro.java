package ministro.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ministro.interfaces.InterfazBuscarDirector;
import ministro.interfaces.InterfazCrearDirector;
import ministro.interfaces.InterfazEliminarDirector;
import configuration.Configuration;

public class MiActionListenerInterfazMinistro implements ActionListener{

	private JFrame f;
	
	public MiActionListenerInterfazMinistro(JFrame frame){
		this.f = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		switch(boton.getText()){
			case Configuration.CREAR_DIRECTOR:
				InterfazCrearDirector icd = new InterfazCrearDirector();
				icd.setVisible(true);
				break;
			case Configuration.MODIFICAR_DIRECTOR:
				InterfazBuscarDirector ibd = new InterfazBuscarDirector();
				ibd.setVisible(true);
				break;
			case Configuration.ELIMINAR_DIRECTOR:
				InterfazEliminarDirector ied = new InterfazEliminarDirector();
				ied.setVisible(true);
				break;
			case Configuration.VER_NOTAS:
				break;
				
		}
	}
}