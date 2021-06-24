package fr.eni.Enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
	
	
	
	private static final String VERIFICATION_CONNEXION = "SELECT pseudo FROM UTILISATEURS WHERE (email=? or pseudo=?) AND mot_de_passe=? ";
	
	private static final String MODIFICATION_COMPTE="UPDATE utilisateurs SET ? WHERE pseudo=?";
//	private static final String MODIFICATION_COMPTE_PSEUDO="UPDATE utilisateurs SET pseudo= ? WHERE email=?";
	
	
	private static final String SUPPRIMER_COMPTE="DELETE FROM utilisateurs WHERE pseudo=? ";
	
	private static final String AFFICHE_VENDEUR_PAR_ID=  "SELECT pseudo"
			+ ",nom"
			+ ",prenom"
			+ ",email"
			+ ",telephone"
			+ ",rue"
			+ ",code_postal"
			+ ",ville FROM utilisateurs WHERE pseudo =?";
	

	/**
	 * Inscription d'un nouvel adh�rent
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
//		int noUtilisateur = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String cp = rs.getString("code_postal");
		String ville = rs.getString("ville");
//		String mdp = rs.getString("mot_de_passe");
//		int credit = rs.getInt("credit");
//		byte admin = rs.getByte("administrateur");
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville); 
		return utilisateur;
	/**
	 * SelectByPseudo et SelectByEmail pour v�rifier que l'utilisateur n'existe pas d�j�	
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
			e.printStackTrace();
		}
		return dejaInscrit;
	}
	
	/**
	 * Modification du compte	
	 */
	@Override
	public void modifierCompte(Utilisateur utilisateur, String newPassword, String pseudo) throws BusinessException {
		try(Connection conex2 = ConnectionProvider.getConnection();)
		
		{
			StringBuilder sql=new StringBuilder();
			
			if(!(utilisateur.getPseudo()==null)&& !verificationMailPseudoDejaUtilise(utilisateur))
				{
					sql.append("pseudo="+utilisateur.getPseudo()+",");
				
				}
				else if(!(utilisateur.getEmail()==null)&& !verificationMailPseudoDejaUtilise(utilisateur)) 
				{
					sql.append("email="+utilisateur.getEmail()+",");
				}
				
				else if(!(utilisateur.getNom()==null)) 
				{
					sql.append("nom="+utilisateur.getNom()+",");
				}
				else if(!(utilisateur.getPrenom()==null)) 
				{
					sql.append("prenom="+utilisateur.getPrenom()+",");
				}
				
				else if(!(utilisateur.getTelephone()==null)) 
				{
					sql.append("telephone="+utilisateur.getTelephone()+",");
				}
				else if(!(utilisateur.getRue()==null)) 
				{
					sql.append("rue="+utilisateur.getRue()+",");
				}
				else if(!(utilisateur.getCodePostal()==null)) 
				{
					sql.append("code_postal="+utilisateur.getCodePostal()+",");
				}
				else if(!(utilisateur.getVille()==null)) 
				{
					sql.append("ville="+utilisateur.getVille()+",");
				}
				else if(!((utilisateur.getMotDePasse())==null))
				{
					utilisateur.setMotDePasse(newPassword);
					String changePassword=utilisateur.getMotDePasse();
					sql.append("mot_de_passe="+changePassword);
				}
				
			PreparedStatement stmt=conex2.prepareStatement(MODIFICATION_COMPTE);
			stmt.setString(1, sql.toString());
			stmt.setString(2, pseudo);
			stmt.executeUpdate();
			stmt.close();
					
		}catch (Exception e){
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SAISIE_INCORRECTE);
			throw businessException;
		}
	
	/**
	 * Suppression du compte	
	*/
	}
	@Override
	public void supprimerCompte(String pseudo) throws BusinessException {
		try (Connection conex2 = ConnectionProvider.getConnection();
				 PreparedStatement stmt= conex2.prepareStatement(SUPPRIMER_COMPTE);)
		{
			stmt.setString(1, pseudo);
			stmt.executeUpdate();
		} catch (Exception e) {
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_IMPOSSIBLE);
			throw businessException;
		}
	}
	
	/*
	 * Affichage des données du vendeur
	 * */
	@Override
	public Utilisateur afficherVendeur(String pseudoVendeur) throws BusinessException {
		Utilisateur id= new Utilisateur();
		try(Connection conex2 = ConnectionProvider.getConnection();
				PreparedStatement stmt= conex2.prepareStatement(AFFICHE_VENDEUR_PAR_ID);){
				stmt.setString(1, pseudoVendeur);
			try(ResultSet rs= stmt.executeQuery()){
				if(rs.next()) {
					id=mappingUtilisateur(rs);
				}
			}
		}catch (Exception e){
			BusinessException businessException =new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.AFFICHE_IMPOSSIBLE);
			throw businessException;
		}
		return id;
		
	}
	@Override
	public Utilisateur verificationByPseudoAndMail(Utilisateur user) throws BusinessException {
		boolean connexionVerifie=false;
		Utilisateur utilisateur = new Utilisateur();
		String pseudo = null;
		try (Connection con = ConnectionProvider.getConnection(); PreparedStatement pstmt = con.prepareStatement(VERIFICATION_CONNEXION)) {
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPseudo());
			pstmt.setString(3, user.getMotDePasse());
			ResultSet rs = pstmt.executeQuery();
			connexionVerifie = rs.next();
			if(connexionVerifie) {
				pseudo = rs.getString("pseudo");
				utilisateur = new Utilisateur(pseudo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	@Override
	public Utilisateur recuperationPseudo(Utilisateur user) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	

}

