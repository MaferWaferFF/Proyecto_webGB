<%@page import="com.unu.proyectoWebGB.beans.Libro"%>
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
	Libro l = (Libro)request.getAttribute("libros");
	List<Autor> listaA = (List<Autor>)request.getAttribute("listaAutores");
	List<Genero> listaG = (List<Genero>)request.getAttribute("listaGenero");
	List<Editorial> listaE = (List<Editorial>)request.getAttribute("listaEditorial");
	%>
	<h2 class="text-center my-3">Modificar Libro</h2>
	<div class="container">
		<button class="btn btn-secondary" onclick="location.href='<%=url%>LibrosController?op=listar'">Volver</button>
	</div>
	<br>
	<div class = "container">
	<form action="<%=url%>LibrosController" method="post">
		<input  type="hidden" name="op" value="modificar">
		<input type="hidden" name = "id" value="<%=l.getIdL()%>">
		<label for = "cod">Cod Libro: </label>
		<input class="form-control" type="text" name = "cod" value="<%=l.getCod()%>"><br>
		<label for = "nombre">Nombre Libro: </label>
		<input class="form-control" type="text" name = "nombre" value="<%=l.getNombre()%>"><br>
		<label for = "existencias">Existencias: </label>
		<input class="form-control" type="text" name = "existencias" value="<%=l.getExistencias()%>"><br>
		<label for = "desc">Descripción: </label>
		<input class="form-control" type="text" name = "desc" value="<%=l.getDescripcion()%>"><br>
		<label for="mAutor">Autor : </label>
		<input type="text" name = "mAutor" value = "<%=l.getIdA()%>"><br>
		<label>Modifique Autor: </label><br>
		<select id="selectA" name="selectA" class="form-control">
			<option value = "ninguno">Seleccione </option>
			<%
			if(listaA != null){
				for(Autor a: listaA){
					if(!a.getNombre().equals(l.getIdA())){
			%>
				 	<option value="<%=a.getIdAutor() %>"><%=a.getNombre() %></option>
			<%
					}
				}
			}else{
			%>
				<option>La lista esta vacia</option>
			<%
			}
			%>
		</select>
		<br>
		<label for="mGenero">Género: </label>
		<input type="text" name = "mGenero" value = "<%=l.getIdG()%>"><br>	
		<label>Modifique Género: </label><br>
		<select id="selectG" name="selectG" class="form-control">
			<option value = "ninguno">Seleccione </option>
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
		<label for="mEditorial">Editorial: </label>
		<input type="text" name = "mEditorial" value = "<%=l.getIdE()%>"><br>	
		<label>Modifique Editorial: </label><br>
		<select id="selectE" name="selectE" class="form-control">
			<option value = "ninguno">Seleccione </option>
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
		<button type="submit" class="form-control btn btn-primary" id="modificar" name="modificar" value = "modificar">Modificar</button>
	</form>
	</div>
</body>
</html>