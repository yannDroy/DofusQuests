package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database instance
 * @author yann
 *
 */
public class DatabaseInstance {
	
	/** Singleton of the database */
	private static DatabaseInstance instance = new DatabaseInstance();
	
	/** Connection to the database */
	private Connection connection;
	
	/**
	 * Database constructor
	 */
	private DatabaseInstance() {
		connection = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      connection = DriverManager.getConnection("jdbc:sqlite:dofus_achievements.db");
	    } catch (Exception e) {
	      System.err.println(e.getClass().getName() + ": " + e.getMessage());
	      System.exit(1);
	    }
	}
	
	/**
	 * Closes the connection
	 */
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for the database instance
	 * @return the database instance
	 */
	public static DatabaseInstance getInstance() {
		return instance;
	}

	/**
	 * Getter for the connection to the database
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
