package fr.eni.Enchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.Enchere.bll.CodesResultatBLL;
import fr.eni.Enchere.bll.EnchereManager;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/Inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		try {
			if (request.getParameter("password") == request.getParameter("confirm_password")) {
				utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
						request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"),
						request.getParameter("rue"), request.getParameter("cp"), request.getParameter("ville"),
						request.getParameter("password"), 0, (byte) 0);
			}else {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatServlet.REGLE_MOT_DE_PASSE_NON_INDENTIQUE);
				throw businessException;
			}
			EnchereManager.getInstance().insertNouvelAdherent(utilisateur);
			HttpSession session = request.getSession();
			session.setAttribute("pseudoConnection", request.getParameter("pseudo")); //TODO
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.jsp");
			rd.forward(request, response);
			
		} catch (BusinessException businessException) {
			businessException.printStackTrace();
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Inscription.jsp");
			rd.forward(request, response);
		}
		

	}

}
