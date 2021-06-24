package fr.eni.Enchere.bo;

import java.time.LocalDate;

public class ArticleVendu {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private Utilisateur noUtilisateur;
	
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, Utilisateur noUtilisateur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
	}


	public int getNoArticle() {
		return noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public int getMiseAPrix() {
		return miseAPrix;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public Utilisateur getVendeur() {
		return noUtilisateur;
	}
	
	
	
	
	
	
	
	
}
