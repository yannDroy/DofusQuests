package gui.panel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.MatteBorder;

import domain.Achievement;
import domain.ApplicationData;
import gui.IConfigGUI;
import gui.label.SubSuccessLabel;
import gui.label.SuccessLabel;
import gui.listener.SubSuccessMouseListener;
import gui.listener.SuccessMouseListener;

public class SuccessesPanel extends AchievementListPanel {

	private static final long serialVersionUID = -3199110611287063156L;

	/** Subsuccesses labels list */
	private static Map<String, List<SubSuccessLabel>> subsuccessesLabels;
	
	/** Current opened success */
	private static SuccessLabel openedSuccess;

	/** Current opened subsuccess */
	private static SubSuccessLabel openedSubsuccess;

	public SuccessesPanel() {
		super();
		
		this.setBackground(IConfigGUI.BACKGROUND_COLOR_TREE_PANEL);
		this.setBorder(new MatteBorder(2, 4, 4, 2, IConfigGUI.BLACK_BORDER_COLOR));

		subsuccessesLabels = new LinkedHashMap<String, List<SubSuccessLabel>>();
		openedSuccess = null;
		openedSubsuccess = null;

		buildPanel(null);
	}

	public void buildPanel(Achievement nullAchievement) {
		ApplicationData data = ApplicationData.getInstance();
		
		final Map<String, Achievement> successes = data.getSuccesses();
		final Map<String, Map<String, Achievement>> subsuccesses = data.getSubsuccesses();

		for(final Map.Entry<String, Achievement> suc : successes.entrySet()){
			final String idSuc = suc.getKey();

			final SuccessLabel sucLabel = new SuccessLabel(suc.getValue());

			this.add(sucLabel);
			
			sucLabel.addMouseListener(new SuccessMouseListener(sucLabel));

			if(subsuccesses.containsKey(idSuc)){
				for(final Map.Entry<String, Achievement> sub : subsuccesses.get(idSuc).entrySet()){
					final SubSuccessLabel subLabel = new SubSuccessLabel(sub.getValue());
					
					subLabel.addMouseListener(new SubSuccessMouseListener(subLabel));

					if(!subsuccessesLabels.containsKey(idSuc))
						subsuccessesLabels.put(idSuc, new ArrayList<SubSuccessLabel>());
					
					subsuccessesLabels.get(idSuc).add(subLabel);
					
					this.add(subLabel);
				}
			}
		}

		this.revalidate();
	}
	
	/**
	 * Getter for the current opened success
	 * @return
	 */
	public static SuccessLabel getOpenedSuccess() {
		return openedSuccess;
	}

	/**
	 * Setter for the opened success
	 * @param openedSubsuccess the new opened success
	 */
	public static void setOpenedSuccess(SuccessLabel openedSuccess) {
		SuccessesPanel.openedSuccess = openedSuccess;
	}

	/**
	 * Getter for the current opened subsuccess
	 * @return
	 */
	public static SubSuccessLabel getOpenedSubsuccess() {
		return openedSubsuccess;
	}

	/**
	 * Setter for the opened subsuccess
	 * @param openedSubsuccess the new opened subsuccess
	 */
	public static void setOpenedSubsuccess(SubSuccessLabel openedSubsuccess) {
		SuccessesPanel.openedSubsuccess = openedSubsuccess;
	}

	/**
	 * Getter for the subsuccesses labels list
	 * @return the subsuccesses labels list
	 */
	public static Map<String, List<SubSuccessLabel>> getSubsuccessesLabels() {
		return subsuccessesLabels;
	}
}
