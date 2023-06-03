<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>I.E.P. Santa Rita de Cassia</title>
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
	<h1 class="title">LISTADO DE ALUMNA</h1>
	<br>
	<div class="card">
		<div class="card-header">Criterios de busqueda</div>
		<div class="card-body">
			<form method="post" action="#">
				<div class="mb-3 row">
					<div class="col-sm-4">
						<input type="text" class="form-control" id="last_name"
							name="last_name" placeholder="Ingrese apellido">
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="names" name="names"
							placeholder="Ingrese nombre">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary mb-3" id="btnBuscar"
							name="btnBuscar">Buscar</button>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary mb-3" id="btnNuevo"
							name="btnNuevo">Nuevo</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="card" id="divResultado">
		<div class="card-header">Resultado</div>
		<div class="card-body">
			<a href="#" class="btn btn-primary" id="btnDescargar">Descargar
				Lista</a>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombres</th>
						<th>Apellidos</th>
						<th>Tipo de documento</th>
						<th>N° de documento</th>
						<th>Email</th>
						<th>Celular</th>
						<th>Activo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody id="detalleStudent" class="detalleStudent">

					<tr>
						<td>${r.id}</td>
						<td>${r.names}</td>
						<td>${r.last_name}</td>
						<td>${r.type_document}</td>
						<td>${r.number_document}</td>
						<td>${r.email}</td>
						<td>${r.cell_phone}</td>
						<td>${r.activate}</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>

	<!-- Formulario de edición de registro -->

	<div class="card" id="divRegistro" style="display: none;">
		<div class="card-header" id="TituloDeRegistro">{accion}
			ESTUDIANTE</div>
		<div class="card-body">
			<form>

				<input type="hidden" id="accion" name="accion"> <input
					type="hidden" id="accion" name="accion">
				<div class="row mb-3">
					<label for="formId" class="col-sm-2 col-form-label"></label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" id="formId"
							disabled="disabled" value="0">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formNombre" class="col-sm-2 col-form-label">Nombres</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="formNombre">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formApellidos" class="col-sm-2 col-form-label">Apellidos</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="formApellidos">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formTipoDeDocumento" class="col-sm-2 col-form-label">Tipo
						de Documento</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="formTipoDeDocumento"
							maxlength="3">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formNumeroDeDocumento" class="col-sm-2 col-form-label">N°
						de Documento</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="15"
							id="formNumeroDeDocumento">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="formEmail">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formCelular" class="col-sm-2 col-form-label">Celular</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" maxlength="9"
							id="formCelular">
					</div>
				</div>
				<div class="row mb-3">
					<label for="formActivo" class="col-sm-2 col-form-label"></label>
					<div class="col-sm-10">
						<input type="hidden" class="form-control" id="formActivo"
							disabled="disabled" value="A">
					</div>
				</div>
				<button type="button" class="btn btn-primary" id="btnProcesar">Procesar</button>
			</form>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous">
		
	</script>

	<script type="text/javascript">
		// Constantes del CRUD
		const ACCION_NUEVO = "NUEVO";
		const ACCION_EDITAR = "EDITAR";
		const ACCION_ELIMINAR = "ELIMINAR";
		
		//Arreglo de registros
		let arreglo = [];
		
		// Acceder a los controles
		let btnBuscar = document.getElementById("btnBuscar");
		let btnNuevo = document.getElementById("btnNuevo");
		let btnProcesar = document.getElementById("btnProcesar");

		// Programar los controles
		btnBuscar.addEventListener("click", fnBtnBuscar);
		btnNuevo.addEventListener("click", fnBtnNuevo);
		btnProcesar.addEventListener("click", fnBtnProcesar);

		//Función Editar
		function fnEditar(id) {
			TituloDeRegistro
			document.getElementById("TituloDeRegistro").innerHTML = ACCION_EDITAR
					+ " Registro"
			document.getElementById("accion").value = ACCION_EDITAR;
			fnCargarForm(id);
			//Formulario
			document.getElementById("divResultado").style.display = "none"
			document.getElementById("divRegistro").style.display = "block"
		}

		//Función Eliminar
		function fnEliminar(id) {
			document.getElementById("TituloDeRegistro").innerHTML = ACCION_ELIMINAR
					+ " Registro"
			document.getElementById("accion").value = ACCION_ELIMINAR;
			fnCargarForm(id);
			//Formulario
			document.getElementById("divResultado").style.display = "none"
			document.getElementById("divRegistro").style.display = "block"
		}

		// Acceder al control del botón de descarga
		let btnDescargar = document.getElementById("btnDescargar");
		btnDescargar.addEventListener("click", fnBtnDescargar);

		//Función Procesar
		function fnBtnProcesar() {
			let datos = "accion=" + document.getElementById("accion").value;
			datos += "&id=" + document.getElementById("formId").value;
			datos += "&names=" + document.getElementById("formNombre").value;
			datos += "&last_name="
					+ document.getElementById("formApellidos").value;
			datos += "&type_document="
					+ document.getElementById("formTipoDeDocumento").value;
			datos += "&number_document="
					+ document.getElementById("formNumeroDeDocumento").value;
			datos += "&email=" + document.getElementById("formEmail").value;
			datos += "&cell_phone="
					+ document.getElementById("formCelular").value;
			datos += "&activate=" + document.getElementById("formActivo").value;

			//Formulario
			// El envio con AJAX
			let xhr = new XMLHttpRequest();
			xhr.open("POST", "StudentProcesar", true);
			xhr.setRequestHeader('Content-type',
					'application/x-www-form-urlencoded');
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					// La solicitud se completó correctamente
					console.log(xhr.responseText);
					alert(xhr.responseText);
				}
			};
			xhr.send(datos);
		}

		// Función fnBtnNuevo
		function fnBtnNuevo() {
			document.getElementById("TituloDeRegistro").innerHTML = ACCION_NUEVO
					+ " Registro"
			document.getElementById("accion").value = ACCION_NUEVO;
			//Formulario
			document.getElementById("divResultado").style.display = "none"
			document.getElementById("divRegistro").style.display = "block"
		}

		// Función fnBtnBuscar
		function fnBtnBuscar() {
			// Datos
			let last_name = document.getElementById("last_name").value;
			let names = document.getElementById("names").value;
			// Preparar la URL
			let url = "StudentBuscar2?last_name=" + last_name + "&names="
					+ names;
			// La llama AJAX
			let xhttp = new XMLHttpRequest();
			xhttp.open("GET", url, true);
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					let respuesta = xhttp.responseText;
					arreglo = JSON.parse(respuesta);
					let detalleStudent = "";
					arreglo
							.forEach(function(item) {
								detalleStudent += "<tr>";
								detalleStudent += "<td>" + item.id + "</td>";
								detalleStudent += "<td>" + item.names + "</td>";
								detalleStudent += "<td>" + item.last_name
										+ "</td>";
								detalleStudent += "<td>" + item.type_document
										+ "</td>";
								detalleStudent += "<td>" + item.number_document
										+ "</td>";
								detalleStudent += "<td>" + item.email + "</td>";
								detalleStudent += "<td>" + item.cell_phone
										+ "</td>";
								detalleStudent += "<td>" + item.activate
										+ "</td>";
								detalleStudent += "<td>";
								detalleStudent += "<A href='javascript: fnEditar(" + item.id + ")'>Editar</A>  ";
								detalleStudent += "<A href='javascript: fnEliminar(" + item.id + ")'>Eliminar</A>";
								detalleStudent + "</td>";
								detalleStudent += "</tr>";
							});
					document.getElementById("detalleStudent").innerHTML = detalleStudent;
					//Mostar formulario
					document.getElementById("divResultado").style.display = "block"
					document.getElementById("divRegistro").style.display = "none"
				}
			};
			xhttp.send();
		}
		// Función fnBtnDescargar
		function fnBtnDescargar() {
		    let tabla = document.getElementById("detalleStudent");
		    let html = tabla.outerHTML;
		    let url = 'data:text/html;charset=UTF-8,' + encodeURIComponent(html);
		    let a = document.createElement('a');
		    a.href = url;
		    a.download = 'lista_alumnos.pdf';
		    a.click();
		}
		
		function fnCargarForm(id){
			arreglo.forEach(function(item) {
				if (item.id == id){
					document.getElementById("formId").value = item.id;
					document.getElementById("formNombre").value = item.names;
					document.getElementById("formApellidos").value = item.last_name;
					document.getElementById("formTipoDeDocumento").value = item.type_document;
					document.getElementById("formNumeroDeDocumento").value = item.number_document;
					document.getElementById("formEmail").value = item.email;
					document.getElementById("formCelular").value = item.cell_phone;
					document.getElementById("formActivo").value = item.activate;
					//break;
				}
			});
		}
	</script>
</body>
</html>