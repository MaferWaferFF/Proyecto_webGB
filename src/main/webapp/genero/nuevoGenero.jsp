<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
	<%
	String url = "http://localhost:8080/Proyecto_webGB/";
	%>
	<a href="<%=url%>GeneroController?op=listar">Volver</a>
	<h2>NUEVO GENEROS</h2>
	<form action="<%=url%>GeneroController" method="post">
		<input type="hidden" name=op value=agregar >
		<label for= nombre>Nombre</label>
		<input type="text" name="nombre" placeholder="Ingrese nombre"><br>
		<label for= descri>Descripcion</label>
		<input type="text" name="descri" placeholder="Ingrese la descripcion"><br>
		<button name="guardar">Guardar</button>
	</form>
</body>
</html>