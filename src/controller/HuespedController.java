package controller;


import java.sql.Date;
import java.util.List;

import dao.HuespedDAO;
import dao.UsuariosDAO;
import factory.ConnectionFactory;
import model.Huesped;
import model.Usuario;

/*import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;*/

import dao.UsuariosDAO;

public class HuespedController {
	
	private HuespedDAO huespedDAO;
	
	public HuespedController() {
		this.huespedDAO =  new HuespedDAO(new ConnectionFactory().recuperaConexion());
	}
	
	public void registrarHuesped(Huesped huesped) {
		huespedDAO.guardarHuesped(huesped);
	}

	public List<Huesped> listarHuesped() {
		return huespedDAO.listarHuesped();
	}
	
	public int eliminarHuesped(Integer id) {
		return huespedDAO.eliminarHuesped(id);
	}

	public int modificarHuesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer id) {
		return huespedDAO.modificarHuesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id);
	}
}
