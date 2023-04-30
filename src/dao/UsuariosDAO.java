package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factory.ConnectionFactory;
import model.Usuario;

public class UsuariosDAO {
	final private Connection con;
	
	public UsuariosDAO(Connection con) {
		this.con = con;
	}
	
	public boolean iniciarSesion(Usuario usuario){ 	
    	try(con){
	    	final PreparedStatement state = con.prepareStatement("SELECT COUNT(USUARIO) "
	    			+ "FROM USUARIOS WHERE usuario = ? AND pass = ?", java.sql.Statement.RETURN_GENERATED_KEYS);
	    	
	    	try(state) {
	    		state.setString(1, usuario.getUsuario());
	    		state.setString(2, usuario.getPassword());

	        	state.execute();
	        	
	        	final ResultSet resultSet =  state.getResultSet();
	        	
	        	try(resultSet){
	        	
	    	    	while(resultSet.next()) {
	    	    		//System.out.println(resultSet.getString(1));
	    	    		if(resultSet.getInt(1) == 1)
	    	    			return true; break;
	    	    	}
	    	    	return false;
	        	}
	    	} 
	    	
    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}
	}
}
