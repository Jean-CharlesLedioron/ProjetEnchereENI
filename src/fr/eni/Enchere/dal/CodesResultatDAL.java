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
}
