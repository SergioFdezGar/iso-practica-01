package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import dominio.GestorUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLog;
	private JTextField textFieldPass;
	private JTextPane textPaneEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setTitle("Pr\u00E1ctica 1 - Acceso a bases de datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduzcaElLogin = new JLabel("Introduzca el login y el password para acceder al sistema");
		lblIntroduzcaElLogin.setBounds(6, 19, 386, 43);
		contentPane.add(lblIntroduzcaElLogin);
		
		textFieldLog = new JTextField();
		textFieldLog.setBounds(86, 68, 134, 28);
		contentPane.add(textFieldLog);
		textFieldLog.setColumns(10);
		
		JLabel lblLogin = new JLabel("Password:");
		lblLogin.setBounds(6, 122, 73, 16);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("Login:");
		label.setBounds(6, 74, 61, 16);
		contentPane.add(label);
		
		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(86, 116, 134, 28);
		contentPane.add(textFieldPass);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*Al pulsar aceptar, hay que tomar los valores de los campos que recogen el login y el password
				 * y mediante el GestorUsuarios hay que realizar la consulta a la base de datos. Toda consulta
				 * tiene una respuesta (sea afirmativa, negativa o una excepci�n) que deber� mostrarse en el
				 * panel de estado.
				 */
				String nombre= textFieldLog.getText();
				String psswd= textFieldPass.getText();
				
				try {
					boolean autenticado=GestorUsuario.autenticar(nombre, psswd);
					textPaneEstado.setText("Autenticado: "+ autenticado);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					textPaneEstado.setText(e.printStackTrace());
				}
				
										
			}
		});
		buttonAceptar.setBounds(264, 69, 117, 29);
		contentPane.add(buttonAceptar);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(6, 171, 61, 16);
		contentPane.add(lblEstado);
		
		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(6, 199, 407, 102);
		contentPane.add(textPaneEstado);
		
		JButton buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Limpiaremos el panel de salida para visualizar nuevas operaciones
				 */
				textPaneEstado.setText("");
			}
		});
		buttonLimpiar.setBounds(264, 117, 117, 29);
		contentPane.add(buttonLimpiar);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrameNuevoUsuario frame = new JFrameNuevoUsuario();
				frame.setVisible(true);
			}
		});
		btnNuevoUsuario.setBounds(264, 166, 117, 29);
		contentPane.add(btnNuevoUsuario);
		
		/*JScrollPane scrollPaneSalida = new JScrollPane();
		scrollPaneSalida.setToolTipText("Este panel mostrar\u00E1 el resultado de la consulta, las excepciones o cualquier otro resultado");
		scrollPaneSalida.setBounds(6, 193, 407, 108);
		scrollPaneSalida.
		contentPane.add(scrollPaneSalida);*/
	}
}
