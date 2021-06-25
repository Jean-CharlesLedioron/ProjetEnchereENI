package fr.eni.Enchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.Enchere.bll.EnchereManager;
import fr.eni.Enchere.bo.ArticleVendu;
import fr.eni.Enchere.exception.BusinessException;




/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.getAttribute("pseudo");
		List<ArticleVendu> listeEncheres = new ArrayList<ArticleVendu>();
		try {
			listeEncheres  = EnchereManager.getInstance().selectionnerTousLesEncheres();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeEncheres", listeEncheres);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
		rd.forward(request, response);}
	
		
	

	/**
	

	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//J'affiche toutes les enchères

			
			//Je lis les paramètres et j'affiche les enchères correspondantes
		 
		/**request.getParameter(filtre);
		request.getParameter(categorie);
		String nomArticle = null;
		request.setAttribute("filtre", filtre);
		request.setAttribute("categorie", categorie);
		
		
		
		listeEncheresFiltres = accueilManager.selectionnerLesEncheresCorrespondantes(categorie, filtre, nomArticle);
		
		request.setAttribute("listeEncheresFiltres", listeEncheresFiltres);
		}
				
	}
	
			//Pas d'enchères en cours
	
	catch (BusinessException e) {
	
		e.printStackTrace();
		request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
	}
	*/
		doGet(request, response);
		

			
		
				
				
	}
}