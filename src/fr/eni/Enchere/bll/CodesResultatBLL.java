package fr.eni.Enchere.bll;

public abstract class CodesResultatBLL {

	/**
	 * Echec de la cr�aton de compte adh�rent car pseudo d�j� utilis�
	 */
	public static final int REGLE_PSEUDO_DEJA_UTILISE=20001;
	
	/**
	 * Echec de la modification du mot de passe. le mots de passe ne correspondent pas 
	 */
	public static final int REGLE_COINCIDENCE_MOTDEPASSE=20105;
}
