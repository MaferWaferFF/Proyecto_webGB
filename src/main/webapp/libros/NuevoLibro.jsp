<%@page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@page import="com.unu.proyectoWebGB.beans.Genero"%>
<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NUEVO LIBRO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
	<%
	String url = "http://localhost:8080/Proyecto_webGB/";
	List<Autor> listaA = (List<Autor>)request.getAttribute("listaAutores");
	List<Genero> listaG = (List<Genero>)request.getAttribute("listaGenero");
	List<Editorial> listaE = (List<Editorial>)request.getAttribute("listaEditorial");
	%>
	<h2 class="text-center my-3">Nuevo Libro</h2>
	<div class="container">
		<button class="btn btn-secondary" onclick="location.href='<%=url%>LibrosController?op=listar'">Volver</button>
	</div>
	<br>
	<div class = "container">
	<form action="<%=url%>LibrosController" method="post">
		<input  type="hidden" name="op" value="agregar">
		<label for = "cod">Cod Libro: </label>
		<input class="form-control" type="text" name = "cod" placeholder = "Ingrese el código" ><br>
		<label for = "nombre">Nombre Libro: </label>
		<input class="form-control" type="text" name = "nombre" placeholder = "Ingrese el nombre"><br>
		<label for = "existencias">Existencias: </label>
		<input class="form-control" type="text" name = "existencias" placeholder = "Ingrese las existencias"><br>
		<label for = "desc">Descripción: </label>
		<input class="form-control" type="text" name = "desc" placeholder = "Ingrese el descripción"><br>
		<label>Seleccion Autor: </label><br>
		<select id="selectA" name="selectA" class="form-control">
			<%
			if(listaA != null){
				for(Autor a: listaA){
			%>
				<option value="<%=a.getIdAutor() %>"><%=a.getNombre() %></option>
			<%
				}
			}else{
			%>
				<option>La lista esta vacia</option>
			<%
			}
			%>
		</select>
		<br>	
		<label>Seleccion Género: </label><br>
		<select id="selectG" name="selectG" class="form-control">
			<%
			if(listaG != null){
				for(Genero g: listaG){
			%>
				<option value="<%=g.getId() %>"><%=g.getNombre()%></option>
			<%
				}
			}else{
			%>
				<option>La lista esta vacia</option>
			<%
			}
			%>
		</select>
		<br>	
		<label>Seleccion Editorial: </label><br>
		<select id="selectE" name="selectE" class="form-control">
			<%
			if(listaG != null){
				for(Editorial e: listaE){
			%>
				<option value="<%=e.getIdEditorial()%>"><%=e.getNombre()%></option>
			<%
				}
			}else{
			%>
				<option>La lista esta vacia</option>
			<%
			}
			%>
		</select>
		<br>
		<button type="submit" class="form-control btn btn-primary" id="agregar" name="agregar" value = "agregar">Guardar</button>
	</form>
	</div>
</body>
</html>