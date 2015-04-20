package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import configuration.Configuration;

public class InterfazLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLogin frame = new InterfazLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazLogin() {
		super(Configuration.getInstance().getProperty(Configuration.TITULO_LOGIN));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel usuarioLabel = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_USUARIO));
		panelPrincipal.add(usuarioLabel);
		
		usuario = new JTextField();
		panelPrincipal.add(usuario);
		usuario.setColumns(10);
		
		JLabel passwordLabel = new JLabel(Configuration.getInstance().getProperty(Configuration.TEXTO_PASSWORD));
		panelPrincipal.add(passwordLabel);
		
		password = new JPasswordField();
		panelPrincipal.add(password);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton botonAceptar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_ACEPTAR));
		panelBotones.add(botonAceptar);
		
		JButton botonCancelar = new JButton(Configuration.getInstance().getProperty(Configuration.TEXTO_CANCELAR));
		panelBotones.add(botonCancelar);
		
		MiActionListenerLogin mall = new MiActionListenerLogin(this,usuario,password);
		
	}
}
