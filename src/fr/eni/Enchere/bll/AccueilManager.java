package fr.eni.Enchere.bll;



import java.util.ArrayList;
import java.util.List;

import fr.eni.Enchere.exception.BusinessException;
import fr.eni.Enchere.bo.Enchere;
import fr.eni.Enchere.dal.DAOFactory;
import fr.eni.Enchere.dal.AccueilDAO;

public class AccueilManager {

	private AccueilDAO accueilDAO;
		
		public AccueilManager() {
			this.accueilDAO=DAOFactory.getAccueilDAO();
		}
		
			//Toutes les enchères en cours
			
	
		public List<Enchere> selectionnerTousLesEncheres() throws BusinessException {
			
		BusinessException exception = new BusinessException();
		
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		
		if(!exception.hasErreurs()) 
		{
			try {
				listeEncheres = accueilDAO.selectAll();
				
			} 
			catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(exception.hasErreurs()) {
			
			throw exception;
		}
		
		
		return listeEncheres;
	}


		

			//Encheres selon filtre
	

		//public Enchere selectionnerLesEncheresCorrespondantes(String categorie, String filtre, String nomArticle) throws BusinessException {
		//	return this.accueilDAO.selectById(nomArticle);}

}
