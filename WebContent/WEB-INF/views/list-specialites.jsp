<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des spécialités</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body class="container">
	<%@include file="layout/header.jsp"%>

	<h3 align="center">
		<c:if test="${target != null}">
		Modifier le nom de la spécialité : ${target.libelle}
		</c:if>
		<c:if test="${target == null}">
		Ajouter une spécialité
		</c:if>
	</h3>
	<hr />
	<c:if test="${target == null}">
		<form action="addSpecialite" method="post" class="form-example">
	</c:if>
	<c:if test="${target != null}">
		<form action="updateSpecialite" method="post" class="form-example">
			<input type="hidden" name="id" id="id"
				value="<c:out value='${target.id}'/>" />
	</c:if>
	<div class="form-group">
		<label>Specialité</label> <input type="text" class="form-control"
			id="libelle" placeholder="Enter libelle" name="libelle"
			value="<c:out value='${target.libelle}'/>" required>
	</div>
	<div class="form-group">
		<c:if test="${target != null}">
			<input type="submit" class="btn btn-primary" value="Editer" />
		</c:if>
		<c:if test="${target == null}">
			<input type="submit" class="btn btn-primary" value="Ajouter" />
		</c:if>
	</div>
	</form>
	<div align="center">
		<h3 text>Liste des Specialites</h3>
		<hr />

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Libelle</th>
					<th scope="col">Update | Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="specialite" items="${lalistespecialites}">

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/specialite/deleteSpecialite">
						<c:param name="specialiteId" value="${specialite.id}" />
					</c:url>

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/specialite/catchSpecialite">
						<c:param name="specialiteId" value="${specialite.id}" />
					</c:url>

					<tr>
						<td><c:out value="${specialite.getId()}" /></td>
						<td><c:out value="${specialite.getLibelle()}" /></td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you
								sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>