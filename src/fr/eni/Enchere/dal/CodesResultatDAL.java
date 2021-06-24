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
	 * Echec de suppression du compte
	 */
	public static final int SUPPRESSION_IMPOSSIBLE=10005;
	
	/**
	 * Echec de L'affichage de l'utilisateur 
	 */
	public static final int AFFICHE_IMPOSSIBLE = 10009;
	
	public static final int LECTURE_ENCHERE_ECHEC = 0;
	
}
