<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<head>
	<title>TaskManager - Editar tarea</title>
<body>
	<form action="editarTarea" method="post" name="crearTarea_form_name">

		<center>
			<h1>Editar tarea</h1>
		</center>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td><div class="form-group">
						<label for="titulo">Título <span style="color: red">*</span></label>
						<input type="text" name="tituloTarea" class="form-control"
							id="titulo" value="${tareaSeleccionada.title}" size="30" />
					</div></td>
			</tr>
			<tr>
				<td><div class="form-group">	<!-- *TODO* no funciona en Firefox -->
						<label for="fecha">Fecha planeada</label> <input type="date"
							class="form-control" name="fechaPlaneadaTarea" value="yyyy-mm-dd"
							id="fecha" />
					</div></td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="comentario">Comentario</label>
						<textarea class="form-control" name="comentarioTarea" rows="5"
							id="comentario" size="30">${tareaSeleccionada.comments}</textarea>
					</div></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn btn-primary"
					value="Editar tarea" /></td>
			</tr>
		</table>
	</form>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>