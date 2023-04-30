package model;

import java.sql.Date;

import controller.HuespedController;

public class Huesped {
	
	private Integer id;
	private String  nombre;
	private String  apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	
	HuespedController huespedController;
	

	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huesped(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public String getTelefono() {
		return telefono;
	}
	
	
}
