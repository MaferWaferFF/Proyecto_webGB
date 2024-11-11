<%@page import="com.unu.proyectoWebGB.beans.Genero"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GENERO</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<body>
	<%
	String url = "http://localhost:8080/Proyecto_webGB/";
	%>
	<a href="<%=url%>GeneroController?op=nuevo">Nuevo Genero click</a><br>
	<h2>CATALOGO DE GENEROS</h2>
	<table class="table table-striped-columns">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Genero> g = (List<Genero>) request.getAttribute("listaGenero");
			if (g != null) {
				for (Genero gen : g) {
			%>
			<tr>
				<td><%=gen.getId()%></td>
				<td><%=gen.getNombre()%></td>
				<td><%=gen.getdescripcion()%></td>
				<td>
				<button onclick = "location.href='<%=url%>GeneroController?op=obtener&id=<%=gen.getId()%>'">Modificar</button>
				<button onclick = "location.href='<%=url%>GeneroController?op=eliminar&id=<%=gen.getId()%>'">Eliminar</button>
				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td>NO HAY DATOS</td>
				<td>NO HAY DATOS</td>
				<td>NO HAY DATOS</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>