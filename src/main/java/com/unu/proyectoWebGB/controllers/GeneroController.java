package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Editorial;
import com.unu.proyectoWebGB.beans.Genero;
import com.unu.proyectoWebGB.models.GeneroModel;

public class GeneroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GeneroModel model = new GeneroModel();
       
    public GeneroController() {
        super();
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	if (request.getParameter("op")==null) {
    		listar(request, response);
    		return;
    	}
    	
    	String opciones = request.getParameter("op");
    	switch(opciones) {
    	  case "listar":
    		  listar(request, response);
    		  break;
    	  case "nuevo":
    		  request.getRequestDispatcher("/genero/nuevoGenero.jsp").forward(request, response);
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
    
    protected void listar (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		request.setAttribute("listaGenero", model.listarGeneros());
    		
    		Iterator<Genero> i = model.listarGeneros().iterator();
    		while(i.hasNext()) {
    			Genero gen = i.next();
    			System.out.println(gen.getNombre());
    		}
    		request.getRequestDispatcher("/genero/listarGenero.jsp").forward(request, response);
    	}catch (Exception e) {
    		Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
    protected void agregar (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Genero g = new Genero();
    		g.setNombre(request.getParameter("nombre"));
    		g.setdescripcion(request.getParameter("descri"));
    		if (model.agregarGenero(g)>0) {
    			response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
    		}
    	}catch (Exception e) {
    		Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
    protected void obtener (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		System.out.println(id);
    		request.setAttribute("genero", model.obtenerGenero(id));
    		request.getRequestDispatcher("/genero/modificarGenero.jsp").forward(request, response);
    	}catch (Exception e) {
    		Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
    protected void modificar (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Genero g = new Genero();
    		g.setId(Integer.parseInt(request.getParameter("id")));
    		g.setNombre(request.getParameter("nombre"));
    		g.setdescripcion(request.getParameter("descri"));
    		if (model.modificarGenero(g)>0) {
    			response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
    		}
    	}catch (Exception e) {
    		Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
    protected void eliminar (HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int id = Integer.parseInt(request.getParameter("id"));
    		System.out.println(id);
    		if (model.eliminarGenero(id)>0) {
    			response.sendRedirect(request.getContextPath()+"/GeneroController?op=listar");
    		}
    	}catch (Exception e) {
    		Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
