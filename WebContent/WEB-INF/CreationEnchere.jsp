<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.Enchere.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<html>
<head>
<meta charset="UTF-8">
<title>Création d'enchère</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<legend>ENI-Enchères</legend>

			<fieldset>
				<legend style="text-align: center;">Nouvelle vente</legend>
				<c:if test="${!empty listeCodesErreur}">
					<div class="alert alert-danger" role="alert">
						<strong>Erreur!</strong>
						<ul>
							<c:forEach var="code" items="${listeCodesErreur}">
								<li>${LecteurMessage.getMessageErreur(code)}</li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<c:if test="${!empty succesCreation}">
					<div class="alert alert-success" role="alert">
						<c:out value="Ventre créée" />
					</div>
				</c:if>
				<form role="form" method="POST" action="CreationEnchere">
					<div class="col-md-3 col-xs-12">

						<div class="w-25 p-3">
							<img src="image/magni.jpg" style="width: 300px; height: auto"
								class="w-50 img-thumbnail" alt="Magni">
						</div>
					</div>
					<div class="col-xs-12 col-md-7 offset-md-3">
						<div class="row">
							<label for="article" class="col-xs-4 col-md-3">Article :</label>
							<input type="text"
								class="col-xs-8 offset-xs-4 col-md-9 offset-md-3" name="article"
								id="article" placeholder="Nom de votre article"
								required="required" autofocus="autofocus">
						</div>
						<br>
						<div class="row">
							<label for="description" class="col-xs-4 col-md-3">Description
								:</label>
							<textarea class="col-xs-8 offset-xs-4 col-md-9 offset-md-3"
								name="description" id="description"
								placeholder="Description de votre article" autofocus="autofocus"></textarea>

						</div>
						<br>
						<div class="row">
							<label for="categorie" class="col-xs-4 col-md-3">Catégorie
								:</label> <select class="col-xs-4 offset-xs-4 col-md-3 offset-md-3"
								name="categorie" id="categorie">
								<c:forEach items="${listeCategorie}" var="item">
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>
						</div>

						<div class="row">
							<label for="photo" class="col-xs-4 col-md-3">Photo de
								l'article :</label> <input
								class="col-xs-8 offset-xs-4 col-md-9 offset-md-3" type="file"
								id="photo" name="photo" />

						</div>
						<div class="row">
							<label for="prix" class="col-xs-4 col-md-3">Mise à
								prix :</label> <input type="number" name="prix" min="0">
						</div>
						<br>
						<div class="row">
							<label for="debutEnchere" class="col-xs-4 col-md-3">Début de
								l'enchère</label> <input name="debutEnchere" type="date">
						</div>
						<br>
						<div class="row">
							<label for="finEnchere" class="col-xs-4 col-md-3">Fin de
								l'enchère</label> <input name="finEnchere" type="date">
						</div>
						<br> <br>
						<div class="card" title="Retrait">
							<div class="row">
								<label for="rue" class="col-xs-4 col-md-3">Rue :</label> <input
									class="col-xs-4 offset-xs-4 col-md-3 offset-md-3" type="text"
									name="rue" id="rue" required="required" value="${adresse.rue}">
							</div>
							<br>
							<div class="row">
								<label for="cp" class="col-xs-4 col-md-3">Code postal :</label>
								<input class="col-xs-4 offset-xs-4 col-md-3 offset-md-3"
									type="text" name="cp" id="cp" required="required"
									value="${adresse.codePostal}">
							</div>
							<br>
							<div class="row">
								<label for="ville" class="col-xs-4 col-md-3">Ville :</label> <input
									class="col-xs-4 offset-xs-4 col-md-3 offset-md-3" type="text"
									name="ville" id="ville" required="required"
									value="${adresse.ville}">
							</div>
							<br>
							<div class="row">
					<div class="col-xs-1 offset-xs-1 col-md-2 offset-md-1">
						<button type="submit" class="btn btn-primary">Créer</button>
					</div>
					<div class="col-xs-1 offset-xs-4 col-md-2 offset-md-5">
						<button type="reset" class="btn btn-primary">Reset</button>
					</div>
					<div class="col-xs-1 offset-xs-7 col-md-2 offset-md-9">
						<a href="home" class="btn btn-primary">Retour</a>
					</div>
				</div>
						</div>
					</div>
				</form>
				<br> <br>
				
			</fieldset>
		</div>
	</div>
</body>
</html>