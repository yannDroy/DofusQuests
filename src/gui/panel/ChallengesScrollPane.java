package gui.panel;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import gui.IConfigGUI;

/**
 * Displays the challenges and quests
 * @author yann
 *
 */
public class ChallengesScrollPane extends JScrollPane {
	
	private static final long serialVersionUID = -5187449302850290709L;
	
	/**
	 * Challenge panel
	 */
	private ChallengesPanel challengesPanel;

	/**
	 * Constructor of the information panel
	 */
	public ChallengesScrollPane() {
		this.setPreferredSize(new Dimension(IConfigGUI.CHALLENGES_PANEL_WIDTH, IConfigGUI.CHALLENGES_PANEL_HEIGHT));
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		this.getVerticalScrollBar().setUnitIncrement(15);
		this.setViewportBorder(null);
		this.setBorder(null);
		
		challengesPanel = new ChallengesPanel();
		
		this.setViewportView(challengesPanel);
	}
	
	/**
	 * Sets (updates) the viewport
	 */
	public void setViewport(boolean scroll) {
		this.setViewportView(challengesPanel);
		
		if(scroll)
			this.getVerticalScrollBar().setValue(0);
	}

	/**
	 * Getter for the challenge panel
	 * @return the challenge panel
	 */
	public ChallengesPanel getChallengesPanel() {
		return challengesPanel;
	}
}
