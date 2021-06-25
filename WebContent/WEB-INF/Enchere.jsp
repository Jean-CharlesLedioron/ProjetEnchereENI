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
<title>Enchère</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<legend>ENI-Enchères</legend>
			<fieldset>
				<legend style="text-align: center;">Détail vente</legend>
				<form role="form" method="POST" action="Enchere">
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
					<c:if test="${!empty succesEnchere}">
						<div class="alert alert-success" role="alert">
							<c:out value="Enchère prise en compte" />
						</div>
					</c:if>
					<div class="col-md-3 col-xs-12">

						<div class="w-25 p-3">
							<img src="image/magni.jpg" style="width: 300px; height: auto"
								class="w-50 img-thumbnail" alt="Magni">
						</div>
					</div>
					<div class="col-xs-12 col-md-7 offset-md-3">
						<div class="row">
							<div class="col-xs-12">
								<h3>${article.nomArticle}</h3>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-3 col-md-3">Description :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${article.description}</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Catégorie :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${article.categorie.libelle}</div>
						</div>
						<div class="row">
							<c:choose>
								<c:when test="${meilleureEnchere.montantEnchere eq null}">
									<div class="col-xs-4 col-md-3">Meilleure offre :</div>
									<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">Aucune
										enchère</div>
								</c:when>
								<c:otherwise>
									<div class="col-xs-4 col-md-3">Meilleure offre :</div>
									<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">${meilleureEnchere.montantEnchere}
										par ${meilleureEnchere.noUtilisateur.pseudo}</div>
								</c:otherwise>
							</c:choose>

						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Mise à prix :</div>
							<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">${article.prixInitial}
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Fin de l'enchère :</div>
							<input class="col-xs-8 offset-xs-4 col-md-9 offset-md-3"
								type="datetime-local" id="finEnchere" name="finEnchere"
								value="${article.dateFinEnchere}" disabled="disabled">
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Retrait :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">
								${article.retrait.rue} <br> ${article.retrait.codePostal}
								${article.retrait.ville}
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Vendeur :</div>
							<a href="pageProfilid"
								class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${article.utilisateur.pseudo}</a>
						</div>
						<c:if test="${article.utilisateur.pseudo ne pseudo}">
							<div class="row">
								<label class="col-xs-4 col-md-3">Ma proposition :</label>
								<div class="col-xs-4 offset-xs-4 col-md-2 offset-md-3">
									<c:choose>
										<c:when
											test="${meilleureEnchere.montantEnchere  gt  article.prixInitial}">
											<input type="number" name="propositionEnchere"
												min="${meilleureEnchere.montantEnchere}"
												value="${meilleureEnchere.montantEnchere}">
										</c:when>
										<c:otherwise>
											<input type="number" name="propositionEnchere"
												min="${article.prixInitial}" value="${article.prixInitial}">

										</c:otherwise>
									</c:choose>
								</div>
								<div class="col-xs-1 offset-xs-11 col-md-3 offset-md-7">
									<button type="submit" class="btn btn-primary">Enchérir</button>
								</div>
							</div>
						</c:if>
						<br> <br>
						<c:if test="${article.utilisateur.pseudo ne pseudo}">
							<div class="row">
								<div class="col-xs-2 col-xs-offset-3">
									<a href="ServletAccueil" class="btn btn-primary">Retour</a>
								</div>
							</div>
						</c:if>
						<c:if test="${article.utilisateur.pseudo eq pseudo}">
							<div class="row">
								<div class="col-xs-2">
									<a href="home" class="btn btn-primary">Modifier l'enchère</a>
								</div>
								<div class="col-xs-2 col-xs-offset-2">
									<a href="home" class="btn btn-primary">Supprimer l'enchère</a>
								</div>
								<div class="col-xs-2 col-xs-offset-2">
									<a href="ServletAccueil" class="btn btn-primary">Retour</a>
								</div>
							</div>
						</c:if>
					</div>
				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>