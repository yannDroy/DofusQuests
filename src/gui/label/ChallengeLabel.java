package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import domain.Achievement;
import gui.IConfigGUI;

/**
 * Challenge label
 * @author yann
 *
 */
public class ChallengeLabel extends AchievementLabel {

	private static final long serialVersionUID = -7154775791673874959L;

	/**
	 * Challenge label constructor
	 * @param challenge the challenge to display
	 */
	public ChallengeLabel(Achievement challenge) {
		super(challenge);

		this.setMaximumSize(new Dimension(IConfigGUI.CHALLENGE_WIDTH, IConfigGUI.CHALLENGE_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.CHALLENGE_WIDTH, IConfigGUI.CHALLENGE_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.CHALLENGE_WIDTH, IConfigGUI.CHALLENGE_HEIGHT));
		//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.CHALLENGE_FONT_COLOR);
		this.setBorder(new MatteBorder(0, 0, 2, 0, IConfigGUI.GREY_BORDER_COLOR));
		this.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 1, IConfigGUI.BIG_FONT_SIZE));

		this.setIcon(new ImageIcon("resources/parchment/parchment_1.jpg"));
		this.setIconTextGap(- IConfigGUI.CHALLENGE_WIDTH * 15 / 16);

		setMouseHoverColor(false);
	}

	@Override
	public void setMouseClickedColor() {
		this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
		//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_OPEN_COLOR);
		this.setForeground(IConfigGUI.CHALLENGE_FONT_OPEN_COLOR);
	}

	@Override
	public void setMouseReleasedColor() {
		if(getAchievement().isFinished()){
			//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_FINISHED_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_green.jpg"));
			this.setForeground(IConfigGUI.CHALLENGE_FONT_FINISHED_COLOR);
		}else{
			//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_dark.jpg"));
			this.setForeground(IConfigGUI.CHALLENGE_FONT_COLOR);
		}
	}

	@Override
	public void setMousePressedColor() {
		if(isOpened()){
			//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_very_bright.jpg"));
			this.setForeground(IConfigGUI.CHALLENGE_FONT_CLICK_COLOR);
		}else{
			//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
			this.setForeground(IConfigGUI.CHALLENGE_FONT_CLICK_COLOR);
		}
	}

	@Override
	public void setMouseHoverColor(boolean enter) {
		if(enter){
			if(isOpened()){
				//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_bright.jpg"));
				this.setForeground(IConfigGUI.CHALLENGE_FONT_OPEN_COLOR);
			}else{
				//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
				this.setForeground(IConfigGUI.CHALLENGE_FONT_HOVER_COLOR);
			}
		}else{
			if(isOpened()){
				//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_OPEN_COLOR);
				this.setIcon(new ImageIcon("resources/parchment/parchment_1_normal.jpg"));
				this.setForeground(IConfigGUI.CHALLENGE_FONT_OPEN_COLOR);
			}else{
				if(getAchievement().isFinished()){
					//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_FINISHED_COLOR);
					this.setIcon(new ImageIcon("resources/parchment/parchment_1_green.jpg"));
					this.setForeground(IConfigGUI.CHALLENGE_FONT_FINISHED_COLOR);
				}else{
					//this.setBackground(IConfigGUI.CHALLENGE_BACKGROUND_COLOR);
					this.setIcon(new ImageIcon("resources/parchment/parchment_1_dark.jpg"));
					this.setForeground(IConfigGUI.CHALLENGE_FONT_COLOR);
				}
			}
		}
	}
}
