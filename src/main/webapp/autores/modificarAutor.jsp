<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Autor</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
	<% String url = "http://localhost:8080/Proyecto_webGB/";
		Autor a;
		//System.out.println("wazzz-> "+a.getIdAutor());
		if(request.getAttribute("autor") == null){//si en el atributo almacenado de request(pedido) no encuentra ningun dato de los autores  
			a = new Autor();
		}else{
			a = (Autor)request.getAttribute("autor");
		}
	%>
	<h2>Modifica Autor</h2>
	<form role= "form" action="<%=url%>AutoresController" method= "POST"> 
		<input type="hidden" name="op" value= "modificar"/><!-- Para almacenar informacion que el usuario no puede ver directamente -->
		<input type= "hidden" name= "id" id= "id" value= "<%=a.getIdAutor()%>"/>
			<label for = "nombre">Nombre del Autor: </label>
			<input type="text" name = "nombre" id="nombre" value="<%=a.getNombre()%>"/><br>
			<label for = "nacionalidad">Nacionalidad del Autor: </label>
			<input type="text" name= "nacio" value= "<%=a.getNacinalidad()%>"/><br>
		<input type="submit" value= "Guardar" name= "guardar"><br><br>
		<a href="<%=url%>AutoresController?op=listar">Volver</a>
	</form>
</body>
</html>