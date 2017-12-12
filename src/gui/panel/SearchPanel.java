package gui.panel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import gui.AchievementCheckBox;
import gui.AchievementSearchField;
import gui.IConfigGUI;

/**
 * Search panel for challenges, quests and subquests
 * @author yann
 *
 */
public class SearchPanel extends JPanel {

	private static final long serialVersionUID = -4325812177583872950L;
	
	/** Search text field */
	private AchievementSearchField searchField;
	
	/** Checkbox for challenges */
	private JCheckBox challengeCheck;
	
	/** Checkbox for quests */
	private JCheckBox questCheck;
	
	/** Checkbox for subquests */
	private JCheckBox subquestCheck;
	
	/**
	 * Search panel constructor
	 */
	public SearchPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setMaximumSize(new Dimension(IConfigGUI.SEARCH_PANEL_WIDTH, IConfigGUI.SEARCH_PANEL_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.SEARCH_PANEL_WIDTH, IConfigGUI.SEARCH_PANEL_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.SEARCH_PANEL_WIDTH, IConfigGUI.SEARCH_PANEL_HEIGHT));
		this.setBackground(IConfigGUI.BACKGROUND_COLOR_SEARCH_PANEL);
		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setAlignmentY(LEFT_ALIGNMENT);
		this.setBorder(new MatteBorder(3, 0, 0, 0, IConfigGUI.BLACK_BORDER_COLOR));
		
		this.setVisible(true);
		
		JLabel text = new JLabel("  Rechercher :  ");
		text.setOpaque(false);
		text.setVisible(true);
		text.setForeground(IConfigGUI.SEARCHLABEL_FONT_COLOR);
		text.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 1, 18));
		
		this.add(text);

		searchField = new AchievementSearchField();
		
		challengeCheck = new AchievementCheckBox("Challenges", searchField);
		questCheck = new AchievementCheckBox("Quêtes", searchField);
		subquestCheck = new AchievementCheckBox("Sous-quêtes", searchField);
		
		this.add(searchField);
		
		this.add(new JLabel("   "));
		
		this.add(challengeCheck);
		this.add(questCheck);
		this.add(subquestCheck);
	}

	/**
	 * Getter for the search field
	 * @return the search field
	 */
	public AchievementSearchField getSearchField() {
		return searchField;
	}
	
	/**
	 * Test if challenges are selected
	 * @return true if yes, false otherwise
	 */
	public boolean isChallengeChecked() {
		return challengeCheck.isSelected();
	}
	
	/**
	 * Test if quests are selected
	 * @return true if yes, false otherwise
	 */
	public boolean isQuestChecked() {
		return questCheck.isSelected();
	}
	
	/**
	 * Test if subquests are selected
	 * @return true if yes, false otherwise
	 */
	public boolean isSubquestChecked() {
		return subquestCheck.isSelected();
	}
}
