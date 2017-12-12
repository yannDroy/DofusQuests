package gui.listener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.AchievementSearchField;
import gui.GUIWindow;

/**
 * Listener for the search bar
 * @author yann
 *
 */
public class SearchListener implements DocumentListener {
	
	/** The search field */
	private JTextField search;
	
	public SearchListener(JTextField search) {
		this.search = search;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}

	@Override
	public void insertUpdate(DocumentEvent e) {
		GUIWindow.getInstance().getRightPanel().getChallengesScrollPane().getChallengesPanel().filterAddChar(search.getText());
		AchievementSearchField.valueBeforeChanged = search.getText();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		GUIWindow.getInstance().getRightPanel().getChallengesScrollPane().getChallengesPanel().filterDeleteChar(search.getText());
		AchievementSearchField.valueBeforeChanged = search.getText();
	}

}
