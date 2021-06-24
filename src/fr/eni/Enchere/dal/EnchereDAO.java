package fr.eni.Enchere.dal;

import java.util.List;

import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

public interface EnchereDAO {
	
	public void insertNouvelAdherent(Utilisateur utilisateur) throws BusinessException;

	public List<Utilisateur> selectListeUtilisateurs() throws BusinessException;

	public boolean verificationMailPseudoDejaUtilise(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur verificationByPseudoAndMail(Utilisateur user) throws BusinessException;

	public Utilisateur recuperationPseudo(Utilisateur user) throws BusinessException;

}
