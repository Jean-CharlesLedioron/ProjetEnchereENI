package fr.eni.Enchere.dal;

import java.util.List;

import fr.eni.Enchere.bo.ArticleVendu;
import fr.eni.Enchere.bo.Categorie;
import fr.eni.Enchere.bo.Retrait;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

public interface EnchereDAO {
	
	public void insertNouvelAdherent(Utilisateur utilisateur) throws BusinessException;

	public List<Utilisateur> selectListeUtilisateurs() throws BusinessException;

	public boolean verificationMailPseudoDejaUtilise(Utilisateur utilisateur) throws BusinessException;

	public void encherirSurUnObjet(Utilisateur utilisateur, ArticleVendu article, int propostionEnchere) throws BusinessException;

	public Utilisateur recuperationAdresseByPseudo(String pseudo) throws BusinessException;

	public void creerEnchere(ArticleVendu enchere, Categorie categorie, Retrait retrait, String pseudo)throws BusinessException;

	public List<String> retourneListeCategorie() throws BusinessException;

	public ArticleVendu descriptionArticle(Integer noArticle) throws BusinessException;

	
	public Utilisateur verificationByPseudoAndMail(Utilisateur user) throws BusinessException;

	public List<ArticleVendu> selectAllEnchere() throws BusinessException;

	//public Utilisateur recuperationPseudo(Utilisateur user) throws BusinessException; Théo

	public Utilisateur recuperationPseudo(Utilisateur user) throws BusinessException;
	
	public void modifierCompte(Utilisateur utilisateur, String newPassword, String pseudo) throws BusinessException;
	
	public void supprimerCompte(String pseudo) throws BusinessException;
	
	public Utilisateur afficherVendeur(String pseudoVendeur) throws BusinessException;
}
