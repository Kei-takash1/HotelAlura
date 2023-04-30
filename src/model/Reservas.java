package model;

import java.sql.Date;

public class Reservas {
	
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Integer valor;
	private String formaPago;
	private Integer idHuesped;
	private String nombreHuesped;
	private String apellidoHuesped;
	

	public Reservas(Date fechaEntrada, Date fechaSalida, Integer valor, String formaPago, Integer idHuesped) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		this.idHuesped = idHuesped;
	}
	
	public Reservas(Integer id, Date fechaEntrada, Date fechaSalida, Integer valor, String formaPago, Integer idHuesped, String nombreHuesped, String apellidoHuesped) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		this.idHuesped = idHuesped;
		this.nombreHuesped = nombreHuesped;
		this.apellidoHuesped = apellidoHuesped;
	}

	public String getApellidoHuesped() {
		return apellidoHuesped;
	}

	public Integer getIdHuesped() {
		return idHuesped;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public Integer getValor() {
		return valor;
	}


	public String getFormaPago() {
		return formaPago;
	}

	public String getNombreHuesped() {
		return nombreHuesped;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
