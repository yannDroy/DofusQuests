package gui.listener;

import java.awt.event.MouseEvent;

import gui.GUIWindow;
import gui.label.SubSuccessLabel;
import gui.label.SuccessLabel;
import gui.panel.SuccessesPanel;

/**
 * Success mouse listener
 * @author yann
 *
 */
public class SuccessMouseListener extends AchievementMouseListener {

	/**
	 * Constructor of the success mouse listener
	 */
	public SuccessMouseListener(SuccessLabel success) {
		super(success);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SuccessLabel current = (SuccessLabel) getLabel();
		
		if(e.getButton() == MouseEvent.BUTTON1){
			GUIWindow.getInstance().clearSearch();
			GUIWindow.getInstance().clearChallenges();

			if(SuccessesPanel.getOpenedSuccess() != null){
				String openedId = SuccessesPanel.getOpenedSuccess().getAchievement().getId();

				if(SuccessesPanel.getSubsuccessesLabels().containsKey(openedId)){
					for(SubSuccessLabel sub : SuccessesPanel.getSubsuccessesLabels().get(openedId))
						sub.setVisible(false);
				}

				SuccessesPanel.getOpenedSuccess().setOpened(false);

				if(SuccessesPanel.getOpenedSubsuccess() != null){
					SuccessesPanel.getOpenedSubsuccess().setOpened(false);
					SuccessesPanel.setOpenedSubsuccess(null);
				}

				if(!openedId.equals(current.getAchievement().getId())){
					if(SuccessesPanel.getSubsuccessesLabels().containsKey(current.getAchievement().getId())){
						for(SubSuccessLabel sub : SuccessesPanel.getSubsuccessesLabels().get(current.getAchievement().getId())){
							if(sub.getAchievement().getName().equals("Général")){
								sub.setVisible(false);
								GUIWindow.getInstance().updateChallenges(sub.getAchievement(), true);
							}else{
								sub.setVisible(true);
							}
						}
						
						SuccessesPanel.setOpenedSuccess(current);
						current.setOpened(true);
					}
				}else{
					SuccessesPanel.setOpenedSuccess(null);
				}
			}else{
				if(SuccessesPanel.getOpenedSubsuccess() != null){
					SuccessesPanel.getOpenedSubsuccess().setOpened(false);
					SuccessesPanel.setOpenedSubsuccess(null);
				}

				if(SuccessesPanel.getSubsuccessesLabels().containsKey(current.getAchievement().getId())){
					for(SubSuccessLabel sub : SuccessesPanel.getSubsuccessesLabels().get(current.getAchievement().getId())){
						if(sub.getAchievement().getName().equals("Général")){
							sub.setVisible(false);
							GUIWindow.getInstance().updateChallenges(sub.getAchievement(), true);
						}else{
							sub.setVisible(true);
						}
					}
					
					SuccessesPanel.setOpenedSuccess(current);
					current.setOpened(true);
				}
			}
		}else if(e.getButton() == MouseEvent.BUTTON3){
			
		}
		
		current.setMouseHoverColor(true);
	}
}
