<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.Enchere.bo.Utilisateur" %>
<%@ page import="fr.eni.Enchere.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier profil</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- <link rel="stylesheet" href="style/styleconnexion.css"/>  -->
</head>
<body>
<%@ include file="header.jsp"  %>
		<!-- Mon compte--> 
   	<div class="container">
		<div class="row">

		<div class="col-md-8 col-md-offset-2">
		
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
		
		
		${sessionScope.utilisateurs.pseudo}									
			<form role="form" method="POST" action="${pageContext.request.contextPath}/Modification?pseudo=${utilisateurs.pseudo} "> 

				<legend style="text-align: center;">ENI-Enchères</legend>

				<fieldset>
					<legend style="text-align: center;">Mon Profil</legend>

					<div class="form-group col-md-6">
						<label for="pseudo">Pseudo :</label> <input type="text"
							class="form-control" name="pseudo" id="pseudo"
							placeholder="Pseudo" required="required" autofocus="autofocus"/>
					</div>

					<div class="form-group col-md-6">
						<label for="nom">Nom :</label> <input type="text"
							class="form-control" name="nom" id="nom" placeholder="Nom"
							required="required"/>
					</div>

					<div class="form-group col-md-6">
						<label for="prenom">Prénom :</label> <input type="text"
							class="form-control" name="prenom" id="prenom"
							placeholder="Prénom" required="required"/>
					</div>

					<div class="form-group col-md-6">
						<label for="email">Email :</label> <input type="email"
							class="form-control" name="email" id="email" placeholder="Email"
							required="required"/>
					</div>
					<div class="form-group col-md-6">
						<label for="telephone">Téléphone :</label> <input type="tel"
							class="form-control" name="telephone" id="telephone"
							placeholder="ex : 06-76-48-29-23"/>
					</div>
					<div class="form-group col-md-6">
						<label for="rue">Rue :</label> <input type="text"
							class="form-control" name="rue" id="rue" placeholder="Rue"
							required="required"/>
					</div>

					<div class="form-group col-md-6">
						<label for="cp">Code postal :</label> <input type="text"
							class="form-control" name="cp" id="cp" placeholder="Code postal"
							required="required"/>
					</div>

					<div class="form-group col-md-6">
						<label for="ville">Ville :</label> <input type="text"
							class="form-control" name="ville" id="ville" placeholder="Ville"/>
					</div>
					<div class="form-group col-md-6">
						<label for="password">Mot de passe actuel:</label> <input
							type="password" class="form-control" name="password"
							id="password" placeholder="Mot de passe" required="required"/>
					</div>

					<div class="form-group col-md-6">
						<label for="new_password">Nouveau mot de passe:
							</label> <input type="password" class="form-control" name="new_password"
							id="new_password" placeholder="Nouveau mot de passe "/>
					</div>
					
					<div class="form-group col-md-6"> </div>
					
					<div class="form-group col-md-6">
						<label for="confirm_password">Confirmation:
							</label> <input type="password" class="form-control" name="confirm_password"
							id="confirm_password" placeholder="Mot de passe "/>
					</div>
				
				</fieldset>
				
				<!-- Boutons -->
				
				<div class="form-group">
					<div class="col-sm-1 col-sm-offset-1">
						<a href="${pageContext.request.contextPath}/Modification?noUtilisateur=${utilisateurs.pseudo}" class="btn btn-primary">Enregistrer</a>
					</div>
					<div class="col-sm-2 col-sm-offset-2">
						<a href="${pageContext.request.contextPath}/Supprimer?noUtilisateur=${utilisateurs.pseudo}" class="btn btn-primary" >Supprimer mon compte</a>
					</div>
					<div class="col-sm-1 col-sm-offset-2">
						<a href="ServletAccueil" class="btn btn-primary">Annuler</a>
					</div>
					
				</div>

			</form>
		</div>

	</div>
</div>
		<footer><%@ include file="footer.jsp" %></footer>
</body>
</html>