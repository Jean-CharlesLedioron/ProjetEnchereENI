package fr.eni.Enchere.dal;

import java.util.List;

import fr.eni.Enchere.exception.BusinessException;
import fr.eni.Enchere.bo.Enchere;

public interface AccueilDAO {

	public List<Enchere> selectAll() throws BusinessException;
	
	public Enchere selectById(String nomArticle);
}


	