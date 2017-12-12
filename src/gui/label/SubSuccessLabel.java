package gui.label;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import domain.Achievement;
import gui.IConfigGUI;

public class SubSuccessLabel extends AchievementLabel {

	private static final long serialVersionUID = 3500540674915242402L;

	/**
	 * Subsuccess label constructor
	 * @param subsuccess the subsuccess to display
	 */
	public SubSuccessLabel(Achievement subsuccess) {
		super(subsuccess);

		this.setMaximumSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUBSUCCESS_HEIGHT));
		this.setMinimumSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUBSUCCESS_HEIGHT));
		this.setPreferredSize(new Dimension(IConfigGUI.TREE_PANEL_WIDTH, IConfigGUI.SUBSUCCESS_HEIGHT));
		this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_COLOR);
		this.setForeground(IConfigGUI.SUBSUCCESS_FONT_COLOR);
		this.setBorder(new MatteBorder(1, 0, 0, 0, IConfigGUI.BLACK_BORDER_COLOR));
		this.setFont(new Font(IConfigGUI.FONT_ARTEMISIA, 0, IConfigGUI.MIDDLE_FONT_SIZE));

		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setText("      " + getText());

		this.setIcon(new ImageIcon("resources/metal/metal_1_dark.png"));
		this.setIconTextGap(- IConfigGUI.SUBSUCCESS_WIDTH);

		this.setVisible(false);
		
		setMouseHoverColor(false);
	}

	@Override
	public void setMouseClickedColor() {
		//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_OPEN_COLOR);
		this.setIcon(new ImageIcon("resources/metal/metal_1_bright.png"));
		this.setForeground(IConfigGUI.SUBSUCCESS_FONT_OPEN_COLOR);
	}

	@Override
	public void setMouseReleasedColor() {
		if(getAchievement().isFinished()){
			//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_FINISHED_COLOR);
			this.setIcon(new ImageIcon("resources/metal/metal_1_green.png"));
			this.setForeground(IConfigGUI.SUBSUCCESS_FONT_FINISHED_COLOR);
		}else{
			//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_COLOR);
			this.setIcon(new ImageIcon("resources/metal/metal_1_dark.png"));
			this.setForeground(IConfigGUI.SUBSUCCESS_FONT_COLOR);
		}
	}

	@Override
	public void setMousePressedColor() {
		if(isOpened()){
			//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/metal/metal_1_very_bright.png"));
			this.setForeground(IConfigGUI.SUBSUCCESS_FONT_CLICK_COLOR);
		}else{
			//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_CLICK_COLOR);
			this.setIcon(new ImageIcon("resources/metal/metal_1_bright.png"));
			this.setForeground(IConfigGUI.SUBSUCCESS_FONT_CLICK_COLOR);
		}
	}

	@Override
	public void setMouseHoverColor(boolean enter) {
		if(enter){
			if(isOpened()){
				//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/metal/metal_1_bright.png"));
				this.setForeground(IConfigGUI.SUBSUCCESS_FONT_OPEN_COLOR);
			}else{
				//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_HOVER_COLOR);
				this.setIcon(new ImageIcon("resources/metal/metal_1_normal.png"));
				this.setForeground(IConfigGUI.SUBSUCCESS_FONT_HOVER_COLOR);
			}
		}else{
			if(isOpened()){
				//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_OPEN_COLOR);
				this.setIcon(new ImageIcon("resources/metal/metal_1_normal.png"));
				this.setForeground(IConfigGUI.SUBSUCCESS_FONT_OPEN_COLOR);
			}else{
				if(getAchievement().isFinished()){
					//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_FINISHED_COLOR);
					this.setIcon(new ImageIcon("resources/metal/metal_1_green.png"));
					this.setForeground(IConfigGUI.SUBSUCCESS_FONT_FINISHED_COLOR);
				}else{
					//this.setBackground(IConfigGUI.SUBSUCCESS_BACKGROUND_COLOR);
					this.setIcon(new ImageIcon("resources/metal/metal_1_dark.png"));
					this.setForeground(IConfigGUI.SUBSUCCESS_FONT_COLOR);
				}
			}
		}
	}
}
