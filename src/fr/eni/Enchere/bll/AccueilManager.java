package fr.eni.Enchere.bll;



import java.util.ArrayList;
import java.util.List;

import fr.eni.Accueil.Exception.BusinessException;
import fr.eni.Accueil.bo.Enchere;
import fr.eni.Accueil.dal.DAOFactory;
import fr.eni.Accueil.dal.AccueilDAO;

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
