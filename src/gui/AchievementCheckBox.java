package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

/**
 * Checkbox for filtering achievements
 * @author yann
 *
 */
public class AchievementCheckBox extends JCheckBox {

	private static final long serialVersionUID = 8988475609591144970L;

	/**
	 * Checkbox constructor
	 */
	public AchievementCheckBox(String text, final AchievementSearchField search) {
		super(text);
		
		this.setSelected(true);
		this.setBackground(IConfigGUI.BACKGROUND_COLOR_SEARCH_PANEL);
		this.setForeground(IConfigGUI.SEARCHLABEL_FONT_COLOR);
		this.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 0, 14));
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GUIWindow.getInstance().getRightPanel().getChallengesScrollPane().getChallengesPanel().filterDeleteChar(search.getText());
			}
		});
	}
}
