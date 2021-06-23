package fr.eni.Enchere.dal;

public abstract class CodesResultatDAL {
	/**
	 * la connexion avec la BDD ne se fait pas
	 */
	public static final int PROBLEME_ACCES_BDD=10000;
	
	/**
	 * les informations saisies présente une erreur de format
	 */
	public static final int SAISIE_INCORRECTE=10001;
	
	
	/**
	 * les informations saisies présente une erreur de format
	 */
	public static final int ECHEC_DE_LECTURE_DES_DONNEES=10002;
	
	/**
	 * crédit utilisateur insufissant
	 */
	public static final int CREDIT_UTILISATEUR_INSUFISSANT=10003;
	
	
	/**
	 * une valeur d'enchere plus fort présente
	 */
	public static final int ENCHERE_INSUFFISANTE=10004;
	
	/**
	 * erreur d'écriture de la requete d'enchere
	 */
	public static final int ECHEC_DE_PRISE_EN_COMPTE_DE_L_ENCHERE=10005;
	
	
	/**
	 * Problème lié à la récupération d'adresse
	 */

	public static final int ERREUR_RECUPERATION_ADRESSE = 10006;
	/**
	 * Probleème de lecture de la catégorie
	 */

	public static final int ERREUR_CATEGORIE = 10007;
	/**
	 * Echec de la récupération des information clients
	 */

	public static final int PROBLEME_RECUPERATION_INFOS_CLIENT = 10008;
	/**
	 * Echec de la création d'enchère
	 */

	public static final int ECHEC_CREATION_ENCHERE = 10009;
	
	/**
	 * Echec de la récupération des catégories
	 */

	public static final int ECHEC_RECUPERATION_CATEGORIE = 10010;
	
	/**
	 * Echec de la récupération de l'enchère
	 */

	public static final int ECHEC_RECUPERATION_ENCHERE = 10011;
}
