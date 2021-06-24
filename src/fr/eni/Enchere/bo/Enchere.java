package fr.eni.Enchere.bo;

import java.time.LocalDateTime;

public class Enchere {
	private Utilisateur noUtilisateur;
	private ArticleVendu noArticle;
	private LocalDateTime datEnchere;
	private Integer montantEnchere;
	
	
	/**
	 * Constructeur Meilleure enchère
	 * @param montantEnchere
	 */
	public Enchere(Integer montantEnchere) {
		super();
		this.montantEnchere = montantEnchere;
	}


	public Enchere() {
	}


	/**
	 * contructeur complet
	 * @param noUtilisateur
	 * @param noArticle
	 * @param datEnchere
	 * @param montantEnchere
	 */
	public Enchere(Utilisateur noUtilisateur, ArticleVendu noArticle, LocalDateTime datEnchere, Integer montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.datEnchere = datEnchere;
		this.montantEnchere = montantEnchere;
	}




	/**
	 * @param noUtilisateur
	 * @param montantEnchere
	 */
	public Enchere(Utilisateur noUtilisateur, Integer montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.montantEnchere = montantEnchere;
	}


	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public ArticleVendu getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}


	public LocalDateTime getDatEnchere() {
		return datEnchere;
	}


	public void setDatEnchere(LocalDateTime datEnchere) {
		this.datEnchere = datEnchere;
	}


	public Integer getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datEnchere == null) ? 0 : datEnchere.hashCode());
		result = prime * result + ((montantEnchere == null) ? 0 : montantEnchere.hashCode());
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
		result = prime * result + ((noUtilisateur == null) ? 0 : noUtilisateur.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchere other = (Enchere) obj;
		if (datEnchere == null) {
			if (other.datEnchere != null)
				return false;
		} else if (!datEnchere.equals(other.datEnchere))
			return false;
		if (montantEnchere == null) {
			if (other.montantEnchere != null)
				return false;
		} else if (!montantEnchere.equals(other.montantEnchere))
			return false;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		if (noUtilisateur == null) {
			if (other.noUtilisateur != null)
				return false;
		} else if (!noUtilisateur.equals(other.noUtilisateur))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Enchere [noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle + ", datEnchere=" + datEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
	
	
	

}
//public class Enchere {
//
//	private LocalDate dateEnchere;
//	private int montant_enchere;
//	private Utilisateur noUtilisateur;
//	private ArticleVendu noArticle;
//	
//	
//	//Constructeur
//	
//
//	public Enchere() {
//		
//	}
//
//
//	public Enchere(LocalDate dateEnchere, int montant_enchere, Utilisateur noUtilisateur,ArticleVendu noArticle ) {
//		super();
//		this.dateEnchere = dateEnchere;
//		this.montant_enchere = montant_enchere;
//		this.noUtilisateur = noUtilisateur;
//		this.noArticle = noArticle;
//	}
//
//
//
//	
//
//	public Enchere(LocalDate dateFin, String nomArticle, String pseudo, int prixInitial, int montantEnchere,
//			int noArticle) {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Enchere(Enchere enchere) {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Enchere(String parameter, String parameter2, String parameter3, String parameter4, String parameter5,
//			String parameter6) {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	//Getter
//	public LocalDate getDateEnchere() {
//		return dateEnchere;
//	}
//
//	public int getMontant_enchere() {
//		return montant_enchere;
//	}
//
//
//	public Utilisateur getNoUtilisateur() {
//		return noUtilisateur;
//	}
//
//
//	public ArticleVendu getNoArticle() {
//		return noArticle;
//	}
//}
	
	

	
