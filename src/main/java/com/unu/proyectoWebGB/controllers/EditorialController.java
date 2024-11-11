package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Editorial;
import com.unu.proyectoWebGB.models.EditorialModel;

public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EditorialModel model = new EditorialModel();

	public EditorialController() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println(request.getParameter("op"));
		//response.setContentType("text/html;charset=UFT-8");
		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}

		String opcion = request.getParameter("op");
		
		switch (opcion) {
		case "listar":
			listar(request, response);
			break;
		case "nuevo":
			request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
			break;
		case "guardar":
			guardar(request, response);
			break;
		case "obtener":
			obtener(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listarEditorial", model.listarEditoriales());

			Iterator<Editorial> i = model.listarEditoriales().iterator();
			while (i.hasNext()) {
				Editorial e = i.next();
				System.out.println(" " + e.getIdEditorial() + " " + e.getCodigo() + " " + e.getNombre());

			}

			request.getRequestDispatcher("editoriales/listarEditorial.jsp").forward(request, response);
			;
		} catch (Exception e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
		}

	}
	
	protected void guardar (HttpServletRequest request, HttpServletResponse response) {
		try {
			Editorial e = new Editorial();
			e.setCodigo(request.getParameter("codigo"));
			e.setNombre(request.getParameter("nombre"));
			e.setContacto(request.getParameter("contacto"));
			e.setTelefono(request.getParameter("telefono"));
			if(model.nuevoEditorial(e)>0) {
				request.getSession().setAttribute("exito", "Agregado con exito");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}
		}catch (IOException | SQLException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	protected void obtener (HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			request.setAttribute("editorial",model.obtenerEditorial(id));
			request.getRequestDispatcher("/editoriales/ModificarEditorial.jsp").forward(request, response);
		}catch (ServletException | IOException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	protected void modificar (HttpServletRequest request, HttpServletResponse response) {
		try {
			Editorial e = new Editorial();
			e.setIdEditorial(Integer.parseInt(request.getParameter("id")));
			e.setCodigo(request.getParameter("codigo"));
			e.setNombre(request.getParameter("nombre"));
			e.setContacto(request.getParameter("contacto"));
			e.setTelefono(request.getParameter("telefono"));
			System.out.println("-> "+request.getParameter("id"));
			if(model.modificarEditorial(e)>0) {
				request.getSession().setAttribute("exito", "Agregado con exito");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}			
		}catch (Exception e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	protected void eliminar (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if(model.eliminarEditorial(id)>0) {
				request.getSession().setAttribute("exito", "Agregado con exito");
				response.sendRedirect(request.getContextPath()+"/EditorialController?op=listar");
			}
		}catch (IOException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
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
