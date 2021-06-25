package fr.eni.Enchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import fr.eni.Enchere.bo.Categorie;
import fr.eni.Enchere.bo.Retrait;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletCreationEnchere
 */
@WebServlet("/CreationEnchere")
public class ServletCreationEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<String> listeCategorie = EnchereManager.getInstance().retourneListeCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
			HttpSession session = request.getSession();
			Utilisateur adresseRetraitDefault = EnchereManager.getInstance().retourneAdresseRetrait((String) session.getAttribute("pseudo"));
			request.setAttribute("adresse", adresseRetraitDefault);
			} catch (BusinessException businessException) {
				businessException.printStackTrace();
				request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/CreationEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		ArticleVendu enchere = new ArticleVendu(request.getParameter("article"),request.getParameter("description"),
				LocalDateTime.parse(request.getParameter("debutEnchere")),LocalDateTime.parse(request.getParameter("finEnchere")),
				Integer.valueOf(request.getParameter("prix")));
		Categorie categorie =	new Categorie(request.getParameter("categorie"));
		Retrait retrait = new Retrait(request.getParameter("rue"),request.getParameter("cp"), request.getParameter("ville"));
		try {
			EnchereManager.getInstance().creationEnchere(enchere,categorie,retrait,(String) session.getAttribute("pseudo"));
			request.setAttribute("succesCreation", "oui");
		} catch (BusinessException businessException) {
			businessException.printStackTrace();
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
		}
		doGet(request, response);
	}

}
