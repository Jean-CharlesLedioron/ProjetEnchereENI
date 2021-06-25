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
				
			<div class="row">
				<div></div>				
				<div class="form-group col-md-6">
						<label for="pseudo">Pseudo :</label> 				
				</div>
				
				<div class="form-group col-md-6">
					<label for="pseudo">${vendeur.pseudo}</label> 
				</div>	
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="nom">Nom :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="nom">${vendeur.nom}</label> 
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="prenom">Prénom :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="prenom">${vendeur.prenom}</label> 
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="email">Email :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="email">${vendeur.email}</label> 
				</div>
			</div>
			
			<div class="row">		
				<div class="form-group col-md-6">
					<label for="telephone">Téléphone :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="telephone">${vendeur.telephone}</label> 
				</div>
			</div>
			
			<div class="row">		
				<div class="form-group col-md-6">
					<label for="rue">Rue :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="rue">${vendeur.rue}</label> 
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="cp">Code postal :</label> 
				</div>
					
				<div class="form-group col-md-6">
					<label for="cp">${vendeur.pseudo}</label> 
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
						<label for="ville">Ville :</label> 
				</div>
					
					<div class="form-group col-md-6">
						<label for="ville">${vendeur.ville}</label> 
					</div>
			</div>
					<div class="form-group col-md-6">
						
					</div>
					
				
				
				<!-- Bouton -->
				
			<div class="form-group">
				<c:if test="${vendeur.pseudo eq pseudo}">
					
					<div class="col-sm-1 col-sm-offset-1">
						<a href="Modification" class="btn btn-primary">Modifier mon compte</a>
					</div>
			
				</c:if>
					<div class="col-sm-1 col-sm-offset-2">
						<a href="monProfil.jsp" class="btn btn-primary">Revenir à mon compte</a>
					</div>
			</div>
				
			
				

		</div>

	</div>
</div>

</body>
</html>