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
			<form role="form" method="POST" action="Enchere">
				<fieldset>
					<legend style="text-align: center;">Détail vente</legend>
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
					<c:if test="${!empty succesAjout}">
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
							<div class="col-xs-12">${article}Statue Magni</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Description :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${description}Magni
								Barbe-de-Bronze ( Angl. Magni Bronzebeard) fut le Roi du royaume
								nain de Khaz Modan et le chef du Clan Barbe-de-Bronze. Connu
								pour être un excellent forgeron, il fut l'artisan qui forgea la
								célèbre Porte-cendres.</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Catégorie :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${categorie}Statue</div>
						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Meilleure offre :</div>
							<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">${prixVente}8.000.000</div>
						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Mise à prix :</div>
							<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">${prixInitial}
								Inestimable</div>
						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Fin de l'enchère :</div>
							<div class="col-xs-8 offset-xs-4 col-md-9 offset-md-3">${dateFinEnchere}
								20/09/2021</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Retrait :</div>
							<div class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">
								${rue} Chez moi<br> ${cp}${ville}29200 Brest
							</div>
						</div>
						<div class="row">
							<div class="col-xs-3 col-md-3">Vendeur :</div>
							<a href ="pageProfilid"class="col-xs-9 offset-xs-3 col-md-9 offset-md-3">${vendeur}JC</a>
						</div>
						<div class="row">
							<div class="col-xs-4 col-md-3">Ma proposition :</div>
							<div class="col-xs-4 offset-xs-4 col-md-3 offset-md-3">
								<input type="number" name="propositioEnchere" min="8000000" ${prixvente} value="8000000" ${prixvente}>
							</div>
							<div class="col-xs-2 offset-xs-10 col-md-3 offset-md-7">
								<button type="submit" class="btn btn-primary">Enchérir</button>
							</div>
						</div>
						<br> <br>
						<div class="row">
							<div class="col-xs-2 col-xs-offset-5">
								<a href="home" class="btn btn-primary">Retour</a>
							</div>
						</div>

					</div>
		</div>
		</fieldset>
		</form>
	</div>
	</div>
</body>
</html>