package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import domain.Achievement;
import gui.IConfigGUI;

public class SuccessLabel extends AchievementLabel {

	private static final long serialVersionUID = -7154775791673874959L;

	/**
	 * Success label constructor
	 * @param success the success to display
	 */
	public SuccessLabel(Achievement success) {
		super(success);

		this.setMaximumSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUCCESS_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUCCESS_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUCCESS_HEIGHT));
		this.setBorder(new MatteBorder(2, 0, 0, 0, IConfigGUI.BLACK_BORDER_COLOR));
		this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.SUCCESS_FONT_COLOR);
		this.setFont(new Font(IConfigGUI.FONT_THEOKRITOS, 0, IConfigGUI.BIG_FONT_SIZE));

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setText("    " + getText());

		this.setIcon(new ImageIcon("resources/wood/wood_1_dark.jpg"));
		this.setIconTextGap(- IConfigGUI.SUCCESS_WIDTH);
	}

	@Override
	public void setMouseClickedColor() {
		//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_OPEN_COLOR);
		this.setIcon(new ImageIcon("resources/wood/wood_1_bright.jpg"));
		this.setForeground(IConfigGUI.SUCCESS_FONT_OPEN_COLOR);
	}

	@Override
	public void setMouseReleasedColor() {
		//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_COLOR);
		this.setIcon(new ImageIcon("resources/wood/wood_1_dark.jpg"));
		this.setForeground(IConfigGUI.SUCCESS_FONT_COLOR);
	}

	@Override
	public void setMousePressedColor() {
		if(isOpened()){
			//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/wood/wood_1_very_bright.jpg"));
			this.setForeground(IConfigGUI.SUCCESS_FONT_CLICK_COLOR);
		}else{
			//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/wood/wood_1_bright.jpg"));
			this.setForeground(IConfigGUI.SUCCESS_FONT_CLICK_COLOR);
		}
	}

	@Override
	public void setMouseHoverColor(boolean enter) {
		if(enter){
			if(isOpened()){
				//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/wood/wood_1_bright.jpg"));
				this.setForeground(IConfigGUI.SUCCESS_FONT_OPEN_COLOR);
			}else{
				//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/wood/wood_1_normal.jpg"));
				this.setForeground(IConfigGUI.SUCCESS_FONT_HOVER_COLOR);
			}
		}else{
			if(isOpened()){
				//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_OPEN_COLOR);
				this.setIcon(new ImageIcon("resources/wood/wood_1_normal.jpg"));
				this.setForeground(IConfigGUI.SUCCESS_FONT_OPEN_COLOR);
			}else{
				//this.setBackground(IConfigGUI.SUCCESS_BACKGROUND_COLOR);
				this.setIcon(new ImageIcon("resources/wood/wood_1_dark.jpg"));
				this.setForeground(IConfigGUI.SUCCESS_FONT_COLOR);
			}
		}
	}
}
