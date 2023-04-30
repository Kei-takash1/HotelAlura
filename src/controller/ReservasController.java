package controller;


import java.util.Date;
import java.util.List;

import dao.ReservasDAO;
import dao.UsuariosDAO;
import factory.ConnectionFactory;
import model.Huesped;
import model.Reservas;
import model.Usuario;

/*import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;*/

import dao.UsuariosDAO;

public class ReservasController {
	
	private ReservasDAO reservasDAO;
	
	public ReservasController() {
		this.reservasDAO =  new ReservasDAO(new ConnectionFactory().recuperaConexion());
	}

	public void guardarReserva(Reservas reservas) {
		reservasDAO.guardarReserva(reservas);
	}

	public List<Reservas> listarReservas() {
		return reservasDAO.listarReservas();
	}

	public int eliminarReserva(Integer id) {
		return reservasDAO.eliminarReserva(id);
	}

	public int modificarReserva(Date fechaEntrada, Date fechaSalida, Integer id, Integer valor, String formaPago) {
		return reservasDAO.modificarReserva(fechaEntrada, fechaSalida, id, valor, formaPago);
	}
}
