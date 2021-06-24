package fr.eni.Enchere.dal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {




	private static DataSource dataSource;
	
	/**
	 * Au chargement de la classe, la DataSource est recherchï¿½e dans l'arbre JNDI
	 */
	static
	{
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}
	
	/**
	 * Cette mï¿½thode retourne une connection opï¿½rationnelle issue du pool de connexion
	 * vers la base de donnï¿½es. 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	
	}

}
