package fr.eni.Enchere.dal;

public abstract class CodesResultatDAL {
	/**
	 * la connexion avec la BDD ne se fait pas
	 */
	public static final int PROBLEME_ACCES_BDD=10000;
	
	/**
	 * les informations saisies pr�sente une erreur de format
	 */
	public static final int SAISIE_INCORRECTE=10001;
	
	
	/**
	 * les informations saisies pr�sente une erreur de format
	 */
	public static final int ECHEC_DE_LECTURE_DES_DONNEES=10002;
	
	/**
	 * cr�dit utilisateur insufissant
	 */
	public static final int CREDIT_UTILISATEUR_INSUFISSANT=10003;
	
	
	/**
	 * une valeur d'enchere plus fort pr�sente
	 */
	public static final int ENCHERE_INSUFFISANTE=10004;
	
	/**
	 * erreur d'�criture de la requete d'enchere
	 */
	public static final int ECHEC_DE_PRISE_EN_COMPTE_DE_L_ENCHERE=10005;
	
	
	/**
	 * Probl�me li� � la r�cup�ration d'adresse
	 */

	public static final int ERREUR_RECUPERATION_ADRESSE = 10006;
	/**
	 * Proble�me de lecture de la cat�gorie
	 */

	public static final int ERREUR_CATEGORIE = 10007;
	/**
	 * Echec de la r�cup�ration des information clients
	 */

	public static final int PROBLEME_RECUPERATION_INFOS_CLIENT = 10008;
	/**
	 * Echec de la cr�ation d'ench�re
	 */

	public static final int ECHEC_CREATION_ENCHERE = 10009;
	
	/**
	 * Echec de la r�cup�ration des cat�gories
	 */

	public static final int ECHEC_RECUPERATION_CATEGORIE = 10010;
	
	/**
	 * Echec de la r�cup�ration de l'ench�re
	 */

	public static final int ECHEC_RECUPERATION_ENCHERE = 10011;
}
