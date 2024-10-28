package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oracle.jdbc.driver.parser.Parseable;

import java.io.IOException;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.models.AutoresModel;

@WebServlet(name = "AutoresController", urlPatterns = { "/AutoresController" })

public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AutoresModel modelo = new AutoresModel();

	public AutoresController() {
		super();
	}

	/* reques nos sirve para recoger los parametros dentro de la lista */
	protected void processRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {

		reponse.setContentType("text/html;charset=UTF-8");

		if (request.getParameter("op") == null) {// si tengo una opcion con op(parametro y si es nulo entonces estaria
													// // mostrandome la lista)
			listar(request, reponse);
			return;
		}

		String operacion = request.getParameter("op");
		System.out.println(operacion);

		switch (operacion) {
		case "listar":
			listar(request, reponse);
			break;
		case "nuevo":
			request.getRequestDispatcher("/autores/GuardarAutores.jsp").forward(request, reponse);
			break;
		case "agregar":
			agregar(request, reponse);
			break;
		case "modificar":
			modificar(request, reponse);
			break;
		case "obtener":
			obtener(request, reponse);
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse reponse) {
		// el reponse.add lo que va a hacer es cargar a la lista y despues disparar
		try {
			request.setAttribute("listaAutores", modelo.listaAutores());//almacena un atributo en una solucitud con una fórmula de clave/valor

			Iterator<Autor> it = modelo.listaAutores().iterator();
			while (it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getIdAutor() + " " + a.getNombre() + " " + a.getNacinalidad());
			}

			request.getRequestDispatcher("autores/listaAutores.jsp").forward(request, reponse);
		} catch (Exception e) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	protected void agregar (HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			Autor a = new Autor();
			a.setNombre(request.getParameter("nombre"));
			a.setNacinalidad(request.getParameter("nacio"));
			if (modelo.agregarAutor(a)>0) {
				request.getSession().setAttribute("exito", "Autor registrado exitosamente");
				response.sendRedirect(request.getContextPath()+"/AutoresController?=listar");
			}else {
				request.getSession().setAttribute("fracaso", "Autor no registrado");
				response.sendRedirect(request.getContextPath()+"/AutoresController?=listar");//como respuesta vamos a mandar al usuario a otro lado "url", para que despues se obtenga el contexto de la aplicacion
			}
		}catch (IOException | SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	protected void modificar (HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			Autor a = new Autor();
			a.setIdAutor(Integer.parseInt(request.getParameter("id")));
			a.setNombre(request.getParameter("nom"));
			a.setNacinalidad(request.getParameter("nacio"));
			if (modelo.modificarAutor(a)>0) {
				request.getSession().setAttribute("exito", "Autor registrado exitosamente");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			}
		}catch (Exception e) {
			request.getSession().setAttribute("fracaso", "Autor no registrado");
			response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");

		}
	}
	
	protected void obtener (HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
		try {
			String id = request.getParameter("id");
			System.out.println("->" + id);
			Autor a = modelo.obtenerAutor(Integer.parseInt(id));
			if(a != null) {
				request.setAttribute("autor", a);
				request.getRequestDispatcher("/autores/modificarAutor.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}

		}catch (SQLException e) {
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
