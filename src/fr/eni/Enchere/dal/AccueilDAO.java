package fr.eni.Enchere.dal;

import java.util.List;

import fr.eni.Accueil.Exception.BusinessException;
import fr.eni.Accueil.bo.Enchere;

public interface AccueilDAO {

	public List<Enchere> selectAll() throws BusinessException;
	
	public Enchere selectById(String nomArticle);
}


	