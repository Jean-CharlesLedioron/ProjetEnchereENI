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
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletModification
 */
@WebServlet(
		urlPatterns = {
		"/Modification",
		"/Supprimer"
		})
public class ServletModification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		String pseudo = (String) session.getAttribute("pseudo");
		Utilisateur utilisateur;
		
	try {
		if(request.getServletPath().equals("/Modification")) {
			
				 utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
						request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"),
						request.getParameter("rue"), request.getParameter("cp"), request.getParameter("ville"),
						request.getParameter("password"), 0, (byte) 0);
			
			EnchereManager.getInstance().modifierCompte(utilisateur, 
					request.getParameter("new_password"),
					request.getParameter("confirm_password"),
					pseudo
					);
			
			
		}else if(request.getServletPath().equals("/Supprimer")) {
			
			List<Integer> listeCodesErreur= new ArrayList<Integer>();
			
			if(listeCodesErreur.size()>0) 
			{
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}
			else 
			{
				
				try 
				{
					EnchereManager.getInstance().supprimerCompte(pseudo);
				}
				catch (BusinessException e) 
				{
					e.printStackTrace();
					request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				}
			}
		}
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Acceuil.jsp");
			rd.forward(request, response);
		} 
		catch (BusinessException businessException) {
			businessException.printStackTrace();
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
			rd.forward(request, response);
		}
		

	}
	
	

}
