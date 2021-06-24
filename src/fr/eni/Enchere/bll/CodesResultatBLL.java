package fr.eni.Enchere.bll;

public abstract class CodesResultatBLL {

	
	/**
	 * Mot de passe et confirmation de mot de passe non indentique
	 * 
	 */
	public static final int REGLE_MOT_DE_PASSE_NON_INDENTIQUE=20300;
	/**
	 * Echec de la cr�aton de compte adh�rent car pseudo d�j� utilis�
	 */
	public static final int REGLE_PSEUDO_DEJA_UTILISE=20301;
	
	
	/**
	 * Echec de la modification du mot de passe. le mots de passe ne correspondent pas 
	 */
	public static final int REGLE_COINCIDENCE_MOTDEPASSE=20105;
}
