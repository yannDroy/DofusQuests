package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import gui.IConfigGUI;
import gui.label.TitleLabel;


/**
 * Represents the challenges
 * @author yann
 *
 */
public class RightPanel extends JPanel {

	private static final long serialVersionUID = -3199110611287063156L;
	
	/** Title label */
	private TitleLabel title;
	
	/** Information panel */
	private ChallengesScrollPane challengesScrollPane;
	
	/** Search bar */
	private SearchPanel searchPanel;
	
	/**
	 * Constructor of the challenge panel
	 */
	public RightPanel() {
		this.setPreferredSize(new Dimension(IConfigGUI.RIGHT_PANEL_WIDTH, IConfigGUI.RIGHT_PANEL_HEIGHT));
		this.setBackground(IConfigGUI.BACKGROUND_COLOR_RIGHT_PANEL);
		this.setVisible(true);
		this.setBorder(new MatteBorder(4, 4, 4, 4, IConfigGUI.BLACK_BORDER_COLOR));
		this.setLayout(new BorderLayout());

		buildPanel();
		
		this.add(title, BorderLayout.NORTH);
		this.add(challengesScrollPane, BorderLayout.CENTER);
		this.add(searchPanel, BorderLayout.SOUTH);
	}

	/**
	 * Builds the panel
	 */
	private void buildPanel() {
		title = new TitleLabel("Succès");
		challengesScrollPane = new ChallengesScrollPane();
		searchPanel = new SearchPanel();
	}

	/**
	 * Getter for the information panel
	 * @return the information panel
	 */
	public ChallengesScrollPane getChallengesScrollPane() {
		return challengesScrollPane;
	}

	/**
	 * Getter for the search panel
	 * @return the search panel
	 */
	public SearchPanel getSearchPanel() {
		return searchPanel;
	}
}
