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
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mail = request.getParameter("pseudo");
		String password = request.getParameter("password");
		
		Utilisateur user = new Utilisateur(pseudo, mail, password);	
		HttpSession session = request.getSession();
		
		if(pseudo != null || mail != null && password != null) {
			try {
				Utilisateur utilisateur = EnchereManager.getInstance().connexionByPseudoOrMail(user);
					if (utilisateur.getPseudo() != null) {
					session.setAttribute("pseudo", utilisateur.getPseudo());
					RequestDispatcher rf = request.getRequestDispatcher("/WEB-INF/loginsucces.jsp");
					rf.forward(request, response);

				} else {
					session.setAttribute("listeErreur", "Login ou mot de passe incorrect");
					
					RequestDispatcher rf = request.getRequestDispatcher("/WEB-INF/Connexion.jsp");
					rf.forward(request, response);

				}
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} 
		}


}
