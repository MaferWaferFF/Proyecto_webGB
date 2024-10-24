package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.models.AutoresModel;

public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AutoresModel modelo = new AutoresModel();
	
	public AutoresController() {
		super();
	}
/*reques nos sirve para recoger los parametros dentro de la lista*/
	protected void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
		if (request.getParameter("op") == null) {// si tengo una opcion con op(parametro y si es nulo entonces estaria													// mostrandome la lista)
			listar(request, reponse);
			return;
		}
		
		String operacion = request.getParameter("op");
		
		switch (operacion) {
		case "listar":
			listar(request, reponse);
			break;
		case "nuevo":
			//nuevo()
			break;
		}
	}

	private void listar (HttpServletRequest request, HttpServletResponse reponse) {
		//el reponse.add lo que va a hacer es cargar a la lista y despues disparar
		try {
			request.setAttribute("listaAutores", modelo.listarAutores());
			
			Iterator<Autor> it = modelo.listarAutores().iterator();
			while(it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getIdAutor()+" "+a.getNombre()+" "+a.getNacinalidad());
			}
			
			request.getRequestDispatcher("autores/listaAutores.jsp").forward(request, reponse);
		}catch (Exception e) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
