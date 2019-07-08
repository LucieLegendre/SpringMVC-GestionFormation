<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de sessions</title>
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
		Modifier la session ${target.sujet} de ${target.lieu}
		</c:if>
		<c:if test="${target == null}">
		Ajouter une session
		</c:if>
	</h3>
	<hr />
	<c:if test="${target == null}">
		<form action="addSession" method="POST" class="form-example">
	</c:if>
	<c:if test="${target != null}">
		<form action="updateSession" method="POST" class="form-example">
		<input type="hidden" name="id" id="id"
			value="<c:out value='${target.id}'/>" />
	</c:if>
	<div class="form-group">
		<label>Date de début</label> <input class="form-control"
			type="texte" id="date_debut" placeholder="yyyy/mm/dd"
			name="date_debut" value="<fmt:formatDate var="fmtDate" value='${target.date_debut}' type="date" dateStyle="short" pattern="yyyy/MM/dd"/>" required>
	</div>
	<div class="form-group">
		<label>Date de fin</label> <input type="text" class="form-control"
			id="date_fin" placeholder="yyyy/mm/dd" name="date_fin"
			value="<fmt:formatDate var="fmtDateFin" value='${target.date_fin}' type="date" dateStyle="short" pattern="yyyy/MM/dd"/>" required>
	</div>
	<div class="form-group">
		<label>Sujet</label> <input type="text" class="form-control"
			id="sujet" placeholder="Enter sujet" name="sujet"
			value="<c:out value='${target.sujet}'/>" required>
	</div>
	<div class="form-group">
		<label>Lieu</label> <input type="text" class="form-control" id="lieu"
			placeholder="Enter lieu" name="lieu"
			value="<c:out value='${target.lieu}'/>" required >
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
		<h3>Liste des Session</h3>
		<hr />

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date de début</th>
					<th scope="col">Date de fin</th>
					<th scope="col">Sujet</th>
					<th scope="col">Lieu</th>
					<th scope="col">Specialite</th>
					<th scope="col">Update | Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="session" items="${lalistesessions}">

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/session/deleteSession">
						<c:param name="sessionId" value="${session.id}" />
					</c:url>

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/session/catchSession">
						<c:param name="sessionId" value="${session.id}" />
					</c:url>

					<tr>
						<td><c:out value="${session.getId()}" /></td>
						<td><fmt:formatDate var="fmtDate" value="${session.getDate_debut()}" type="date" dateStyle="short" pattern="yyyy/MM/dd"/>
						<c:out value = "${fmtDate}" /></td>
						<td><fmt:formatDate var="fmtDateFin" value="${session.getDate_fin()}" type="date" dateStyle="short" pattern="yyyy/MM/dd"/>
						<c:out value = "${fmtDateFin}" /></td>
						<td><c:out value="${session.getSujet()}" /></td>
						<td><c:out value="${session.getLieu()}" /></td>
						<td><c:out value="${session.getSpecialite().getLibelle()}" /></td>
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