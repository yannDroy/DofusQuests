package gui.panel;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import domain.Achievement;

/**
 * Achievement list panel
 * @author yann
 *
 */
public abstract class AchievementListPanel extends JPanel {

	private static final long serialVersionUID = -8346514664830862822L;

	/**
	 * Achievement panel constructor
	 */
	public AchievementListPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setVisible(true);
	}
	
	public abstract void buildPanel(Achievement parentAchievement);
	
	/**
	 * Removes all the views in the panel
	 */
	public void clearPanel() {
		this.removeAll();
	}
}
