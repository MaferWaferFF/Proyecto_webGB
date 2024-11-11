<%@page import="com.unu.proyectoWebGB.beans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catálogo de Libros</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</head>
<body>
	<% String url = "http://localhost:8080/Proyecto_webGB/";%>
	<h2 class="text-center my-3">Catálogo de Libros</h2><br>
	<div class="container">
		<div class="d-grid gap-2 d-md-flex justify-content-md-end" >
			<button type = "button" onclick = "location.href='<%=url%>LibrosController?op=nuevo'" class="btn btn-primary">Nuevo Libro</button><br>
		</div>	
	</div>
	<br>
	<div class="container-fluid">
	<table class="table table-bordered" >
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nombre Libro</th>
				<th>Nombre Autor</th>
				<th>Nombre Editorial</th>
				<th>Género</th>
				<th>Existencias</th>
				<th>Descripción</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Libro> lista = (List<Libro>)request.getAttribute("listaLibros");
				if(lista != null){
					for(Libro l: lista){
			%>
				<tr>
					<td><%=l.getCod()%></td>
					<td><%=l.getNombre()%></td>
					<td><%=l.getIdA()%></td>
					<td><%=l.getIdE()%></td>
					<td><%=l.getIdG()%></td>
					<td><%=l.getExistencias()%></td>
					<td><%=l.getDescripcion()%></td>
					<td>
					 <button onclick="location.href='<%=url%>LibrosController?op=obtener&id=<%=l.getIdL()%>'" class="btn btn-success">Modificar</button>
					 <button onclick="location.href='<%=url%>LibrosController?op=eliminar&id=<%=l.getIdL()%>'" class="btn btn-warning">Eliminar</button>
					</td>	
				</tr>
			<%			
					}
				}else{
			%>
				<tr>
					<td>NO HAY DATOS</td>
					<td>NO HAY DATOS</td>
					<td>NO HAY DATOS</td>
					<td>NO HAY DATOS</td>
					<td>NO HAY DATOS</td>
					<td>NO HAY DATOS</td>
				</tr>
			<%	
				}
			%>
		</tbody>
	</table>
	</div>	
</body>
</html>