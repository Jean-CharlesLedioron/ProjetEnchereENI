package fr.eni.Enchere.bll;

import java.util.List;

import fr.eni.Enchere.bo.ArticleVendu;
import fr.eni.Enchere.bo.Categorie;
import fr.eni.Enchere.bo.Retrait;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.dal.DAOFactory;
import fr.eni.Enchere.dal.EnchereDAO;
import fr.eni.Enchere.exception.BusinessException;
import fr.eni.Enchere.servlet.CodesResultatServlet;
import sun.security.krb5.Confounder;

public class EnchereManager {
	private static EnchereManager instance;
	private EnchereDAO enchereDAO;

	public EnchereManager() throws BusinessException {
		enchereDAO = DAOFactory.getEnchereDAO();
	}

	/**
	 * Singleton
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public static synchronized EnchereManager getInstance() throws BusinessException {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	/**
	 * Ajout d'un nouvel adhérent
	 * 
	 * @param utilisateur
	 * @param ConfirmPassword
	 * @throws BusinessException
	 */
	public void insertNouvelAdherent(Utilisateur utilisateur, String confirmPassword) throws BusinessException {
		if (utilisateur.getMotDePasse().equals(confirmPassword)) {
			if (!enchereDAO.verificationMailPseudoDejaUtilise(utilisateur)) {
				enchereDAO.insertNouvelAdherent(utilisateur);
			} else {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_DEJA_UTILISE);
				throw businessException;
			}

		} else {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatBLL.REGLE_MOT_DE_PASSE_NON_INDENTIQUE);
			throw businessException;
		}
	}

	public void propositionEnchere(Utilisateur utilisateur, ArticleVendu article, int propostionEnchere)
			throws BusinessException {
		enchereDAO.encherirSurUnObjet(utilisateur, article, propostionEnchere);
	}

	public Utilisateur retourneAdresseRetrait(String pseudo) throws BusinessException {
		Utilisateur adresseRetrait = enchereDAO.recuperationAdresseByPseudo(pseudo);
		return adresseRetrait;
	}

	public void creationEnchere(ArticleVendu enchere, Categorie categorie, Retrait retrait, String pseudo)
			throws BusinessException {
		enchereDAO.creerEnchere(enchere, categorie, retrait, pseudo);
	}

	public List<String> retourneListeCategorie() throws BusinessException {
		List<String> listeCategorie = enchereDAO.retourneListeCategorie();
		return listeCategorie;
	}

	public ArticleVendu desriptionArticle(Integer noArticle) throws BusinessException {
		ArticleVendu article = enchereDAO.descriptionArticle(noArticle);
		return article;
	}

}
