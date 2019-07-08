<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion formateurs</title>
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
		Modifier le formateur ${target.nom} ${target.prenom}
		</c:if>
		<c:if test="${target == null}">
		Ajouter un formateur
		</c:if>
	</h3>

	<hr />
	<c:if test="${target == null}">
		<form action="addFormateur" method="POST" class="form-example">
	</c:if>
	<c:if test="${target != null}">
		<form action="updateFormateur" method="POST" class="form-example">
			<input type="hidden" name="id" id="id"
				value="<c:out value='${target.id}'/>" />
	</c:if>
	<div class="form-group">
		<label>Identifiant</label> <input type="text" class="form-control"
			type="text" id="identifiant" placeholder="Entrer identifiant"
			name="identifiant" value="<c:out value='${target.identifiant}'/>" required>
	</div>
	<div class="form-group">
		<label>Nom</label> <input type="text" class="form-control" id="nom"
			placeholder="Enter nom" name="nom"
			value="<c:out value='${target.nom}'/>" required>
	</div>
	<div class="form-group">
		<label>Prenom</label> <input type="text" class="form-control"
			id="prenom" placeholder="Enter prenom" name="prenom"
			value="<c:out value='${target.prenom}'/>" required>
	</div>
	<div class="form-group">
		<label>Age</label> <input type="text" class="form-control" id="age"
			placeholder="Enter age" name="age"
			value="<c:out value='${target.age}'/>" required>
	</div>
	<div class="form-group">
		<label>Salaire</label> <input type="text" class="form-control"
			id="salaire" placeholder="Enter salaire" name="salaire"
			value="<c:out value='${target.salaire}'/>" required>
	</div>
	<div class="form-group">
		<label>Session</label> <select name="sessionId">
			<c:forEach var="session" items="${listSession}">
				<option value="${session.id}">${session.sujet}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>Specialite</label> <select name="specialiteId">
			<c:forEach var="specialite" items="${listSpecialite}">
				<option value="${specialite.id}">${specialite.libelle}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<c:if test="${target != null}">
			<input type="submit" class="btn btn-primary" value="Editer" />
		</c:if>
		<c:if test="${target == null}">
			<input type="submit" class="btn btn-primary" value="Valider" />
		</c:if>
	</div>



	</form>

	<br>
	<hr />
	<br>

	<div align="center">
		<h3>Liste des Formateurs</h3>
		<hr />

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Identifiant</th>
					<th scope="col">Nom</th>
					<th scope="col">Prenom</th>
					<th scope="col">Age</th>
					<th scope="col">Salaire</th>
					<th scope="col">Sessions</th>
					<th scope="col">Specialite</th>
					<th scope="col">Update | Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="formateur" items="${lalisteformateurs}">

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/formateur/deleteFormateur">
						<c:param name="formateurId" value="${formateur.id}" />
					</c:url>

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/formateur/catchFormateur">
						<c:param name="formateurId" value="${formateur.id}" />
					</c:url>

					<tr>
						<td><c:out value="${formateur.getId()}" /></td>
						<td><c:out value="${formateur.getIdentifiant()}" /></td>
						<td><c:out value="${formateur.getNom()}" /></td>
						<td><c:out value="${formateur.getPrenom()}" /></td>
						<td><c:out value="${formateur.getAge()}" /></td>
						<td><c:out value="${formateur.getSalaire()}" /></td>
						<td><c:out value="${formateur.getSession().getSujet()}" /></td>
						<td><c:out value="${formateur.getSpecialite().getLibelle()}" /></td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you
								sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>
</html>