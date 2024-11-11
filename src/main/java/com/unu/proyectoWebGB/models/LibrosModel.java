package com.unu.proyectoWebGB.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectoWebGB.beans.Libro;

public class LibrosModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<Libro> listarLibros() throws SQLException{
		try {
			List<Libro> lista = new ArrayList<>();
			String sql = "call sp_listarLibros()";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Libro l = new Libro();
				l.setIdL(rs.getInt("idLibro"));
				l.setCod(rs.getString("codLibro"));
				l.setNombre(rs.getString("Nombre_Libros"));
				l.setIdA(rs.getString("Nombre_Autor"));
				l.setIdE(rs.getString("Nombre_Editorial"));
				l.setIdG(rs.getString("Nombre_Genero"));
				l.setExistencias(rs.getInt("existencias"));
				l.setDescripcion(rs.getString("descripcion"));
				lista.add(l);
			}
			this.cerrarConexion();
			return lista;
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			this.cerrarConexion();
			return null;
		}
	}
	
	public int obtenerIdAutor (String nombre) throws SQLException{
		try {
			String sql = "call sp_obtenerAxnombre(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, nombre);
			rs = cs.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("idautores");
				this.cerrarConexion();
				return id;
			}
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			return 0;
		}
		return 0;
	}
	
	public int obtenerIdGenero (String nombre) throws SQLException{
		try {
			String sql = "call sp_obtenerGxnombre(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, nombre);
			rs = cs.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("idGenero");
				this.cerrarConexion();
				return id;
			}
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			return 0;
		}
		return 0;
	}
	
	public int obtenerIdEditor (String nombre) throws SQLException{
		try {
			String sql = "call sp_obtenerExnombre(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, nombre);
			rs = cs.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("idEditorial");
				this.cerrarConexion();
				return id;
			}
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			return 0;
		}
		return 0;
	}
	
	public int agregarLibroAux (Libro libro) throws SQLException{
		try {
			String sql = "call sp_insertarLibros(?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, libro.getCod());
			cs.setString(2, libro.getNombre());
			cs.setInt(3, libro.getExistencias());
			cs.setInt(4, obtenerIdAutor(libro.getIdA()));
			cs.setInt(5, obtenerIdEditor(libro.getIdE()));
			cs.setInt(6, obtenerIdGenero(libro.getIdG()));
			cs.setString(7, libro.getDescripcion());
			int filas = cs.executeUpdate();
			this.cerrarConexion();
			return filas;
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int agregarLibroA (Libro libro, int idA, int idE, int idG) throws SQLException{
		try {
			String sql = "call sp_insertarLibros(?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, libro.getCod());
			cs.setString(2, libro.getNombre());
			cs.setInt(3, libro.getExistencias());
			cs.setInt(4, idA);
			cs.setInt(5, idE);
			cs.setInt(6, idG);
			cs.setString(7, libro.getDescripcion());
			int filas = cs.executeUpdate();
			this.cerrarConexion();
			return filas;
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Libro obtenerLibro (int id) {
		try {
			String sql = "call sp_obtenerLibro(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			while (rs.next()) {
				Libro l = new Libro();
				l.setIdL(rs.getInt("idLibro"));
				l.setCod(rs.getString("codLibro"));
				l.setNombre(rs.getString("Nombre_Libros"));
				l.setIdA(rs.getString("Nombre_Autor"));
				l.setIdE(rs.getString("Nombre_Editorial"));
				l.setIdG(rs.getString("Nombre_Genero"));
				l.setExistencias(rs.getInt("existencias"));
				l.setDescripcion(rs.getString("descripcion"));
				return l;
			}
			this.cerrarConexion();
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);;
			this.cerrarConexion();
			return null;
		}
		return null;
	}
	
	public int modificarLibro (Libro libro, int idA, int idE, int idG) {
		try {
			String sql = "call sp_modificarLibro(?,?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, libro.getIdL());
			cs.setString(2, libro.getCod());
			cs.setString(3, libro.getNombre());
			cs.setInt(4, libro.getExistencias());
			cs.setInt(5, idA);
			cs.setInt(6, idE);
			cs.setInt(7, idG);
			cs.setString(8, libro.getDescripcion());
			int filas = cs.executeUpdate();
			this.cerrarConexion();
			return filas;
		}catch (SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminar(int id) {
		try {
			String sql = "call sp_eliminarLibro(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			int fila = cs.executeUpdate();
			this.cerrarConexion();
			return fila;
		}catch(SQLException e) {
			Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}

}
