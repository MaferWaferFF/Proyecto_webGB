package com.unu.proyectoWebGB.models;

import java.util.ArrayList;
import java.util.List;

import com.unu.proyectoWebGB.beans.*;

public class AutoresModel {

	public List<Autor> listarAutores() {

		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor(1, "Garcia Marquez", "Colombiana"));
		autores.add(new Autor(2, "Borgues", "Argentino"));
		autores.add(new Autor(3, "Allende", "Chileno"));

		return autores;//hay inquietas hay like
	}

}
