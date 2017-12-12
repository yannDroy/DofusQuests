package domain;

/**
 * Dofus character
 * @author yann
 *
 */
public class Player {
	/** ID of the character */
	private int id;
	
	/** Name of the character */
	private String name;
	
	/**
	 * Player constructor
	 * @param name
	 */
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Getter for the character ID
	 * @return the character ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Getter of the character name
	 * @return the name of the character
	 */
	public String getName() {
		return name;
	}
}
