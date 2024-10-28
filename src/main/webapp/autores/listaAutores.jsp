<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.unu.proyectoWebGB.beans.Autor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autores</title>
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
	<a href="<%=url%>AutoresController?op=nuevo">Nuevo
		Autor click</a>
	<table class="table table-borderless" id="tabla">
		<thead>
			<tr>
				<!-- Esto significa la fila de la tabla -->
				<th>Codigo del Autor</th>
				<th>Nombre del Autor</th>
				<th>Nacionalidad</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
			if (listaAutores != null) {
				for (Autor autor : listaAutores) {
			%>
			<tr>
				<td><%=autor.getIdAutor()%></td>
				<td><%=autor.getNombre()%></td>
				<td><%=autor.getNacinalidad()%></td>
				<td><a href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Modificar</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td>No hay datos</td>
				<td></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>