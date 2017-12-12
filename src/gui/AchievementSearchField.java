package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import gui.listener.SearchListener;

/**
 * Search field to search among achievements
 * @author yann
 *
 */
public class AchievementSearchField extends JTextField {

	private static final long serialVersionUID = 5012444077022181660L;
	
	public static String valueBeforeChanged;

	/**
	 * Search field constructor
	 */
	public AchievementSearchField() {
		this.setMaximumSize(new Dimension(IConfigGUI.SEARCHBAR_WIDTH, IConfigGUI.SEARCHBAR_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.SEARCHBAR_WIDTH, IConfigGUI.SEARCHBAR_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.SEARCHBAR_WIDTH, IConfigGUI.SEARCHBAR_HEIGHT));
		this.setVisible(true);
		this.setOpaque(true);
		this.setBorder(null);
		this.setBackground(IConfigGUI.SEARCHBAR_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.SEARCHBAR_FONT_COLOR);
		this.setFont(new Font(IConfigGUI.FONT_FREE_SERIF, 0, 18));
		this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(2, 5, 2, 5)));
		
		this.getDocument().addDocumentListener(new SearchListener(this));
		
		valueBeforeChanged = "";
	}
	
	/**
	 * Clears the search field
	 */
	public void clearSearch() {
		this.setText("");
	}
}
