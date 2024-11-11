<%@page import="com.unu.proyectoWebGB.beans.Editorial"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDITORIALES</title>
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
	<a href="<%=url%>EditorialController?op=nuevo">Nueva Editorial</a>
	<br>
	<table class="table table-striped" id="tabla">
		<thead>
			<tr>
				<th>ID</th>
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Contacto</th>
				<th>Telefono</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Editorial> lista = (List<Editorial>)request.getAttribute("listarEditorial");
				if (lista != null){
					for(Editorial ed: lista){
			%>
			<tr>
				<td><%=ed.getIdEditorial() %></td>
				<td><%=ed.getCodigo()%></td>
				<td><%=ed.getNombre()%></td>
				<td><%=ed.getContacto()%></td>
				<td><%=ed.getTelefono()%></td>
				<td>
				<button class="btn btn-outline-primary" onclick = "location.href='<%=url%>EditorialController?op=obtener&id=<%=ed.getIdEditorial() %>'">Modificar</button>
				<button class="btn btn-outline-danger" onclick= "location.href='<%=url%>EditorialController?op=eliminar&id=<%=ed.getIdEditorial()%>'">Eliminar</button>
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
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>