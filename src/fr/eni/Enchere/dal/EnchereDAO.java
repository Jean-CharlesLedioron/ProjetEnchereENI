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

	

}
