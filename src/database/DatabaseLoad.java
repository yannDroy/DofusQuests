package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.Achievement;
import domain.Player;

/**
 * Loads the database content
 * @author yann
 *
 */
public class DatabaseLoad {

	/** Database instance */
	private static DatabaseInstance databaseInstance = DatabaseInstance.getInstance();

	/**
	 * Loads the players
	 * @return the players list
	 */
	public static Map<Integer, Player> loadPlayers() {
		Map<Integer, Player> players = null;

		try {
			players = new LinkedHashMap<Integer, Player>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Player ORDER BY id";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				int id = set.getInt(1);
				String name = set.getString(2);

				players.put(id, new Player(id, name));
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return players;
	}

	/**
	 * Loads the successes
	 * @return the successes list
	 */
	public static Map<String, Achievement> loadSuccesses() {
		Map<String, Achievement> successes = null;

		try {
			successes = new LinkedHashMap<String, Achievement>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Achievement WHERE id LIKE 'SUC%'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				String id = set.getString(1);
				String name = set.getString(2);

				Achievement success = new Achievement(id, name, null, false);

				successes.put(id, success);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return successes;
	}

	/**
	 * Loads the subsuccesses
	 * @return the subsuccesses list
	 */
	public static Map<String, Map<String, Achievement>> loadSubsuccesses() {
		Map<String, Map<String, Achievement>> subsuccesses = null;

		try {
			subsuccesses = new LinkedHashMap<String, Map<String, Achievement>>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Achievement WHERE id LIKE 'SUB%'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				String id = set.getString(1);
				String name = set.getString(2);
				String success = set.getString(3);
				int finished = set.getInt(4);

				Achievement subsuccess;

				if(finished == 0)
					subsuccess = new Achievement(id, name, success, false);
				else
					subsuccess = new Achievement(id, name, success, true);

				if(!subsuccesses.containsKey(success))
					subsuccesses.put(success, new LinkedHashMap<String, Achievement>());

				subsuccesses.get(success).put(id, subsuccess);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return subsuccesses;
	}

	/**
	 * Loads the challenges
	 * @return the challenges list
	 */
	public static Map<String, Map<String, Achievement>> loadChallenges() {
		Map<String, Map<String, Achievement>> challenges = null;

		try {
			challenges = new LinkedHashMap<String, Map<String, Achievement>>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Achievement WHERE id LIKE 'CHA%'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				String id = set.getString(1);
				String name = set.getString(2);
				String subsuccess = set.getString(3);
				int finished = set.getInt(4);

				Achievement challenge;

				if(finished == 0)
					challenge = new Achievement(id, name, subsuccess, false);
				else
					challenge = new Achievement(id, name, subsuccess, true);

				if(!challenges.containsKey(subsuccess))
					challenges.put(subsuccess, new LinkedHashMap<String, Achievement>());

				challenges.get(subsuccess).put(id, challenge);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return challenges;
	}

	/**
	 * Loads the quests
	 * @return the quests list
	 */
	public static Map<String, Map<String, Achievement>> loadQuests() {
		Map<String, Map<String, Achievement>> quests = null;

		try {
			quests = new LinkedHashMap<String, Map<String, Achievement>>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Achievement WHERE id LIKE 'QUE%'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				String id = set.getString(1);
				String name = set.getString(2);
				String challenge = set.getString(3);
				int finished = set.getInt(4);

				Achievement quest;

				if(finished == 0)
					quest = new Achievement(id, name, challenge, false);
				else
					quest = new Achievement(id, name, challenge, true);

				if(!quests.containsKey(challenge))
					quests.put(challenge, new LinkedHashMap<String, Achievement>());

				quests.get(challenge).put(id, quest);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return quests;
	}

	/**
	 * Loads the subquests
	 * @return the subquests list
	 */
	public static Map<String, Map<String, Achievement>> loadSubquests() {
		Map<String, Map<String, Achievement>> subquests = null;

		try {
			subquests = new LinkedHashMap<String, Map<String, Achievement>>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT * FROM Achievement WHERE id LIKE 'SBQ%'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				String id = set.getString(1);
				String name = set.getString(2);
				String quest = set.getString(3);
				int finished = set.getInt(4);

				Achievement subquest;

				if(finished == 0)
					subquest = new Achievement(id, name, quest, false);
				else
					subquest = new Achievement(id, name, quest, true);

				if(!subquests.containsKey(quest))
					subquests.put(quest, new LinkedHashMap<String, Achievement>());

				subquests.get(quest).put(id, subquest);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return subquests;
	}

	/**
	 * Gets the players who achieved the achievement with ID id
	 * @param id the ID of the achievement
	 * @return
	 */
	public static List<Integer> getWhoAchieved(String id) {
		List<Integer> who = null;

		try {
			who = new ArrayList<Integer>();

			Connection c = databaseInstance.getConnection();
			Statement stmt = c.createStatement();

			String sql = "SELECT Player.id FROM Achieved, Player"
					+ " WHERE Player.id = Achieved.player"
					+ " AND Achieved.achievement LIKE '" + id + "'";

			ResultSet set = stmt.executeQuery(sql);

			while(set.next()){
				int playerId = set.getInt(1);

				who.add(playerId);
			}

			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return who;
	}
}
