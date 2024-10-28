<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guardar Autores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

</head>
<body>
	<% String url = "http://localhost:8080/Proyecto_webGB/"; %>
	<a href="<%=url%>AutoresController?=listar">Volver</a>
	
	<h2>NUEVO AUTOR</h2>
	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type= "hidden" name= "op" value= "agregar" />
		<label for = "nombre">Nombre del Autor: </label>
		<input type="text"  id= "nombre" name= "nombre" placeholder= "Nombre del Autor"/><br>
		<label for= "nacionalidad">Nacionalidad: </label>
		<input type= "text" id= "nacio" name= "nacio" placeholder="Ingrese nacionalidad"/><br>
		<input type="submit" name = "guardar" value="guardar">
	</form>
</body>
</html>