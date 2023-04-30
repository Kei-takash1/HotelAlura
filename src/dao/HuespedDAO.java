package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import factory.ConnectionFactory;
import model.Huesped;

public class HuespedDAO {
	final private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardarHuesped(Huesped huesped){ 	
		try(con){
	    	final PreparedStatement state = con.prepareStatement("INSERT INTO HUESPEDES (nombre, apellido, "
	    			+ "fecha_nacimiento, nacionalidad, telefono)" +
					"VALUES(?, ?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
	    	
	    	try(state) {
	    		state.setString(1, huesped.getNombre());
	    		state.setString(2, huesped.getApellido());
	    		state.setDate(3, huesped.getFechaNacimiento());
	    		state.setString(4, huesped.getNacionalidad());
	    		state.setString(5, huesped.getTelefono());
	    		
	        	state.execute();
	        	
	        	final ResultSet resultSet =  state.getGeneratedKeys();
	        	
	        	try(resultSet){
	        	
	    	    	while(resultSet.next()) {
	    	    		huesped.setId(resultSet.getInt(1));
	    	    		JOptionPane.showMessageDialog(null, "Se agrego con exito al huesped: " + huesped.getNombre());
	    	    	}
	        	}
	    	} 
	    	
    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}
	}

	public List<Huesped> listarHuesped() {
		try(con){
		
			final PreparedStatement state = con.prepareStatement("SELECT * FROM huespedes");
			
			try(state){
				state.execute();
				
				ResultSet resulSet = state.getResultSet();
				
				List<Huesped> resultado = new ArrayList<>();
				
				while (resulSet.next()) {
					Huesped fila = new Huesped(resulSet.getInt("ID"),
							resulSet.getString("NOMBRE"),
							resulSet.getString("APELLIDO"),
							resulSet.getDate("FECHA_NACIMIENTO"),
							resulSet.getString("NACIONALIDAD"),
							resulSet.getString("TELEFONO"));
					
					resultado.add(fila);
					
				}
				return resultado;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int eliminarHuesped(int id) {
		try(con){
			
			final PreparedStatement state = con.prepareStatement("DELETE FROM huespedes WHERE ID = ?");
			
			try(state){
				
				state.setInt(1, id);
				state.execute();
				
				return state.getUpdateCount();
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modificarHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer id) {
		
		try(con){
			
			final PreparedStatement state = con.prepareStatement("UPDATE huespedes SET"
					+ " nombre = ? "
					+ ", apellido = ? "
					+ ", fecha_nacimiento = ? "
					+ ", nacionalidad = ? "
					+ ", telefono = ? "
					+ " WHERE ID = ? ");
			
			try(state){
				state.setString(1, nombre);
				state.setString(2, apellido);
				state.setDate(3, fechaNacimiento);
				state.setString(4, nacionalidad);
				state.setString(5, telefono);
				state.setInt(6, id);
				int updateCount = state.getUpdateCount();
				state.execute();
				
				return updateCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
