<%@page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFICAR</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
	<h3>Modificar Editorial</h3>
	<%
	 Editorial e = (Editorial)request.getAttribute("editorial");
	 String url = "http://localhost:8080/Proyecto_webGB/";
	%>
	<a href="<%=url%>EditorialController?=listar">Volver</a>
	<form action="<%=url%>EditorialController" method="post">
		<div  class="mb-3">
			<input type="hidden" name = "op" value = "modificar">
			<input type="hidden" name = "id" value = "<%=e.getIdEditorial()%>">
			<label for="codigo" class="form-lable">Código: </label> 
			<input type="text" name="codigo" value = "<%=e.getCodigo()%>" class="form-control"><br>
			<label for="nombre" class="form-lable">Nombre: </label>
			<input type="text"name="nombre" value = "<%=e.getNombre()%>" class="form-control"><br>
			<label for="contacto"class="form-lable">Contacto: </label> 
			<input type="email" name="contacto" value = "<%=e.getContacto()%>" class="form-control"><br> 
			<label for="telefono" class="form-lable">Teléfono: </label> 
			<input type="text" name="telefono" value = "<%=e.getTelefono()%>" class="form-control"><br>
		</div>
		<button type="submit" name=guardar class="btn btn-primary">Modificar</button>
	</form>
</body>
</html>