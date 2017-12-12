package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import domain.Achievement;
import gui.IConfigGUI;

/**
 * Subquest label
 * @author yann
 *
 */
public class SubQuestLabel extends AchievementLabel {

	private static final long serialVersionUID = 3500540674915242402L;

	/**
	 * Subquest label constructor
	 * @param quuest the subquest to display
	 */
	public SubQuestLabel(Achievement quest) {
		super(quest);

		this.setMaximumSize(new Dimension(IConfigGUI.SUBQUEST_WIDTH, IConfigGUI.SUBQUEST_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.SUBQUEST_WIDTH, IConfigGUI.SUBQUEST_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.SUBQUEST_WIDTH, IConfigGUI.SUBQUEST_HEIGHT));
		this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.SUBQUEST_FONT_COLOR);
		this.setBorder(new MatteBorder(0, 0, 1, 0, IConfigGUI.GREY_BORDER_COLOR));
		this.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 0, IConfigGUI.LITTLE_FONT_SIZE));

		this.setVisible(false);

		this.setIcon(new ImageIcon("resources/parchment/parchment_1_dark.jpg"));
		this.setIconTextGap(- IConfigGUI.QUEST_WIDTH * 13 / 16);

		setMouseHoverColor(false);
	}

	@Override
	public void setMouseClickedColor() {
		//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_COLOR);
		this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
		this.setForeground(IConfigGUI.SUBQUEST_FONT_COLOR);
	}

	@Override
	public void setMouseReleasedColor() {
		if(getAchievement().isFinished()){
			//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_FINISHED_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_green.jpg"));
			this.setForeground(IConfigGUI.SUBQUEST_FONT_FINISHED_COLOR);
		}else{
			//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_dark.jpg"));
			this.setForeground(IConfigGUI.SUBQUEST_FONT_COLOR);
		}
	}

	@Override
	public void setMousePressedColor() {
		//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_CLICK_COLOR);
		this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
		this.setForeground(IConfigGUI.SUBQUEST_FONT_CLICK_COLOR);
	}

	@Override
	public void setMouseHoverColor(boolean enter) {
		if(enter){
			//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_HOVER_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
			this.setForeground(IConfigGUI.SUBQUEST_FONT_HOVER_COLOR);
		}else{
			if(getAchievement().isFinished()){
				//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_FINISHED_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_green.jpg"));
				this.setForeground(IConfigGUI.SUBQUEST_FONT_FINISHED_COLOR);
			}else{
				//this.setBackground(IConfigGUI.SUBQUEST_BACKGROUND_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_dark.jpg"));
				this.setForeground(IConfigGUI.SUBQUEST_FONT_COLOR);
			}
		}
	}
}
