<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.Enchere.bo.Utilisateur" %>
<%@ page import="fr.eni.Enchere.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"> 
<!-- <link rel="stylesheet" href="style/styleconnexion.css"/> 
 -->
<meta charset="UTF-8">
<title>Profil du vendeur</title>
</head>
<body>



<div class="container">
		<div class="row">
		
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

		<div class="col-md-8 col-md-offset-2">

				<legend style="text-align: center;">ENI-Enchères</legend>
				
								
				<div class="form-group col-md-6">
						<label for="pseudo">Pseudo :</label> 				
				</div>
				
				<div class="form-group col-md-6">
					<label for="pseudo">${utilisateur.pseudo}</label> 
				</div>	

				<div class="form-group col-md-6">
					<label for="nom">Nom :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="nom">${utilisateur.nom}</label> 
				</div>

				<div class="form-group col-md-6">
					<label for="prenom">Prénom :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="prenom">${utilisateur.prenom}</label> 
				</div>

				<div class="form-group col-md-6">
					<label for="email">Email :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="email">${utilisateur.email}</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="telephone">Téléphone :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="telephone">${utilisateur.telephone}</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="rue">Rue :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="rue">${utilisateur.rue}</label> 
				</div>

				<div class="form-group col-md-6">
					<label for="cp">Code postal :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="cp">${utilisateur.pseudo}</label> 
				</div>

				<div class="form-group col-md-6">
						<label for="ville">Ville :</label> 
				</div>
					
					<div class="form-group col-md-6">
						<label for="ville">${utilisateur.ville}</label> 
					</div>
				
					<div class="form-group col-md-6">
						
					</div>
					
				
				
				<!-- Bouton -->
				
				<div class="form-group">
					<div class="col-md-2 col-md-offset-1">
						<a href="monProfil.jsp" class="btn btn-primary">Revenir à mon compte</a>
					</div>
				</div>

		</div>

	</div>
</div>

</body>
</html>