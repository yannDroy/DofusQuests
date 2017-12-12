package gui.panel;

import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.Achievement;
import domain.ApplicationData;
import gui.AchievementSearchField;
import gui.GUIWindow;
import gui.IConfigGUI;
import gui.label.ChallengeLabel;
import gui.label.QuestLabel;
import gui.label.SearchResultLabel;
import gui.label.SubQuestLabel;
import gui.listener.ChallengeMouseListener;
import gui.listener.QuestMouseListener;
import gui.listener.SearchLabelMouseListener;
import gui.listener.SubQuestMouseListener;

/**
 * The panel where challenges are displayed
 * @author yann
 *
 */
public class ChallengesPanel extends AchievementListPanel {

	private static final long serialVersionUID = 1374306352611655887L;

	/** Challenge labels list */
	private static List<ChallengeLabel> challengesLabels;

	/** Quest labels list */
	private static Map<String, List<QuestLabel>> questsLabels;

	/** Subquest labels list */
	private static Map<String, List<SubQuestLabel>> subquestsLabels;

	/** Search result labels */
	private List<SearchResultLabel> searchLabels;

	/** Backup of the panel */
	private Component[] backup;

	/** Current opened challenge */
	private static ChallengeLabel openedChallenge;

	/** Current opened quest */
	private static QuestLabel openedQuest;

	/**
	 * Constructor of the challenge panel
	 */
	public ChallengesPanel() {
		super();

		this.setBackground(IConfigGUI.BACKGROUND_COLOR_CHALLENGE_PANEL);
		this.setVisible(true);

		challengesLabels = null;
		questsLabels = null;
		subquestsLabels = null;

		openedChallenge = null;
		openedQuest = null;

		this.searchLabels = null;
		this.backup = null;
	}

	/**
	 * Builds the panel
	 */
	public void buildPanel(Achievement subsuccess) {
		clearPanel();

		challengesLabels = new ArrayList<ChallengeLabel>();
		questsLabels = new LinkedHashMap<String, List<QuestLabel>>();
		subquestsLabels = new LinkedHashMap<String, List<SubQuestLabel>>();

		ApplicationData data = ApplicationData.getInstance();
		final Map<String, Map<String, Achievement>> challenges = data.getChallenges();
		final Map<String, Map<String, Achievement>> quests = data.getQuests();
		final Map<String, Map<String, Achievement>> subquests = data.getSubquests();

		ChallengeLabel chaLabel = null;

		if(challenges.containsKey(subsuccess.getId())){
			for(final Map.Entry<String, Achievement> cha : challenges.get(subsuccess.getId()).entrySet()){
				final String challengeId = cha.getKey();
				chaLabel = new ChallengeLabel(cha.getValue());

				challengesLabels.add(chaLabel);

				this.add(chaLabel);

				chaLabel.addMouseListener(new ChallengeMouseListener(chaLabel));

				if(quests.containsKey(challengeId)){
					for(final Map.Entry<String, Achievement> que : quests.get(challengeId).entrySet()){
						final String questId = que.getKey();
						final QuestLabel queLabel = new QuestLabel(que.getValue());

						if(!questsLabels.containsKey(challengeId))
							questsLabels.put(challengeId, new ArrayList<QuestLabel>());

						questsLabels.get(challengeId).add(queLabel);

						this.add(queLabel);

						queLabel.addMouseListener(new QuestMouseListener(queLabel));

						if(subquests.containsKey(questId)){
							for(final Map.Entry<String, Achievement> subque : subquests.get(questId).entrySet()){
								final SubQuestLabel subqueLabel = new SubQuestLabel(subque.getValue());

								if(!subquestsLabels.containsKey(questId))
									subquestsLabels.put(questId, new ArrayList<SubQuestLabel>());

								subquestsLabels.get(questId).add(subqueLabel);

								this.add(subqueLabel);

								subqueLabel.addMouseListener(new SubQuestMouseListener(subqueLabel));
							}
						}
					}
				}
			}
		}

		this.revalidate();
	}

	/**
	 * Filters the challenges with the search input when removing a character
	 * @param search
	 */
	public void filterDeleteChar(String search) {
		if(search.length() >= 4){
			boolean chaCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isChallengeChecked();
			boolean queCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isQuestChecked();
			boolean subqueCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isSubquestChecked();

			for(SearchResultLabel l : searchLabels){
				if(l.getAchievement().getId().contains("CHA-")){
					if(chaCheck){
						if(!l.isVisible() && l.getAchievement().getName().toLowerCase().contains(search.toLowerCase()))
							l.setVisible(true);
					}else{
						l.setVisible(false);
					}
				}else if(l.getAchievement().getId().contains("QUE-")){
					if(queCheck){
						if(!l.isVisible() && l.getAchievement().getName().toLowerCase().contains(search.toLowerCase()))
							l.setVisible(true);
					}else{
						l.setVisible(false);
					}
				}else{
					if(subqueCheck){
						if(!l.isVisible() && l.getAchievement().getName().toLowerCase().contains(search.toLowerCase()))
							l.setVisible(true);
					}else{
						l.setVisible(false);
					}
				}

				l.setMouseReleasedColor();
			}

			this.revalidate();
		}else if(search.length() == 3){
			clearPanel();

			this.revalidate();
		}else if(search.length() > 0){
			if(AchievementSearchField.valueBeforeChanged.length() > 3){
				clearPanel();
				this.revalidate();
			}
			
			for(Component c : backup)
				this.add(c);

			this.revalidate();
		}else{
			if(AchievementSearchField.valueBeforeChanged.length() > 3){
				clearPanel();
				this.revalidate();
			}
			
			if(this.getComponentCount() == 0){
				for(Component c : backup)
					this.add(c);
				this.revalidate();
			}
			
			backup = null;
		}
	}

	/**
	 * Filters the challenges with the search input when adding a character
	 * @param search
	 */
	public void filterAddChar(String search) {
		if(search.length() == 4){
			clearPanel();

			this.searchLabels = new ArrayList<SearchResultLabel>();

			ApplicationData data = ApplicationData.getInstance();

			boolean chaCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isChallengeChecked();
			boolean queCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isQuestChecked();
			boolean subqueCheck = GUIWindow.getInstance().getRightPanel().getSearchPanel().isSubquestChecked();

			final Map<String, Map<String, Achievement>> challenges = data.getChallenges();
			final Map<String, Map<String, Achievement>> quests = data.getQuests();
			final Map<String, Map<String, Achievement>> subquests = data.getSubquests();

			for(Map.Entry<String, Map<String, Achievement>> chaList : challenges.entrySet()){
				if(chaList.getValue() != null){
					for(Map.Entry<String, Achievement> cha : chaList.getValue().entrySet()){
						if(cha.getValue().getName().toLowerCase().contains(search.toLowerCase())){
							SearchResultLabel chaLabel = new SearchResultLabel(cha.getValue());

							if(!chaCheck)
								chaLabel.setVisible(false);

							chaLabel.addMouseListener(new SearchLabelMouseListener(chaLabel, GUIWindow.getInstance().getRightPanel().getSearchPanel().getSearchField()));
							searchLabels.add(chaLabel);
							this.add(chaLabel);
						}
					}
				}
			}

			for(Map.Entry<String, Map<String, Achievement>> queList : quests.entrySet()){
				if(queList.getValue() != null){
					for(Map.Entry<String, Achievement> que : queList.getValue().entrySet()){
						if(que.getValue().getName().toLowerCase().contains(search.toLowerCase())){
							SearchResultLabel queLabel = new SearchResultLabel(que.getValue());

							if(!queCheck)
								queLabel.setVisible(false);

							queLabel.addMouseListener(new SearchLabelMouseListener(queLabel, GUIWindow.getInstance().getRightPanel().getSearchPanel().getSearchField()));
							searchLabels.add(queLabel);
							this.add(queLabel);
						}
					}
				}
			}

			for(Map.Entry<String, Map<String, Achievement>> subqueList : subquests.entrySet()){
				if(subqueList.getValue() != null){
					for(Map.Entry<String, Achievement> subque : subqueList.getValue().entrySet()){
						if(subque.getValue().getName().toLowerCase().contains(search.toLowerCase())){
							SearchResultLabel subqueLabel = new SearchResultLabel(subque.getValue());

							if(!subqueCheck)
								subqueLabel.setVisible(false);

							subqueLabel.addMouseListener(new SearchLabelMouseListener(subqueLabel, GUIWindow.getInstance().getRightPanel().getSearchPanel().getSearchField()));
							searchLabels.add(subqueLabel);
							this.add(subqueLabel);
						}
					}
				}
			}

			this.revalidate();
		}else if(search.length() > 4){
			for(SearchResultLabel l : searchLabels){
				if(l.isVisible() && !l.getAchievement().getName().toLowerCase().contains(search.toLowerCase()))
					l.setVisible(false);
			}

			this.revalidate();
		}else if(search.length() == 1){
			backup = this.getComponents();

			clearPanel();

			this.revalidate();
		}
	}

	/**
	 * Getter for the opened challenge
	 * @return the opened challenge
	 */
	public static ChallengeLabel getOpenedChallenge() {
		return openedChallenge;
	}

	/**
	 * Setter for the opened challenge
	 * @param openedChallenge the new opened challenge
	 */
	public static void setOpenedChallenge(ChallengeLabel openedChallenge) {
		ChallengesPanel.openedChallenge = openedChallenge;
	}

	/**
	 * Getter for the opened quest
	 * @return the opened quest
	 */
	public static QuestLabel getOpenedQuest() {
		return openedQuest;
	}

	/**
	 * Setter for the opened quest
	 * @param openedQuest the new opened quest
	 */
	public static void setOpenedQuest(QuestLabel openedQuest) {
		ChallengesPanel.openedQuest = openedQuest;
	}

	/**
	 * Getter for the quests labels list
	 * @return the quests labels list
	 */
	public static Map<String, List<QuestLabel>> getQuestsLabels() {
		return questsLabels;
	}

	/**
	 * Getter for the subquests labels list
	 * @return the subquests labels list
	 */
	public static Map<String, List<SubQuestLabel>> getSubQuestsLabels() {
		return subquestsLabels;
	}
}
