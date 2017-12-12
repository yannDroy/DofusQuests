package gui.label;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domain.Achievement;

/**
 * Achievement label
 * @author yann
 *
 */
public abstract class AchievementLabel extends JLabel {

	private static final long serialVersionUID = -4655988039066836947L;

	/** The achievement being displayed */
	private Achievement achievement;
	
	/** Test if the achievement is opened */
	private boolean opened;
	
	/**
	 * Achievement label constructor
	 */
	public AchievementLabel(Achievement achievement) {
		this.achievement = achievement;
		this.opened = false;
		
		this.setText(achievement.getName());
		this.setOpaque(true);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setVisible(true);
	}
	
	/**
	 * Sets the appropriate color when the label is clicked
	 */
	public abstract void setMouseClickedColor();
	
	/**
	 * Sets the appropriate color when the label is released
	 */
	public abstract void setMouseReleasedColor();
	
	/**
	 * Sets the appropriate color when the label is pressed
	 */
	public abstract void setMousePressedColor();
	
	/**
	 * Sets the appropriate color when the label is hovered
	 */
	public abstract void setMouseHoverColor(boolean enter);
	
	/**
	 * Getter of the achievement
	 * @return the success
	 */
	public Achievement getAchievement() {
		return achievement;
	}

	/**
	 * Getter for the opened boolean
	 * @return the opened boolean
	 */
	public boolean isOpened() {
		return opened;
	}
	
	/**
	 * Setter for the opened boolean
	 * @param opened the new boolean
	 */
	public void setOpened(boolean opened) {
		this.opened = opened;
		
		if(opened)
			setMouseClickedColor();
		else
			setMouseReleasedColor();
	}
}
