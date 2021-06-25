<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/eni.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Acceuil</title>
</head>
<body>
	<c:choose>
			<c:when test="${empty pseudo}">
	<header>
		<img alt="logo" src=""> <a class="header-slogan"
			href="ServletAccueil"> ENI-Enchères</a>


		<div id="subscribe">
			<a href="Inscription">S'inscrire </a> <br>
		</div>
		<div id="login">
			<a href="Connexion"> Se connecter</a>
		</div>
	</header>
	</c:when>
	<c:otherwise>
	    <header>
		<img alt="logo" src="">
			<a class="header-slogan" href="/ContenuProjetE/"> ENI-Enchères</a>
		

		<div id="subscribe">
			<a href="CreationEnchere">Vendre un article</a> 
		</div>
		<div id="login">
			<a href=""> Enchère</a>
		</div>
		<div id="login">
			<a href="ServletAffichageVendeur?pseudo=${pseudo }">Mon Profil </a>
		</div>
		<div id="login">
			<a href="Deconnexion">Déconnexion</a>
		</div>
	</header>
	</c:otherwise>
	</c:choose>
	<!-- <p> -->
	<%-- 		<c:if test="${!empty categorie}">${request.getParameter("categorie")}</c:if> --%>
	<%-- 		<c:if test="${!empty Filtre}">${request.getParameter("Filtre")}</c:if> --%>

	<%-- 		<c:if test="${empty listeEncheres}"> --%>
	<!-- 			<p>Pas d'enchères en cours !</p> -->
	<%-- 		</c:if> --%>
	<!-- 	</p> -->
	<section class="row">
		<h1>Liste des enchères</h1>
		<div id="selection">
			<form method="post" action="Accueil">
				<label>Filtre : </label> <input type="search" name="Filtre"
					id="Filtre" placeholder="Le nom de l'article contient">
			</form>
			<br />
			<form method="post" action="Accueil">
				<label>Catégorie : </label> <select name="categorie" id="categorie">
					<option value="Toutes">Toutes</option>
					<option>Informatique</option>
					<option>Ameublement</option>
					<option>Vêtements</option>
					<option>Sport et Loisirs</option>
				</select>
				<button id="envoyer" type="submit" name="search" value="Rechercher"
					name="envoyer" />
				Rechercher
				</button>
			</form>
		</div>
		<br>

	</section>
	<section class="row">
		<c:choose>
			<c:when test="${!empty pseudo}">
				<div class="row">
					<c:forEach items="${listeEncheres}" var="enchere">
						<div class="col-12 col-lg-6 mb-2 mt-2">
							<div class="card flex-row bg-warning">
								<img src="#" alt="Belle image">
								<div class="card-body">
									<a href="Enchere?idEnchere=${enchere.noArticle }" class="card-link"><h5 class="card-title">${enchere.nomArticle }</h5></a><br>
									Prix : ${enchere.prixInitial } crédits<br> Fin de
									l'enchère : ${enchere.dateFinEnchere }<br> Vendeur : <a
										href="ServletAffichageVendeur?pseudo=${enchere.utilisateur.pseudo }" id="${enchere.utilisateur.pseudo }" class="card-link">${enchere.utilisateur.pseudo }</a><br>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<c:forEach items="${listeEncheres}" var="enchere">
						<div class="col-12 col-lg-6 mb-2 mt-2">
							<div class="card flex-row bg-warning">
								<img src="#" alt="Belle article déco">
								<div class="card-body">
									<h5 class="card-title">${enchere.nomArticle }</h5>
									<br> Prix : ${enchere.prixInitial } crédits<br> Fin
									de l'enchère : ${enchere.dateFinEnchere }<br> Vendeur :
									${enchere.utilisateur.pseudo }<br>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>