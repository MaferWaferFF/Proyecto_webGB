package com.unu.proyectoWebGB.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/bibliotecapoo";
	private String user = "Mareah";
	private String pass = "Mibb2205@fer";
	protected Connection connection;
	
	public void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			if(connection != null) {
				System.out.println("Conexion OK");
			}
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void cerrarConexion () {
		try {
			if(connection != null && connection.isClosed()) {
				connection.close();
				System.out.println("Conexion cerrada");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
