package domain;

/**
 * Dofus abstract achievement
 * @author yann
 *
 */
public class Achievement {
	/** ID of the achievement */
	private String id;
	
	/** Name of the achievement */
	private String name;
	
	/** ID of the parent */
	private String parentId;
	
	/** Finished boolean */
	private boolean finished;
	
	/**
	 * Abstract achievement constructor
	 * @param id ID of the achievement
	 * @param name name of the achievement
	 */
	public Achievement(String id, String name, String parentId, boolean finished) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.finished = finished;
	}
	
	/**
	 * Getter of the achievement ID
	 * @return the achievement ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter of the achievement name
	 * @return the achievement name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter of the parent ID
	 * @return the parent ID
	 */
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * Getter for the finished boolean
	 * @return true if finished, false otherwise
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Set the achievement as finished
	 * @param finished the finished boolean
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Achievement){
			return ((Achievement) o).getId() == id;
		}
		
		return false;
	}
}
