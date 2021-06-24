package fr.eni.Enchere.dal;

public abstract class DAOFactory {
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}

	public static AccueilDAO getAccueilDAO() {
		return new AccueilDAOJdbcImpl();
	}
}
