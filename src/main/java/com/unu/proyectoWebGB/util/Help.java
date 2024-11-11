package com.unu.proyectoWebGB.util;

import com.unu.proyectoWebGB.util.*;

public class Help {

	public static void main(String[] args) {
		
		/*AutoresModel autores = new AutoresModel();
		Iterator<Autor> it = autores.listarAutores().iterator();
		while(it.hasNext()) {
			Autor a = it.next();
			System.out.println(a.getIdAutor()+" "+a.getNombre()+" "+a.getNacinalidad());
		}*/
		
		Conexion con = new Conexion();
		
		con.abrirConexion();
		
	}

}
