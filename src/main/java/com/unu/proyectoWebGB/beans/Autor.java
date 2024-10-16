package com.unu.proyectoWebGB.beans;

public class Autor {
	private int idAutor;
	private String nacinalidad;
	private String nombre;

	public Autor(int idAutor, String nacinalidad, String nombre) {
		super();
		this.idAutor = idAutor;
		this.nacinalidad = nacinalidad;
		this.nombre = nombre;
	}

	public Autor() {
		this(0, "", "");
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNacinalidad() {
		return nacinalidad;
	}

	public void setNacinalidad(String nacinalidad) {
		this.nacinalidad = nacinalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
