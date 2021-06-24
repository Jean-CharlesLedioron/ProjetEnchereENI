<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/eni.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Acceuil</title>
</head>
<body>

	<header>
		<img alt="logo" src="">
			<a class="header-slogan" href="/ContenuProjetE/"> ENI-Enchères</a>
		

		<div id="subscribe">
			<a href="">S'inscrire </a> <br>
		</div>
		<div id="login">
			<a href=""> Se connecter</a>
		</div>
	</header>

<section>
	<h1>Liste des enchères</h1> 
<div id="selection">
<form method="post" action="Accueil" >
	
	<label>Filtre : </label>
	<input type="search" name="Filtre" id="Filtre" placeholder="Le nom de l'article contient">
	
</form>
<br />

<form method="post" action="Accueil">

		<label>Catégorie : </label>
		<select name="categorie" id="categorie">
			<option value="Toutes">Toutes</option>
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtements</option>
			<option>Sport et Loisirs</option>
		</select>  
		
			<button id="envoyer" type="submit" name="search" value ="Rechercher"  name="envoyer"/>Rechercher</button>
		
</form>
</div>	


</section>		

	
		${test}







<p>
	<c:if test="${!empty categorie}">${request.getParameter("categorie")}</c:if>
	<c:if test="${!empty Filtre}">${request.getParameter("Filtre")}</c:if>

	<c:if test="${empty listeEncheres}"><p>Pas d'enchères en cours !</p></c:if>
	
				
</p>
</body>
</html>