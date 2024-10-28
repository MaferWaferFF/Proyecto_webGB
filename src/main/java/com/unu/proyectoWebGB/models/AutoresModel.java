package com.unu.proyectoWebGB.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import com.unu.proyectoWebGB.beans.*;

public class AutoresModel extends Conexion{
	CallableStatement cs;
	ResultSet rs;

	/*public List<Autor> listarAutores() {

		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor(1, "Garcia Marquez", "Colombiana"));
		autores.add(new Autor(2, "Borgues", "Argentino"));
		autores.add(new Autor(3, "Allende", "Chileno"));

		return autores;//hay inquietas hay like
	}*/
	
	public List<Autor> listaAutores() throws SQLException{
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "call sp_listarAutores";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Autor a = new Autor();
				a.setIdAutor(rs.getInt("idautores"));
				a.setNombre(rs.getString("nombre_autor"));
				a.setNacinalidad(rs.getString("nacionalidad"));
				lista.add(a);
			}
			this.cerrarConexion();
			return lista;
		}catch (SQLException e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return null;
		}
		
	}
	
	public int agregarAutor (Autor autor) throws SQLException {
		int filasAfectadas = 0;
		try {
			String sql = "CALL sp_InsetarAutor(?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, autor.getNombre());
			cs.setString(2, autor.getNacinalidad());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
		}catch (SQLException e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
		return filasAfectadas;
	}
	
	public Autor obtenerAutor (int id) throws SQLException{			
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if (rs.next()) {
				Autor a = new Autor();
				a.setNombre(rs.getString("nombre_autor"));
				a.setNacinalidad(rs.getString("nacionalidad"));
				this.cerrarConexion();
				return a;
			}
		}catch (SQLException e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return null;
		}
		return null;
	}
	
	public int modificarAutor (Autor autor) throws SQLException {
		int filas = 0;
		try {
			String sql = "CALL sp_modificarAutor(?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1,autor.getIdAutor());
			cs.setString(2, autor.getNombre());
			cs.setString(3, autor.getNacinalidad());
			filas = cs.executeUpdate();
			this.cerrarConexion();
			return filas;
		}catch (SQLException e) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, e);;
			this.cerrarConexion();
			return 0;
		}
	}

}
