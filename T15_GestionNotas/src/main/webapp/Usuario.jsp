<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="Image/Insignia-SRC.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Estudiante.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">NotasGO</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="Estudiante.jsp">Estudiante</a></li>
					<li class="nav-item"><a class="nav-link" href="Usuario.jsp">Usuario</a></li>
					<li class="nav-item"><a class="nav-link" href="Curso.jsp">Curso
							2</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h1 class="title">Registro de Usuario</h1>
	<br>
		<div class="form">
		<form>
			<label for="exampleInputEmail1" class="form-label">Nombres:</label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp"> <label
				for="exampleInputPassword1" class="form-label">Apellidos:</label> <input
				class="form-control" id="exampleInputPassword1"> <label
				for="exampleInputPassword1" class="form-label">Tipo de
				Documento:</label> <input class="form-control" id="exampleInputPassword1">
			<label for="exampleInputPassword1" class="form-label">Número
				de Documento:</label> <input class="form-control" id="exampleInputPassword1">
			<label for="exampleInputPassword1" class="form-label">Tipo de Usuario:</label>
			<input class="form-control" id="exampleInputPassword1"> <label
				for="exampleInputPassword1" class="form-label">Teléfono:</label> <input
				class="form-control" id="exampleInputPassword1"> <label
				for="exampleInputPassword1" class="form-label">Email:</label> <input
				class="form-control" id="exampleInputPassword1">
		</form>
	</div>
	<br>
	<div class="button">
		<button type="submit" class="btn btn-primary">Agregar</button>
		<button type="button" class="btn btn-danger">Cancelar</button>
	</div>

	<br>
	<br>
	<h1 class="title">LISTADO DE USUARIOS</h1>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido</th>
				<th scope="col">Tipo de Usuario</th>
				<th scope="col">Email</th>
				<th scope="col">Numero de Documento</th>
				<th scope="col">Numero de Celular</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Maria</td>
				<td>Paola</td>
				<td>Carla</td>
				<td>Otto</td>
				<td>@mdo</td>
				<td>Otto</td>

			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Jacob</td>
				<td>Thornton</td>
				<td>@fat</td>
				<td>Thornton</td>
				<td>@fat</td>
				<td>Thornton</td>

			</tr>
			<tr>
				<th scope="row">3</th>
				<td colspan="2">Larry the Bird</td>
				<td>@twitter</td>
				<td colspan="2">Larry the Bird</td>
				<td colspan="2">Larry the Bird</td>
			</tr>
		</tbody>
	</table>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">
	</script>
</body>
</html>
