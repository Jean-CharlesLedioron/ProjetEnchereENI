package fr.eni.Enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.dal.DAOFactory;
import fr.eni.Enchere.dal.EnchereDAO;
import fr.eni.Enchere.exception.BusinessException;

public class EnchereManager {
	private static EnchereManager instance;
	private EnchereDAO enchereDAO;
	
	public EnchereManager() throws BusinessException {
		enchereDAO= DAOFactory.getEnchereDAO();
	}
	
/**
 * Singleton
 * @return
 * @throws BusinessException
 */
	public static synchronized EnchereManager getInstance() throws BusinessException{
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

/**
 * Ajout d'un nouvel adhérent
 * @param utilisateur
 * @throws BusinessException
 */
	public void insertNouvelAdherent(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();
			if (!enchereDAO.verificationMailPseudoDejaUtilise(utilisateur)) {
				enchereDAO.insertNouvelAdherent(utilisateur);
			}else {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_DEJA_UTILISE);
				throw businessException;
			}
	}

public Utilisateur connexionByPseudoOrMail(Utilisateur user) throws BusinessException {
	Utilisateur utilisateur = enchereDAO.verificationByPseudoAndMail(user);
	return utilisateur;
}

public Utilisateur recuperationPseudoSession(Utilisateur user) throws BusinessException {
	Utilisateur pseudo = enchereDAO.recuperationPseudo(user);		
	return pseudo;
}



}
