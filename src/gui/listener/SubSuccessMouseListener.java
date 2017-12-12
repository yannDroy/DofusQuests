package gui.listener;

import java.awt.event.MouseEvent;

import gui.GUIWindow;
import gui.label.SubSuccessLabel;
import gui.panel.SuccessesPanel;

/**
 * Subsuccess mouse listener
 * @author yann
 *
 */
public class SubSuccessMouseListener extends AchievementMouseListener {

	/**
	 * Constructor of the subsuccess mouse listener
	 */
	public SubSuccessMouseListener(SubSuccessLabel subsuccess) {
		super(subsuccess);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SubSuccessLabel current = (SubSuccessLabel) getLabel();

		if(e.getButton() == MouseEvent.BUTTON1){
			GUIWindow.getInstance().clearSearch();
			GUIWindow.getInstance().clearChallenges();

			if(SuccessesPanel.getOpenedSubsuccess() != null){
				String openedId = SuccessesPanel.getOpenedSubsuccess().getAchievement().getId();

				SuccessesPanel.getOpenedSubsuccess().setOpened(false);

				if(!openedId.equals(current.getAchievement().getId())){
					SuccessesPanel.setOpenedSubsuccess(current);
					current.setOpened(true);

					GUIWindow.getInstance().updateChallenges(current.getAchievement(), true);
				}else{
					SuccessesPanel.setOpenedSubsuccess(null);

					for(SubSuccessLabel sub : SuccessesPanel.getSubsuccessesLabels().get(SuccessesPanel.getOpenedSuccess().getAchievement().getId())){
						if(sub.getAchievement().getName().equals("Général"))
							GUIWindow.getInstance().updateChallenges(sub.getAchievement(), true);
					}
				}
			}else{
				SuccessesPanel.setOpenedSubsuccess(current);
				current.setOpened(true);

				GUIWindow.getInstance().updateChallenges(current.getAchievement(), true);
			}		
		}else if (e.getButton() == MouseEvent.BUTTON3){
//			Map<Integer, Integer> checks = new LinkedHashMap<Integer, Integer>();
//
//			ChoicePanel panel = new ChoicePanel(current.getAchievement(), checks);
//
//			int ret = JOptionPane.showConfirmDialog(null, panel, "Édition du sous-succès", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//			if(ret == 0){
//				Map<String, Boolean> changes;
//				changes = DatabaseInsertion.getInstance().setAchieved(current.getAchievement().getId(), current.getAchievement().getParentId(), checks);
//				
//				ApplicationData.getInstance().setFinished(changes);
//				
//				if(current.isOpened())
//					GUIWindow.getInstance().updateChallenges(current.getAchievement(), false);
//			}
		}

		current.setMouseHoverColor(true);
	}
}
