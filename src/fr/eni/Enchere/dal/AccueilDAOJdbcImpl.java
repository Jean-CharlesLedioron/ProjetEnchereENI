package fr.eni.Enchere.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.Enchere.exception.BusinessException;
import fr.eni.Enchere.bo.Enchere;



public class AccueilDAOJdbcImpl implements AccueilDAO {

	private static final String SELECT_ALL=" SELECT " +
										"a.date_fin_enchere " +
										"a.nom_article"+
										"a.prix_initial"+
										"a.no_article"+
										"u.pseudo"+
										"e.montant_enchere"+
										"FROM" + 
										"ARTICLES_VENDUS a" + 
										"INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur"+
										"LEFT JOIN ( SELECT MAX(montant_enchere) as montant_enchere ,no_article"+
										"FROM ENCHERES GROUP BY no_article) e ON e.no_article=a.no_article";
	;
	
	
		//Récupérer toutes les enchères en cours
	
	@Override
	public List<Enchere> selectAll() throws BusinessException{
		
			List<Enchere> listeEncheres = new ArrayList<Enchere>();
			try(Connection cnx = ConnectionProvider.getConnection())
			{
				Statement stmt = cnx.createStatement();
			
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				Enchere enchere = null;
				while(rs.next())
					{
					LocalDate dateFin = rs.getDate("date_fin_enchere").toLocalDate();
					String nomArticle = rs.getString("nom_article");
					String pseudo = rs.getString("pseudo");
					int prixInitial = rs.getInt("prix_initial");
					int montantEnchere = rs.getInt("montant_enchere");
					int noArticle = rs.getInt("no_article");
					
					enchere = new Enchere(dateFin,nomArticle,pseudo,prixInitial,montantEnchere,noArticle);
					
					listeEncheres.add(enchere);
				
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_ENCHERE_ECHEC);
				throw businessException;
			}
			return listeEncheres;
	}

			// Récuperer certaines encheres selon les filtres
	
	public Enchere selectById(String nomArticle) {
		return null;
	}



}

