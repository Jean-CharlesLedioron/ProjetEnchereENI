package fr.eni.Enchere.bo;

import java.util.List;

public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private byte administrateur;
	private List<ArticleVendu> achat;
	private List<ArticleVendu> vente;
	private List<Enchere> enchere;
	
	private String newPassword;
	
	
	
	
	/**
	 * Constructeur par d�faut
	 */
	public Utilisateur() {
	}


	/**
	 * @param noUtilisateur
	 */
	public Utilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	




	/**
	 * Constructeur pour la requete select noUtilisateur et credit by pseudo
	 * @param noUtilisateur
	 * @param pseudo
	 * @param credit
	 */
	public Utilisateur(int noUtilisateur, String pseudo, int credit) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.credit = credit;
	}


	/**
	 * COntructeur infos d'adresse de retrait pour le pseudo connect?
	 * @param pseudo
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Utilisateur(String pseudo, String rue, String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/**
	 * 
	 * Constructeur complet d'un adh�rent
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, byte administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	

	/**
	 * 
	 * Contructeur sans id pour la cr�ation de compte
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, byte administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	/*
	 * Constructeur pour l'affichage du vendeur
	*/
	public Utilisateur (String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	/*
	 * Constructeur pour la modification de données 
	*/
	public Utilisateur (String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String password, String newPassword) {
		
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse=password;
		this.newPassword=newPassword;
	}
	
	public List<ArticleVendu> getAchat() {
		return achat;
	}


	public void setAchat(List<ArticleVendu> achat) {
		this.achat = achat;
	}


	public List<ArticleVendu> getVente() {
		return vente;
	}


	public void setVente(List<ArticleVendu> vente) {
		this.vente = vente;
	}


	public List<Enchere> getEnchere() {
		return enchere;
	}


	public void setEnchere(List<Enchere> enchere) {
		this.enchere = enchere;
	}



	
	public Utilisateur(String login, String mail, String password) {
		this.pseudo=login;
		this.email=mail;
		this.motDePasse=password;
		}


		public Utilisateur(String pseudo) {
			this.pseudo=pseudo;
		}
	
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public byte getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(byte administrateur) {
		this.administrateur = administrateur;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}


	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}


	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}



	
}
