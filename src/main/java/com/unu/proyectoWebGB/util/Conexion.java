package com.unu.proyectoWebGB.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	String url = "jdbc:mysql://localhost:3306/bibliotecapoo";
	String pass = "1234";
	String user = "root";
	Connection con;

	public void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerraConexion () {
		try {
			if (con != null && con.isClosed()) {
				con.close();
				System.out.println("Conexion Cerrada");
			}
			
		}catch (SQLException e) {
			
		}
	}

}
