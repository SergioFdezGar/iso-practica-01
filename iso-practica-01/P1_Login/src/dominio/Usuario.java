package dominio;

import java.util.Vector;

import persistencia.Agente;

public class Usuario {
	
	private String mLogin;
	private String mPassword;
	
	//Constructor para la creación de un objeto Usuario vacio
	public Usuario(){
		this.mLogin = null;
		this.mPassword = null;
	}
	
	//Constructor para la creación de un Usuario
	public Usuario(String login, String password){
		this.mLogin = login;
		this.mPassword = password;
	}
	
	//Selección de un usuario de la base de datos a partir del login y el password
	public static Usuario read(String login, String password) throws Exception{
		String l,g;
		Usuario u = null;
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT login, password FROM Usuario WHERE login = '"+login+"' AND password = '"+password+"';";
		
		Agente a = Agente.getAgente();
		Vector<Object> res = a.select(SQL_Consulta);
		
		if (res.size() == 1){
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1));
		}
		return u;
	}
	
	//Inserción de un nuevo usuario en la base de datos
	public int insert() throws Exception{
		/*Debe implementarse la lógica para insertar el contenido de un objeto usuario en la base de datos
		 *Los objetos de la capa de dominio se comunican con el agente para enviarle sus peticiones
		 *AYUDA1: la consulta para realizar la inserción es la siguiente
		 * "INSERT INTO Usuario VALUES('"+this.mLogin+"','"+this.mPassword+"');"
		 *AYUDA2: Del mismo modo que para consultar la información, el agente provee de un método "select",
		 *para hacer una inserción el agente provee de un método "insert"
		 */
	}
}
