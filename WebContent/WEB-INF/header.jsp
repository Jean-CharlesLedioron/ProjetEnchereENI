<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page language="java" contentType="text/html; charset=UTF-8"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<header>
		<a href="/ContenuProjetE/" title="lien accueil">
   <img alt="logo" src="${pageContext.request.contextPath}/image/logo3.png" >
		</a>	
			<a class="header-slogan" href="/ContenuProjetE/"> ENI-Enchères</a>
		<nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top" style="color: #ffffff; font-size:20px;
 font-family:; font-style:italic; text-align:left; background-color:black; border-bottom-color:#d5a770; 
 border-bottom-style:solid; border-width:2px; position:right;">
  		<div class="container-fluid">
            
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      	<li class="nav-item">
      		
      	</li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="CreationEnchere">Vendre un article</a>
        </li>
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ServletAffichageVendeur?pseudo=${pseudo }">Mon Profil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Deconnexion">Déconnexion</a>
        </li>
      </ul>
    </div>
  </div>
  
</nav>  
      </ul>
</header>		