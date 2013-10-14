package presentacion;
//Comentario de prueba
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextPane;

import dominio.GestorUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameNuevoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNuevoUsuario frame = new JFrameNuevoUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public JFrameNuevoUsuario() {
		setTitle("Dar de alta a un nuevo usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Password:");
		lblLogin.setBounds(6, 81, 69, 16);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("Login:");
		label.setBounds(6, 37, 69, 16);
		contentPane.add(label);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(87, 31, 134, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(87, 75, 134, 28);
		contentPane.add(textFieldPassword);
		
		JButton btnAltaUsuario = new JButton("Alta usuario");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//c—digo necesario para insertar un nuevo usuario en la base de datos.
				//Se deber‡ comprobar que el usuario se ha insertado correctamente intentando 
				//hacer el login			
				//Se deber‡ reportar en el panel de estado el resultado de la inserci—n. Tanto su exito
				//como cualquier excepci—n que pueda surgir.
				
				//--------->
				
				//Primero recogemos los datos
				String nombre=textFieldLogin.getText();
				String psswd= textFieldPassword.getText();
				
				//Comprobamos que el usuario no existe anteriormente
					//Mirar si sólo se puede consultar por en nombre
				try {
					boolean existe=GestorUsuario.autenticar(nombre);
					textPaneEstado.setText("Autenticado: "+ autenticado);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					textPane.setText(e.printStackTrace());
				}
				
				//Realizamos la insercción
				
				//<---------
				
			}
		});
		btnAltaUsuario.setBounds(253, 76, 117, 29);
		contentPane.add(btnAltaUsuario);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 126, 61, 16);
		contentPane.add(label_1);
		
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
	}
}
