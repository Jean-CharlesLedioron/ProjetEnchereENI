package fr.eni.Enchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.Enchere.bll.EnchereManager;
import fr.eni.Enchere.bo.ArticleVendu;
import fr.eni.Enchere.bo.Enchere;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletVisualisationEnchere
 */
@WebServlet("/Enchere")
public class ServletVisualisationEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = 6;
		HttpSession session = request.getSession();
		session.setAttribute("objetEnchere", id);
		session.setAttribute("pseudo", "Diego");
		request.getParameter("objetEnchere");
		try {
			ArticleVendu article = EnchereManager.getInstance().desriptionArticle((Integer) session.getAttribute("objetEnchere"));
			request.setAttribute("article", article);
			for (Enchere enchere : article.getEnchere()) {
				request.setAttribute("meilleureEnchere", enchere);
			}
		} catch (BusinessException businessException) {
			businessException.printStackTrace();
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Enchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = new Utilisateur((String) session.getAttribute("pseudo"));
		ArticleVendu article = new ArticleVendu((Integer) session.getAttribute("objetEnchere"));
		int propostionEnchere = Integer.valueOf(request.getParameter("propositionEnchere"));
		try {
			EnchereManager.getInstance().propositionEnchere(utilisateur,article,propostionEnchere);
			request.setAttribute("succesEnchere", "oui");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Enchere.jsp");
			rd.forward(request, response);
		} catch (BusinessException businessException) {
			businessException.printStackTrace();
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Enchere.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
