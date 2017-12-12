package gui.listener;

import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import database.DatabaseInsertion;
import domain.ApplicationData;
import gui.label.SubQuestLabel;
import gui.panel.ChoicePanel;

/**
 * Subquest mouse listener
 * @author yann
 *
 */
public class SubQuestMouseListener extends AchievementMouseListener {

	/**
	 * Constructor of the subquest mouse listener
	 */
	public SubQuestMouseListener(SubQuestLabel subquest) {
		super(subquest);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SubQuestLabel current = (SubQuestLabel) getLabel();

		if(e.getButton() == MouseEvent.BUTTON3){
			Map<Integer, Integer> checks = new LinkedHashMap<Integer, Integer>();
			
			ChoicePanel panel = new ChoicePanel(current.getAchievement(), checks);
			
			int ret = JOptionPane.showConfirmDialog(null, panel, "Édition de la sous-quête", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(ret == 0){
				Map<String, Boolean> changes;
				changes = DatabaseInsertion.getInstance().setAchieved(current.getAchievement().getId(), current.getAchievement().getParentId(), checks);
				
				ApplicationData.getInstance().setFinished(changes);
			}
		}

		current.setMouseHoverColor(true);
	}
}
