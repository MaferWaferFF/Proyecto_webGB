package com.unu.proyectoWebGB.beans;

public class Libro {
	
	private int idL;
	private String cod;
	private String nombre;
	private int existencias;
	private String idA;
	private String idE;
	private String idG;
	private String descripcion;
	
	public Libro(int idL, String cod, String nombre, int existencias, String idA, String idE, String idG,
			String descripcion) {
		super();
		this.idL = idL;
		this.cod = cod;
		this.nombre = nombre;
		this.existencias = existencias;
		this.idA = idA;
		this.idE = idE;
		this.idG = idG;
		this.descripcion = descripcion;
	}

	public Libro() {
		this(0,"","",0,"","","","");
	}

	public int getIdL() {
		return idL;
	}

	public void setIdL(int idL) {
		this.idL = idL;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public String getIdA() {
		return idA;
	}

	public void setIdA(String idA) {
		this.idA = idA;
	}

	public String getIdE() {
		return idE;
	}

	public void setIdE(String idE) {
		this.idE = idE;
	}

	public String getIdG() {
		return idG;
	}

	public void setIdG(String idG) {
		this.idG = idG;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
