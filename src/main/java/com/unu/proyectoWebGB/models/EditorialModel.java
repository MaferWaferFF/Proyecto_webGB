package com.unu.proyectoWebGB.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.jasper.tagplugins.jstl.core.Redirect;

import com.unu.proyectoWebGB.beans.*;

public class EditorialModel extends Conexion {

	CallableStatement cs;
	ResultSet rs;

	public List<Editorial> listarEditoriales() {
		try {
			List<Editorial> lista = new ArrayList<Editorial>();
			this.abrirConexion();
			String sql = "call sp_listarEditores";
			cs = connection.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial e = new Editorial();
				e.setIdEditorial(rs.getInt("idEditorial"));
				e.setCodigo(rs.getString("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setContacto(rs.getString("contacto"));
				e.setTelefono(rs.getString("telefono"));
				lista.add(e);
			}
			this.cerrarConexion();
			return lista;
		} catch (SQLException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return null;
		}
	}

	public int nuevoEditorial(Editorial edi) throws SQLException {
		try {
			String sql = "call sp_insertarEditores(?,?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setString(1, edi.getCodigo());
			cs.setString(2, edi.getNombre());
			cs.setString(3, edi.getContacto());
			cs.setString(4, edi.getTelefono());
			int filaAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filaAfectadas;
		} catch (SQLException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
	}

	public Editorial obtenerEditorial(int id) {
		try {
			String sql = "call sp_obtenerEditorial(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			if (rs.next()){
				Editorial e = new Editorial();
				e.setIdEditorial(rs.getInt("idEditorial"));
				e.setCodigo(rs.getString("codigo"));
				e.setNombre(rs.getString("nombre"));
				e.setContacto(rs.getString("contacto"));
				e.setTelefono(rs.getString("telefono"));
				return e;
			}
			this.cerrarConexion();
		} catch (SQLException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return null;		
		}
		return null;
	}
	
	public int modificarEditorial (Editorial e) {
		try {
			String sql = "call sp_modificarEditorial(?,?,?,?,?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			System.out.println("->| "+e.getIdEditorial());
			cs.setInt(1, e.getIdEditorial());
			cs.setString(2, e.getCodigo());
			cs.setString(3, e.getNombre());
			cs.setString(4, e.getContacto());
			cs.setString(5, e.getTelefono());
			int f = cs.executeUpdate();
			this.cerrarConexion();
			System.out.print(f);
			return f;
		}catch (SQLException ex) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, ex);
			this.cerrarConexion();
			return 0;
		}

	}
	
	public int eliminarEditorial (int id)  {
		try {
			String sql = "call sp_eliminarEditorial(?)";
			this.abrirConexion();
			cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			int f = cs.executeUpdate();
			this.cerrarConexion();
			return f;
		} catch (SQLException e) {
			Logger.getLogger(EditorialModel.class.getName()).log(Level.SEVERE, null, e);
			this.cerrarConexion();
			return 0;
		}
	}
	
	
}
