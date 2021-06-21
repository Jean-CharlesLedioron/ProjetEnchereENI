package fr.eni.Enchere.bo;

import java.time.LocalDate;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private Integer prixInitial;
	private Integer prixVente;
	private Integer noUtilisateur;
	private Integer noCategorie;
	
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
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, Integer prixInitial, Integer prixVente, Integer noUtilisateur,
			Integer noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	
	

	/**
	 * Contructeur création enchere
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 */
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			Integer prixInitial) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
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

	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
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

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutEnchere == null) ? 0 : dateDebutEnchere.hashCode());
		result = prime * result + ((dateFinEnchere == null) ? 0 : dateFinEnchere.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
		result = prime * result + ((noCategorie == null) ? 0 : noCategorie.hashCode());
		result = prime * result + ((noUtilisateur == null) ? 0 : noUtilisateur.hashCode());
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
		if (noCategorie == null) {
			if (other.noCategorie != null)
				return false;
		} else if (!noCategorie.equals(other.noCategorie))
			return false;
		if (noUtilisateur == null) {
			if (other.noUtilisateur != null)
				return false;
		} else if (!noUtilisateur.equals(other.noUtilisateur))
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
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + "]";
	}
	
	
	

}
