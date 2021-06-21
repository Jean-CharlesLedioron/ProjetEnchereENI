package fr.eni.Enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import fr.eni.Enchere.bo.ArticleVendu;
import fr.eni.Enchere.bo.Categorie;
import fr.eni.Enchere.bo.Retrait;
import fr.eni.Enchere.bo.Utilisateur;
import fr.eni.Enchere.exception.BusinessException;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_NOUVEL_ADHERENT = "INSERT INTO UTILISATEURS" + 
			"           (pseudo" + 
			"           ,nom" + 
			"           ,prenom" + 
			"           ,email" + 
			"           ,telephone" + 
			"           ,rue" + 
			"           ,code_postal" + 
			"           ,ville" + 
			"           ,mot_de_passe" + 
			"           ,credit" + 
			"           ,administrateur)" + 
			"     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_LISTE_UTILISATEURS = "SELECT * FROM UTILISATEURS";
	
	private static final String RECHERCHE_UTILISATEUR_BY_EMAIL_OR_PSEUDO = "SELECT * FROM UTILISATEURS WHERE email=? or pseudo=? ";
	
	private static final String SELECT_MONTANT_ENCHERE_ACTUEL = "SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article=? GROUP BY montant_enchere ";
	
	private static final String SELECT_NUMERO_UTILISATEUR_ET_CREDIT_BY_PSEUDO = "SELECT no_utilisateur,credit FROM UTILISATEURS WHERE pseudo=? ";
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERE VALUES (?,?,?,?)";
	
	private static final String SELECT_ADRESSE_BY_PSEUDO = "SELECT pseudo, rue, code_postal, ville FROM UTILISATEURS WHERE pseudo=? ";
	
	private static final String INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLES_VENDUS VALUES(?,?,?,?,?,null,?,?)";
	
	private static final String SELECT_CATEGORIES = "SELECT * FROM CATEGORIES WHERE libelle=? ";
	
	private static final String INSERT_POINT_RETRAIT = "INSERT INTO RETRAIT VALUES(?,?,?,?)";
	
	

	/**
	 * Inscription d'un nouvel adhérent
	 */
	@Override
	public void insertNouvelAdherent(Utilisateur utilisateur) throws BusinessException {
		try(Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_NOUVEL_ADHERENT)) {
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setByte(11, utilisateur.getAdministrateur());
			pstmt.executeUpdate();
		} catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SAISIE_INCORRECTE);
			throw businessException;
		}
		
	}
/**
 * renvoie une liste de tout les utilisateurs
 */
	@Override
	public List<Utilisateur> selectListeUtilisateurs() throws BusinessException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		try(Connection con = ConnectionProvider.getConnection(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECT_LISTE_UTILISATEURS);
			while (rs.next()) {
				Utilisateur utilisateur = mappingUtilisateur(rs);
				listeUtilisateur.add(utilisateur);
			}
		} catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.PROBLEME_ACCES_BDD);
			throw businessException;
		}
		return listeUtilisateur;
	}
	
	
	/**
	 * Mapping complet pour reconstruire un utilisateur avec toute les infos
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Utilisateur mappingUtilisateur (ResultSet rs) throws SQLException {
		int noUtilisateur = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String cp = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String mdp = rs.getString("mot_de_passe");
		int credit = rs.getInt("credit");
		byte admin = rs.getByte("administrateur");
		Utilisateur utilisateur = new Utilisateur(noUtilisateur,pseudo,nom,prenom,email,telephone,rue,cp,ville,mdp,credit,admin);
		return utilisateur;
	/**
	 * SelectByPseudo et SelectByEmail pour vérifier que l'utilisateur n'existe pas déjà	
	 */
	}
	@Override
	public boolean verificationMailPseudoDejaUtilise(Utilisateur utilisateur) throws BusinessException {
		boolean dejaInscrit=false;
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(RECHERCHE_UTILISATEUR_BY_EMAIL_OR_PSEUDO)) {
			pstmt.setString(1, utilisateur.getEmail());
			pstmt.setString(2, utilisateur.getPseudo());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dejaInscrit =true;
			}
		} catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.ECHEC_DE_LECTURE_DES_DONNEES);
			throw businessException;
		}
		return dejaInscrit;
	}
	@Override
	public void encherirSurUnObjet(Utilisateur utilisateur, ArticleVendu article, int propositionEnchere)
			throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(SELECT_MONTANT_ENCHERE_ACTUEL);
				PreparedStatement pstmt2 = con.prepareStatement(SELECT_NUMERO_UTILISATEUR_ET_CREDIT_BY_PSEUDO); PreparedStatement pstmt3 = con.prepareStatement(INSERT_ENCHERE)) {
			pstmt.setInt(1, article.getNoArticle());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (propositionEnchere > rs.getInt("montant_enchere")) {
				pstmt2.setString(1, utilisateur.getPseudo());
				ResultSet rs2 = pstmt2.executeQuery();
				rs2.next();
				if (propositionEnchere<= rs2.getInt("credit")) {
					pstmt3.setInt(1, rs2.getInt("no_utilisateur"));
					pstmt3.setInt(2, article.getNoArticle());
					pstmt3.setDate(3, Date.valueOf(LocalDate.now()));
					pstmt3.setInt(4, propositionEnchere);
				}
				else {
					BusinessException businessException =new BusinessException();
					businessException.ajouterErreur(CodesResultatDAL.CREDIT_UTILISATEUR_INSUFISSANT);
					throw businessException;
				}
				}else {
					BusinessException businessException =new BusinessException();
					businessException.ajouterErreur(CodesResultatDAL.ENCHERE_INSUFFISANTE);
					throw businessException;
				}
		}catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.ECHEC_DE_PRISE_EN_COMPTE_DE_L_ENCHERE);
			throw businessException;
		}
				
		
	}
	@Override
	public Utilisateur recuperationAdresseByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(SELECT_ADRESSE_BY_PSEUDO))	{	
				pstmt.setString(1, pseudo);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				utilisateur = new Utilisateur(pseudo,rue,cp,ville);
		} catch (SQLException e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.ERREUR_RECUPERATION_ADRESSE);
			throw businessException;
		}		
				return utilisateur;
				
	}
	@Override
	public void creerEnchere(ArticleVendu enchere, Categorie categorie, Retrait retrait, String pseudo)
			throws BusinessException {
		
		try (Connection con = ConnectionProvider.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLE_VENDU, PreparedStatement.RETURN_GENERATED_KEYS );
				PreparedStatement pstmt2 = con.prepareStatement(INSERT_POINT_RETRAIT)){
		Utilisateur utilisateur = noUtilisateurEtCreditByPseudo(pseudo,con);
		Categorie categorieEtLibelle = categorieByLibelle(categorie,con);
		pstmt.setString(1, enchere.getNomArticle());
		pstmt.setString(2, enchere.getDescription());
		pstmt.setDate(3, Date.valueOf(enchere.getDateDebutEnchere()));
		pstmt.setDate(4, Date.valueOf(enchere.getDateFinEnchere()));
		pstmt.setInt(5, enchere.getPrixInitial());
		pstmt.setInt(6, utilisateur.getNoUtilisateur());
		pstmt.setInt(7, categorieEtLibelle.getNoCategorie());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		rs.next();
		Integer noArticle = (rs.getInt(1));
		rs.close();
		pstmt2.setInt(1, noArticle);
		pstmt2.setNString(2, retrait.getRue());
		pstmt2.setNString(2, retrait.getCodePostal());
		pstmt2.setNString(2, retrait.getVille());
		pstmt2.executeUpdate();
		} catch (SQLException e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.ECHEC_CREATION_ENCHERE);
			throw businessException;
		}
		
	}
	

	
	private Categorie categorieByLibelle(Categorie categorie, Connection con) throws BusinessException {
		try (PreparedStatement pstmt = con.prepareStatement(SELECT_CATEGORIES)){
			pstmt.setString(1, categorie.getLibelle());
			ResultSet rs = pstmt.executeQuery();
			rs.next(); 
			Integer noCategorie = rs.getInt("no_categorie");
			rs.close();
			Categorie categorieEtLibelle = new Categorie(noCategorie,categorie.getLibelle());
			return categorieEtLibelle;
		} catch (SQLException e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.ERREUR_CATEGORIE);
			throw businessException;
		}
	}
	private Utilisateur noUtilisateurEtCreditByPseudo(String pseudo, Connection con) throws BusinessException {
		try (PreparedStatement pstmt = con.prepareStatement(SELECT_NUMERO_UTILISATEUR_ET_CREDIT_BY_PSEUDO)){
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Integer noUtilisateur = rs.getInt("no_utilisateur");
			Integer credit =rs.getInt("credit");
			rs.close();
			Utilisateur utilisateur = new Utilisateur(noUtilisateur,pseudo,credit);
			return utilisateur;
		} catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.PROBLEME_RECUPERATION_INFOS_CLIENT);
			throw businessException;
		}
		
	}

}
