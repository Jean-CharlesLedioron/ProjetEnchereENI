package fr.eni.Enchere.bo;

import java.time.LocalDate;
public class Enchere {

	private LocalDate dateEnchere;
	private int montant_enchere;
	private Utilisateur noUtilisateur;
	private ArticleVendu noArticle;
	
	
	//Constructeur
	

	public Enchere() {
		
	}


	public Enchere(LocalDate dateEnchere, int montant_enchere, Utilisateur noUtilisateur,ArticleVendu noArticle ) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
	}



	

	public Enchere(LocalDate dateFin, String nomArticle, String pseudo, int prixInitial, int montantEnchere,
			int noArticle) {
		// TODO Auto-generated constructor stub
	}


	public Enchere(Enchere enchere) {
		// TODO Auto-generated constructor stub
	}


	public Enchere(String parameter, String parameter2, String parameter3, String parameter4, String parameter5,
			String parameter6) {
		// TODO Auto-generated constructor stub
	}


	//Getter
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}


	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}


	public ArticleVendu getNoArticle() {
		return noArticle;
	}
}
	
	

	