package fr.eni.Enchere.dal;

public abstract class CodesResultatDAL {
	/**
	 * la connexion avec la BDD ne se fait pas
	 */
	public static final int PROBLEME_ACCES_BDD=10300;
	
	/**
	 * les informations saisies présente une erreur de format
	 */
	public static final int SAISIE_INCORRECTE=10301;
	
	
	/**
	 * les informations saisies présente une erreur de format
	 */
	public static final int ECHEC_DE_LECTURE_DES_DONNEES=10302;
	
	/**
	 * crédit utilisateur insufissant
	 */
	public static final int CREDIT_UTILISATEUR_INSUFISSANT=10303;
	
	
	/**
	 * une valeur d'enchere plus fort présente
	 */
	public static final int ENCHERE_INSUFFISANTE=10304;
	
	/**
	 * erreur d'écriture de la requete d'enchere
	 */
	public static final int ECHEC_DE_PRISE_EN_COMPTE_DE_L_ENCHERE=10305;
	
	
	/**
	 * Problème lié à la récupération d'adresse
	 */

	public static final int ERREUR_RECUPERATION_ADRESSE = 10306;
	/**
	 * Probleème de lecture de la catégorie
	 */

	public static final int ERREUR_CATEGORIE = 10307;
	/**
	 * Echec de la récupération des information clients
	 */

	public static final int PROBLEME_RECUPERATION_INFOS_CLIENT = 10308;
	/**
	 * Echec de la création d'enchère
	 */

	public static final int ECHEC_CREATION_ENCHERE = 10309;
	
	/**
	 * Echec de la récupération des catégories
	 */

	public static final int ECHEC_RECUPERATION_CATEGORIE = 10310;
	
	/**
	 * Echec de la récupération de l'enchère
	 */

	public static final int ECHEC_RECUPERATION_ENCHERE = 10311;
	/**
	 * Echec de la mise à jour des crédits
	 */
	public static final int ECHEC_PRISE_EN_COMPTE_CREDIT = 10312;
/**
 * Erreur à la lecture des enchere
 */
	public static final int LECTURE_ENCHERE_ECHEC = 10200;
}
