package ministro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
				break;
			case Configuration.VER_NOTAS:
				break;
				
		}
	}
}