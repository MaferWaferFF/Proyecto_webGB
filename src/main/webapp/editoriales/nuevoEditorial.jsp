<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NUEVO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
</head>
<body>
	<%
	String url = "http://localhost:8080/Proyecto_webGB/";
	%>
	<h3>Nuevo Editorial</h3>
	<br>
	<a href="<%=url%>EditorialController?=listar">Volver</a>
	<form action="<%=url%>EditorialController" method="POST">
		<div class="mb-3">
			<input type="hidden" name="op" value="guardar"> 
			<label for="codigo" class="form-lable">Código: </label> 
			<input type="text" name="codigo"placeholder="Ingrese el código" class="form-control"><br>
			<label for="nombre" class="form-lable">Nombre: </label>
			<input type="text"name="nombre" placeholder="Ingrese el nombre" class="form-control"><br>
			<label for="contacto"class="form-lable">Contacto: </label> 
			<input type="email" name="contacto" placeholder="example@gmail.com" class="form-control"><br> 
			<label for="telefono" class="form-lable">Teléfono: </label> 
			<input type="text" name="telefono" placeholder="Ingrese el telefono" class="form-control"><br>
		</div>
		<button type="submit" name=guardar class="btn btn-primary">Guardar</button>
	</form>
</body>
</html>