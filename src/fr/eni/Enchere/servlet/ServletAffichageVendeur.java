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

import fr.eni.Enchere.bll.EnchereManager;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletAffichageVendeur
 */
@WebServlet("/ServletAffichageVendeur")
public class ServletAffichageVendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudoVendeur="";
		List<Integer> listeCodesErreur=new ArrayList<>();
		try
		{
			pseudoVendeur = request.getParameter("pseudo");
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlet.FORMAT_NO_UTILISATEUR_ERREUR);
		}
			
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			try {
				EnchereManager enchereManager =new EnchereManager();
				Utilisateur vendeur;
				vendeur = enchereManager.afficherVendeur(pseudoVendeur);
				request.setAttribute("pseudo", vendeur);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pageProfil.jsp");
		rd.forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
