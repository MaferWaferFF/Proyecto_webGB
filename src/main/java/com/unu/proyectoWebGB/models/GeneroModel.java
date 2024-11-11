package com.unu.proyectoWebGB.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.unu.proyectoWebGB.beans.*;

public class GeneroModel extends Conexion{

	CallableStatement cs;
	ResultSet rs;
	
	public List<Genero> listarGeneros () throws SQLException{
		try {
			List<Genero> lista = new ArrayList<Genero>();
			String sql = "call sp_listaGenero()";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Genero g = new Genero();
				g.setId(rs.getInt("idGenero"));
				g.setNombre(rs.getString("nombre"));
				g.setdescripcion(rs.getString("descripcion"));
				lista.add(g);
			}
			this.cerrarConexion();
			return lista;
		}catch (SQLException e) {
			Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return null;
		}
	}
	
	public int agregarGenero(Genero gen) {
		try {
			String sql = "call sp_insertarGenero(?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, gen.getNombre());
			cs.setString(2, gen.getdescripcion());
			int f = cs.executeUpdate();
			this.cerrarConexion();
			return f;
		}catch (SQLException e) {
			Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public Genero obtenerGenero (int id) {
		try {
			String sql = "call sp_obtenerGenero(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if (rs.next()) {
				Genero dg = new Genero();
				dg.setId(rs.getInt("idGenero"));
				dg.setNombre(rs.getString("nombre"));				
				dg.setdescripcion(rs.getString("descripcion"));
				return dg;
			}
			this.cerrarConexion();
		}catch (Exception e) {
			Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return null;
		}
		return null;
	}
	
	public int modificarGenero (Genero g) {
		try {
			String sql = "call  sp_modificarGenero(?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, g.getId());
			cs.setString(2, g.getNombre());
			cs.setString(3, g.getdescripcion());
			int f = cs.executeUpdate();
			this.cerrarConexion();
			return f;
		}catch (SQLException e) {
			Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	public int eliminarGenero (int id) {
		try {
			String sql = "call sp_eliminarGenero(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			int f = cs.executeUpdate();
			this.cerrarConexion();
			return f;
		}catch (Exception e) {
			Logger.getLogger(GeneroModel.class.getName()).log(Level.SEVERE,null,e);
			this.cerrarConexion();
			return 0;
		}
	}

}
