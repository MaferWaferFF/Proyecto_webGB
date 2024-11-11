<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo_Select</title>
</head>
<body>
	<form action="">
		<label for = "select">Seleccion una opción</label>
		<select id = "select">
			<option value = "opcion1">opcion1</option>
			<option value = "opcion2">opcion2</option>
			<option value = "opcion3">opcion3</option>
		</select><br>
		<button onclick= "mostrarMensaje()">Mostran Mensaje</button>
	</form>
	<div id = "resultado"></div>
	<script type="text/javascript">
		function mostrarMensaje (){
			const select = document.getElementById("select");//es para seleccionar el componente con el id
			const valorSelect = select.value;//interaccion directa con los valores del componente
			//alert ("Has seleccionado: "+valorSelect);
			document.getElementById("resultado").innerText = "Has selecionado";
			return select;
		}
	</script>
</body>
</html>