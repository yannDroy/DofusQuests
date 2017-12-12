package gui.listener;

import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import database.DatabaseInsertion;
import domain.ApplicationData;
import gui.label.QuestLabel;
import gui.label.SubQuestLabel;
import gui.panel.ChallengesPanel;
import gui.panel.ChoicePanel;

/**
 * Quest mouse listener
 * @author yann
 *
 */
public class QuestMouseListener extends AchievementMouseListener {

	/**
	 * Constructor of the quest mouse listener
	 */
	public QuestMouseListener(QuestLabel quest) {
		super(quest);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		QuestLabel current = (QuestLabel) getLabel();

		if(e.getButton() == MouseEvent.BUTTON1){
			if(ChallengesPanel.getOpenedQuest() != null){
				String openedId = ChallengesPanel.getOpenedQuest().getAchievement().getId();

				if(ChallengesPanel.getSubQuestsLabels().containsKey(openedId)){
					for(SubQuestLabel subque : ChallengesPanel.getSubQuestsLabels().get(openedId))
						subque.setVisible(false);
				}

				ChallengesPanel.getOpenedQuest().setOpened(false);

				if(!openedId.equals(current.getAchievement().getId())){
					if(ChallengesPanel.getSubQuestsLabels().containsKey(current.getAchievement().getId())){
						for(SubQuestLabel subque : ChallengesPanel.getSubQuestsLabels().get(current.getAchievement().getId()))
							subque.setVisible(true);

						ChallengesPanel.setOpenedQuest(current);
						current.setOpened(true);
					}
				}else{
					ChallengesPanel.setOpenedQuest(null);
				}
			}else{
				if(ChallengesPanel.getSubQuestsLabels().containsKey(current.getAchievement().getId())){
					for(SubQuestLabel subque : ChallengesPanel.getSubQuestsLabels().get(current.getAchievement().getId()))
						subque.setVisible(true);

					ChallengesPanel.setOpenedQuest(current);
					current.setOpened(true);
				}
			}
		}else if (e.getButton() == MouseEvent.BUTTON3){
			Map<Integer, Integer> checks = new LinkedHashMap<Integer, Integer>();

			ChoicePanel panel = new ChoicePanel(current.getAchievement(), checks);

			int ret = JOptionPane.showConfirmDialog(null, panel, "Édition de la quête", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if(ret == 0){
				Map<String, Boolean> changes;
				changes = DatabaseInsertion.getInstance().setAchieved(current.getAchievement().getId(), current.getAchievement().getParentId(), checks);

				ApplicationData.getInstance().setFinished(changes);

				if(ChallengesPanel.getSubQuestsLabels().containsKey(current.getAchievement().getId())){
					for(SubQuestLabel sbq : ChallengesPanel.getSubQuestsLabels().get(current.getAchievement().getId()))
						sbq.setMouseHoverColor(false);
				}
			}
		}

		current.setMouseHoverColor(true);
	}
}
