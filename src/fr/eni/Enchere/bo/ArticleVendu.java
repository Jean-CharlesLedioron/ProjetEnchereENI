package fr.eni.Enchere.bo;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEnchere;
	private LocalDateTime dateFinEnchere;
	private Integer prixInitial;
	private Integer prixVente;
	private Utilisateur utilisateur;
	
	
	/**
	 * Constructeur liste d'enchere de l'acceuil
	 * @param noArticle
	 * @param nomArticle
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param utilisateur
	 * @param enchere
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, LocalDateTime dateFinEnchere, Integer prixInitial,
			Utilisateur utilisateur, List<Enchere> enchere) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.utilisateur = utilisateur;
		this.enchere = enchere;
	}

	private Categorie categorie;
	private Retrait retrait;
	private List<Enchere> enchere;
	
	public ArticleVendu() {
	}

	/**
	 * 
	 * @param noArticle
	 */
	public ArticleVendu(Integer noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * 
	 * Contructeur complet d'un article
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDateTime dateDebutEnchere,
			LocalDateTime dateFinEnchere, Integer prixInitial, Integer prixVente, Utilisateur utilisateur,
			Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}
	
	
	

	/**
	 * Contructeur création enchere
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 */
	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
			Integer prixInitial) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
	}



	/**
	 *  Contructeur pour la visualisation d'enchère
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param utilisateur
	 * @param categorie
	 * @param retrait
	 * @param enchere
	 */
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDateTime dateFinEnchere,
			Integer prixInitial, Utilisateur utilisateur, Categorie categorie, Retrait retrait, List<Enchere> enchere) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.retrait = retrait;
		this.enchere = enchere;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public List<Enchere> getEnchere() {
		return enchere;
	}

	public void setEnchere(List<Enchere> enchere) {
		this.enchere = enchere;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDateTime dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDateTime getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setNoCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutEnchere == null) ? 0 : dateDebutEnchere.hashCode());
		result = prime * result + ((dateFinEnchere == null) ? 0 : dateFinEnchere.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
		result = prime * result + ((nomArticle == null) ? 0 : nomArticle.hashCode());
		result = prime * result + ((prixInitial == null) ? 0 : prixInitial.hashCode());
		result = prime * result + ((prixVente == null) ? 0 : prixVente.hashCode());
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
		ArticleVendu other = (ArticleVendu) obj;
		if (dateDebutEnchere == null) {
			if (other.dateDebutEnchere != null)
				return false;
		} else if (!dateDebutEnchere.equals(other.dateDebutEnchere))
			return false;
		if (dateFinEnchere == null) {
			if (other.dateFinEnchere != null)
				return false;
		} else if (!dateFinEnchere.equals(other.dateFinEnchere))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		if (nomArticle == null) {
			if (other.nomArticle != null)
				return false;
		} else if (!nomArticle.equals(other.nomArticle))
			return false;
		if (prixInitial == null) {
			if (other.prixInitial != null)
				return false;
		} else if (!prixInitial.equals(other.prixInitial))
			return false;
		if (prixVente == null) {
			if (other.prixVente != null)
				return false;
		} else if (!prixVente.equals(other.prixVente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + utilisateur + ", noCategorie="
				+ categorie + "]";
	}
}	
	
	


//
//public class ArticleVendu {
//
//	private int noArticle;
//	private String nomArticle;
//	private String description;
//	private LocalDate dateDebutEncheres;
//	private LocalDate dateFinEncheres;
//	private int miseAPrix;
//	private int prixVente;
//	private Utilisateur noUtilisateur;
//	
//	
//	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
//			LocalDate dateFinEncheres, int miseAPrix, int prixVente, Utilisateur noUtilisateur) {
//		super();
//		this.noArticle = noArticle;
//		this.nomArticle = nomArticle;
//		this.description = description;
//		this.dateDebutEncheres = dateDebutEncheres;
//		this.dateFinEncheres = dateFinEncheres;
//		this.miseAPrix = miseAPrix;
//		this.prixVente = prixVente;
//		this.noUtilisateur = noUtilisateur;
//	}
//
//}
