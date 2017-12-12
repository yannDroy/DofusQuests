package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import domain.Achievement;
import gui.IConfigGUI;

/**
 * Quest label
 * @author yann
 *
 */
public class QuestLabel extends AchievementLabel {

	private static final long serialVersionUID = 3500540674915242402L;

	/**
	 * Quest label constructor
	 * @param quest the quest to display
	 */
	public QuestLabel(Achievement quest) {
		super(quest);

		this.setMaximumSize(new Dimension(IConfigGUI.QUEST_WIDTH, IConfigGUI.QUEST_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.QUEST_WIDTH, IConfigGUI.QUEST_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.QUEST_WIDTH, IConfigGUI.QUEST_HEIGHT));
		//this.setBackground(IConfigGUI.QUEST_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.QUEST_FONT_COLOR);
		this.setBorder(new MatteBorder(0, 0, 1, 0, IConfigGUI.GREY_BORDER_COLOR));
		this.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 0, IConfigGUI.MIDDLE_FONT_SIZE));

		this.setVisible(false);

		this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
		this.setIconTextGap(- IConfigGUI.QUEST_WIDTH * 8 / 9);

		setMouseHoverColor(false);
	}

	@Override
	public void setMouseClickedColor() {
		//this.setBackground(IConfigGUI.QUEST_BACKGROUND_OPEN_COLOR);
		this.setIcon(new ImageIcon("resources/parchment/parchment_1_very_bright.jpg"));
		this.setForeground(IConfigGUI.QUEST_FONT_OPEN_COLOR);
	}

	@Override
	public void setMouseReleasedColor() {
		if(getAchievement().isFinished()){
			//this.setBackground(IConfigGUI.QUEST_BACKGROUND_FINISHED_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_green_bright.jpg"));
			this.setForeground(IConfigGUI.QUEST_FONT_FINISHED_COLOR);
		}else{
			//this.setBackground(IConfigGUI.QUEST_BACKGROUND_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
			this.setForeground(IConfigGUI.QUEST_FONT_COLOR);
		}
	}

	@Override
	public void setMousePressedColor() {
		if(isOpened()){
			//this.setBackground(IConfigGUI.QUEST_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_very_bright_2.jpg"));
			this.setForeground(IConfigGUI.QUEST_FONT_CLICK_COLOR);
		}else{
			//this.setBackground(IConfigGUI.QUEST_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_very_bright.jpg"));
			this.setForeground(IConfigGUI.QUEST_FONT_CLICK_COLOR);
		}
	}

	@Override
	public void setMouseHoverColor(boolean enter) {
		if(enter){
			if(isOpened()){
				//this.setBackground(IConfigGUI.QUEST_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_very_bright.jpg"));
				this.setForeground(IConfigGUI.QUEST_FONT_OPEN_COLOR);
			}else{
				//this.setBackground(IConfigGUI.QUEST_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
				this.setForeground(IConfigGUI.QUEST_FONT_HOVER_COLOR);
			}
		}else{
			if(isOpened()){
				//this.setBackground(IConfigGUI.QUEST_BACKGROUND_OPEN_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
				this.setForeground(IConfigGUI.QUEST_FONT_OPEN_COLOR);
			}else{
				if(getAchievement().isFinished()){
					//this.setBackground(IConfigGUI.QUEST_BACKGROUND_FINISHED_COLOR);
					this.setIcon(new ImageIcon("resources/parchment/parchment_1_green_bright.jpg"));
					this.setForeground(IConfigGUI.QUEST_FONT_FINISHED_COLOR);
				}else{
					//this.setBackground(IConfigGUI.QUEST_BACKGROUND_COLOR);
					this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
					this.setForeground(IConfigGUI.QUEST_FONT_COLOR);
				}
			}
		}
	}
}
