package gui.listener;

import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import database.DatabaseInsertion;
import domain.ApplicationData;
import gui.label.ChallengeLabel;
import gui.label.QuestLabel;
import gui.label.SubQuestLabel;
import gui.panel.ChallengesPanel;
import gui.panel.ChoicePanel;

/**
 * Challenge mouse listener
 * @author yann
 *
 */
public class ChallengeMouseListener extends AchievementMouseListener {

	/**
	 * Constructor of the challenge mouse listener
	 */
	public ChallengeMouseListener(ChallengeLabel challenge) {
		super(challenge);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ChallengeLabel current = (ChallengeLabel) getLabel();

		if(e.getButton() == MouseEvent.BUTTON1){
			if(ChallengesPanel.getOpenedChallenge() != null){
				String openedId = ChallengesPanel.getOpenedChallenge().getAchievement().getId();

				if(ChallengesPanel.getQuestsLabels().containsKey(openedId)){
					for(QuestLabel que : ChallengesPanel.getQuestsLabels().get(openedId)){
						if(ChallengesPanel.getSubQuestsLabels().containsKey(que.getAchievement().getId())){
							for(SubQuestLabel subque : ChallengesPanel.getSubQuestsLabels().get(que.getAchievement().getId()))
								subque.setVisible(false);
						}

						que.setVisible(false);
					}
				}

				ChallengesPanel.getOpenedChallenge().setOpened(false);

				if(ChallengesPanel.getOpenedQuest() != null){
					ChallengesPanel.getOpenedQuest().setOpened(false);
					ChallengesPanel.setOpenedQuest(null);
				}

				if(!openedId.equals(current.getAchievement().getId())){
					if(ChallengesPanel.getQuestsLabels().containsKey(current.getAchievement().getId())){
						for(QuestLabel que : ChallengesPanel.getQuestsLabels().get(current.getAchievement().getId()))
							que.setVisible(true);

						ChallengesPanel.setOpenedChallenge(current);
						current.setOpened(true);
					}
				}else{
					ChallengesPanel.setOpenedChallenge(null);
				}
			}else{
				if(ChallengesPanel.getOpenedQuest() != null){
					ChallengesPanel.getOpenedQuest().setOpened(false);
					ChallengesPanel.setOpenedQuest(null);
				}

				if(ChallengesPanel.getQuestsLabels().containsKey(current.getAchievement().getId())){
					for(QuestLabel que : ChallengesPanel.getQuestsLabels().get(current.getAchievement().getId()))
						que.setVisible(true);

					ChallengesPanel.setOpenedChallenge(current);
					current.setOpened(true);
				}
			}
		}else if(e.getButton() == MouseEvent.BUTTON3){
			Map<Integer, Integer> checks = new LinkedHashMap<Integer, Integer>();

			ChoicePanel panel = new ChoicePanel(current.getAchievement(), checks);

			int ret = JOptionPane.showConfirmDialog(null, panel, "Édition du challenge", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			if(ret == 0){
				Map<String, Boolean> changes;
				changes = DatabaseInsertion.getInstance().setAchieved(current.getAchievement().getId(), current.getAchievement().getParentId(), checks);

				ApplicationData.getInstance().setFinished(changes);

				if(ChallengesPanel.getQuestsLabels().containsKey(current.getAchievement().getId())){
					for(QuestLabel que : ChallengesPanel.getQuestsLabels().get(current.getAchievement().getId())){
						que.setMouseHoverColor(false);

						if(ChallengesPanel.getSubQuestsLabels().containsKey(que.getAchievement().getId())){
							for(SubQuestLabel sbq : ChallengesPanel.getSubQuestsLabels().get(que.getAchievement().getId()))
								sbq.setMouseHoverColor(false);
						}
					}
				}				
			}
		}

		current.setMouseHoverColor(true);
	}
}
