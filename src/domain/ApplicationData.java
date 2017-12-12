package domain;

import java.util.Map;

import database.DatabaseLoad;

/**
 * Contains the application data
 * @author yann
 *
 */
public class ApplicationData {
	/** Application data instance */
	private static ApplicationData instance = new ApplicationData();

	/** Successes list */
	private Map<String, Achievement> successes;

	/** Subsuccesses list */
	private Map<String, Map<String, Achievement>> subsuccesses;

	/** Challenges list */
	private Map<String, Map<String, Achievement>> challenges;

	/** Quests list */
	private Map<String, Map<String, Achievement>> quests;

	/** Subquests list */
	private Map<String, Map<String, Achievement>> subquests;

	/** Characters list */
	private Map<Integer, Player> players;

	/**
	 * Application data constructor
	 */
	private ApplicationData() {
		players = DatabaseLoad.loadPlayers();
		successes = DatabaseLoad.loadSuccesses();
		subsuccesses = DatabaseLoad.loadSubsuccesses();
		challenges = DatabaseLoad.loadChallenges();
		quests = DatabaseLoad.loadQuests();
		subquests = DatabaseLoad.loadSubquests();
	}

	public void setFinished(Map<String, Boolean> changes) {
		String success = null;
		String subsuccess = null;
		for(Map.Entry<String, Boolean> c : changes.entrySet()){
			if(c.getKey().contains("SUC-")){
				success = c.getKey();
			}else if(c.getKey().contains("SUB-")){
				subsuccess = c.getKey();
			}

			if(success != null && subsuccess != null)
				break;
		}

		if(success != null && subsuccess != null){
			for(Map.Entry<String, Achievement> sub : subsuccesses.get(success).entrySet()){
				if(sub.getKey().equals(subsuccess)){
					if(changes.get(subsuccess))
						sub.getValue().setFinished(true);
					else
						sub.getValue().setFinished(false);

					if(challenges.containsKey(subsuccess)){
						for(Map.Entry<String, Achievement> cha : challenges.get(subsuccess).entrySet()){
							if(changes.containsKey(cha.getKey())){
								if(changes.get(cha.getKey()))
									cha.getValue().setFinished(true);
								else
									cha.getValue().setFinished(false);
							}

							if(quests.containsKey(cha.getKey())){
								for(Map.Entry<String, Achievement> que : quests.get(cha.getKey()).entrySet()){
									if(changes.containsKey(que.getKey())){
										if(changes.get(que.getKey()))
											que.getValue().setFinished(true);
										else
											que.getValue().setFinished(false);
									}

									if(subquests.containsKey(que.getKey())){
										for(Map.Entry<String, Achievement> sbq : subquests.get(que.getKey()).entrySet()){
											if(changes.containsKey(sbq.getKey())){
												if(changes.get(sbq.getKey()))
													sbq.getValue().setFinished(true);
												else
													sbq.getValue().setFinished(false);
											}
										}
									}
								}
							}
						}
					}

					break;
				}
			}
		}
	}

	/**
	 * Getter for application data instance
	 * @return the instance of application data
	 */
	public static ApplicationData getInstance() {
		return instance;
	}

	/**
	 * Getter for successes list
	 * @return the successes list
	 */
	public Map<String, Achievement> getSuccesses() {
		return successes;
	}

	/**
	 * Getter for subsuccesses list
	 * @return the subsuccesses list
	 */
	public Map<String, Map<String, Achievement>> getSubsuccesses() {
		return subsuccesses;
	}

	/**
	 * Getter for challenges list
	 * @return the challenges list
	 */
	public Map<String, Map<String, Achievement>> getChallenges() {
		return challenges;
	}

	/**
	 * Getter for quests list
	 * @return the quests list
	 */
	public Map<String, Map<String, Achievement>> getQuests() {
		return quests;
	}

	/**
	 * Getter for subquests list
	 * @return the subquests list
	 */
	public Map<String, Map<String, Achievement>> getSubquests() {
		return subquests;
	}

	/**
	 * Getter for players list
	 * @return the players list
	 */
	public Map<Integer, Player> getPlayers() {
		return players;
	}
}
