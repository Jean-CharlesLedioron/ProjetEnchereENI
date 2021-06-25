<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>TrocEnchere</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleconnexion.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>

				<header class="card-header">
					<h4 class="card-title mt-2">ENI-Enchère</h4>
				</header>
<div class="container">
    <div id="content" class="row justify-content-center">
        <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
        </svg>
        <h2>Connexion</h2>
        	<c:if test="${!empty listeErreur}">${listeErreur}</c:if>
                    <form method="POST" action="Connexion">
					  <div class="mb-3 row justify-content-md-center">
                        <label for="staticEmail" class="col-sm-2 col-form-label" for="identifiant">Identifiant :</label>
                          <div class="col-sm-2">
                              <input type="text" id="identifiant" placeholder="Email ou Pseudo" name="pseudo">
                          </div>
                      </div>
                      <div class="mb-3 row justify-content-md-center">
                        <label for="inputPassword" class="col-sm-2 col-form-label" for="password">Mot de passe :</label>
                          <div class="col-sm-2">
                            <input type="password" id="password" placeholder="Password" name="password" required="required">
                          </div>
                      </div>
                      <div class="row justify-content-md-center">
                        <div class="col-sm-2">
                          <button type="submit" name="connexion">Connexion</button>
                        </div>
                        <div class="col-sm-2" id="option">
                        <div class="col">
                          <input class="form-check-input" type="checkbox" id="check">
                          <label id="remember" for="check">
                              se souvenir de moi
                          </label>
                        </div>
                        <div class="col">
                          <a id="mdpoublie"href="#">mot de passe oublié</a>
                        </div>
                        </div>
                      </div>
                    </form>
                    <br>
                <div class="row col-sm-4">
                <a href="Inscription" id="buttonCreate">Creer un compte</a>
                </div>
    </div> 
</div>
	
                        
    </body>
                                     

</html>