package com.unu.proyectoWebGB.util;

import com.unu.proyectoWebGB.beans.Autor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.unu.proyectoWebGB.models.AutoresModel;

public class Help {

	public static void main(String[] args) {
		
		AutoresModel autores = new AutoresModel();
		Iterator<Autor> it = autores.listarAutores().iterator();
		while(it.hasNext()) {
			Autor a = it.next();
			System.out.println(a.getIdAutor()+" "+a.getNombre()+" "+a.getNacinalidad());
		}
		
	}

}
