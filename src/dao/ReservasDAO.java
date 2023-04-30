package dao;

import java.sql.Connection;
import java.util.Date;
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
import model.Reservas;

public class ReservasDAO {
	final private Connection con;
	
	public ReservasDAO(Connection con) {
		this.con = con;
	}
	
	public void guardarReserva(Reservas reservas){
		try(con){
	    	final PreparedStatement state = con.prepareStatement("INSERT INTO RESERVAS "
	    			+ "(fecha_entrada, fecha_salida, valor, forma_pago, id_huesped)" +
					"VALUES(?, ?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
	    	
	    	try(state) {
	    		state.setDate(1, reservas.getFechaEntrada());
	    		state.setDate(2, reservas.getFechaSalida());
	    		state.setInt(3, reservas.getValor());
	    		state.setString(4, reservas.getFormaPago());
	    		state.setInt(5, reservas.getIdHuesped());
	    		
	        	state.execute();
	        	
	        	final ResultSet resultSet =  state.getGeneratedKeys();
	        	
	        	try(resultSet){
	        	
	    	    	while(resultSet.next()) {
	    	    		reservas.setId(resultSet.getInt(1));
	    	    		JOptionPane.showMessageDialog(null, "La reserva se ha guardado correctamente con id: " + reservas.getId());
	    	    	}
	        	}
	    	} 
	    	
    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}
	}

	public List<Reservas> listarReservas() {
		try(con){
		
			final PreparedStatement state = con.prepareStatement("SELECT r.*, h.nombre, h.apellido FROM reservas r "
					+ "INNER JOIN huespedes h ON r.id_huesped = h.id;");
			
			try(state){
				state.execute();
				
				ResultSet resulSet = state.getResultSet();
				
				List<Reservas> resultado = new ArrayList<>();
				
				while (resulSet.next()) {
					Reservas fila = new Reservas(resulSet.getInt("ID"),
							resulSet.getDate("FECHA_ENTRADA"),
							resulSet.getDate("FECHA_SALIDA"),
							resulSet.getInt("VALOR"),
							resulSet.getString("FORMA_PAGO"),
							resulSet.getInt("id_huesped"),
							resulSet.getString("nombre"),
							resulSet.getString("apellido"));
					
					resultado.add(fila);
					
				}
				return resultado;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int eliminarReserva(int id) {
		try(con){
			
			final PreparedStatement state = con.prepareStatement("DELETE FROM reservas WHERE ID = ?");
			
			try(state){
				
				state.setInt(1, id);
				state.execute();
				
				return state.getUpdateCount();
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modificarReserva(Date fechaEntrada, Date fechaSalida, Integer id, Integer valor, String formaPago) {
		try(con){
			
			final PreparedStatement state = con.prepareStatement("UPDATE reservas SET"
					+ " fecha_entrada = ? "
					+ ", fecha_salida = ? "
					+ ", valor = ? "
					+ ", forma_pago = ? "
					+ " WHERE ID = ? ");
			
			try(state){
				state.setDate(1, (java.sql.Date) fechaEntrada);
				state.setDate(2, (java.sql.Date) fechaSalida);
				state.setInt(3, valor);
				state.setString(4, formaPago);
				state.setInt(5, id);
				int updateCount = state.getUpdateCount();
				state.execute();
				
				return updateCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
