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

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.beans.Libro;
import com.unu.proyectoWebGB.models.AutoresModel;
import com.unu.proyectoWebGB.models.EditorialModel;
import com.unu.proyectoWebGB.models.GeneroModel;
import com.unu.proyectoWebGB.models.LibrosModel;

public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    LibrosModel model = new LibrosModel();
	AutoresModel modelA = new AutoresModel();
	GeneroModel modelG = new GeneroModel();
	EditorialModel modelE = new EditorialModel();
    
    public LibrosController() {
        super();
       
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	if (request.getParameter("op")==null) {
    		listar(request, response);
    		return;
    	}
    	
    	String operaciones = request.getParameter("op");
    	System.out.println(operaciones);
    	
    	switch (operaciones) {
		case "listar":
			listar(request, response);
			break;
		case "nuevo":
			nuevo(request, response);
			break;
		case "agregar":
			agregar(request, response);
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
    
    protected void listar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		request.setAttribute("listaLibros", model.listarLibros());   		
    		request.getRequestDispatcher("/libros/VistaLibros.jsp").forward(request, response);
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
		}
    }
    
    protected void nuevo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		request.setAttribute("listaAutores", modelA.listaAutores());
    		request.setAttribute("listaGenero", modelG.listarGeneros());
    		request.setAttribute("listaEditorial", modelE.listarEditoriales());
			request.getRequestDispatcher("/libros/NuevoLibro.jsp").forward(request, response);    		    		
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
		}
    }
   
    protected void agregar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Libro l = new Libro();
    		l.setCod(request.getParameter("cod"));
    		l.setNombre(request.getParameter("nombre"));
    		l.setExistencias(Integer.parseInt(request.getParameter("existencias")));
    		l.setDescripcion(request.getParameter("desc"));
    		int idA = Integer.parseInt(request.getParameter("selectA"));
    		int idG = Integer.parseInt(request.getParameter("selectG"));
    		int idE = Integer.parseInt(request.getParameter("selectE"));
    		if (model.agregarLibroA(l, idA, idE, idG)>0) {
    			response.sendRedirect(request.getContextPath()+"/LibrosController?op=listar");
    		}
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
		}
    }
    
    protected void obtener (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		request.setAttribute("listaAutores", modelA.listaAutores());
    		request.setAttribute("listaGenero", modelG.listarGeneros());
    		request.setAttribute("listaEditorial", modelE.listarEditoriales());
    		request.setAttribute("libros", model.obtenerLibro(id)); 
    		request.getRequestDispatcher("/libros/modificarLibro.jsp").forward(request, response);
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
		}
    }
    
    protected void modificar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int idA=0,idG=0,idE=0;
    		Libro l = new Libro();
    		int id = Integer.parseInt(request.getParameter("id"));
    		l.setIdL(Integer.parseInt(request.getParameter("id")));
    		l.setCod(request.getParameter("cod"));
    		l.setNombre(request.getParameter("nombre"));
    		l.setExistencias(Integer.parseInt(request.getParameter("existencias")));
    		l.setDescripcion(request.getParameter("desc"));
    		if (!request.getParameter("selectA").equals("ninguno")) {
    			idA = Integer.parseInt(request.getParameter("selectA"));
    		}else {
    			idA = (model.obtenerIdAutor(request.getParameter("mAutor"))); 
    		}
    		
    		if (!request.getParameter("selectG").equals("ninguno")) {
    			idG = Integer.parseInt(request.getParameter("selectG"));
    		}else {
    			idG = (model.obtenerIdGenero(request.getParameter("mGenero"))); 
    		}
    		
    		if (!request.getParameter("selectE").equals("ninguno")) {
    			idE = Integer.parseInt(request.getParameter("selectE"));
    		}else {
    			idE = (model.obtenerIdEditor(request.getParameter("mEditorial"))); 
    		}

    		if (model.modificarLibro(l, idA, idE, idG)>0) {
    			response.sendRedirect(request.getContextPath()+"/LibrosController?op=listar");
    		}
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
    protected void eliminar (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		if (model.eliminar(id)>0) {
    			response.sendRedirect(request.getContextPath()+"/LibrosController?=listar");
    		}
    		
    	}catch (Exception e) {
    		Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
