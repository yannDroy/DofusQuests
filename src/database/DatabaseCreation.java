package database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Creation of the database
 * @author yann
 *
 */
public class DatabaseCreation {

	/** Database instance */
	private static DatabaseInstance database;

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]) {
		database = DatabaseInstance.getInstance();
		
		System.out.println("Reseting the database ...\n");

		if(dropTables() != 0){
			System.out.println("Error during table deletion");
			System.exit(1);
		}
		if(createTables() != 0){
			System.out.println("Error during table creation");
			System.exit(1);
		}
		
		System.out.println("Database created !\n");
	}
	
	/**
	 * Create the tables
	 * @return 0 if success, 1 otherwise
	 */
	private static int createTables() {
		System.out.println("Creating tables in the database ...");
		
		String sqlCharacter = "CREATE TABLE Player ("
				+ "id INT NOT NULL,"
				+ "name VARCHAR(256) NOT NULL,"
				+ "CONSTRAINT PK_CHARACTER PRIMARY KEY (id)"
				+ ")";
		String sqlAchievement = "CREATE TABLE Achievement ("
				+ "id VARCHAR(8) NOT NULL,"
				+ "name VARCHAR(256) NOT NULL,"
				+ "parent VARCHAR(16) DEFAULT NULL,"
				+ "finished INT NOT NULL DEFAULT 0,"
				+ "CONSTRAINT PK_ABSTRACT_ACHIEVEMENT PRIMARY KEY (id),"
				+ "CONSTRAINT FK_PARENT FOREIGN KEY (parent) REFERENCES Achievement (id)"
				+ ")";
		String sqlAchieved = "CREATE TABLE Achieved ("
				+ "player INT NOT NULL,"
				+ "achievement VARCHAR(16) NOT NULL,"
				+ "CONSTRAINT PK_ACHIEVED PRIMARY KEY (player, achievement),"
				+ "CONSTRAINT REF_CHARACTER FOREIGN KEY (player) REFERENCES Player(id),"
				+ "CONSTRAINT REF_OBJECT_ACHIEVEMENT FOREIGN KEY (achievement) REFERENCES Achievement(id)"
				+ ")";
		
		if(createTable("Player", sqlCharacter) != 0){
			System.out.println("Error creating CHARACTER table");
			return 1;
		}
		if(createTable("Achievement", sqlAchievement) != 0){
			System.out.println("Error creating ACHIEVEMENT table");
			return 1;
		}
		if(createTable("Achieved", sqlAchieved) != 0){
			System.out.println("Error creating ACHIEVED table");
			return 1;
		}

		System.out.println("Tables created successfully!\n");

		return 0;
	}
	
	/**
	 * Creates a table
	 * @param name the name of the table
	 * @param sql the sql request to create the table
	 * @return 0 if success, 1 otherwise
	 */
	private static int createTable(String name, String sql) {
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			stmt.executeUpdate(sql);
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}

		System.out.println("Table " + name.toUpperCase() + " created successfully");

		return 0;
	}

	/**
	 * Drops all the tables from the database
	 * @return 0 if success, 1 otherwise
	 */
	private static int dropTables() {
		System.out.println("Deleting tables from database ...");
		
		if(drop("Achieved") != 0){
			System.out.println("Error deleting ACHIEVED table");
			return 1;
		}
		if(drop("Achievement") != 0){
			System.out.println("Error deleting ACHIEVEMENT table");
			return 1;
		}
		if(drop("Player") != 0){
			System.out.println("Error deleting PLAYER table");
			return 1;
		}

		System.out.println("Tables deleted successfully!\n");

		return 0;
	}
	
	/**
	 * Drops one table
	 * @param table the table name
	 * @return 0 if success, 1 otherwise
	 */
	private static int drop(String table) {
		try {
			Connection c = database.getConnection();
			Statement stmt = c.createStatement();

			String sql = "DROP TABLE IF EXISTS " + table;

			stmt.executeUpdate(sql);
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}

		System.out.println("Table " + table.toUpperCase() + " deleted successfully");

		return 0;
	}
}
