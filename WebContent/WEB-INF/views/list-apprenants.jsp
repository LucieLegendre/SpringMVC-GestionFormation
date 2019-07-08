<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion des apprenants</title>
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
		Modifier le compte de ${target.prenom} ${target.nom}
		</c:if>
		<c:if test="${target == null}">
		Ajouter un apprenant
		</c:if>
	</h3>
	<hr />
	<c:if test="${target == null}">
		<form action="addApprenant" method="post" class="form-example">
	</c:if>
	<c:if test="${target != null}">
		<form action="updateApprenant" method="post" class="form-example">
			<input type="hidden" name="id" id="id"
				value="<c:out value='${target.id}'/>" />
	</c:if>
	<div class="form-group">
		<label>Identifiant Pole Emploi</label> <input type="text"
			class="form-control" id="idpe" placeholder="Enter ID" name="idpe"
			value="<c:out value='${target.idpe}'/>" required>
	</div>
	<div class="form-group">
		<label>Nom</label> <input type="text" class="form-control" id="nom"
			placeholder="Enter Nom" name="nom"
			value="<c:out value='${target.nom}'/>" required>
	</div>
	<div class="form-group">
		<label>Prenom</label> <input type="text" class="form-control"
			id="prenom" placeholder="Enter Prenom" name="prenom"
			value="<c:out value='${target.prenom}'/>" required>
	</div>
	<div class="form-group">
		<label>Age</label> <input type="text" class="form-control" id="age"
			placeholder="Enter age" name="age"
			value="<c:out value='${target.age}'/>" required>
	</div>
	<div class="form-group">
		<label>Indemnités</label> <input type="text" class="form-control"
			id="indemnite" placeholder="Enter Indemnités" name="indemnite"
			value="<c:out value='${target.indemnite}'/>" required>
	</div>
	<div class="form-group">
		<label>Diplome</label> <input type="text" class="form-control"
			id="diplome" placeholder="Enter Diplome" name="diplome"
			value="<c:out value='${target.diplome}'/>" required>
	</div>
	<div class="form-group">
		<label>Session</label>
		<select name="sessionId">
			<c:forEach var="session" items="${listSession}">
			<option value="${session.id}">${session.sujet}</option>			
			</c:forEach>
		</select>
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

	<br>
	<hr />
	<br>

	<div align="center">
		<h3>Liste des Apprenants</h3>
		<hr />

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Identifiant Pôle Emploi</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">Age</th>
					<th scope="col">Indemnités</th>
					<th scope="col">Diplomes</th>
					<th scope="col">Sessions</th>
					<th scope="col">Update | Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="apprenant" items="${lalisteapprenants}">

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/apprenant/deleteApprenant">
						<c:param name="apprennantId" value="${apprenant.id}" />
					</c:url>

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/apprenant/catchApprenant">
						<c:param name="apprenantId" value="${apprenant.id}" />
					</c:url>

					<tr>
						<td><c:out value="${apprenant.getId()}" /></td>
						<td><c:out value="${apprenant.getIdpe()}" /></td>
						<td><c:out value="${apprenant.getNom()}" /></td>
						<td><c:out value="${apprenant.getPrenom()}" /></td>
						<td><c:out value="${apprenant.getAge()}" /></td>
						<td><c:out value="${apprenant.getIndemnite()}" /></td>
						<td><c:out value="${apprenant.getDiplome()}" /></td>
						<td><c:out value="${apprenant.getSession().getSujet()}" /></td>
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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>
</html>