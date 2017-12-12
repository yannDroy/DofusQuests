package gui.listener;

import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import database.DatabaseInsertion;
import domain.ApplicationData;
import gui.AchievementSearchField;
import gui.GUIWindow;
import gui.label.AchievementLabel;
import gui.panel.ChoicePanel;

/**
 * Search label mouse listener
 * @author yann
 *
 */
public class SearchLabelMouseListener extends AchievementMouseListener {

	/** Search field */
	private AchievementSearchField search;
	
	/**
	 * Constructor of the search label mouse listener
	 */
	public SearchLabelMouseListener(AchievementLabel achievement, AchievementSearchField search) {
		super(achievement);
		
		this.search = search;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		AchievementLabel current = getLabel();
		
		if(e.getButton() == MouseEvent.BUTTON1){
			//TODO ??????
		}else if(e.getButton() == MouseEvent.BUTTON3){
			Map<Integer, Integer> checks = new LinkedHashMap<Integer, Integer>();

			ChoicePanel panel = new ChoicePanel(current.getAchievement(), checks);

			int ret = -1;
			
			if(current.getAchievement().getId().contains("SUB-"))
				ret = JOptionPane.showConfirmDialog(null, panel, "Édition du sous-succès", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			else if(current.getAchievement().getId().contains("CHA-"))
				ret = JOptionPane.showConfirmDialog(null, panel, "Édition du challenge", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			else if(current.getAchievement().getId().contains("QUE-"))
				ret = JOptionPane.showConfirmDialog(null, panel, "Édition de la quête", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			else if(current.getAchievement().getId().contains("SBQ-"))
				ret = JOptionPane.showConfirmDialog(null, panel, "Édition de la sous-quête", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if(ret == 0){
				Map<String, Boolean> changes;
				changes = DatabaseInsertion.getInstance().setAchieved(current.getAchievement().getId(), current.getAchievement().getParentId(), checks);
				
				ApplicationData.getInstance().setFinished(changes);
				
				GUIWindow.getInstance().getRightPanel().getChallengesScrollPane().getChallengesPanel().filterDeleteChar(search.getText());
			}
		}
		
		current.setMouseHoverColor(true);
	}
}
