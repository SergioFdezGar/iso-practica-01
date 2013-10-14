package persistencia;


import java.awt.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;

public class Agente {
	//instancia del agente
    protected static Agente mInstancia=null;
    //Conexion con la base de datos
    protected static Connection mBD;
	//Identificador ODBC de la base de datos
    private static String url="jdbc:odbc:BD_Login";
    //Driven para conectar con bases de datos Microsoft Access 
    private static String driver="sun.jdbc.odbc.JdbcOdbcDriver";
    
    //Constructor
    private Agente()throws Exception {
    	conectar();
    		
    }
    
    //Implementacion del patron singleton
    //Este patron de diseño permite implementar clases de las cuales
    //solo existir una instancia
    //http://es.wikipedia.org/wiki/Singleton
    
    
     public static Agente getAgente() throws Exception{
          if (mInstancia==null){
          mInstancia=new Agente();
        }
        return mInstancia;
     }
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar() throws Exception {
         Class.forName(driver);
         mBD=DriverManager.getConnection(url);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	mBD.close();
    }

    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws SQLException, Exception{ 
     	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int delete(String SQL) throws SQLException,Exception{
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int update(String SQL) throws SQLException,Exception{
    	conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    
	public Vector<Object> select(String SQL) throws SQLException,Exception{
		/*Metodo para realizar una busqueda o seleccion de informacion enla base de datos
	    *El mŽtodo select develve un vector de vectores, donde cada uno de los vectores
	    *que contiene el vector principal representa los registros que se recuperan de la base de datos.
	    */	
	}
}