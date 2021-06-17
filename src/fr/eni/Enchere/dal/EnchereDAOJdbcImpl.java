package fr.eni.Enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

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
			e.printStackTrace();
		}
		return dejaInscrit;
	}

}
