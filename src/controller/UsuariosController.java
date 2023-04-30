package controller;


import java.util.List;

import dao.UsuariosDAO;
import factory.ConnectionFactory;
import model.Usuario;

/*import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;*/

import dao.UsuariosDAO;

public class UsuariosController {
	
	private UsuariosDAO usuariosDAO;
	
	public UsuariosController() {
		this.usuariosDAO =  new UsuariosDAO(new ConnectionFactory().recuperaConexion());
	}

	public boolean iniciarSesion(Usuario usuario) {
		return usuariosDAO.iniciarSesion(usuario);
	}
}
