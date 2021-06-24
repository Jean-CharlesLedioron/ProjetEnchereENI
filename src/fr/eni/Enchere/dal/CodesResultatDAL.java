package fr.eni.Enchere.dal;

public abstract class CodesResultatDAL {
	/**
	 * la connexion avec la BDD ne se fait pas
	 */
	public static final int PROBLEME_ACCES_BDD=10300;
	
	/**
	 * les informations saisies pr�sente une erreur de format
	 */
	public static final int SAISIE_INCORRECTE=10301;
	
	
	/**
	 * les informations saisies pr�sente une erreur de format
	 */
	public static final int ECHEC_DE_LECTURE_DES_DONNEES=10302;
	
	/**
	 * cr�dit utilisateur insufissant
	 */
	public static final int CREDIT_UTILISATEUR_INSUFISSANT=10303;
	
	
	/**
	 * une valeur d'enchere plus fort pr�sente
	 */
	public static final int ENCHERE_INSUFFISANTE=10304;
	
	/**
	 * erreur d'�criture de la requete d'enchere
	 */
	public static final int ECHEC_DE_PRISE_EN_COMPTE_DE_L_ENCHERE=10305;
	
	
	/**
	 * Probl�me li� � la r�cup�ration d'adresse
	 */

	public static final int ERREUR_RECUPERATION_ADRESSE = 10306;
	/**
	 * Proble�me de lecture de la cat�gorie
	 */

	public static final int ERREUR_CATEGORIE = 10307;
	/**
	 * Echec de la r�cup�ration des information clients
	 */

	public static final int PROBLEME_RECUPERATION_INFOS_CLIENT = 10308;
	/**
	 * Echec de la cr�ation d'ench�re
	 */

	public static final int ECHEC_CREATION_ENCHERE = 10309;
	
	/**
	 * Echec de la r�cup�ration des cat�gories
	 */

	public static final int ECHEC_RECUPERATION_CATEGORIE = 10310;
	
	/**
	 * Echec de la r�cup�ration de l'ench�re
	 */

	public static final int ECHEC_RECUPERATION_ENCHERE = 10311;
	/**
	 * Echec de la mise � jour des cr�dits
	 */
	public static final int ECHEC_PRISE_EN_COMPTE_CREDIT = 10312;
/**
 * Erreur � la lecture des enchere
 */
	public static final int LECTURE_ENCHERE_ECHEC = 10200;
}
